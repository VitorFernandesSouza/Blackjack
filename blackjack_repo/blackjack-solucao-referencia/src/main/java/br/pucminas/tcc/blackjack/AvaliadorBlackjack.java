package br.pucminas.tcc.blackjack;

public class AvaliadorBlackjack {

    public ResultadoRodada comparar(Mao jogador, Mao banca) {
        if (jogador == null || banca == null) {
            throw new IllegalArgumentException("As mãos não podem ser nulas");
        }

        boolean jogadorEstourou = jogador.estourou();
        boolean bancaEstourou = banca.estourou();

        if (jogadorEstourou && bancaEstourou) {
            return ResultadoRodada.EMPATE;
        }
        if (jogadorEstourou) {
            return ResultadoRodada.VITORIA_BANCA;
        }
        if (bancaEstourou) {
            return ResultadoRodada.VITORIA_JOGADOR;
        }

        int pontuacaoJogador = jogador.pontuacao();
        int pontuacaoBanca = banca.pontuacao();

        if (pontuacaoJogador > pontuacaoBanca) {
            return ResultadoRodada.VITORIA_JOGADOR;
        }
        if (pontuacaoJogador < pontuacaoBanca) {
            return ResultadoRodada.VITORIA_BANCA;
        }
        return ResultadoRodada.EMPATE;
    }
}