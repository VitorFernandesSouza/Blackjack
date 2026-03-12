package br.pucminas.tcc.blackjack;

public class BlackjackEvaluator {

    public RoundResult compare(Hand player, Hand dealer) {
        if (player == null || dealer == null) {
            throw new IllegalArgumentException("As mãos não podem ser nulas");
        }

        boolean playerBust = player.isBust();
        boolean dealerBust = dealer.isBust();

        if (playerBust && dealerBust) {
            return RoundResult.DRAW;
        }
        if (playerBust) {
            return RoundResult.DEALER_WIN;
        }
        if (dealerBust) {
            return RoundResult.PLAYER_WIN;
        }

        int playerScore = player.score();
        int dealerScore = dealer.score();

        if (playerScore > dealerScore) {
            return RoundResult.PLAYER_WIN;
        }
        if (playerScore < dealerScore) {
            return RoundResult.DEALER_WIN;
        }
        return RoundResult.DRAW;
    }
}
