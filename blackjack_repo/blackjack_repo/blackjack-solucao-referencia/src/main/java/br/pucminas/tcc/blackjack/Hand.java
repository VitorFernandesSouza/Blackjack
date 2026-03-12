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
        if (card == null) {
            throw new IllegalArgumentException("Carta não pode ser nula");
        }
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public int score() {
        return cards.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    public boolean isBust() {
        return score() > 21;
    }
}
