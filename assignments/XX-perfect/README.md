### **Números Perfeitos**  

**Referência:** Fonte: DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects*. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.  

---

### **📌 Descrição**  

Um **número perfeito** é um número inteiro positivo em que a soma de seus divisores próprios (incluindo 1, mas excluindo o próprio número) é igual ao próprio número.  

Por exemplo, o número **6** é perfeito, pois seus divisores próprios são **1, 2 e 3**, e sua soma é:  
\[
6 = 1 + 2 + 3
\]

O programa deve implementar um método **`isPerfect(int number)`** que determina se um número dado é **perfeito**.  

Além disso, a aplicação deve:  
1. **Exibir todos os números perfeitos no intervalo de 1 a 1000**.  
2. **Exibir os divisores de cada número perfeito encontrado** para confirmar sua perfeição.  
3. **Permitir testar números maiores que 1000**, para desafiar a capacidade computacional do sistema.  

---

### **📌 Especificação**  

1. O programa deve verificar se um número inteiro é **perfeito** e listar seus divisores.  
2. Deve exibir **todos os números perfeitos entre 1 e 1000**, junto com seus fatores.  
3. Deve permitir que o usuário insira **um número maior que 1000** para testar se é perfeito.  
4. A saída do programa deve seguir o formato abaixo:
   ```bash
   Números perfeitos entre 1 e 1000:
   6 é um número perfeito. Fatores: 1, 2, 3
   28 é um número perfeito. Fatores: 1, 2, 4, 7, 14
   496 é um número perfeito. Fatores: 1, 2, 4, 8, 16, 31, 62, 124, 248

   Teste adicional:
   Digite um número para verificar se é perfeito: 8128
   8128 é um número perfeito. Fatores: 1, 2, 4, 8, 16, 32, 64, 127, 254, 508, 1016, 2032, 4064
   ```
5. O programa deve garantir que **o usuário insira um número válido**.  
6. O cálculo dos divisores e da verificação de perfeição deve ser realizado pelo método **`isPerfect(int number)`**.  

---

### **📌 Requisitos de Implementação**  

1. O programa deve conter uma **classe chamada `PerfectNumber`**.  
2. A classe `PerfectNumber` deve conter os seguintes métodos públicos e estáticos:  
   - **`isPerfect(int number)`** → Retorna `true` se `number` for um número perfeito, `false` caso contrário.  
   - **`getFactors(int number)`** → Retorna um `List<Integer>` contendo os fatores próprios do número.  
   - **`main(String[] args)`** → Executa o programa, imprimindo os números perfeitos no intervalo de 1 a 1000 e permitindo ao usuário testar valores maiores.  
3. O programa deve **usar `Scanner`** para permitir que o usuário insira um número para teste adicional.  
4. Os cálculos de fatores devem ser feitos com **otimização de laço**, iterando até a raiz quadrada do número.  