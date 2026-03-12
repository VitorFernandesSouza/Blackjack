package br.pucminas.tcc.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackEvaluatorTest {

    @Test
    void deveInterpretarCartaNumericaCorretamente() {
        Card card = new Card("7H");

        assertEquals("7", card.getRank());
        assertEquals('H', card.getSuit());
        assertEquals(7, card.getValue());
    }

    @Test
    void deveInterpretarCartaDezCorretamente() {
        Card card = new Card("10D");

        assertEquals("10", card.getRank());
        assertEquals('D', card.getSuit());
        assertEquals(10, card.getValue());
    }

    @Test
    void figurasDevemValerDez() {
        assertEquals(10, new Card("JH").getValue());
        assertEquals(10, new Card("QD").getValue());
        assertEquals(10, new Card("KS").getValue());
    }

    @Test
    void asDeveValerOnze() {
        assertEquals(11, new Card("AC").getValue());
    }

    @Test
    void deveLancarExcecaoParaCartaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Card("1H"));
        assertThrows(IllegalArgumentException.class, () -> new Card("10X"));
        assertThrows(IllegalArgumentException.class, () -> new Card(""));
    }

    @Test
    void deveSomarPontuacaoDaMao() {
        Hand hand = new Hand(List.of(
                new Card("10H"),
                new Card("5D"),
                new Card("AC")
        ));

        assertEquals(26, hand.score());
    }

    @Test
    void deveDetectarQuandoAMaoEstourou() {
        Hand hand = new Hand(List.of(
                new Card("10H"),
                new Card("9D"),
                new Card("5C")
        ));

        assertTrue(hand.isBust());
    }

    @Test
    void naoDeveConsiderarBustQuandoPontuacaoEh21OuMenor() {
        Hand hand = new Hand(List.of(
                new Card("10H"),
                new Card("A D".replace(" ", ""))
        ));

        assertFalse(hand.isBust());
        assertEquals(21, hand.score());
    }

    @Test
    void jogadorDeveVencerQuandoTemMaiorPontuacaoSemEstourar() {
        Hand player = new Hand(List.of(new Card("10H"), new Card("9S")));
        Hand dealer = new Hand(List.of(new Card("8D"), new Card("8C")));

        BlackjackEvaluator evaluator = new BlackjackEvaluator();

        assertEquals(RoundResult.PLAYER_WIN, evaluator.compare(player, dealer));
    }

    @Test
    void dealerDeveVencerQuandoJogadorEstoura() {
        Hand player = new Hand(List.of(new Card("10H"), new Card("9S"), new Card("5D")));
        Hand dealer = new Hand(List.of(new Card("8D"), new Card("8C")));

        BlackjackEvaluator evaluator = new BlackjackEvaluator();

        assertEquals(RoundResult.DEALER_WIN, evaluator.compare(player, dealer));
    }

    @Test
    void jogadorDeveVencerQuandoDealerEstoura() {
        Hand player = new Hand(List.of(new Card("10H"), new Card("8S")));
        Hand dealer = new Hand(List.of(new Card("10D"), new Card("8C"), new Card("5H")));

        BlackjackEvaluator evaluator = new BlackjackEvaluator();

        assertEquals(RoundResult.PLAYER_WIN, evaluator.compare(player, dealer));
    }

    @Test
    void deveRetornarEmpateQuandoPontuacoesForemIguais() {
        Hand player = new Hand(List.of(new Card("10H"), new Card("8S")));
        Hand dealer = new Hand(List.of(new Card("9D"), new Card("9C")));

        BlackjackEvaluator evaluator = new BlackjackEvaluator();

        assertEquals(RoundResult.DRAW, evaluator.compare(player, dealer));
    }

    @Test
    void deveRetornarEmpateQuandoAmbosEstouram() {
        Hand player = new Hand(List.of(new Card("10H"), new Card("8S"), new Card("5D")));
        Hand dealer = new Hand(List.of(new Card("9D"), new Card("9C"), new Card("8H")));

        BlackjackEvaluator evaluator = new BlackjackEvaluator();

        assertEquals(RoundResult.DRAW, evaluator.compare(player, dealer));
    }
}
