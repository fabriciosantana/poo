### **Sequência de Collatz**  

**Referência:** 
1. [CS 2110: Object-Oriented Programming and Data Structures @ Cornell University](https://www.cs.cornell.edu/courses/cs2110/2025sp/assignments/a1_handout.html)
2. [Code Forces](https://codeforces.com/contest/1982/problem/B)

---

### **Descrição**  

A [Conjectura de Collatz](https://en.wikipedia.org/wiki/Collatz_conjecture) é um problema matemática que sugere que, **ao aplicar repetidamente uma das duas operações simples em um número inteiro positivo, sempre se chega ao valor 1**. As regras para determinar o próximo número na sequência são:  

- **Se o número atual for par**, divida-o por **2**.  
- **Se o número atual for ímpar**, multiplique-o por **3** e adicione **1**.  

O objetivo do programa é **calcular a soma de todos os termos** gerados a partir de um número inicial até que o valor **1 seja alcançado**.  

Esse problema envolve um número indefico de iteração, então uma sugestão **loop `while`**.  

---

### **Especificação**  

1. O programa deve solicitar ao usuário um número inteiro **positivo** (`n`), chamado de **semente** da sequência de Collatz.  
2. O programa deve gerar a **sequência de Collatz** para esse número, aplicando as regras:  
   - **Se `n` for par** → `n = n / 2`  
   - **Se `n` for ímpar** → `n = (n * 3) + 1`  
3. O programa deve calcular e exibir:  
   - A **sequência gerada** a partir do número inicial até que atinja `1`.  
   - A **soma total de todos os termos** gerados na sequência.  
4. O programa deve validar a entrada e exibir uma **mensagem de erro** caso o usuário insira um valor inválido (número menor que 1).  
5. Exemplos:
    - **Caso de entrada válido:**  
    ```bash
    Digite um número inteiro positivo: 6
    Sequência de Collatz: 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    Soma dos termos: 55
    ```
    - **Outro exemplo:**  
    ```bash
    Digite um número inteiro positivo: 11
    Sequência de Collatz: 11 → 34 → 17 → 52 → 26 → 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
    Soma dos termos: 284
    ```
    - **Caso de entrada inválida:**  
    ```bash
    Digite um número inteiro positivo: -3
    Erro: O número deve ser um inteiro positivo.
    ```

---

### **Requisitos de Implementação**  

1. O programa deve conter uma **classe chamada `CollatzSequence`**.  
2. A classe `CollatzSequence` deve conter os seguintes **métodos públicos e estáticos (`static`)**:  
   - `nextCollatz(int n)`: **Recebe um inteiro positivo e retorna o próximo número da sequência de Collatz**.  
   - `calculateCollatzSum(int n)`: **Gera a sequência de Collatz a partir de `n` e retorna a soma de todos os termos**.  
3. O programa deve validar a entrada, garantindo que **`n` seja um número inteiro positivo**. Caso contrário, deve exibir uma mensagem de erro.  
4. O programa deve utilizar um **loop `while`** para calcular a sequência até que `n == 1`.  
5. O programa principal (`main`) deve:  
   - **Solicitar um número inteiro positivo ao usuário**.  
   - **Chamar os métodos `nextCollatz` e `calculateCollatzSum`** para calcular a sequência e a soma.  
   - **Exibir a sequência e a soma total**.