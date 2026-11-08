# Parte 13 — Prática guiada (11 exercícios progressivos)

Estas atividades seguem a regra original: **não publicar a solução antes do aluno solicitá-la**. Cada cenário possui enunciado, entrada, saída esperada, restrições, três dicas em progressão e cinco testes para validação manual. As saídas exibem a **representação lógica**, não dependem da ordem incidental de hashes.

## Exercício 1 — ArrayList

**Enunciado:** Manter sequência de notas (0 a 10), inserir no final, alterar posição, remover primeira ocorrência de valor e consultar índice.

**Entrada de exemplo:** [7, 9, 7], alterar índice 1 para 8; remover valor 7.

**Saída esperada:** [8, 7].

**Restrições:** Use uma lista mutável; índices começam em zero; não faça remoção direta no for-each.

**Três dicas progressivas:**
1. Use uma lista mutável
2. índices começam em zero
3. não faça remoção direta no for-each.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[]; adicionar 5` | `[5]` |
| 2 | `[7,7]; remover 7` | `[7]` |
| 3 | `[1,2]; set(1,3)` | `[1,3]` |
| 4 | `[8]; procurar 9` | `não encontrado` |
| 5 | `[1,2]; remover índice inválido` | `validação, lista intacta` |

**Por que ArrayList:** índices eficientes e sequência dinâmica.

## Exercício 2 — LinkedList

**Enunciado:** Organizar uma fila de passageiros, inserir na frente e no fim, atender o primeiro e consultar o último.

**Entrada de exemplo:** [Ana, Bia], addFirst(Caio), pollFirst.

**Saída esperada:** Caio atendido, fila [Ana,Bia].

**Restrições:** Utilize LinkedList/Deque; diferencie peek/poll; confira fila vazia.

**Três dicas progressivas:**
1. Utilize LinkedList/Deque
2. diferencie peek/poll
3. confira fila vazia.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[]; pollFirst` | `null` |
| 2 | `[]; addLast(Ana)` | `[Ana]` |
| 3 | `[A]; addFirst(B)` | `[B,A]` |
| 4 | `[A,B]; peekLast` | `B, lista inalterada` |
| 5 | `[A,B]; pollFirst` | `A e restante [B]` |

**Por que LinkedList:** operações nas pontas e estrutura duplamente encadeada.

## Exercício 3 — ArrayDeque

**Enunciado:** Processar comandos de desfazer usando pilha LIFO com push/peek/pop.

**Entrada de exemplo:** push A, push B, pop.

**Saída esperada:** B; resta A.

**Restrições:** Escolha Deque; use push/pop; não insira null.

**Três dicas progressivas:**
1. Escolha Deque
2. use push/pop
3. não insira null.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[]; peek` | `null` |
| 2 | `push A; pop` | `A` |
| 3 | `push A,B; pop` | `B` |
| 4 | `push A,B; peek` | `B sem remover` |
| 5 | `push null` | `NullPointerException` |

**Por que ArrayDeque:** pilha/fila com inserção e retirada eficiente nas pontas.

## Exercício 4 — PriorityQueue

**Enunciado:** Criar triagem de chamados com maior gravidade primeiro e desempate por número crescente de chegada.

**Entrada de exemplo:** [(A,2,1),(B,5,2),(C,5,3)].

**Saída esperada:** B, C, A.

**Restrições:** Defina record; crie Comparator composto; processe com poll.

**Três dicas progressivas:**
1. Defina record
2. crie Comparator composto
3. processe com poll.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[]; poll` | `null` |
| 2 | `[(A,1,1)]; poll` | `A` |
| 3 | `[(A,1,1),(B,3,2)]; sequência B,A` | `ver enunciado` |
| 4 | `[(A,2,1),(B,2,2)]; sequência A,B` | `ver enunciado` |
| 5 | `[(A,0,1),(B,1,2)]; ordem B,A` | `ver enunciado` |

**Por que PriorityQueue:** remoção pela prioridade segundo comparador.

## Exercício 5 — HashSet

**Enunciado:** Deduplicar identificadores de participantes sem exigência de ordem.

**Entrada de exemplo:** [4,2,4,3,2].

**Saída esperada:** {2,3,4}, tamanho 3 (ordem indiferente).

**Restrições:** Use HashSet; add ignora duplicados; compare conjuntos sem depender de impressão.

**Três dicas progressivas:**
1. Use HashSet
2. add ignora duplicados
3. compare conjuntos sem depender de impressão.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[]` | `tamanho 0` |
| 2 | `[1,1]` | `tamanho 1` |
| 3 | `[1,2]` | `contém 2` |
| 4 | `[1,2]; remove 1` | `{2}` |
| 5 | `[4,2,4]` | `tamanho 2` |

**Por que HashSet:** deduplicação sem ordem obrigatória.

## Exercício 6 — LinkedHashSet

**Enunciado:** Deduplicar tags mantendo a primeira ordem de aparição.

**Entrada de exemplo:** [java, poo, java, colecoes].

**Saída esperada:** [java, poo, colecoes].

**Restrições:** Use LinkedHashSet; preserve a inserção; remover e reinserir desloca para o fim.

**Três dicas progressivas:**
1. Use LinkedHashSet
2. preserve a inserção
3. remover e reinserir desloca para o fim.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[]` | `[]` |
| 2 | `[A,A]` | `[A]` |
| 3 | `[B,A,B]` | `[B,A]` |
| 4 | `[A,B]; remove A, add A` | `[B,A]` |
| 5 | `[A,B]; contains C` | `false` |

**Por que LinkedHashSet:** unicidade e ordem de primeira inserção.

## Exercício 7 — TreeSet

**Enunciado:** Manter idades distintas em ordem crescente e consultar vizinhos de um valor.

**Entrada de exemplo:** [20,18,20,25]; floor(22).

**Saída esperada:** [18,20,25]; floor(22)=20.

**Restrições:** Use TreeSet/NavigableSet; compare inteiros; investigue floor/higher.

**Três dicas progressivas:**
1. Use TreeSet/NavigableSet
2. compare inteiros
3. investigue floor/higher.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[]` | `[]` |
| 2 | `[4,1,4]` | `[1,4]` |
| 3 | `[5,10]; floor(7)` | `5` |
| 4 | `[5,10]; higher(5)` | `10` |
| 5 | `[5,10]; lower(5)` | `null` |

**Por que TreeSet:** unicidade, ordenação natural e busca de vizinhos.

## Exercício 8 — HashMap

**Enunciado:** Relacionar SKU à quantidade em estoque; somar quantidade para SKU já cadastrado.

**Entrada de exemplo:** [(A,2),(B,3),(A,4)].

**Saída esperada:** A=6, B=3 (ordem indiferente).

**Restrições:** Use Map; combine valor anterior; não dependa da ordem.

**Três dicas progressivas:**
1. Use Map
2. combine valor anterior
3. não dependa da ordem.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `{}; get A` | `null` |
| 2 | `A=2; incluir A+3` | `A=5` |
| 3 | `A=2; remove A` | `{}` |
| 4 | `A=2,B=2` | `duas chaves, valores podem repetir` |
| 5 | `A=0` | `containsKey(A)=true` |

**Por que HashMap:** consulta por chave sem ordem.

## Exercício 9 — LinkedHashMap

**Enunciado:** Registrar vendas preservando a ordem da primeira ocorrência de cada produto.

**Entrada de exemplo:** [(B,2),(A,1),(B,4)].

**Saída esperada:** {B=4,A=1}, nessa ordem.

**Restrições:** Escolha LinkedHashMap; put substitui; atualizações não mudam ordem por padrão.

**Três dicas progressivas:**
1. Escolha LinkedHashMap
2. put substitui
3. atualizações não mudam ordem por padrão.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `{}` | `{}` |
| 2 | `put B, put A` | `[B,A]` |
| 3 | `put B=2 e B=3` | `[B], valor 3` |
| 4 | `remove B e put B novamente em [B,A]` | `[A,B]` |
| 5 | `mapa com A=null` | `contém chave A` |

**Por que LinkedHashMap:** associação por chave mantendo ordem de inserção.

## Exercício 10 — TreeMap

**Enunciado:** Criar índice por código numérico e exibir produtos em intervalo de chaves.

**Entrada de exemplo:** {30:C,10:A,20:B}; subMap(10,true,30,false).

**Saída esperada:** {10=A,20=B}.

**Restrições:** Use TreeMap; ordene chaves; observe limites inclusivos/exclusivos.

**Três dicas progressivas:**
1. Use TreeMap
2. ordene chaves
3. observe limites inclusivos/exclusivos.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `{}` | `{}` |
| 2 | `put 3,1,2` | `chaves [1,2,3]` |
| 3 | `{1:A,3:C}; floorKey(2)` | `1` |
| 4 | `{1:A,3:C}; ceilingKey(2)` | `3` |
| 5 | `{1:A,2:B,3:C}; subMap(2,true,3,false)` | `{2=B}` |

**Por que TreeMap:** consultas por intervalo de chaves ordenadas.

## Exercício 11 — Collections

**Enunciado:** Gerar estatísticas de notas com sort, frequency, min, max e disjoint.

**Entrada de exemplo:** [8,5,8,10]; segunda turma [2,5].

**Saída esperada:** ordenado [5,8,8,10]; freq(8)=2; min=5; max=10; disjoint=false.

**Restrições:** Use lista mutável; ordene antes de binarySearch; escolha quatro métodos.

**Três dicas progressivas:**
1. Use lista mutável
2. ordene antes de binarySearch
3. escolha quatro métodos.

**Cinco casos de teste:**

| Nº | Entrada/operação | Resultado esperado |
|---|---|---|
| 1 | `[2,1] sort` | `[1,2]` |
| 2 | `[3,3,2] frequency(3)` | `2` |
| 3 | `[8,4] min` | `4` |
| 4 | `[8,4] max` | `8` |
| 5 | `[1,2] e [3,4] disjoint` | `true` |

**Por que Collections:** algoritmos prontos para listas e coleções.

# Parte 14 — Revisão ativa em entrevista

O prompt determina **uma pergunta por vez**, aguardando uma resposta autêntica do aluno, e adaptando o próximo passo ao desempenho. Portanto **não será fabricado um diálogo de acertos e erros**. Esta é a pauta a seguir durante a execução real:

1. Escolha da coleção adequada.
2. Ordem vs. ordenação.
3. Regras de duplicidade.
4. Aceitação/rejeição de `null`.
5. Desempenho de buscas, índices, inserção e remoção.
6. `equals` e `hashCode`.
7. `Comparable` e `Comparator`.
8. Algoritmos de `Collections`.
9. `List.of`, `Set.of` e `Map.of`.

**Primeira pergunta (responda antes de avançar):** Preciso registrar códigos de clientes sem repetição, preservando a sequência da primeira inserção. Qual implementação Java 21 você escolheria e por quê? Explique duplicidade, ordem e custo típico de busca.

**Regra de condução:** se a resposta estiver correta, confirmar, complementar com uma propriedade menos óbvia e fazer a próxima pergunta; se houver erro, explicar com contraexemplo e perguntar um caso similar para consolidar. Não disponibilizar gabarito antecipado durante a entrevista.

**Estado da execução interativa:** aguardando resposta do aluno. Sem essa resposta, a parte 14 **não está concluída**, mesmo que todos os materiais de apoio estejam publicados no GitHub.
