# I2-07 — Collections — 15-duplicate

**Aluno:** Leonardo Freitas  
**Disciplina:** Programação Orientada a Objetos — IDP  
**Professor:** Fabricio Santana  
**Enunciado:** `assignments/07-collections/15-duplicate/README.md` (branch `2026.2`)

## Solução

A aplicação `src/DuplicateNamesApp.java` cadastra primeiros nomes pelo terminal usando `Scanner`. A estrutura `Set<String>` recebe uma implementação `TreeSet<>(String.CASE_INSENSITIVE_ORDER)`, que:

- impede nomes repetidos mesmo com diferenças de maiúsculas/minúsculas (`Ana` equivale a `ana`);
- organiza os nomes alfabeticamente, conservando a grafia da primeira ocorrência inserida;
- informa se um nome pesquisado está cadastrado;
- encerra a inclusão com `fim` e a busca com `sair` (comandos sem diferenciação de caixa);
- ignora linhas vazias no cadastro e remove espaços no início/fim do texto;
- lida com término da entrada (EOF) sem bloquear ou lançar exceção.

## Executar (Java 21)

A partir desta pasta:

```sh
mkdir -p out
javac --release 21 -encoding UTF-8 -d out src/DuplicateNamesApp.java test/DuplicateNamesAppTest.java
java -cp out DuplicateNamesApp
java -cp out DuplicateNamesAppTest
```

Para Windows PowerShell, substitua `mkdir -p out` por `New-Item -ItemType Directory -Force -Path out`.

## Exemplo oficial

**Entrada:**

```text
Ana
Bruno
ana
Carlos
FIM
bruno
joão
sair
```

**Saída relevante:**

```text
Nomes cadastrados:
[Ana, Bruno, Carlos]

Pesquisar nomes (digite 'sair' para encerrar):
Nome encontrado.
Nome não encontrado.
```

## Evidências dos testes

Executado localmente com **OpenJDK 21**, com compilação `javac --release 21` sem erros e **14 cenários aprovados** em `test/DuplicateNamesAppTest.java`:

1. Exemplo oficial e ordem alfabética
2. Pesquisa positiva
3. Pesquisa negativa
4. Eliminação de duplicatas ignorando caixa, inclusive com acentos
5. Ordenação independentemente da sequência cadastrada
6. Espaços excedentes no cadastro
7. Espaços excedentes nas buscas
8. Lista inicialmente vazia
9. Ignorar linhas em branco
10. Comando `fim` com caixa variada e espaços
11. Comando `sair` com caixa variada e espaços
12. Duas buscas positivas em sequência
13. Duas buscas negativas em sequência
14. Fim de arquivo sem sentinela

Resultado observado: `TESTES_OK: 14 cenários validados`.

**Observação:** na branch `2026.2` atual, o caminho da tarefa é `assignments/07-collections/15-duplicate`, sem o prefixo antigo `01-programming` que aparece em alguns materiais. O workflow de submissões existente ainda se refere a esse caminho antigo e à branch `2026.1`; sua ausência de execução não invalida os testes locais descritos acima.
