package br.pucminas.tcc.blackjack;

public class Carta {

    private final String valor;
    private final char naipe;

    public Carta(String notacao) {
        if (notacao == null || notacao.isBlank() || notacao.length() < 2) {
            throw new IllegalArgumentException("Carta inválida");
        }

        this.naipe = notacao.charAt(notacao.length() - 1);
        this.valor = notacao.substring(0, notacao.length() - 1);

        validar();
    }

    private void validar() {
        if ("COPE".indexOf(naipe) == -1) {
            throw new IllegalArgumentException("Naipe inválido");
        }

        if (!valor.matches("2|3|4|5|6|7|8|9|10|J|Q|K|A")) {
            throw new IllegalArgumentException("Valor inválido");
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

    public String getNaipePorExtenso() {
        return switch (naipe) {
            case 'C' -> "Copas";
            case 'O' -> "Ouros";
            case 'P' -> "Paus";
            case 'E' -> "Espadas";
            default -> throw new IllegalArgumentException("Naipe inválido");
        };
    }
}