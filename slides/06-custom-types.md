---
layout: frontcover
transition: none
title: IDP - POO
id: aula03b
lesson: Definição de tipos personalizados em Java
goals:
  - Criar classes com atributos, construtores e métodos de acesso
  - Encapsular regras de negócio simples (depósitos)
  - Consumir objetos a partir de aplicações de console
---

---
layout: default
lesson: Modelagem de domínio
---

## Classe `Account`

```java
// lectures/examples/03-custom-types/Account.java
public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        if (balance > 0.0) {
            this.balance = balance;
        }
    }

    public void deposit(double depositAmount) {
        if (depositAmount > 0.0) {
            balance += depositAmount;
        }
    }
}
```

- Encapsula estado e regras de validação (`balance > 0`)
- Construtores oferecem diferentes formas de inicialização
- Encapsulamento garante que invariantes sejam preservados internamente
- Métodos públicos compõem a **interface** da classe

---

## Consumindo objetos

```java
// AccountApp.java (trecho)
try (Scanner scanner = new Scanner(System.in)) {
    Account account = new Account();
    account.setName(scanner.nextLine());
    account.setBalance(scanner.nextDouble());
    account.deposit(scanner.nextDouble());
}
```

- `try-with-resources` garante fechamento automático
- Separar coleta de dados (interface) da lógica da classe
- Responsabilidade única: `Account` cuida da regra de saldo, `AccountApp` da interação
- Objetos comunicam-se por mensagens (métodos) para manter coesão

---

## Outro exemplo: `Student`

```java
// Student.java
public class Student {
    private String name;
    private int age;
    private String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Student: %s%nAge: %d%nCourse: %s", name, age, course);
    }
}
```

- Construtor centraliza a inicialização obrigatória
- `toString` facilita registro no console (`StudentApp`)
- Getters expõem estado de maneira controlada; setters permitem mutabilidade
- Avalie quando optar por objetos imutáveis para simplificar concorrência

---

## Boas práticas

- Mantenha variáveis de instância `private`
- Forneça métodos de acesso apenas quando necessário
- Valide dados de entrada dentro da classe
- Crie métodos utilitários (`deposit`) para operações frequentes
- Utilize testes de unidade para assegurar invariantes e evitar efeitos colaterais
- Documente suposições (ex.: saldo não negativo) em JavaDoc

---
layout: backcover
---
