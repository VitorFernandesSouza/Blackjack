package br.pucminas.tcc.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AvaliadorBlackjackTest {

    @Test
    void deveInterpretarCartaNumericaCorretamente() {
        Carta carta = new Carta("7H");

        assertEquals("7", carta.getValor());
        assertEquals('H', carta.getNaipe());
        assertEquals(7, carta.getValorNumerico());
    }

    @Test
    void deveInterpretarCartaDezCorretamente() {
        Carta carta = new Carta("10D");

        assertEquals("10", carta.getValor());
        assertEquals('D', carta.getNaipe());
        assertEquals(10, carta.getValorNumerico());
    }

    @Test
    void figurasDevemValerDez() {
        assertEquals(10, new Carta("JH").getValorNumerico());
        assertEquals(10, new Carta("QD").getValorNumerico());
        assertEquals(10, new Carta("KS").getValorNumerico());
    }

    @Test
    void asDeveValerOnze() {
        assertEquals(11, new Carta("AC").getValorNumerico());
    }

    @Test
    void deveLancarExcecaoParaCartaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Carta("1H"));
        assertThrows(IllegalArgumentException.class, () -> new Carta("10X"));
        assertThrows(IllegalArgumentException.class, () -> new Carta(""));
    }

    @Test
    void deveSomarPontuacaoDaMao() {
        Mao mao = new Mao(List.of(
                new Carta("10H"),
                new Carta("5D"),
                new Carta("AC")
        ));

        assertEquals(26, mao.pontuacao());
    }

    @Test
    void deveDetectarQuandoAMaoEstourou() {
        Mao mao = new Mao(List.of(
                new Carta("10H"),
                new Carta("9D"),
                new Carta("5C")
        ));

        assertTrue(mao.estourou());
    }

    @Test
    void naoDeveConsiderarEstouroQuandoPontuacaoEh21OuMenor() {
        Mao mao = new Mao(List.of(
                new Carta("10H"),
                new Carta("AD")
        ));

        assertFalse(mao.estourou());
        assertEquals(21, mao.pontuacao());
    }

    @Test
    void jogadorDeveVencerQuandoTemMaiorPontuacaoSemEstourar() {
        Mao jogador = new Mao(List.of(new Carta("10H"), new Carta("9S")));
        Mao banca = new Mao(List.of(new Carta("8D"), new Carta("8C")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.VITORIA_JOGADOR, avaliador.comparar(jogador, banca));
    }

    @Test
    void bancaDeveVencerQuandoJogadorEstoura() {
        Mao jogador = new Mao(List.of(new Carta("10H"), new Carta("9S"), new Carta("5D")));
        Mao banca = new Mao(List.of(new Carta("8D"), new Carta("8C")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.VITORIA_BANCA, avaliador.comparar(jogador, banca));
    }

    @Test
    void jogadorDeveVencerQuandoBancaEstoura() {
        Mao jogador = new Mao(List.of(new Carta("10H"), new Carta("8S")));
        Mao banca = new Mao(List.of(new Carta("10D"), new Carta("8C"), new Carta("5H")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.VITORIA_JOGADOR, avaliador.comparar(jogador, banca));
    }

    @Test
    void deveRetornarEmpateQuandoPontuacoesForemIguais() {
        Mao jogador = new Mao(List.of(new Carta("10H"), new Carta("8S")));
        Mao banca = new Mao(List.of(new Carta("9D"), new Carta("9C")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.EMPATE, avaliador.comparar(jogador, banca));
    }

    @Test
    void deveRetornarEmpateQuandoAmbosEstouram() {
        Mao jogador = new Mao(List.of(new Carta("10H"), new Carta("8S"), new Carta("5D")));
        Mao banca = new Mao(List.of(new Carta("9D"), new Carta("9C"), new Carta("8H")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.EMPATE, avaliador.comparar(jogador, banca));
    }
}