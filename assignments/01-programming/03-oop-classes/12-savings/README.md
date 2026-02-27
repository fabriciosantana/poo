### Savings Account  

**Referência:** Fonte: DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects*. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.  

---

### Especificação

1. O programa deve solicitar que o usuário informe o saldo inicial
```bash
Informe o saldo inicial: 2000
```
1. O programa deve solicitarque o usuário informe a taxa de juros anual
```bash
Informe a taxa de juros anual (%): 4
```
1. O programa deve criar uma conta com saldo inicial informado pelo usuário
1. O programa deve configurar a taxa de juros anual para 4%
1. O programa deve imprimir, calcular e exibir os saldos atualizados para cada mês ao longo de 12 meses.
```bash
Saldos com taxa de juros de 4.0%:
Mês 1: R$2006.67
Mês 2: R$2013.36
Mês 3: R$2020.07
Mês 4: R$2026.80
Mês 5: R$2033.56
Mês 6: R$2040.33
Mês 7: R$2047.14
Mês 8: R$2053.96
Mês 9: R$2060.81
Mês 10: R$2067.68
Mês 11: R$2074.57
Mês 12: R$2081.48
```
1. Após 12 meses, o programa deve solicitar a nova taxa anual
```bash
Informe a nova taxa de juros anual: 5%
```
1. O programa deve atualizar a taxa de juros anual para 5%
1. Após os 12 meses, o programa deve modificar a taxa de juros anual para `5%`, calcular o próximo mês de juros e imprimir os novos saldos de ambas as contas.
```
Alterando taxa de juros anual para 5%...

Mês 13: R$2090.16
```

---

### Requisitos de Implementação

1. O programa deve conter uma classe chamada `SavingsAccount` e outra chamada `SavingsAccountApp`.
1. A classe `SavingsAccount` deve conter:
    - Um atributo privado `savingsBalance` (`double`): Representa o saldo atual da conta.
    - Um atributo de classe (`static`) `annualInterestRate` (`double`): Representa a taxa de juros anual aplicada ao saldo da conta.
    - Um construtor que recebe `savingsBalance` como parâmetro e inicializa o saldo da conta.
        - Se o saldo informado for menor que zero, deve disparar uma exceção do tipo `IllegalArgumentException` com a mensagem "O saldo inicial não pode ser negativo."
    - Um método `calculateMonthlyInterest()`: Calcula os juros mensais e adiciona ao saldo da conta.
        - Para calcular o saldo atualizado mensal, calcule a taxa mensal de acordo com a fórmula abaixo:
        ```
        taxa mensal = (1 + taxa anual)^(1/12)) -1
        ```
    - Métodos `get`e `set` que permita recuperar e modificar a taxa de juros    
        - Se a taxa informada for menor que zero, deve disparar uma exceção do tipo `IllegalArgumentException` com a mensagem "A taxa de juros não pode ser negativa."
    - Um método `getSavingsBalance()`: Retorna o saldo atualizado da conta.
1. A classe (`SavingsAccountApp`) deve:
    - Solicitar ao usuário o valor do saldo inicial
    - Solicitar ao usuário a taxa de juros
    - Criar um novo objeto do tipo `SavingsAccount`
    - Definir a taxa de juros anual para a taxa informada pelo usuário.
    - Calcular e exibir os saldos de ambas as contas ao longo de `12 meses`.
    - Solicitar ao usuário nova taxa de juros
    - Calcular e exibir o saldo das contas após mais um mês com a nova taxa de juros.
1. Utilizar a classe `System.out` para imprimir os valores no console.