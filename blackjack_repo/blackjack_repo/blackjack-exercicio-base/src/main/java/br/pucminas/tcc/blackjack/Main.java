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
        System.out.println(evaluator.compare(player, dealer));
    }
}
