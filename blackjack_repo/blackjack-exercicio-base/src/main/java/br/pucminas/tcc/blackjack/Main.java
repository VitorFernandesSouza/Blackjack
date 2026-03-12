package br.pucminas.tcc.blackjack;

public class Main {

    public static void main(String[] args) {
        Mao jogador = new Mao();
        jogador.adicionarCarta(new Carta("10H"));
        jogador.adicionarCarta(new Carta("9S"));

        Mao banca = new Mao();
        banca.adicionarCarta(new Carta("8D"));
        banca.adicionarCarta(new Carta("8C"));

        AvaliadorBlackjack avaliador = new AvaliadorBlackjack();
        ResultadoRodada resultado = avaliador.comparar(jogador, banca);

        System.out.println("Pontuação do jogador: " + jogador.pontuacao());
        System.out.println("Pontuação da banca: " + banca.pontuacao());
        System.out.println("Resultado: " + resultado);
    }
}