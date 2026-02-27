### Mediana de Três

Referência: [CS 2110: Object-Oriented Programming and Data Structures @ Cornell University](https://www.cs.cornell.edu/courses/cs2110/2025sp/assignments/a1_handout.html)

---

#### Descrição

A **mediana** de um conjunto de números é o valor que estaria no meio se o conjunto estivesse ordenado. Um caso especial de mediana é a **"Mediana de Três"**, que é amplamente utilizada em sistemas **tolerantes a falhas** para **tomar decisões baseadas em múltiplas entradas** quando os componentes de um sistema não concordam entre si.  

Esse procedimento é **comumente executado em software de voo da SpaceX** para determinar quais sensores e comandos devem ser confiáveis em um dado momento.  

O objetivo deste programa é **determinar a mediana de três números inteiros distintos ou duplicados, sem a necessidade de ordenação explícita da lista**.  

O algoritmo deve ser implementado utilizando **cadeia de estruturas condicionais (`if/else`)**, possivelmente aninhadas, para determinar o valor mediano.  

---

#### Especificação

1. O programa deve determinar a **mediana** de três números inteiros informados pelo usuário.
2. A mediana de um conjunto de números é o valor que estaria no meio caso os números fossem ordenados.
3. O programa deve solicitar ao usuário **três números inteiros**, de acordo com o exemplo:
```bash
Digite o primeiro número: 7
Digite o segundo número: 2
Digite o terceiro número: 5
```
4. O programa deve calcular a mediana utilizando uma **cadeia de estruturas condicionais (`if`/`else`)**, possivelmente aninhadas, para determinar o valor central sem ordenar explicitamente os números.
5. O programa deve imprimir no console a mediana dos três números informados, conforme exemplo:
```bash
A mediana dos números é: 5
```
---

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `MedianCalculator`**.  
2. A classe `MedianCalculator` deve conter os seguintes **métodos públicos (`public`) e estáticos (`static`)**:  
   - `findMedian(int a, int b, int c)`: **Recebe três números inteiros e retorna a mediana**.  
3. O programa deve utilizar **estruturas condicionais (`if/else`) para encontrar a mediana**, sem ordenar explicitamente os números.  
4. O programa principal (`main`) deve:  
   - **Solicitar ao usuário três números inteiros (`num1`, `num2`, `num3`)**.  
   - **Chamar o método `findMedian(int num1, int num2, int num3)`** para calcular a mediana.  
   - **Exibir a mediana calculada** usando `System.out.println()`.  
5. O programa deve permitir **entradas duplicadas** e retornar a mediana corretamente nesses casos.