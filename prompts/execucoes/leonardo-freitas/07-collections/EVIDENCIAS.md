# Evidências e validação — prompt 07 Collections

## Ambiente previsto

- Java 21, especificado em `prompts/07-collections.md`.
- Classes: `CollectionsDemo` e `CollectionsDemoTest`, sem bibliotecas externas.
- Casos automatizados: 34 verificações de coleção, comparação e exceções, incluindo comportamentos específicos do Java 21.

## Como reproduzir

~~~sh
java -version
javac -version
mkdir -p out
javac -encoding UTF-8 --release 21 -d out src/CollectionsDemo.java src/CollectionsDemoTest.java
java -cp out CollectionsDemo
java -ea -cp out CollectionsDemoTest
~~~

O teste encerra com `TESTES_OK: 34 verificações executadas` quando as assertivas passam. **Não considerar esta frase como um log de execução**: ela descreve o comportamento esperado do programa.

## Estado verificável

- Os arquivos-fonte e as atividades documentadas estão versionados na branch da entrega.
- A execução de compilação/testes do **conteúdo versionado** ainda precisa ser confirmada com um log real Java 21. Não são apresentados logs inventados.
- Os 55 casos de teste dos 11 exercícios pedagógicos são **cenários propostos**, não resultados de implementações concluídas.
- A parte 14 exige interação real com o aluno e permanece **em andamento**.
- O enunciado externo solicita **link da execução do prompt**. Link de PR ou arquivo GitHub é evidência adicional, não substitui necessariamente o link público da conversa.
