### Cálculo da Área de um Polígono Regular

**Referência:** [CS 2110: Object-Oriented Programming and Data Structures @ Cornell University](https://www.cs.cornell.edu/courses/cs2110/2025sp/assignments/a1_handout.html)

#### Especificação

1. O programa deve calcular a área de um polígono regular
2. O programa deve solicitar ao usuário o número de lados (`n`) e o comprimento do lado (`s`) de um polígono regular, de acordo com o exemplo:

```bash
Digite o número de lados do polígono: 6
Digite o comprimento do lado em metros: 5.0
```
3. A área (`A`) de um polígono regular é calculada utilizando a seguinte fórmula:
\[
A = \frac{1}{4} \times s^2 \times n \times \frac{1}{\tan(\pi / n)}
\]
onde:
- `n` → número de lados do polígono;
- `s` → comprimento de um lado;
- `π` → constante matemática (π ≈ 3.14159), disponível na API do Java [java.lang.Math.PI](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#PI);
- `tan(x)` → função tangente, disponível API do Java [java.lang.Math.tan(double a)](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#tan-double-).
4. A unidade da área resultante será compatível com a unidade da entrada do comprimento do lado (**exemplo: se s for dado em metros, A será em metros quadrados**).
5. O programa deve imprimir no console o resultado do cálculo da área do polígono, conforme exemplo:
```bash
A área do polígono é: 64.95 metros quadrados
```
#### Requisitos de Implementação
1. O programa deve conter uma **classe chamada `CalculadoraPoligono`**.
2. A classe deve possuir **três métodos públicos (public) e estáticos (static)**: `main`, `calcularArea` e `formatarSaida`.
3. O **método `main`** deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`).
4. O **método `calcularArea`** deve receber dois parâmetros, `n` e `s`, sendo `n` do tipo `int` e `s` do tipo `double`, e deve retornar um valor `double` representando a área do polígono.
5. O **método `formatarSaida`** deve receber um valor `double` representando a área e retornar uma `String` formatada para exibição.
6. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
7. Deve-se utilizar a **classe `Math`** para cálculos matemáticos, incluindo a constante `Math.PI` e a função `Math.tan()`.
