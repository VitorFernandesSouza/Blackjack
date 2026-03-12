package br.pucminas.tcc.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public void addCard(Card card) {
        throw new UnsupportedOperationException("TODO: implementar addCard");
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public int score() {
        throw new UnsupportedOperationException("TODO: implementar score");
    }

    public boolean isBust() {
        throw new UnsupportedOperationException("TODO: implementar isBust");
    }
}
