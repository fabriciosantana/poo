### Elefante Visitando o Amigo

Referência: [Elephant @ CodeForces](https://codeforces.com/problemset/problem/617/A)

#### Especificação

1. O programa deve calcular o **mínimo número de passos necessários** para um elefante viajar da posição **0** até a posição **x** na linha de coordenadas.
2. O elefante pode dar **passos de tamanho 1, 2, 3, 4 ou 5** em cada movimento.
3. O programa deve solicitar ao usuário um **inteiro positivo `x`** representando a posição da casa do amigo, conforme o exemplo:
```bash
Digite a posição da casa do amigo: 12
```
4. O programa deve calcular a **quantidade mínima de passos** necessários para alcançar `x`.
5. O programa deve imprimir no console o número mínimo de passos, conforme exemplo:
```bash
O número mínimo de passos necessários é: 3
```

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `PassosElefante`**.
2. A classe deve possuir **três métodos públicos (`public`) e estáticos (`static`)**: `main`, `calcularPassosMinimos` e `formatarSaida`.
3. O **método `main`** deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`).
4. O **método `calcularPassosMinimos`** deve receber um parâmetro `x` do tipo `int` e retornar um valor `int` representando o número mínimo de passos necessários.
5. O **método `formatarSaida`** deve receber um valor `int` representando a quantidade de passos calculada e retornar uma `String` formatada para exibição.
6. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
7. O programa deve garantir que `x` esteja dentro do intervalo permitido (**1 ≤ x ≤ 1.000.000**).