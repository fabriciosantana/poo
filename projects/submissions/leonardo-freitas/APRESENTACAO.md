# Apresentação do AgenciaFlow

Este documento organiza a apresentação do **AgenciaFlow** conforme os requisitos do Projeto Autoral de Programação Orientada a Objetos.

## 1. Objetivo da apresentação

A apresentação deve demonstrar quatro pontos:

1. explicar o problema de negócio e a modelagem adotada;
2. executar os três casos de uso definidos no projeto;
3. localizar no código os principais requisitos de Programação Orientada a Objetos;
4. justificar as decisões de implementação.

A demonstração pode ser feita diretamente pelo terminal usando `AgenciaFlowApp`.

## 2. Roteiro sugerido

### Etapa 1 — Contextualização do problema

**Tempo sugerido: 1 minuto**

O AgenciaFlow representa uma pequena agência digital que precisa controlar serviços contratados por clientes. Um projeto pode reunir serviços de design e tecnologia, cada um com regras próprias de cálculo. O sistema também controla orçamento, limite de serviços e conclusão das entregas.

Apresente os três casos de uso:

1. adicionar serviços respeitando orçamento e capacidade;
2. calcular o valor consolidado usando polimorfismo;
3. localizar e concluir serviços até permitir a conclusão do projeto.

### Etapa 2 — Modelagem e diagrama de classes

**Tempo sugerido: 1 a 2 minutos**

Abra o diagrama em `doc/diagrama-classes.png` e explique:

- `Cliente`: representa o contratante e seu limite de orçamento;
- `Projeto`: agrega os serviços, controla capacidade, orçamento e status;
- `Servico`: superclasse abstrata com dados e comportamentos comuns;
- `ServicoDesign`: especialização para trabalhos de design;
- `ServicoTecnologia`: especialização para trabalhos de tecnologia.

Explique que `Projeto` mantém um `Cliente` e um array de `Servico`, enquanto `ServicoDesign` e `ServicoTecnologia` são subclasses de `Servico`.

### Etapa 3 — Herança, abstração e polimorfismo

**Tempo sugerido: 2 minutos**

Abra `Servico.java`.

Mostre que a classe é abstrata:

```java
public abstract class Servico
```

Explique que todo serviço possui `id`, `descricao`, `valorBase` e estado de conclusão, mas cada tipo calcula seu valor final de forma diferente.

Mostre os métodos abstratos:

```java
public abstract double calcularValorFinal();
public abstract String getTipo();
```

Depois abra `ServicoDesign.java` e `ServicoTecnologia.java` e mostre o `@Override`.

No `AgenciaFlowApp`, localize:

```java
Servico[] portfolio = projeto.listarServicos();

for (Servico servico : portfolio) {
    System.out.printf("%s -> R$ %.2f%n",
            servico.getTipo(),
            servico.calcularValorFinal());
}
```

Explique que a variável possui o tipo da superclasse `Servico`, mas em tempo de execução o Java chama a implementação correspondente ao objeto concreto. Essa é a chamada polimórfica exigida pelo projeto.

### Etapa 4 — Encapsulamento e regras de negócio

**Tempo sugerido: 1 a 2 minutos**

Abra `Cliente.java`, `Servico.java` e `Projeto.java`.

Destaque que os atributos são privados e que os objetos só entram em estados válidos por meio dos construtores e métodos.

Exemplos:

- cliente sem nome é recusado;
- orçamento precisa ser positivo e finito;
- serviço precisa ter descrição e valor base válido;
- um projeto não aceita mais de cinco serviços;
- o valor total não pode ultrapassar o orçamento;
- o projeto só pode ser concluído depois que todos os serviços estiverem concluídos.

Explique que essas regras ficam nas classes de domínio e não apenas no `main`.

### Etapa 5 — Outros requisitos da disciplina

**Tempo sugerido: 1 minuto**

Mostre rapidamente:

- `static`: `Servico.proximoId` e `Projeto.CAPACIDADE_MAXIMA`;
- `if`: validações e regras em `Projeto`;
- `switch`: normalização e cálculo de complexidade em `ServicoTecnologia`;
- `for-each`: cálculo e demonstração polimórfica;
- `for`: verificação de conclusão dos serviços;
- `while`: busca pelo ID em `Projeto.buscarServicoPorId()`;
- array: `Servico[] servicos`;
- `toString()`: sobrescrito em classes do domínio.

## 3. Execução dos três casos de uso

No diretório da submissão:

```bash
mkdir -p bin
javac -d bin src/*.java
java -cp bin AgenciaFlowApp
```

### Caso de uso 1 — Adicionar serviços

A aplicação cria um cliente e um projeto, depois adiciona um serviço de design e um serviço de tecnologia.

Explique que `Projeto.adicionarServico()` verifica:

- objeto não nulo;
- capacidade máxima;
- status do projeto;
- valor do serviço;
- total do projeto;
- limite de orçamento.

### Caso de uso 2 — Calcular orçamento consolidado

A aplicação percorre um `Servico[]` e chama `calcularValorFinal()`.

O serviço de design considera quantidade de peças e urgência. O serviço de tecnologia considera horas estimadas e complexidade.

Esse caso demonstra herança, sobrescrita e polimorfismo.

### Caso de uso 3 — Buscar e concluir entregas

A aplicação busca um serviço pelo ID, conclui a entrega e tenta concluir o projeto.

A primeira tentativa deve falhar porque ainda existem serviços pendentes. Depois que todos são concluídos, o projeto pode mudar para `CONCLUIDO`.

## 4. Cenário inválido e caso de fronteira

### Cenário inválido

O programa tenta criar:

```java
new ServicoDesign("Inválido", -10, 1, false);
```

O construtor impede a criação e lança `IllegalArgumentException`.

Explique que a validação protege o estado do objeto desde sua criação.

### Caso de fronteira

A capacidade máxima é:

```java
public static final int CAPACIDADE_MAXIMA = 5;
```

Depois de preencher as cinco posições, a tentativa de adicionar o sexto serviço retorna `false`.

Explique que o limite é uma regra de negócio e também demonstra processamento de array.

## 5. Mapa rápido dos requisitos

| Conceito | Onde mostrar |
|---|---|
| Classes e objetos | Todas as classes do domínio e `AgenciaFlowApp` |
| Encapsulamento | Atributos `private` e validações |
| Herança | `ServicoDesign extends Servico`, `ServicoTecnologia extends Servico` |
| Abstração | `abstract class Servico` |
| Sobrescrita | `calcularValorFinal()` e `getTipo()` |
| Polimorfismo | `Servico[]` percorrido em `AgenciaFlowApp` |
| Associação/agregação | `Projeto` referencia `Cliente` e mantém `Servico[]` |
| `static` | `Servico.proximoId`, `Projeto.CAPACIDADE_MAXIMA` |
| `if` | validações e regras em `Projeto` |
| `switch` | `ServicoTecnologia` |
| `for` | `Projeto.concluirProjeto()` |
| `for-each` | totalização e demonstração em `AgenciaFlowApp` |
| `while` | `Projeto.buscarServicoPorId()` |
| Array | `Servico[] servicos` |
| Busca | `buscarServicoPorId()` |
| Totalização | `calcularTotal()` |
| Validação | construtores e `adicionarServico()` |
| Caso válido | inclusão e conclusão dos serviços |
| Caso inválido | valor base negativo |
| Caso de fronteira | sexto serviço |

## 6. Ordem de arquivos durante a apresentação

Para evitar procurar código durante a avaliação, deixe estas abas abertas antes de começar:

1. `README.md`;
2. `doc/diagrama-classes.png`;
3. `src/AgenciaFlowApp.java`;
4. `src/Servico.java`;
5. `src/ServicoDesign.java`;
6. `src/ServicoTecnologia.java`;
7. `src/Projeto.java`;
8. `src/Cliente.java`.

## 7. Checklist antes da apresentação

- confirmar que o projeto compila com Java 21;
- executar `AgenciaFlowApp` pelo menos uma vez;
- deixar o terminal no diretório correto;
- deixar o diagrama e os arquivos principais abertos;
- saber explicar os três casos de uso sem ler;
- saber apontar herança, polimorfismo, encapsulamento, array, `static`, `switch`, `for`, `for-each` e `while`;
- saber explicar por que `Servico` é abstrata;
- saber explicar por que o array é do tipo `Servico[]`;
- saber explicar as principais regras de negócio;
- saber justificar o uso de `Double.isFinite()` nas validações financeiras.
