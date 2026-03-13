package br.pucminas.tcc.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AvaliadorBlackjackTest {

    @Test
    void deveInterpretarCartaNumericaCorretamente() {
        Carta carta = new Carta("7C");

        assertEquals("7", carta.getValor());
        assertEquals('C', carta.getNaipe());
        assertEquals(7, carta.getValorNumerico());
    }

    @Test
    void deveInterpretarCartaDezCorretamente() {
        Carta carta = new Carta("10O");

        assertEquals("10", carta.getValor());
        assertEquals('O', carta.getNaipe());
        assertEquals(10, carta.getValorNumerico());
    }

    @Test
    void figurasDevemValerDez() {
        assertEquals(10, new Carta("JC").getValorNumerico());
        assertEquals(10, new Carta("QO").getValorNumerico());
        assertEquals(10, new Carta("KE").getValorNumerico());
    }

    @Test
    void asDeveValerOnze() {
        assertEquals(11, new Carta("AP").getValorNumerico());
    }

    @Test
    void deveLancarExcecaoParaCartaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Carta("1C"));
        assertThrows(IllegalArgumentException.class, () -> new Carta("10X"));
        assertThrows(IllegalArgumentException.class, () -> new Carta(""));
    }

    @Test
    void deveSomarPontuacaoDaMao() {
        Mao mao = new Mao(List.of(
                new Carta("10C"),
                new Carta("5O"),
                new Carta("AP")
        ));

        assertEquals(26, mao.pontuacao());
    }

    @Test
    void deveDetectarQuandoAMaoEstourou() {
        Mao mao = new Mao(List.of(
                new Carta("10C"),
                new Carta("9O"),
                new Carta("5P")
        ));

        assertTrue(mao.estourou());
    }

    @Test
    void naoDeveConsiderarEstouroQuandoPontuacaoEh21OuMenor() {
        Mao mao = new Mao(List.of(
                new Carta("10C"),
                new Carta("AO")
        ));

        assertFalse(mao.estourou());
        assertEquals(21, mao.pontuacao());
    }

    @Test
    void jogadorDeveVencerQuandoTemMaiorPontuacaoSemEstourar() {
        Mao jogador = new Mao(List.of(new Carta("10C"), new Carta("9E")));
        Mao banca = new Mao(List.of(new Carta("8O"), new Carta("8P")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.VITORIA_JOGADOR, avaliador.comparar(jogador, banca));
    }

    @Test
    void bancaDeveVencerQuandoJogadorEstoura() {
        Mao jogador = new Mao(List.of(new Carta("10C"), new Carta("9E"), new Carta("5O")));
        Mao banca = new Mao(List.of(new Carta("8O"), new Carta("8P")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.VITORIA_BANCA, avaliador.comparar(jogador, banca));
    }

    @Test
    void jogadorDeveVencerQuandoBancaEstoura() {
        Mao jogador = new Mao(List.of(new Carta("10C"), new Carta("8E")));
        Mao banca = new Mao(List.of(new Carta("10O"), new Carta("8P"), new Carta("5C")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.VITORIA_JOGADOR, avaliador.comparar(jogador, banca));
    }

    @Test
    void deveRetornarEmpateQuandoPontuacoesForemIguais() {
        Mao jogador = new Mao(List.of(new Carta("10C"), new Carta("8E")));
        Mao banca = new Mao(List.of(new Carta("9O"), new Carta("9P")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.EMPATE, avaliador.comparar(jogador, banca));
    }

    @Test
    void deveRetornarEmpateQuandoAmbosEstouram() {
        Mao jogador = new Mao(List.of(new Carta("10C"), new Carta("8E"), new Carta("5O")));
        Mao banca = new Mao(List.of(new Carta("9O"), new Carta("9P"), new Carta("8C")));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();

        assertEquals(ResultadoRodada.EMPATE, avaliador.comparar(jogador, banca));
    }
}