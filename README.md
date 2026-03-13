# Experimento de Programação --- Blackjack Simplificado

Este repositório faz parte de um **experimento acadêmico desenvolvido no
contexto de um Trabalho de Conclusão de Curso (TCC)** na área de
Engenharia de Software.

O objetivo do experimento é investigar **como o uso de ferramentas de
Inteligência Artificial pode influenciar o processo de desenvolvimento
de software**, especialmente em tarefas de **modelagem e implementação
orientada a objetos**.

------------------------------------------------------------------------

# Participação no experimento

Os participantes serão divididos em **dois grupos**.

## Grupo 1 --- Uso de IA permitido

Participantes deste grupo **podem utilizar ferramentas de Inteligência
Artificial** durante a resolução do exercício.

Exemplos de ferramentas permitidas:

-   ChatGPT
-   Tutoriais e artigos técnicos
-   Blogs de programação

Essas ferramentas podem ser utilizadas para:

-   esclarecer dúvidas
-   sugerir código
-   ajudar na implementação
-   auxiliar no raciocínio sobre o problema

------------------------------------------------------------------------

## Grupo 2 --- Sem uso de IA

Participantes deste grupo **não devem utilizar ferramentas de
Inteligência Artificial generativa** durante a resolução do exercício.

No entanto, **é permitido pesquisar normalmente na internet**.

Exemplos de recursos permitidos:

-   documentação oficial da linguagem Java
-   tutoriais e artigos técnicos
-   Stack Overflow
-   blogs de programação
-   fóruns de discussão

Ou seja, você pode pesquisar e consultar materiais normalmente, **desde
que não utilize sistemas de IA que gerem respostas automaticamente**.

------------------------------------------------------------------------

# Importante

Este **não é um teste avaliativo**.

O objetivo do experimento é observar **diferentes estratégias de
resolução de problemas de programação**.

Portanto:

-   não há penalidade por não terminar o exercício
-   não há penalidade por erros
-   o mais importante é **tentar resolver o problema da melhor forma
    possível**

Se você não conseguir concluir tudo dentro do tempo disponível, **não há
problema**.

------------------------------------------------------------------------

# O exercício

Você deverá implementar um pequeno sistema em **Java**, utilizando
**Programação Orientada a Objetos**.

O sistema representa uma versão **simplificada do jogo Blackjack (21)**.

O objetivo é **comparar duas mãos de cartas** e determinar quem venceu a
rodada.

------------------------------------------------------------------------

# O jogo Blackjack (21)

Blackjack é um jogo de cartas em que o objetivo é obter uma pontuação
**o mais próxima possível de 21**, sem ultrapassar esse valor.

Neste exercício teremos dois participantes:

-   **Jogador**
-   **Banca**

Cada participante possui uma **mão de cartas**, e a pontuação da mão é a
soma dos valores das cartas.

------------------------------------------------------------------------
## Valor das Cartas

| Carta | Valor |
|------|------|
| 2 – 10 | Valor numérico da carta |
| J | 10 |
| Q | 10 |
| K | 10 |
| A | 11 |

# Representação das cartas

Cada carta é representada por uma notação curta:

    VALOR + NAIPE

Exemplos:

  Notação   Carta
  --------- -----------------
  7H        7 de copas
  10D       10 de ouros
  QS        dama de espadas
  AC        ás de paus

Naipes possíveis:

  Símbolo   Naipe
  --------- ---------
  H         Copas
  D         Ouros
  C         Paus
  S         Espadas

------------------------------------------------------------------------

# Estouro (Bust)

Se a soma das cartas ultrapassar **21 pontos**, a mão **estoura**.

Exemplo:

    10 + 9 + 5 = 24 → estourou

Quando uma mão estoura, ela perde automaticamente.

------------------------------------------------------------------------

# Regras para determinar o vencedor

Após calcular a pontuação das mãos:

### Vitória do jogador

-   quando o jogador possui maior pontuação que a banca
-   e nenhuma das mãos estourou

### Vitória da banca

-   quando a banca possui maior pontuação
-   ou quando o jogador estoura

### Empate

-   quando as duas mãos possuem a mesma pontuação
-   ou quando ambas estouram

------------------------------------------------------------------------

# Estrutura do projeto

O projeto contém as seguintes classes:

-   **Carta** --- representa uma carta do baralho
-   **Mao** --- representa uma mão de cartas
-   **AvaliadorBlackjack** --- responsável por comparar as mãos
-   **ResultadoRodada** --- enumeração com os possíveis resultados

Sua tarefa é **completar a implementação dessas classes**.

------------------------------------------------------------------------

# Execução dos testes

O projeto possui **testes automatizados** que verificam o comportamento
esperado do sistema.

Para executá-los:

    mvn test

------------------------------------------------------------------------

# Tempo estimado

O exercício foi planejado para ser resolvido em aproximadamente:

**60 a 90 minutos**

------------------------------------------------------------------------

# Entrega

Ao final da atividade, espera-se que você entregue:

-   o código implementado
-   o diagrama de classes UML correspondente à solução

------------------------------------------------------------------------

# Agradecimento

Obrigado por participar deste experimento.

Sua contribuição é importante para a pesquisa sobre **o impacto de
ferramentas de Inteligência Artificial no desenvolvimento de software**.
