### Analisador de Notas com Arrays

**Referência:** Fonte: DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects*. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.

---

#### Descrição

Em uma turma, o professor precisa analisar as notas de vários estudantes ao final de uma avaliação. Para isso, o programa deve armazenar as notas em um **array**, calcular estatísticas básicas e exibir uma distribuição de frequência das notas.

O objetivo desta atividade é aplicar o uso de **arrays unidimensionais**, percorrendo seus elementos com estruturas de repetição para calcular soma, média, maior valor, menor valor, quantidade de notas acima da média e frequência de notas por faixa.

---

#### Especificação

1. O programa deve solicitar ao usuário a quantidade de estudantes da turma.
2. O programa deve ler uma nota inteira para cada estudante.
3. As notas devem estar no intervalo de **0 a 100**.
4. As notas devem ser armazenadas em um array de inteiros (`int[]`).
5. O programa deve calcular:
   - a média das notas;
   - a maior nota;
   - a menor nota;
   - a quantidade de estudantes com nota acima ou igual à média;
   - a frequência de notas em faixas de 10 pontos.
6. A distribuição de frequência deve usar 11 posições:
   - índice `0`: notas de 0 a 9;
   - índice `1`: notas de 10 a 19;
   - ...
   - índice `9`: notas de 90 a 99;
   - índice `10`: nota 100.

#### Exemplo de entrada

```bash
Digite a quantidade de estudantes: 6
Digite a nota do estudante 1: 85
Digite a nota do estudante 2: 70
Digite a nota do estudante 3: 100
Digite a nota do estudante 4: 55
Digite a nota do estudante 5: 70
Digite a nota do estudante 6: 90
```

#### Exemplo de saída

```bash
Média da turma: 78.33
Maior nota: 100
Menor nota: 55
Notas acima ou iguais à média: 3

Distribuição de notas:
00-09: 0
10-19: 0
20-29: 0
30-39: 0
40-49: 0
50-59: 1
60-69: 0
70-79: 2
80-89: 1
90-99: 1
100: 1
```

---

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `GradeAnalyzer`**.
2. A classe deve conter os seguintes métodos públicos (`public`) e estáticos (`static`):
   - `calculateAverage(int[] grades)`: recebe um array de notas e retorna a média como `double`.
   - `findHighestGrade(int[] grades)`: recebe um array de notas e retorna a maior nota como `int`.
   - `findLowestGrade(int[] grades)`: recebe um array de notas e retorna a menor nota como `int`.
   - `countGradesAtOrAboveAverage(int[] grades)`: recebe um array de notas e retorna a quantidade de notas maiores ou iguais à média como `int`.
   - `calculateFrequency(int[] grades)`: recebe um array de notas e retorna um array de inteiros (`int[]`) com 11 posições representando a distribuição por faixa.
   - `formatFrequencyLine(int index, int frequency)`: recebe o índice da faixa e sua frequência, retornando a linha formatada como `String`.
   - `main(String[] args)`: lê os dados do usuário, chama os métodos anteriores e imprime os resultados no console.
3. O método `calculateAverage` deve percorrer o array e calcular a soma das notas.
4. Os métodos `findHighestGrade` e `findLowestGrade` devem percorrer o array para encontrar os valores, sem ordenar o array.
5. O método `calculateFrequency` deve classificar cada nota na faixa correta usando divisão inteira por 10.
6. A nota `100` deve ser contabilizada na posição `10` do array de frequência.
7. O programa deve utilizar a classe `java.util.Scanner` para ler entradas do console.
8. O programa deve validar as entradas:
   - a quantidade de estudantes deve ser maior que zero;
   - cada nota deve estar entre 0 e 100.
9. Caso uma entrada inválida seja informada, o programa deve solicitar novamente o valor.
10. O programa deve utilizar arrays (`int[]`) para armazenar as notas e para armazenar a distribuição de frequência.

#### Envio

1. Sincronize seu repositório com o repositório principal da disciplina.
2. Crie, dentro do diretório `submissions/`, o diretório `seu-nome/src`.
3. Desenvolva o programa dentro do diretório `seu-nome/src`.
4. Salve os arquivos, faça um commit e envie um pull request para o repositório da disciplina.
5. Submeta o link do pull request no ambiente virtual.
