# Parte 10 — Classe `java.util.Collections`

`Collections` é uma classe utilitária com algoritmos estáticos, *wrappers* e fábricas de coleções. Não confundir `Collection` (interface) com `Collections` (classe).

| Método | Uso e cuidado |
|---|---|
| `sort(lista)` | Ordena uma `List` modificável, conforme ordem natural ou comparador. |
| `binarySearch(lista, chave)` | Busca binária; **a lista deve estar ordenada pelo mesmo critério**. Retorna índice ou valor negativo. |
| `reverse(lista)` | Inverte a sequência sem classificar. |
| `shuffle(lista)` | Embaralha; a saída varia salvo gerador controlado. |
| `min(colecao)` | Menor elemento por comparação. |
| `max(colecao)` | Maior elemento por comparação. |
| `frequency(colecao, elemento)` | Conta ocorrências segundo igualdade. |
| `disjoint(a,b)` | `true` quando não há elementos comuns. |
| `addAll(colecao, elementos...)` | Insere vários elementos. |
| `unmodifiableList(lista)` | Visão não modificável; **mudanças no objeto de origem continuam visíveis**. |
| `synchronizedList(lista)` | Wrapper sincronizado; iteração externa ainda exige sincronização explícita. |
| `checkedList(lista, classe)` | Verificação de tipo em inserções (especialmente código legado sem generics). |
| `emptyList()` | Lista vazia não modificável. |
| `singletonList(x)` | Lista não modificável com um elemento; aceita `null`. |
| `nCopies(n,x)` | Lista não modificável com n referências ao mesmo objeto. |

Uma **visão não modificável** lança `UnsupportedOperationException` para alterações via visão. Isso é diferente de cópia independente; e objetos armazenados podem continuar mutáveis.

~~~java
List<Integer> notas = new ArrayList<>(List.of(8, 5, 10, 8));
Collections.sort(notas);
System.out.println(notas); // [5, 8, 8, 10]
System.out.println(Collections.binarySearch(notas, 8)); // índice de um 8
System.out.println(Collections.frequency(notas, 8)); // 2
System.out.println(Collections.min(notas)); // 5
System.out.println(Collections.max(notas)); // 10
Collections.reverse(notas);
System.out.println(notas); // [10, 8, 8, 5]
~~~

**Exercício:** dada uma lista mutável de notas, usar pelo menos quatro métodos `Collections` para ordenar, descobrir mínimo/máximo, contar uma nota e verificar se uma segunda turma tem notas em comum. Não fornecemos a solução antes da tentativa.

# Parte 11 — Fábricas modernas

`List.of`, `Set.of`, `Map.of` criam objetos **não modificáveis**; tentar `add`, `remove`, `clear` ou `put` lança `UnsupportedOperationException`. Elas não aceitam valores `null`; `Set.of` rejeita elementos duplicados e `Map.of` rejeita chaves repetidas. `Map.of` também rejeita valores `null`. Não conte com ordem específica em `Set.of` e `Map.of`.

~~~java
List<String> imutavel = List.of("Ana", "Bia");
Set<String> etiquetas = Set.of("A", "B");
Map<Integer, String> alunos = Map.of(1, "Ana", 2, "Bia");
List<String> editavel = new ArrayList<>(List.of("Ana", "Bia"));
editavel.add("Caio");
~~~

`Collections.emptyList`, `singletonList` e `nCopies` também produzem listas não modificáveis; `Collections.unmodifiableList` é uma visão de lista existente e reflete mudanças realizadas diretamente na origem. `List.of` constrói uma coleção não modificável independente da lista externa. Em todos os casos, a imutabilidade é **estrutural**, não congela objetos mutáveis contidos.

# Parte 12 — Oito erros de borda e correções

## 1. Remover dentro de for-each

**Problema:**

~~~java
List<String> nomes = new ArrayList<>(List.of("Ana", "Bia"));
for (String nome : nomes) if (nome.equals("Ana")) nomes.remove(nome);
~~~

A alteração estrutural fora do iterador pode causar `ConcurrentModificationException` ou comportamento não confiável; o exemplo pequeno não garante exceção em todas as execuções.

**Correção:**

~~~java
Iterator<String> it = nomes.iterator();
while (it.hasNext()) if (it.next().equals("Ana")) it.remove();
~~~

## 2. Chamar `Iterator.remove` na hora errada

**Problema:**

~~~java
Iterator<Integer> it = new ArrayList<>(List.of(1,2)).iterator();
it.remove(); // IllegalStateException: next() ainda não foi chamado
~~~

**Correção:**

~~~java
Iterator<Integer> it = new ArrayList<>(List.of(1,2)).iterator();
if (it.hasNext()) { it.next(); it.remove(); }
~~~

## 3. Depender da ordem de HashSet/HashMap

**Problema:**

~~~java
System.out.println(new HashSet<>(List.of("B", "A"))); // ordem NÃO contratual
~~~

**Correção:**

~~~java
System.out.println(new LinkedHashSet<>(List.of("B", "A"))); // [B, A]
Map<String,Integer> mapa = new LinkedHashMap<>();
mapa.put("B", 2); mapa.put("A", 1);
System.out.println(mapa.keySet()); // [B, A]
~~~

## 4. Supor iteração ordenada em PriorityQueue

**Problema:**

~~~java
Queue<Integer> q = new PriorityQueue<>(List.of(4, 1, 3, 2));
for (int x : q) System.out.println(x); // NÃO é garantia de 1,2,3,4
~~~

**Correção:**

~~~java
while (!q.isEmpty()) System.out.println(q.poll()); // 1,2,3,4
~~~

## 5. Chave mutável no HashMap

**Problema:**

~~~java
class Chave {
    int id;
    Chave(int id) { this.id = id; }
    public int hashCode() { return Integer.hashCode(id); }
    public boolean equals(Object o) { return o instanceof Chave c && c.id == id; }
}
Chave chave = new Chave(5);
Map<Chave,String> mapa = new HashMap<>();
mapa.put(chave, "valor");
chave.id = 9; // altera o hash depois da inserção
~~~

O `mapa.get(chave)` pode retornar `null` porque o bucket calculado não é o original.

**Correção:**

~~~java
record ChaveImutavel(int id) {}
Map<ChaveImutavel,String> seguro = new HashMap<>();
seguro.put(new ChaveImutavel(5), "valor");
~~~

## 6. Comparator muito amplo em TreeSet

**Problema:**

~~~java
record Pessoa(String nome, int id) {}
Set<Pessoa> pessoas = new TreeSet<>(Comparator.comparing(Pessoa::nome));
pessoas.add(new Pessoa("Ana", 1));
pessoas.add(new Pessoa("Ana", 2)); // rejeitada: nomes comparados iguais
~~~

**Correção:**

~~~java
Set<Pessoa> pessoas = new TreeSet<>(
    Comparator.comparing(Pessoa::nome).thenComparingInt(Pessoa::id));
pessoas.add(new Pessoa("Ana", 1));
pessoas.add(new Pessoa("Ana", 2)); // distintas pelo id
~~~

## 7. Tentar alterar uma coleção não modificável

**Problema:**

~~~java
List<String> nomes = List.of("Ana");
nomes.add("Bia"); // UnsupportedOperationException
~~~

**Correção:**

~~~java
List<String> nomes = new ArrayList<>(List.of("Ana"));
nomes.add("Bia");
~~~

## 8. Inserir null em estruturas que não aceitam

**Problema:**

~~~java
Deque<String> fila = new ArrayDeque<>();
fila.add(null); // NullPointerException
List.of("Ana", null); // NullPointerException
~~~

**Correção:**

~~~java
Deque<String> fila = new ArrayDeque<>();
String nome = null;
if (nome != null) fila.add(nome);
List<String> lista = new ArrayList<>();
lista.add(null); // permitido pela ArrayList, se fizer sentido no domínio
~~~

**Resumo:** a escolha correta depende da política de ordem, comparação, duplicidade, `null`, possibilidade de modificação e complexidade. Testar casos de fronteira faz parte do desenho da solução.
