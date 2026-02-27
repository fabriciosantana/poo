### Senha forte

Referência: [Stronger Password @ CodeForces](https://codeforces.com/problemset/problem/1997/A)

#### Especificação

1. O programa deve **fortalecer** a senha adicionando exatamente **uma letra minúscula** do alfabeto latino (`a-z`) em qualquer posição da string.
2. O objetivo é **maximizar o tempo necessário para digitar a senha**. O tempo de digitação é calculado da seguinte forma:
   - **O primeiro caractere leva 2 segundos** para ser digitado.
   - **Cada caractere subsequente** leva:
     - **1 segundo** se for **igual ao caractere anterior**.
     - **2 segundos** se for **diferente do caractere anterior**.
3. O programa deve solicitar ao usuário uma **senha**, conforme o exemplo:
```bash
Digite a senha: a
```
4. O programa deve **inserir uma letra minúscula em qualquer posição** para **maximizar o tempo total de digitação**.
5. O programa deve imprimir no console a **nova senha**, conforme exemplo:
```bash
Senha fortalecida: wa
```

#### Requisitos de Implementação

1. O programa deve conter uma **classe chamada `FortalecerSenha`**.
2. A classe deve possuir **três métodos públicos (`public`) e estáticos (`static`)**: `main`, `fortalecerSenha` e `calcularTempoDigitacao`.
4. O **método `fortalecerSenha`** deve receber um parâmetro `s` do tipo `String` e retornar um `String` representando a senha fortalecida.
5. O **método `calcularTempoDigitacao`** deve receber uma senha e retornar um `int` representando o tempo de digitação.
6. O programa deve garantir que:
   - **1 ≤ |s| ≤ 10** (comprimento da senha original).
   - Apenas caracteres **minúsculos do alfabeto latino (`a-z`)** sejam inseridos.
7. Deve-se utilizar a **classe `java.util.Scanner`** para ler entradas do usuário.
8. O algoritmo deve **testar diferentes posições e caracteres** para encontrar a inserção ótima.