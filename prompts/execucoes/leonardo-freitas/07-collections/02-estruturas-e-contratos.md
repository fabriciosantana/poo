# Parte 5 — Listas

`ArrayList` usa array redimensionável: acesso indexado `O(1)`, adição ao fim amortizada `O(1)` e inserção/remoção no meio `O(n)`. Preserva posições, admite duplicados e `null`. `LinkedList` usa nós duplamente encadeados: acesso por índice `O(n)`, operações nas pontas `O(1)`; implementa também `Deque`. Prefira a interface `List` quando métodos exclusivos da implementação não forem necessários.

~~~java
List<String> nomes = new ArrayList<>(List.of("Ana", "Bia"));
nomes.add("Ana");                  // duplicados
nomes.set(1, "Beatriz");           // alteração
System.out.println(nomes.get(0));  // acesso
nomes.remove("Ana");               // remove primeira ocorrência
for (String nome : nomes) System.out.println(nome);
Iterator<String> it = nomes.iterator();
while (it.hasNext()) if (it.next().startsWith("B")) it.remove();
~~~

~~~java
LinkedList<String> fila = new LinkedList<>();
fila.addFirst("Bia");
fila.addLast("Caio");
System.out.println(fila.removeFirst()); // Bia
~~~

**Objeto complexo:**

~~~java
record Produto(int codigo, String nome) {}
List<Produto> produtos = new ArrayList<>();
produtos.add(new Produto(1, "Caderno"));
produtos.add(new Produto(2, "Caneta"));
Produto buscado = produtos.get(0);
produtos.set(1, new Produto(2, "Caneta azul"));
for (Produto p : produtos) System.out.println(p);
Iterator<Produto> it = produtos.iterator();
while (it.hasNext()) if (it.next().codigo() == 1) it.remove();
~~~

**Exercício:** montar uma lista de produtos, incluir 5, atualizar o de código 3, buscar código 4, remover os de preço zero via `Iterator.remove` e listar resultados. Valide lista vazia, duplicidade de nomes, alteração e remoção. *Dica 1:* comece com `ArrayList<Produto>`. *Dica 2:* faça busca com `for`. *Dica 3:* remova com `Iterator`.

# Parte 6 — Queue, Deque e PriorityQueue

`Queue` representa processamento por uma disciplina de fila; métodos não excepcionais incluem `offer`, `poll` e `peek`. `Deque` permite atuação nas duas extremidades (`addFirst`, `addLast`, `removeFirst`, `removeLast`). `ArrayDeque` é boa para FIFO e LIFO (pilha), com custo amortizado `O(1)` nas pontas, **sem `null`**.

~~~java
Deque<String> fifo = new ArrayDeque<>();
fifo.offerLast("A"); fifo.offerLast("B");
System.out.println(fifo.pollFirst()); // A

Deque<String> pilha = new ArrayDeque<>();
pilha.push("base"); pilha.push("topo");
System.out.println(pilha.pop()); // topo
~~~

`PriorityQueue` usa heap: `peek` traz o menor elemento pela ordenação natural, ou o de maior prioridade segundo o `Comparator`. Oferecer e retirar tipicamente custam `O(log n)`. Não aceita `null`. `Comparable` define comparação padrão do próprio tipo, enquanto `Comparator` define estratégia alternativa. A **iteração não garante classificação**; retirar repetidamente com `poll` respeita a prioridade.

~~~java
Queue<String> nomes = new PriorityQueue<>();
nomes.add("Zoe"); nomes.add("Ana"); nomes.add("Bia");
while (!nomes.isEmpty()) System.out.print(nomes.poll() + " "); // Ana Bia Zoe
~~~

~~~java
record Atendimento(String paciente, int gravidade)
        implements Comparable<Atendimento> {
    @Override public int compareTo(Atendimento outro) {
        return Integer.compare(outro.gravidade, this.gravidade); // maior primeiro
    }
}
Queue<Atendimento> atendimentos = new PriorityQueue<>();
atendimentos.add(new Atendimento("Bia", 2));
atendimentos.add(new Atendimento("Ana", 5));
System.out.println(atendimentos.poll().paciente()); // Ana
~~~

Para desempates, inclua outra chave no comparador (ex.: número de chegada) se o sistema exigir estabilidade.

**Exercício:** triagem de chamados de suporte: maior severidade primeiro; em empate, ordem de chegada. *Dica 1:* modele os dados. *Dica 2:* comparador composto. *Dica 3:* `poll` até a fila esvaziar.

# Parte 7 — Set

| Tipo | Duplicados | Ordem | `null` | Consulta/inserção |
|---|---|---|---|---|
| `HashSet` | Não | Não garantida | Aceita um | Esperado `O(1)` |
| `LinkedHashSet` | Não | Inserção | Aceita um | Esperado `O(1)` |
| `TreeSet` | Não, conforme comparação | Ordenação por comparação | Em ordem natural, rejeita `null` | `O(log n)` |

Em `HashSet` e `LinkedHashSet`, objetos lógicos precisam implementar `equals`/`hashCode` coerentes. Em `TreeSet`, `Comparable` ou `Comparator` pode considerar objetos equivalentes se retornar `0`, mesmo que tenham outros atributos diferentes.

~~~java
Set<String> unico = new LinkedHashSet<>(List.of("azul", "verde", "azul"));
System.out.println(unico); // [azul, verde]
Set<String> ordenado = new TreeSet<>(unico);
System.out.println(ordenado); // [azul, verde] (ordem alfabética)
~~~

~~~java
record Pessoa(int id, String nome) {}
Set<Pessoa> pessoas = new HashSet<>();
pessoas.add(new Pessoa(1, "Ana"));
pessoas.add(new Pessoa(1, "Ana")); // equals/hashCode do record: somente uma

Set<Pessoa> porId = new TreeSet<>(Comparator.comparingInt(Pessoa::id));
porId.add(new Pessoa(1, "Ana"));
porId.add(new Pessoa(1, "Outra")); // rejeita: comparação por id resulta 0
~~~

**Previsão de saídas** (não olhe o gabarito antes de tentar):

1. `new HashSet<>(List.of("A","A","B")).size()`
2. `new LinkedHashSet<>(List.of("B","A","B")).toString()`
3. `new TreeSet<>(List.of(3,1,2)).first()`
4. `new TreeSet<>(List.of(3,1,2)).last()`
5. `new TreeSet<>(String.CASE_INSENSITIVE_ORDER)`, adicionando `"Java"` e `"JAVA"`: qual tamanho?

Gabarito para autocorreção: 2; [B, A]; 1; 3; 1. Não exija ordem de impressão de `HashSet`.

# Parte 8 — Map

`Map<K,V>` associa **chaves únicas** a valores (que podem repetir). Um `put` com chave já existente substitui seu valor. `keySet()` fornece visão de chaves, `values()` uma coleção de valores e `entrySet()` uma visão de entradas que permite iterar chave e valor juntos.

| Tipo | Ordem | `null` | Busca/inserção |
|---|---|---|---|
| `HashMap` | Não garantida | Uma chave nula e valores nulos | Esperado `O(1)` |
| `LinkedHashMap` | Inserção ou acesso (configurável no construtor) | Uma chave nula e valores nulos | Esperado `O(1)` |
| `TreeMap` | Chaves ordenadas por comparação | Chave `null` proibida com ordenação natural; valores nulos permitidos | `O(log n)` |

Em `TreeMap`, comparação de chaves igual a 0 significa **mesma chave lógica para o mapa**.

~~~java
Map<String, Integer> estoque = new HashMap<>();
estoque.put("LAPIS", 10);
estoque.put("LAPIS", 11); // substitui
for (Map.Entry<String,Integer> entrada : estoque.entrySet())
    System.out.println(entrada.getKey() + ": " + entrada.getValue());

Map<String, Produto> catalogo = new TreeMap<>();
catalogo.put("A01", new Produto(1, "Caderno"));
System.out.println(catalogo.keySet());
System.out.println(catalogo.values());
~~~

**Exercício:** um estoque recebe registros de código e quantidade, substitui a quantidade para códigos repetidos e permite listar em ordem de código. *Dica 1:* use `Map`. *Dica 2:* escolha `TreeMap`. *Dica 3:* percorra `entrySet`.

# Parte 9 — Contratos importantes

- **`equals`** decide se dois objetos representam o mesmo valor lógico.
- **`hashCode`** calcula o hash; se `a.equals(b)`, então `a.hashCode() == b.hashCode()`, mas o contrário não é obrigatório.
- **`Comparable<T>`** declara a ordenação natural via `compareTo`.
- **`Comparator<T>`** estabelece uma ordenação externa, selecionável por uso.

`HashSet`, `HashMap`, `LinkedHashSet`, `LinkedHashMap` dependem do contrato hash/equality para deduplicação e localização. `TreeSet`, `TreeMap` dependem do comparador para organização e equivalência. `PriorityQueue` usa a comparação para escolher a cabeça, mas aceita múltiplos elementos equivalentes.

~~~java
record Aluno(int matricula, String nome) {}
Set<Aluno> alunos = new HashSet<>();
alunos.add(new Aluno(7, "Lia"));
alunos.add(new Aluno(7, "Lia")); // somente um, pois record tem equals/hashCode

Comparator<Aluno> porNome = Comparator.comparing(Aluno::nome)
    .thenComparingInt(Aluno::matricula);
Set<Aluno> ordenados = new TreeSet<>(porNome);
~~~

**Cuidados:** não modifique campos usados por `equals`/`hashCode` após inserção em `HashSet` ou como chave de `HashMap`. Também não altere campos do comparador após inserção em `TreeSet`/`TreeMap`. Prefira chaves imutáveis e comparação consistente com a noção de identidade lógica.

**Miniquestionário — 5 perguntas:**

1. Dois objetos iguais podem ter `hashCode` diferente?
2. Se dois `hashCode` são iguais, `equals` deve retornar `true`?
3. O que ocorre se um comparador do `TreeSet` retornar zero para objetos diferentes?
4. Por que editar o código identificador de uma chave de `HashMap` pode tornar `get` ineficaz?
5. Qual é a diferença funcional entre implementar `Comparable` e fornecer `Comparator`?

Gabarito conceitual para conferir depois de responder: 1 não; 2 não; 3 tratados como equivalentes, segundo não entra; 4 hash da chave pode mudar; 5 natural no tipo vs. estratégia externa.
