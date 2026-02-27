### Palíndromos  

**Referência:** [CS 2110: Object-Oriented Programming and Data Structures @ Cornell University](https://www.cs.cornell.edu/courses/cs2110/2025sp/assignments/a1_handout.html)

### **Descrição**  

Um **palíndromo** é uma sequência de caracteres que **permanece a mesma quando lida de trás para frente**. Por exemplo, as seguintes sequências são palíndromos:  
- **12321**  
- **55555**  
- **45554**  
- **11611**  
- **racecar**  
- **madam**  
- **2002**  

O objetivo deste programa é **ler um número inteiro ou uma sequência de caracteres e determinar se ele(a) é um palíndromo**.  

**Observação:**  
Este problema utiliza a classe [String](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html), que permite manipular caracteres de forma eficiente. Alguns métodos úteis incluem:  
- `s.charAt(i)`: Obtém o caractere na posição **i** da string.  
- `s.length()`: Retorna o número total de caracteres na string.  

---

### **Especificação**  

1. O programa deve **ler uma sequência de caracteres inserida pelo usuário**.  
2. O programa deve **comparar os caracteres** da entrada para verificar se ela **é um palíndromo**.  
3. O programa deve **ignorar diferenças entre maiúsculas e minúsculas** e permitir a verificação de **palavras e números**.  
4. O programa deve exibir os seguintes resultados:  
   - **Se for um palíndromo:**  
```bash
Digite uma sequência: racecar
A sequência "racecar" é um palíndromo.
```
   - **Se não for um palíndromo:**  
```bash
Digite uma sequência: hello
A sequência "hello" não é um palíndromo.
```
   - **Se a entrada for vazia ou inválida:**  
```bash
Digite uma sequência:   
Erro: A entrada não pode estar vazia.  
Digite uma sequência: 2002  
A sequência "2002" é um palíndromo.
```

---

### **Requisitos de Implementação**  

1. O programa deve conter uma **classe chamada `PalindromeChecker`**.  
2. A classe `PalindromeChecker` deve conter os seguintes **métodos públicos e estáticos (`static`)**:
   - `isValidInput(String input)`: **Retorna um booleano** indicando se a entrada é **válida** (não vazia e sem espaços em branco excessivos).  
   - `isPalindrome(String input)`: **Retorna um booleano** indicando se a entrada é um **palíndromo**.  
3. O programa deve utilizar os seguintes **métodos da classe `String`**:
   - `charAt(i)`: Para acessar os caracteres individuais da string.  
   - `length()`: Para verificar o tamanho da string.  
   - `toLowerCase()`: Para ignorar a diferença entre maiúsculas e minúsculas.  
4. O programa principal (`main`) deve:
   - **Solicitar ao usuário uma sequência de caracteres** e garantir que ela **não esteja vazia**.  
   - **Chamar o método `isPalindrome`** para verificar se a entrada é um palíndromo.  
   - **Exibir a mensagem apropriada** com o resultado da verificação.  
5. O programa deve **continuar solicitando entradas até que um valor válido seja inserido**.