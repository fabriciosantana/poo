# AgenciaFlow — Gestão de Serviços de uma Agência Digital

## Domínio

O **AgenciaFlow** é uma aplicação Java para organizar os serviços contratados por um cliente em um projeto de agência digital. O sistema controla serviços de design e tecnologia, orçamento, capacidade do projeto e conclusão das entregas.

A proposta é representar um cenário real de uma pequena agência que precisa reunir diferentes tipos de serviço no mesmo projeto, mantendo regras de preço e execução nas próprias classes do domínio.

## Casos de uso

1. **Adicionar serviços ao projeto:** cadastrar serviços de design ou tecnologia respeitando a capacidade e o orçamento do cliente.
2. **Calcular o orçamento consolidado:** percorrer serviços de tipos diferentes e calcular seus valores finais por polimorfismo.
3. **Buscar e concluir entregas:** localizar um serviço pelo identificador, marcá-lo como concluído e finalizar o projeto apenas quando todas as entregas estiverem prontas.

## Regras de negócio

1. Todo cliente precisa ter nome e limite de orçamento positivo.
2. Todo serviço precisa possuir descrição e valor base positivo.
3. Um projeto aceita no máximo **5 serviços**.
4. A soma dos serviços não pode ultrapassar o limite de orçamento do cliente.
5. Serviços de design urgentes recebem acréscimo de **20%** sobre seu valor calculado.
6. Serviços de tecnologia variam de preço conforme a complexidade (`BASICA`, `MEDIA` ou `ALTA`).
7. Um projeto só pode ser concluído quando possuir ao menos um serviço e todos os serviços estiverem concluídos.

## Diagrama de classes

![Diagrama de classes](doc/diagrama-classes.png)

## Decisões de modelagem

- `Servico` é uma **classe abstrata** porque todo serviço possui identidade, descrição, valor base e estado, mas cada especialização calcula seu preço de uma forma diferente.
- `ServicoDesign` e `ServicoTecnologia` herdam de `Servico` e sobrescrevem `calcularValorFinal()` e `getTipo()`, permitindo **polimorfismo**.
- `Projeto` possui associação com um `Cliente` e agrega um array de objetos `Servico`.
- Os atributos são privados e as alterações de estado são feitas por métodos que preservam as regras do domínio, demonstrando **encapsulamento**.
- `Servico` utiliza um contador `static` para gerar identificadores únicos e `Projeto` utiliza uma constante `static` para a capacidade máxima.

## Evidências dos requisitos

| Requisito | Evidência |
|---|---|
| 4+ classes de domínio | `Servico`, `ServicoDesign`, `ServicoTecnologia`, `Cliente`, `Projeto` |
| Herança | `ServicoDesign` e `ServicoTecnologia` estendem `Servico` |
| Polimorfismo | `Servico[]` é percorrido em `AgenciaFlowApp` chamando `calcularValorFinal()` |
| Encapsulamento | atributos privados e validações nos construtores/métodos |
| Associação/agregação | `Projeto` referencia `Cliente` e mantém `Servico[]` |
| `toString()` | sobrescrito em `Servico`, `Cliente` e `Projeto` |
| Membro `static` | `Servico.proximoId` e `Projeto.CAPACIDADE_MAXIMA` |
| Seleção `if/else` | validações e regras de orçamento/capacidade |
| Seleção `switch` | cálculo por complexidade em `ServicoTecnologia` |
| Repetição `for/for-each` | totalização e percurso polimórfico |
| Repetição `while` | busca por ID em `Projeto.buscarServicoPorId()` |
| Cenário inválido | tentativa de criar serviço com valor negativo |
| Caso de fronteira | tentativa de inserir o sexto serviço em um projeto com limite 5 |

## Compilação e execução

```bash
mkdir -p bin
javac -d bin src/*.java
java -cp bin AgenciaFlowApp
```
