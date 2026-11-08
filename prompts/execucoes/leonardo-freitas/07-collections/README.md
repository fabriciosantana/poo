# Execução documentada do prompt 07 — Java Collections Framework

**Aluno:** Leonardo Freitas  
**Disciplina:** Programação Orientada a Objetos — IDP  
**Professor:** Fabricio Santana  
**Prompt de origem:** [prompts/07-collections.md](../../../07-collections.md)  
**Referência:** branch `2026.2` — Java 21.

## Objetivo e alcance

Esta pasta é uma **execução de apoio documentada** das 14 partes do roteiro de estudo de Java Collections. O enunciado da atividade no ambiente virtual solicita **o link da execução do prompt**, e não estabelece que um pull request substitua esse link. Este material no GitHub serve como evidência técnica complementar.

| Partes | Arquivo | Conteúdo |
|---|---|---|
| 1–4 | [01-fundamentos-e-escolhas.md](01-fundamentos-e-escolhas.md) | Framework, interfaces, ordem e guia de decisão |
| 5–9 | [02-estruturas-e-contratos.md](02-estruturas-e-contratos.md) | List, Queue, Deque, Set, Map, equals/hashCode/Comparator |
| 10–12 | [03-collections-fabricas-erros.md](03-collections-fabricas-erros.md) | Classe Collections, fábricas modernas, 8 falhas corrigidas |
| 13–14 | [04-exercicios-e-revisao.md](04-exercicios-e-revisao.md) | 11 exercícios, 55 casos de teste, dicas e roteiro interativo |
| Exemplos | [src/CollectionsDemo.java](src/CollectionsDemo.java) | Demonstrações pequenas e executáveis |
| Testes | [src/CollectionsDemoTest.java](src/CollectionsDemoTest.java) | Testes de comportamento e casos de borda, sem dependências |
| Verificação | [EVIDENCIAS.md](EVIDENCIAS.md) | Comandos e resultados de compilação/execução |

## Como executar localmente (JDK 21)

A partir desta pasta:

~~~sh
mkdir -p out
javac -encoding UTF-8 --release 21 -d out src/CollectionsDemo.java src/CollectionsDemoTest.java
java -cp out CollectionsDemo
java -ea -cp out CollectionsDemoTest
~~~

Use JDK 21: as interfaces `SequencedCollection`, `SequencedSet` e `SequencedMap` foram adicionadas nessa versão.

## Sobre a entrega acadêmica

1. O link compartilhado da conversa na qual o prompt foi executado deve ser gerado por **Compartilhar** no ChatGPT e submetido no ambiente virtual, conforme o enunciado recebido.
2. Este repositório apresenta a execução documentada e o código testado; **o PR, por si só, não comprova a participação do aluno na revisão interativa**.
3. A Parte 13 pede solução somente se explicitamente solicitada; portanto, os 11 problemas de prática ficam propostos com dicas e testes, sem resolver as atividades de treinamento pelo aluno.
4. A Parte 14 exige perguntar **uma pergunta de cada vez**, esperar a resposta, dar feedback e só então avançar. Não é possível simular honestamente as respostas do aluno. O material contém a primeira pergunta e a pauta de avaliação para dar continuidade à conversa.
5. A especificação de `assignments/07b-collections` é uma atividade de programação distinta e não é afirmada como concluída aqui.

## Referências oficiais

- [Oracle — Collections Framework (Java 21)](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-index.html)
- [Oracle — Collections Overview](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-overview.html)
- [Oracle — Collections Outline](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-reference.html)
