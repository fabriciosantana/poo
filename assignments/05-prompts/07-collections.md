# Java Collections Framework

Fontes oficiais usadas como base:
- Oracle Collections Framework: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-index.html
- Overview: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-overview.html
- Outline: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-reference.html

---

## Parte 1: Visão Geral do Framework

Explique:

1. O que é o Java Collections Framework.
2. Por que ele é uma arquitetura unificada.
3. Por que usamos coleções em vez de arrays em muitos problemas.
4. A diferença entre interface e implementação.
5. Por que é comum declarar pela interface, por exemplo:

```java
List<String> nomes = new ArrayList<>();
Set<Integer> codigos = new HashSet<>();
Map<String, Aluno> alunos = new HashMap<>();
```

Inclua uma pergunta ao final para verificar se eu entendi a diferença entre contrato e implementação.

---

## Parte 2: Interfaces Principais

Explique e compare as interfaces:

- `Collection`
- `List`
- `Set`
- `Queue`
- `Deque`
- `Map`
- `SortedSet`
- `NavigableSet`
- `SortedMap`
- `NavigableMap`
- `SequencedCollection`
- `SequencedSet`
- `SequencedMap`

Deixe claro que:

- `Map` faz parte do Collections Framework, mas não herda de `Collection`;
- `List` representa sequência por posição;
- `Set` não permite duplicados;
- `Queue` representa uma fila;
- `Deque` representa uma fila de duas pontas;
- interfaces `Sequenced*` representam coleções/mapas com ordem de iteração definida ou previsível.

Depois, gere uma tabela com:

| Interface | Ideia principal | Exemplo de implementação |

---

## Parte 3: Ordem vs Ordenação

Explique cuidadosamente a diferença entre **ordem** e **ordenação**.

Use esta ideia central:

> Nem toda coleção que mantém uma ordem está ordenada. “Ordem” é como os elementos aparecem; “ordenação” é uma regra de comparação que organiza os elementos.

Compare:

- `ArrayList`
- `LinkedList`
- `ArrayDeque`
- `PriorityQueue`
- `HashSet`
- `LinkedHashSet`
- `TreeSet`
- `HashMap`
- `LinkedHashMap`
- `TreeMap`

Explique especialmente:

1. Por que `HashSet` e `HashMap` não devem ser usados quando a ordem importa.
2. Por que `PriorityQueue` garante prioridade na cabeça, mas não garante iteração ordenada.
3. Por que `TreeSet` e `TreeMap` são estruturas ordenadas por comparação.

Ao final, faça 5 perguntas de verdadeiro ou falso sobre ordem e ordenação.

---

## Parte 4: Critérios Para Escolher a Coleção

Monte um guia de decisão para escolher entre:

- `ArrayList`
- `LinkedList`
- `ArrayDeque`
- `PriorityQueue`
- `HashSet`
- `LinkedHashSet`
- `TreeSet`
- `HashMap`
- `LinkedHashMap`
- `TreeMap`

Use os critérios:

1. Preciso de acesso por índice?
2. Preciso permitir duplicados?
3. Preciso remover duplicados?
4. Preciso preservar ordem de inserção?
5. Preciso manter elementos ordenados?
6. Preciso associar chave e valor?
7. Preciso de fila, pilha ou prioridade?
8. Preciso de desempenho eficiente em busca, inserção ou remoção?

Gere uma tabela com:

| Situação | Melhor escolha | Justificativa | Cuidado |

Depois proponha 5 cenários e peça para eu escolher a coleção adequada.

---

## Parte 5: Listas

Explique `ArrayList` e `LinkedList`.

Para `ArrayList`, aborde:

- array redimensionável;
- ordem por posição;
- permite duplicados;
- permite `null`;
- acesso por índice eficiente;
- inserção/remoção no meio com custo maior;
- uso com generics.

Para `LinkedList`, aborde:

- lista duplamente encadeada;
- também implementa `Deque`;
- acesso por índice menos eficiente;
- operações nas extremidades;
- uso como lista, fila ou pilha.

Crie exemplos pequenos com:

```java
ArrayList<String>
LinkedList<String>
```

Depois crie um exemplo com tipo complexo, como:

```java
class Produto
```

Mostre pelo menos:

- adicionar;
- remover;
- buscar;
- alterar;
- iterar;
- remover com `Iterator`.

Ao final, gere um exercício prático usando `ArrayList` ou `LinkedList`.

---

## Parte 6: Queue, Deque e PriorityQueue

Explique:

1. O que é `Queue`.
2. O que é `Deque`.
3. Quando usar `ArrayDeque`.
4. Quando usar `PriorityQueue`.

Para `ArrayDeque`, mostre exemplos como:

- fila FIFO;
- pilha LIFO;
- operações nas extremidades;
- cuidado com `null`.

Para `PriorityQueue`, explique:

- a cabeça da fila;
- ordem natural;
- uso de `Comparator`;
- uso de `Comparable`;
- por que a iteração não garante ordem de prioridade.

Crie um exemplo com `PriorityQueue<String>` e outro com tipo complexo, como:

```java
class Atendimento implements Comparable<Atendimento>
```

Depois proponha um exercício em que a solução natural envolva `PriorityQueue`.

---

## Parte 7: Set

Explique e compare:

- `HashSet`
- `LinkedHashSet`
- `TreeSet`

Aborde:

1. Como cada um trata duplicados.
2. Qual ordem cada um garante ou não garante.
3. Se permite `null`.
4. Qual contrato é importante:
   - `equals`/`hashCode` para `HashSet` e `LinkedHashSet`;
   - `Comparable`/`Comparator` para `TreeSet`.
5. Complexidade aproximada das principais operações.

Explique com cuidado:

- `HashSet` não garante ordem;
- `LinkedHashSet` preserva ordem de inserção;
- `TreeSet` mantém os elementos ordenados;
- em `TreeSet`, se `compareTo` ou `Comparator` retorna `0`, os objetos são tratados como equivalentes para a coleção.

Crie um exemplo com `String` e outro com tipo complexo.

Depois gere 5 perguntas de previsão de saída.

---

## Parte 8: Map

Explique e compare:

- `HashMap`
- `LinkedHashMap`
- `TreeMap`

Aborde:

1. Chaves e valores.
2. Chaves duplicadas.
3. `null`.
4. Ordem ou ordenação.
5. Uso de `keySet`, `values` e `entrySet`.
6. Complexidade aproximada.
7. Quando usar cada implementação.

Explique:

- `HashMap` não garante ordem;
- `LinkedHashMap` preserva ordem de inserção ou acesso;
- `TreeMap` ordena pelas chaves;
- em `TreeMap`, a comparação das chaves define equivalência e duplicidade.

Crie exemplos usando:

```java
Map<String, Integer>
Map<String, Produto>
```

Depois proponha um exercício envolvendo catálogo, estoque, ranking ou índice por código.

---

## Parte 9: Contratos Importantes

Explique com exemplos:

1. `equals`
2. `hashCode`
3. `Comparable`
4. `Comparator`

Mostre por que esses contratos afetam:

- `HashSet`
- `HashMap`
- `LinkedHashSet`
- `LinkedHashMap`
- `TreeSet`
- `TreeMap`
- `PriorityQueue`

Inclua alertas sobre:

- não alterar atributos usados em `equals`/`hashCode` depois que o objeto foi inserido em `HashSet` ou usado como chave em `HashMap`;
- não alterar atributos usados na comparação depois de inserir objetos em `TreeSet` ou chaves em `TreeMap`;
- manter comparação consistente com a ideia de igualdade lógica.

Depois gere um mini questionário com 5 perguntas.

---

## Parte 10: Classe Collections

Explique a classe `java.util.Collections`.

Aborde os métodos:

- `sort`
- `binarySearch`
- `reverse`
- `shuffle`
- `min`
- `max`
- `frequency`
- `disjoint`
- `addAll`
- `unmodifiableList`
- `synchronizedList`
- `checkedList`
- `emptyList`
- `singletonList`
- `nCopies`

Explique também:

- o que são wrappers;
- o que são coleções não modificáveis;
- por que algumas operações podem lançar `UnsupportedOperationException`.

Crie um exemplo pequeno usando uma lista de notas.

Depois proponha um exercício que use pelo menos 4 métodos de `Collections`.

---

## Parte 11: Fábricas Modernas

Explique os métodos:

- `List.of`
- `Set.of`
- `Map.of`

Mostre exemplos e destaque:

1. Criam coleções pequenas e imutáveis.
2. Não aceitam `null`.
3. Não permitem `add`, `remove` ou `clear`.
4. `Set.of` e `Map.of` não aceitam duplicados.
5. Para modificar depois, é necessário criar uma coleção modificável, por exemplo:

```java
List<String> nomes = new ArrayList<>(List.of("Ana", "Bruno"));
```

Compare brevemente com `Collections.emptyList`, `singletonList`, `nCopies` e `unmodifiableList`.

---

## Parte 12: Casos de Borda e Erros Comuns

Explique e exemplifique:

1. Remover elementos de uma coleção durante `for-each`.
2. Usar `Iterator.remove`.
3. Depender da ordem de `HashSet` ou `HashMap`.
4. Achar que `PriorityQueue` itera em ordem de prioridade.
5. Usar objetos mutáveis como chave de `HashMap`.
6. Usar `TreeSet` com `Comparator` que considera objetos diferentes como equivalentes.
7. Tentar modificar coleção imutável ou não modificável.
8. Inserir `null` em coleções que não aceitam `null`.

Para cada erro, mostre:

- código problemático;
- explicação;
- versão corrigida.

---

## Parte 13: Prática Guiada

Crie uma sequência de exercícios progressivos:

1. Exercício com `ArrayList`.
2. Exercício com `LinkedList`.
3. Exercício com `ArrayDeque`.
4. Exercício com `PriorityQueue`.
5. Exercício com `HashSet`.
6. Exercício com `LinkedHashSet`.
7. Exercício com `TreeSet`.
8. Exercício com `HashMap`.
9. Exercício com `LinkedHashMap`.
10. Exercício com `TreeMap`.
11. Exercício com `Collections`.

Para cada exercício, forneça:

- enunciado;
- entrada;
- saída esperada;
- restrições;
- 3 dicas progressivas;
- 5 casos de teste;
- explicação da estrutura escolhida;
- solução apenas se eu pedir explicitamente.

---

## Parte 14: Revisão Ativa

Faça uma revisão final no formato de entrevista.

Pergunte uma questão por vez sobre:

- escolha da coleção adequada;
- ordem vs ordenação;
- duplicidade;
- `null`;
- desempenho;
- `equals`/`hashCode`;
- `Comparable`/`Comparator`;
- `Collections`;
- `List.of`, `Set.of`, `Map.of`.

Espere minha resposta antes de continuar.

Quando eu errar:

1. explique o erro;
2. mostre um contraexemplo;
3. faça uma nova pergunta parecida.

Quando eu acertar:

1. confirme;
2. complemente com um detalhe importante;
3. avance para a próxima pergunta.

---

## Regras Para Suas Respostas

- Use Java 21.
- Use exemplos curtos e executáveis.
- Prefira `List`, `Set`, `Map`, `Queue` e `Deque` como tipo da variável quando fizer sentido.
- Explique a escolha da implementação concreta.
- Não use APIs fora do escopo da aula, a menos que eu peça.
- Não resolva exercícios imediatamente; primeiro dê dicas.
- Sempre destaque cuidados com ordem, duplicidade, `null`, mutabilidade e desempenho.
- Quando comparar estruturas, use tabelas.
- Quando eu pedir um exercício, inclua casos de teste.
- Quando eu pedir revisão, faça perguntas uma de cada vez.
```