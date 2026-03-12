package br.pucminas.tcc.blackjack;

import java.util.Set;

public class Card {
    private static final Set<Character> VALID_SUITS = Set.of('H', 'D', 'C', 'S');
    private final String rank;
    private final char suit;

    public Card(String notation) {
        if (notation == null || notation.length() < 2) {
            throw new IllegalArgumentException("Notação de carta inválida");
        }

        this.suit = Character.toUpperCase(notation.charAt(notation.length() - 1));
        this.rank = notation.substring(0, notation.length() - 1).toUpperCase();

        if (!VALID_SUITS.contains(this.suit)) {
            throw new IllegalArgumentException("Naipe inválido: " + this.suit);
        }

        validateRank(this.rank);
    }

    private void validateRank(String rank) {
        boolean valid = rank.matches("[2-9]")
                || rank.equals("10")
                || rank.equals("J")
                || rank.equals("Q")
                || rank.equals("K")
                || rank.equals("A");

        if (!valid) {
            throw new IllegalArgumentException("Valor de carta inválido: " + rank);
        }
    }

    public String getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return switch (rank) {
            case "J", "Q", "K" -> 10;
            case "A" -> 11;
            default -> Integer.parseInt(rank);
        };
    }
}
