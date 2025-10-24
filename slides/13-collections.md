---
layout: frontcover
transition: none
title: IDP - POO
id: aula13
lesson: Framework Collections
goals:
  - Conhecer as das principais interfaces do Framework Collections
  - Conhecer as principais classes do Framework Collections
  - Explorar algoritmos utilitários em `Collections`
  - Iterar elementos usando `Iterator`, `forEach` e `Spliterator`
---

---
layout: default
lesson: Framework Collections
---

## Framework Collections

- [Collections](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-index.html)
  - É uma estrutura de dados que pode conter referências a outros objetos​
  - Pode conter referências a objetos de qualquer tipo que tenham o relacionamento "é um" com o tipo de elemento da coleção
- Generic
  - Permitem especificar o tipo exato que será armazenado em uma coleção​
  - Viabiliza verificação de tipo em tempo de compilação
- [java.util.ArrayList](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html)
  - Estrutura de dados semelhante a um array que pode ser redimensionado dinamicamente​
  - Armazena referências a objetos de um tipo que você especifica ao criar o ArrayList

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Principais classes e interfaces

<FigureWithCaption
  src=images/collections-names.png
  link=https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-index.html
/>

---

## Principais classes e interfaces

- [java.util.Collection](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collection.html) (interface): contém métodos para realizar operações em toda a coleção​
- [java.util.List](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/List.html) (interface): é uma coleção de elementos em sequência que pode conter elementos duplicados.​
- [java.util.ArrayList](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html): array redimensionável​
- [java.util.LinkedList](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/LinkedList.html): permite a inserção (ou remoção) eficiente de elementos no meio de uma coleção, mas é muito menos eficiente que um ArrayList para pular para um elemento específico na coleção. ​
- [java.util.Iterator](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Iterator.html) (interface):  permite percorrer um coleção e remover elementos durante a iteração.​
- [java.util.ListIterator](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ListIterator.html) (interface):​

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

--- 

## Principais classes e interfaces

- [java.util.Queue](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Queue.html) (interface)​
- [java.util.PriorityQueue​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html)
- [java.util.Set](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html) (interface)​
- [java.util.HashSet​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashSet.html)
- [java.util.TreeSet​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeSet.html)
- [java.util.Map](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html) (interface)​
- [java.util.HashMap​](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html)
- [java.uti.TreeMap](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/TreeMap.html)

---

## Principais classes e interfaces

- [java.util.Collections](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collections.html): fornece métodos estáticos para pesquisar, ordenar e executar outras operações em coleções.​

<div class="grid grid-cols-2">
  <div>
    <li>sort</li>
    <li>binarySearch</li>
    <li>reverse</li>
    <li>shuffle</li>
    <li>fill</li>
    <li>copy</li>
  </div>
  <div>
    <li>min</li>
    <li>max</li>
    <li>addAll</li>
    <li>frequency</li>
    <li>disjoint</li>
  </div>
</div>

<Reference
  reference="DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.​"
/>

---

## Exemplo HashMap

```java
// HashMapDemo.java
Map<String, Double> accounts = new HashMap<>();
accounts.put("John Doe", 3434.34);
accounts.put("Jane Baker", 1378.00);

for (Map.Entry<String, Double> entry : accounts.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
double balance = accounts.get("John Doe");
accounts.put("John Doe", balance + 1000);
```
---

## Exemplo PriorityQueue

```java
// PriorityQueueTest.java
PriorityQueue<Double> queue = new PriorityQueue<>();
queue.offer(3.2);
queue.offer(9.8);
queue.offer(5.4);

while (!queue.isEmpty()) {
    System.out.printf("%.1f ", queue.poll());
}
```
---

## Algoritmos utilitários

```java
// CollectionsAlgorithmsDemo.java
LinkedList<Integer> numbers = new LinkedList<>();
numbers.add(-8);
numbers.add(20);
numbers.add(-20);
numbers.add(8);

Collections.sort(numbers, Collections.reverseOrder());
Collections.shuffle(numbers);
System.out.println("Minimum: " + Collections.min(numbers));
System.out.println("Maximum: " + Collections.max(numbers));
```

---
layout: backcover
---
