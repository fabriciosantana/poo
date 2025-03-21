## Estudo de caso: IDP Bank

Você foi contratado pela fintech IDP Bank, em razão do seu conhecimento em Programação Orientada a Objetos (POO), para desenvolver um Banco Digital que permita o gerenciamento de clientes e suas contas bancárias.

No seu primeiro dia de trabalho você recebeu a especificação do sistema. Sua tarefa é programar o sistema de forma que atenda plenamente aos requisitos de negócio e técnicos definidos.

### Objetivo do Sistema

O objetivo do sistema é possibilitar que os clientes possam abrir contas bancárias, realizar transações financeiras e gerenciar seus investimentos.

O sistema deverá permitir:

* Cadastrar de clientes
* Abrir de conta
* Realizar depósitos e saques
* Aplicar taxas e rendimentos
* Gerar relatórios e auditoria de transações

### Cronograma

O projeto será implementado em 4 semanas, cada uma focada em um conjunto de funcionalidades específicas:

| Semana | Funcionalidade | Objetivo |
|---|---|--- |
| 1 | [Cadastro e abertura de contas](#semana-1-cadastro-e-abertura-de-contas) | Aplicar os conceitos de classe, objeto, atributos, métodos, atributos e métodos de classe (static), modificadores de acesso, get e set, sobrecarga (_overload_) de métodos e construtores, palavra reservada _this_ |
| 2 | [Possibilitar a abertura de diferentes tipos de contas](#semana-2-possibilitar-a-abertura-de-diferentes-tipos-de-contas) | Aplicar conceitos de herança, superclasses, subclasses e métodos sobrescritos (override) |

### Semana 1: Cadastro e abertura de contas

#### Geral

1. Ao inciar, o programa deve exibir um menu de opções para o usuário escolher a ação desejada: 1. [Abrir conta](#abertura-de-conta); 2. [Consultar cliente](#consultar-cliente); 3. [Depositar](#depositar); 4. [Sacar](#sacar); 5. [Sair](#sair)
```bash
Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:

1. Abrir conta
2. Consultar cliente
3. Depositar
4. Sacar
5. Sair

Digite o número correspondente à opção desejada: 
```
2. Ao digitar a opção deseja, o sistema deverá seguir para a ação correspondente.

#### Abrir conta

1. O programa deve solicitar ao usuário as informações do cliente.
```bash
Digite os dados para a abertura da conta.

Primeiro nome: João  
Sobrenome: Silva  
CPF: 123.456.789-00 
```
2. O programa deve gerar um número de conta único automaticamente para cada novo cliente.
3. Inicialmente, haverá apenas um tipo de conta e cada cliente terá exatamente uma conta.
4. O programa deve imprimir os dados do cliente e os detalhes da conta criada.
```bash
Cliente cadastrado com sucesso!

Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Conta criada com sucesso! Pressione Enter para continuar...
```
6. O programa deve retornar para o início
7. Se o usuário digitar uma opção inválida, o programa deve informar que a opção é inválida e solicitar a opção novamente
```bash
Opção inválida. Tente novamente.

Digite o número correspondente à opção desejada: 
```

#### Consultar cliente

1. O programa deve exibir as informações do cliente
```bash
Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Pressione enter para continuar...
```
2. O programa deve retornar para o início

#### Depositar

1. O programa deve solicitar o valor a ser depositado
```bash
Digite o valor que deseja depositar.

Valor: 

```
2. O programa deve somar o valor depositado na conta do cliente e apresentar as informações do cliente
```bash
Valor depositado com sucesso na conta do cliente João da Silva.

Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Pressione enter para continuar...
```
3. O programa deve retornar para o início

#### Sacar

1. O programa deve solicitar o valor a ser sacado
```bash
Digite o valor que deseja sacar.

Valor: 

```
2. O programa deve subtrair o valor depositado na conta do cliente e apresentar as informações do cliente
```bash
Valor sacado com sucesso da conta do cliente João da Silva.

Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Pressione enter para continuar...
```
3. O programa deve retornar para o início

#### Sair

1. O programa deve encerrar a execução

#### Requisitos de implementação

1. O programa deve conter uma classe chamada `IDPBank`.
2. A classe `IDPBank` deve ter os seguintes métodos públicos (`public`) e estáticos (`static`)
    * `main`: deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`)
    * `createCustomer`: deve receber `firstName`, `lastName` e `CPF`, todos do tipo `String`, e deve retornar um objeto `Customer`
    * `openAccount`: deve receber um objeto `Customer` e deve retornar um objeto `Account`.
    * `deposit`: recebe como parâmetro `amount` do tipo `double` para ser somado ao saldo `balance` da conta do cliente. Esse método deve delegar para a instância da conta e não devem ter lógicas adicionais e epecíficas da cona
    * `withdraw`: recebe como parâmetro `amount` do tipo `double` para ser subtraído do saldo `balando` da conta do cliente. Esse método deve delegar para a instância da conta e não devem ter lógicas adicionais e epecíficas da cona
3. O programa deve ter uma classe chamada `Customer`, que deve ter:
    * atributos privados:
        * `firstName` (`String`): Primeiro nome do cliente.
        * `lastName` (`String`): Sobrenome do cliente.
        * `cpf` (`String`): CPF do cliente.
        * `accounts` (`Account`) → Conta do cliente (inicialmente haverá apenas uma conta, nas próximas iterações esse atributo será alterado para poder receber mais de uma conta).
    * um construtor que recebe os atributos acima como parâmetros `firstName`, `lastName` e `cpf`. 
    * métodos de acesso (`get` e `set`) para seus atributos.
    * método `addAccount(Account account)` que retorna um `boolean` para associar a conta com o cliente
    * método `displayInformation()` que retornar uma `String` para imprimir os detalhes do cliente
4. O programa deve conter uma classe chamada `Account`, que deve ter:
    * atributos privados
        * `id` (int) → Número único da conta bancária.
        * `balance` (double) → Saldo inicial da conta, que deve começar em R$ 0,00.
    * um construtor que inicializa a conta com um número de conta único e saldo zero.
    * métodos de acesso (`get` e `set`) para seus atributos.
        * O método `get` referente ao saldo, deve retornar o saldo formatado
        * O método `set` referente ao saldo, deve impedir saldo negativo
    * método `deposit(double amount)` para depositar valor na conta
    * método `withdraw(double amount)` para sacar valor da conta
    * um atributo de classe (`static`) `accountCounter` do tipo `int` para controlar a quantidade de contas criadas. Cada nova conta deve receber um número sequencial gerado automaticamente pela aplicação, garantindo unicidade.
5. Utilizar a classe [java.util.Scanner](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html) para ler entrada do console.
6. Utilizar a classe [System.out](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#out) para imprimir informações no console.

### Semana 2: Possibilitar a abertura de diferentes tipos de contas

O IDP Bank agora oferecerá três tipos de contas bancárias:

* Conta Corrente (`CheckingAccount`): Conta tradicional que permite saques, depósitos e possui uma taxa mensal de manutenção.
* Conta Poupança (`SavingsAccount`): Conta que rende juros mensalmente sobre o saldo disponível.
* Conta Salário (`SalaryAccount`): Conta para recebimento de salário, permitindo apenas saques e transferências para outra conta.

#### Geral

1. Adicionar a opção [5. transferir]() no menu inicial do programa
```bash
Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:

1. Abrir conta
2. Consultar cliente
3. Depositar
4. Sacar
5. Sair

Digite o número correspondente à opção desejada: 
```
2. Ao digitar a opção deseja, o sistema deverá seguir para a ação correspondente.

#### Criar diferentes tipos de contas

1. O programa deve perguntar ao usuário qual tipo de conta deseja abrir, conforme abaixo:
```bash
Qual tipo de conta deseja abrir?
1. Conta Corrente
2. Conta Poupança
3. Conta Salário

Digite o número da opção desejada:
```
2. O sistema deve permitir que o cliente possua **mais de uma conta** associada ao seu CPF.
3. Cada tipo de conta terá regras específicas para saques e depósitos.

##### Conta Corrente (`CheckingAccount`)
1. Permite depósitos e saques.
1. Possui uma taxa de manutenção mensal fixa de **R$ 10,00**, que será descontada automaticamente do saldo ao final do mês.
1. Permite saldo negativo (limite de crédito de **R$ 500,00**).
1. O programa deve exibir o saldo atualizado após o desconto da taxa de manutenção.

##### Conta Poupança (`SavingsAccount`)
1. Permite depósitos e saques.
1. Aplica um rendimento mensal de **0,5%** sobre o saldo disponível no final de cada mês.
1. Não permite saldo negativo (tentativas de saque além do saldo devem ser bloqueadas).
1. O programa deve calcular e exibir o saldo após o rendimento mensal.

##### Conta Salário (`SalaryAccount`)
1. Apenas recebe depósitos de salário.
1. Permite **somente saques e transferências** para outra conta cadastrada do mesmo cliente.
1. Não permite depósitos manuais, apenas transferência do empregador.

---

#### Requisitos de Implementação

1. A classe `Account` deve ser uma classe abstrata (`abstract`) com:
1. Criar três subclasses de `Account`:
   - `CheckingAccount`
     - Atributo adicional: `maintenanceFee` (R$ 10,00 fixo).
     - Sobrescrever o método `withdraw()` para permitir saldo negativo até -500. Caso uma operação leve o saldo para valor menor, deve ser disparada uma exceção com a mensagem `Saldo insuficiente e sem limite de crédito.`
     - Método `applyMaintenanceFee()` para cobrar taxa mensal.
   - `SavingsAccount`
     - Atributo adicional: `interestRate` (0,5% ao mês).
     - Método `applyInterest()` para calcular juros sobre saldo.
   - `SalaryAccount`
     - Não permite depósitos manuais.
     - Permite apenas saques e transferências.

3. Atualizar a classe `Customer`:
   - Permitir que um cliente possua 3 contas por meio de três atributos (`checkingAccount` `savingsAccount`, `salaryAccount`).
   - Criar método `addAccount(Account account)`.
   - Criar método `displayAccounts()` para listar todas as contas do cliente.
1. Atualizar a classe `IDPBank`:
   - Implementar a lógica de escolha do tipo de conta.
   - Criar método `executeMonthlyProcessing()` que aplica taxas e rendimentos.
1. Utilizar herança para que operações bancárias sejam tratadas de forma genérica, sem verificar manualmente o tipo da conta.