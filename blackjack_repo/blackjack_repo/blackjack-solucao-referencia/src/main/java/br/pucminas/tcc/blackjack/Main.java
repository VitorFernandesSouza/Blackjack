package br.pucminas.tcc.blackjack;

public class Main {
    public static void main(String[] args) {
        Hand player = new Hand();
        player.addCard(new Card("10H"));
        player.addCard(new Card("9S"));

        Hand dealer = new Hand();
        dealer.addCard(new Card("8D"));
        dealer.addCard(new Card("8C"));

        BlackjackEvaluator evaluator = new BlackjackEvaluator();
        System.out.println("Pontuação jogador: " + player.score());
        System.out.println("Pontuação dealer: " + dealer.score());
        System.out.println("Resultado: " + evaluator.compare(player, dealer));
    }
}
