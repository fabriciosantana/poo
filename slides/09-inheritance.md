---
layout: frontcover
transition: none
title: IDP - POO
id: aula09
lesson: Herança e polimorfismo
goals:
  - Criar hierarquias com classes base e derivadas
  - Utilizar `abstract` para definir contratos de subclasses
  - Aplicar polimorfismo com referências ao tipo base
---

---
layout: default
lesson: Estrutura da hierarquia
---

## Classe abstrata `Employee`

```java
// payroll/Employee.java
public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    protected Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s",
            getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public abstract double earnings();
}
```

- Define atributos e comportamento comum
- Método `earnings()` obriga subclasses a implementar regra própria
- Herança promove reutilização, mas deve respeitar o Princípio da Substituição de Liskov
- Use classes abstratas quando não faz sentido instanciar o tipo base diretamente

---

## Subclasses especializadas

- `SalariedEmployee`: salário fixo semanal
- `HourlyEmployee`: calcula horas trabalhadas com adicional de hora extra
- `CommissionEmployee`: baseia-se em vendas e taxa de comissão
- `BasePlusCommissionEmployee`: herda de `CommissionEmployee` e adiciona salário base
- Cada classe valida seus atributos antes de atribuí-los
- Sobrescrita (`@Override`) redefine comportamento mantendo assinatura
- Chamar `super(...)` no construtor garante inicialização do estado herdado

---

## Polimorfismo em ação

```java
// HeartRatesTest.java (trecho)
Employee[] employees = {salariedEmployee, hourlyEmployee,
                commissionEmployee, basePlusCommissionEmployee};

for(
Employee currentEmployee :employees){
        System.out.

println(currentEmployee);

    if(currentEmployee instanceof BasePlusCommissionEmployee){
BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
        employee.

setBaseSalary(1.10*employee.getBaseSalary());
        }

        System.out.

printf("earned $%,.2f%n%n",currentEmployee.earnings());
        }
```

- `instanceof` garante tipo antes do cast
- `earnings()` executa a implementação específica de cada classe
- Experimente atualizar para o pattern matching (`instanceof Tipo var`)
- Polimorfismo permite tratar objetos diferentes por meio de uma referência comum
- Upcasting é implícito; downcasting requer verificação prévia
- Arrays e coleções do tipo base aceitam quaisquer subclasses compatíveis

---

## Boas práticas

- Prefira construtores `protected` em classes abstratas
- Use `@Override` para sinalizar métodos sobrescritos
- Evite duplicação movendo lógica comum para a superclasse
- Documente invariantes (ex.: `weeklySalary >= 0`)
- Avalie composição vs herança: escolha a abordagem que mantém o modelo flexível
- Crie diagramas de classe para visualizar relacionamentos entre tipos

---
layout: backcover
---
