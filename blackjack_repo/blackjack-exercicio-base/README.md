# Blackjack Simplificado — Exercício para Experimento

Este repositório foi preparado para um experimento acadêmico sobre **modelagem UML** e **implementação orientada a objetos em Java**.

## Objetivo
Implementar um sistema simplificado de **Blackjack / Jogo 21** capaz de:

- representar cartas;
- representar uma mão com múltiplas cartas;
- calcular a pontuação da mão;
- identificar quando a mão estourou;
- comparar a mão do jogador com a mão do dealer.

## Regras simplificadas

- Cartas numéricas (`2` a `10`) valem seu próprio valor.
- `J`, `Q` e `K` valem `10`.
- `A` vale **11 fixo**.
- Uma mão **estoura** quando sua pontuação é maior que `21`.
- Na comparação entre duas mãos:
  - se apenas uma estourar, ela perde;
  - se as duas estourarem, o resultado é `EMPATE`;
  - se nenhuma estourar, vence a maior pontuação;
  - pontuações iguais resultam em `EMPATE`.

## Estrutura mínima esperada

- `Card` — representa uma carta
- `Hand` — representa uma mão
- `BlackjackEvaluator` — compara duas mãos
- `RoundResult` — enum com `PLAYER_WIN`, `DEALER_WIN`, `DRAW`

## Formato das cartas
As cartas podem ser construídas a partir de strings como:

- `"AH"` → Ás de copas
- `"10D"` → Dez de ouros
- `"QS"` → Dama de espadas
- `"7C"` → Sete de paus

O último caractere representa o naipe:

- `H` = Hearts
- `D` = Diamonds
- `C` = Clubs
- `S` = Spades

## Entregáveis do participante

1. **Diagrama UML de classes**
2. **Implementação Java**
3. Código passando nos testes automatizados

## Tempo sugerido

- UML: 15–20 min
- Implementação: 40–50 min
- Ajustes e testes: 10–15 min

Tempo total estimado: **1h30**

## Projetos incluídos

### `blackjack-exercicio-base`
Versão base para entregar aos alunos. Os métodos estão com `TODO` / `UnsupportedOperationException`.

### `blackjack-solucao-referencia`
Versão completa de referência, com uma implementação possível.

## Como rodar os testes

```bash
mvn test
```

## Observação metodológica
Este exercício foi desenhado para ter complexidade **menor que poker** e **maior que pedra, papel e tesoura**, mantendo espaço suficiente para observar:

- decomposição do problema;
- qualidade de modelagem OO;
- encapsulamento;
- implementação de regras de negócio simples;
- autonomia do participante ao estruturar a solução.
