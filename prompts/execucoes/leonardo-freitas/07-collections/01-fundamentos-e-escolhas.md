# Parte 1 — Visão geral do Java Collections Framework

O **Java Collections Framework (JCF)** reúne interfaces (contratos), implementações (estruturas concretas) e algoritmos para armazenar e manipular grupos de objetos. É uma **arquitetura unificada** porque os mesmos métodos e contratos permitem substituir uma implementação por outra com poucas mudanças no código cliente.

Uma coleção frequentemente é melhor do que um array porque pode crescer dinamicamente, tem operações prontas (`add`, `remove`, `contains`), combina com genéricos e oferece diferentes políticas de ordenação, unicidade e consulta. Arrays ainda são adequados para tamanho fixo, primitivos e cenários em que o baixo overhead é decisivo.

**Interface** = comportamento prometido; **implementação** = estratégia de armazenamento e desempenho.

~~~java
List<String> nomes = new ArrayList<>();
Set<Integer> codigos = new HashSet<>();
Map<String, Produto> alunosOuProdutos = new HashMap<>();
~~~

Declarar pela interface diminui acoplamento: uma `List` pode trocar `ArrayList` por `LinkedList` se os requisitos mudarem. Cuidado: a escolha concreta ainda afeta ordem, memória, `null` e custo de operações.

**Pergunta de verificação:** Se `List<String> nomes = new ArrayList<>();` compila, quem define o conjunto de operações que o compilador permite acessar pela variável `nomes`: `List` ou `ArrayList`? Explique o papel de cada uma.

# Parte 2 — Interfaces principais

| Interface | Ideia principal | Exemplo de implementação |
|---|---|---|
| `Collection<E>` | Contrato-base para grupos de elementos | `ArrayList` |
| `List<E>` | Sequência indexada, aceita repetidos | `ArrayList`, `LinkedList` |
| `Set<E>` | Elementos sem duplicidade lógica | `HashSet` |
| `Queue<E>` | Processamento em fila, regra de remoção específica | `ArrayDeque` |
| `Deque<E>` | Inserção/remoção nas duas extremidades | `ArrayDeque` |
| `Map<K,V>` | Associação de chaves e valores, chaves únicas | `HashMap` |
| `SortedSet<E>` | `Set` ordenado por comparação | `TreeSet` |
| `NavigableSet<E>` | `SortedSet` com consultas de vizinhança | `TreeSet` |
| `SortedMap<K,V>` | `Map` ordenado por chaves | `TreeMap` |
| `NavigableMap<K,V>` | `SortedMap` com consultas de proximidade | `TreeMap` |
| `SequencedCollection<E>` | Coleção com ordem de encontro definida, acesso às pontas e reversão | `ArrayList` |
| `SequencedSet<E>` | Set com ordem de encontro definida | `LinkedHashSet` |
| `SequencedMap<K,V>` | Map com ordem de encontro definida e entradas nas pontas | `LinkedHashMap` |

**Atenção:** `Map` integra o framework, mas **não** estende `Collection`. `List` organiza elementos por posições; `Set` elimina duplicidade; `Queue` modela uma fila, que pode usar FIFO ou prioridade; `Deque` é fila de duas pontas. As interfaces `Sequenced*` (Java 21) caracterizam ordem de **encontro/iteração**, não necessariamente ordenação por comparação. `TreeSet` e `TreeMap` também têm ordem, porém definida por comparadores. Uma `HashSet` não implementa `SequencedSet`.

# Parte 3 — Ordem × ordenação

**Ordem** é a sequência observável de elementos na iteração; **ordenação** é o critério de comparação que impõe uma relação entre eles. Manter ordem de inserção **não significa** classificar alfabeticamente.

| Estrutura | Ordem de iteração | Ordenação por valor/chave |
|---|---|---|
| `ArrayList` | Índice/inserção, salvo mudanças | Não automática |
| `LinkedList` | Sequência da lista | Não automática |
| `ArrayDeque` | Da frente para trás | Não |
| `PriorityQueue` | Iteração não ordenada | A cabeça respeita prioridade |
| `HashSet` | Não garantida | Não |
| `LinkedHashSet` | Inserção | Não |
| `TreeSet` | Crescente pelo comparador | Sim |
| `HashMap` | Não garantida | Não |
| `LinkedHashMap` | Inserção; pode configurar acesso | Não |
| `TreeMap` | Chaves crescentes pelo comparador | Sim |

Nem `HashSet` nem `HashMap` servem quando a ordem faz parte da regra de negócio: o resultado pode mudar com rehash, versão da JVM ou novas inserções. A `PriorityQueue` implementa heap: `peek()` e `poll()` priorizam a cabeça; `for-each` **não** exibe a fila inteiramente em ordem de prioridade. `TreeSet` e `TreeMap` mantêm classificação de acordo com `Comparable` ou `Comparator`; em `TreeMap` compara-se a **chave**.

**Verdadeiro ou falso — responda antes de verificar:**

1. Um `LinkedHashSet` preserva ordem de inserção, mas não classifica alfabeticamente.
2. Iterar uma `PriorityQueue` devolve sempre os elementos em ordem de prioridade.
3. `TreeMap` ordena registros com base nos valores associados às chaves.
4. Uma `HashSet` pode aparentar estar ordenada em testes, sem oferecer essa garantia.
5. `ArrayList` permite duplicados e mantém a posição de inserção, salvo alterações explícitas.

Gabarito para autocorreção **após responder**: V, F, F, V, V.

# Parte 4 — Guia de decisão

Antes de escolher, pergunte: preciso de índice? aceito duplicados? quero removê-los? ordem de inserção é relevante? preciso de ordenação por comparação? pares chave–valor? FIFO/LIFO/prioridade? quais operações serão mais frequentes?

| Situação | Melhor escolha | Justificativa | Cuidado |
|---|---|---|---|
| Ler frequentemente por índice | `ArrayList` | Acesso `O(1)` | Inserir no início desloca elementos `O(n)` |
| Remover nas extremidades e também usar List | `LinkedList` | Extremidades `O(1)` | Índices `O(n)`, overhead de nós |
| Fila FIFO ou pilha LIFO | `ArrayDeque` | Pontas `O(1)` amortizado | Não admite `null` |
| Atender maior prioridade | `PriorityQueue` | Inserir/remover `O(log n)` | Iteração não ordenada |
| Deduplicar sem requisito de ordem | `HashSet` | Busca/adição esperada `O(1)` | Sem ordem garantida |
| Deduplicar e preservar inserção | `LinkedHashSet` | Unicidade + ordem de encontro | Mais memória que `HashSet` |
| Deduplicar e ordenar | `TreeSet` | Consulta e ordem `O(log n)` | Comparador define equivalência |
| Busca por código | `HashMap` | Associação esperada `O(1)` | Ordem não garantida |
| Dicionário com ordem de cadastro | `LinkedHashMap` | Chaves únicas + inserção | Atualizar valor não muda posição por padrão |
| Consultas por intervalos de chave | `TreeMap` | `subMap` e busca `O(log n)` | Chaves precisam ser comparáveis |

As complexidades são típicas, não garantias universais: colisões, redimensionamento e distribuição dos dados alteram custos.

**Cinco cenários para o aluno decidir e justificar:**

1. Um feed exibe publicações exatamente na ordem em que chegaram, sem perder duplicados.
2. Uma fila de atendimento médico deve chamar antes quem tiver maior gravidade.
3. Um sistema guarda CPFs únicos na ordem em que foram cadastrados.
4. Um catálogo precisa consultar todos os produtos entre dois códigos.
5. Um contador relaciona o nome do produto ao número de vendas, sem precisar manter ordem.

**Critério de correção:** justificar por índice, duplicidade, ordem, `null`, mutabilidade e complexidade; não basta citar o nome da classe.
