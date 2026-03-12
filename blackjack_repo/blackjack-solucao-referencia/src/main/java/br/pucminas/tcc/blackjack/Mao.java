package br.pucminas.tcc.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mao {

    private final List<Carta> cartas;

    public Mao() {
        this.cartas = new ArrayList<>();
    }

    public Mao(List<Carta> cartas) {
        this.cartas = new ArrayList<>(cartas);
    }

    public void adicionarCarta(Carta carta) {
        if (carta == null) {
            throw new IllegalArgumentException("Carta não pode ser nula");
        }
        cartas.add(carta);
    }

    public List<Carta> getCartas() {
        return Collections.unmodifiableList(cartas);
    }

    public int pontuacao() {
        return cartas.stream()
                .mapToInt(Carta::getValorNumerico)
                .sum();
    }

    public boolean estourou() {
        return pontuacao() > 21;
    }
}