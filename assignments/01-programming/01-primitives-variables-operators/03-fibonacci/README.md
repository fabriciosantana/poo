### Número de Fibonacci

Referência: [Sequência de Fibonnaci](https://en.wikipedia.org/wiki/Fibonacci_sequence), ver também [Implementações da sequência de Fibonnaci](https://en.wikibooks.org/wiki/Algorithm_Implementation/Mathematics/Fibonacci_Number_Program). [Code Forces](https://codeforces.com/problemset/problem/193/E)

#### Especificação

1. O programa deve calcular o **n-ésimo número da sequência de Fibonacci**.
2. A sequência de Fibonacci é definida da seguinte forma:
   - `F(0) = 0`
   - `F(1) = 1`
   - `F(n) = F(n-1) + F(n-2)` para *n > 1*
3. O programa deve solicitar ao usuário um número inteiro não negativo (**n**), conforme o exemplo:
```bash
Digite um número inteiro não negativo: 7
```
4. O programa deve calcular o **n-ésimo número de Fibonacci** utilizando uma abordagem eficiente, como:
   - **Iterativa**: Utilizando um loop para calcular o valor.
   - **Recursiva com memoização**: Utilizando recursão e armazenando resultados intermediários para evitar cálculos redundantes.
5. O programa deve imprimir no console o resultado do cálculo, conforme exemplo:
```bash
   O 7º número de Fibonacci é: 13
```

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `Fibonacci`**.
2. A classe deve possuir **três métodos públicos (`public`) e estáticos (`static`)**: `main`, `calcularFibonacci` e `formatarSaida`.
3. O **método `main`** deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`).
4. O **método `calcularFibonacci`** deve receber um parâmetro `n` do tipo `int` e retornar um valor `long` representando o n-ésimo número de Fibonacci.
5. O **método `formatarSaida`** deve receber um valor `long` representando o número de Fibonacci calculado e um valor `int` representando o **n-ésimo número de Fibonacci** e deve retornar uma `String` formatada para exibição.
6. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
7. Deve-se implementar uma abordagem eficiente para o cálculo da sequência de Fibonacci, evitando a ineficiência da recursão simples.
