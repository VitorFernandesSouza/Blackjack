package br.pucminas.tcc.blackjack;

import java.util.Set;

public class Carta {

    private static final Set<Character> NAIPES_VALIDOS = Set.of('H', 'D', 'C', 'S');

    private final String valor;
    private final char naipe;

    public Carta(String notacao) {
        if (notacao == null || notacao.length() < 2) {
            throw new IllegalArgumentException("Notação de carta inválida");
        }

        this.naipe = Character.toUpperCase(notacao.charAt(notacao.length() - 1));
        this.valor = notacao.substring(0, notacao.length() - 1).toUpperCase();

        if (!NAIPES_VALIDOS.contains(this.naipe)) {
            throw new IllegalArgumentException("Naipe inválido: " + this.naipe);
        }

        validarValor(this.valor);
    }

    private void validarValor(String valor) {
        boolean valido = valor.matches("[2-9]")
                || valor.equals("10")
                || valor.equals("J")
                || valor.equals("Q")
                || valor.equals("K")
                || valor.equals("A");

        if (!valido) {
            throw new IllegalArgumentException("Valor de carta inválido: " + valor);
        }
    }

    public String getValor() {
        return valor;
    }

    public char getNaipe() {
        return naipe;
    }

    public int getValorNumerico() {
        return switch (valor) {
            case "J", "Q", "K" -> 10;
            case "A" -> 11;
            default -> Integer.parseInt(valor);
        };
    }
}