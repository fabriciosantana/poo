# Resumo – Introdução aos Conceitos de Orientação a Objetos

**Referência:** WEISFELD, Matt. Introduction to Object-Oriented Concepts. In: ___. The Object-Oriented Thought Process. 5. ed. Boston: Addison-Wesley, 2019.

---

## O que é Programação Orientada a Objetos?

A **Programação Orientada a Objetos (POO)** é um paradigma de programação que organiza o software em torno de **objetos**, em vez de funções e lógica. Um objeto combina **dados** (atributos) e **comportamentos** (métodos) em uma única unidade.

Antes da POO, o paradigma dominante era a **programação procedural**, onde o foco estava em procedimentos (funções) que operavam sobre dados separados. Com o aumento da complexidade dos sistemas, esse modelo se tornou difícil de manter e escalar.

---

## Objetos e Classes

### Objeto
Um **objeto** é uma instância de uma classe. Ele representa uma entidade do mundo real (ou conceitual) com:
- **Atributos**: os dados ou estado do objeto (ex: nome, cor, tamanho)
- **Comportamentos**: as ações que o objeto pode executar (ex: mover, calcular, exibir)

### Classe
Uma **classe** é o molde (ou planta) a partir do qual os objetos são criados. Ela define quais atributos e métodos seus objetos terão.

> **Analogia:** Uma classe é como uma planta arquitetônica de uma casa. Os objetos são as casas construídas a partir dessa planta.

---

## Os Três Pilares da POO

### 1. Encapsulamento

**Encapsulamento** é o princípio de esconder os detalhes internos de um objeto, expondo apenas o que é necessário para o mundo externo.

- Os dados de um objeto devem ser **privados** e acessados apenas por meio de **métodos públicos** (getters e setters).
- Isso protege a integridade dos dados e reduz o acoplamento entre partes do sistema.

> **Princípio:** Um objeto não deve revelar nada sobre si mesmo além do que é estritamente necessário para outros objetos interagirem com ele.

### 2. Herança

**Herança** permite que uma classe (subclasse) herde atributos e comportamentos de outra classe (superclasse), promovendo **reutilização de código**.

- A subclasse pode **estender** ou **sobrescrever** comportamentos da superclasse.
- Representa uma relação **"é um"** (ex: um Cachorro *é um* Animal).

```
Animal
 ├── Cachorro
 ├── Gato
 └── Pássaro
```

### 3. Polimorfismo

**Polimorfismo** permite que objetos de diferentes classes sejam tratados de forma uniforme por meio de uma interface comum.

- Um mesmo método pode ter comportamentos diferentes dependendo do objeto que o executa.
- Facilita a extensão do sistema sem modificar código existente.

> **Exemplo:** Um método `fazerSom()` funciona tanto para `Cachorro` (que late) quanto para `Gato` (que mia), sem que o código chamador precise saber a diferença.

---

## Composição vs. Herança

Além da herança, objetos podem se relacionar por meio de **composição** (relação **"tem um"**).

| Herança | Composição |
|---------|------------|
| "é um" | "tem um" |
| Carro *é um* Veículo | Carro *tem um* Motor |
| Reutiliza via extensão | Reutiliza via delegação |
| Acoplamento mais forte | Acoplamento mais fraco |

Weisfeld destaca que **composição tende a ser preferível** em muitos casos por gerar sistemas mais flexíveis e menos acoplados.

---

## Construtores e Destrutores

- **Construtor**: método especial executado quando o objeto é criado. Responsável por inicializar os atributos.
- **Destrutor**: método executado quando o objeto é destruído (liberação de memória). Em Java, o **garbage collector** gerencia isso automaticamente.

---

## Interfaces vs. Implementação

Um conceito central da POO é a separação entre:
- **Interface**: o que um objeto *pode fazer* (o contrato público)
- **Implementação**: *como* ele faz (os detalhes internos)

Programar orientado à interface, e não à implementação, é uma das práticas mais importantes para sistemas flexíveis e extensíveis.

---

## Conclusão

A POO aproxima o modelo de software do modelo mental humano, tornando sistemas mais intuitivos de projetar, entender e manter. Os conceitos de encapsulamento, herança e polimorfismo, quando bem aplicados, resultam em código mais reutilizável, testável e de fácil manutenção.
