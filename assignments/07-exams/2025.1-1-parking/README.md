### IDP Park: Sistema de Estacionamento de Veículos

Você foi contratado para desenvolver um sistema de controle de estacionamento para o **IDP Park**. O sistema deve permitir o cadastro e o gerenciamento de diferentes tipos de veículos que utilizam o estacionamento (carros, motos e caminhões). Cada veículo possui informações comuns como **placa, marca e modelo**, mas também pode ter atributos e comportamentos específicos.

#### Especificação

1. Crie uma classe abstrata chamada `Vehicle` com os seguintes atributos:
   - `plate` (String): placa do veículo
   - `brand` (String): marca do veículo
   - `model` (String): modelo do veículo

2. A classe `Vehicle` deve possuir:
   - um construtor para inicializar os atributos
   - métodos `get` e `set` para cada atributo
   - um método `calculateParkingFee(int hours)` que será sobrescrito nas subclasses
   - um método `toString()` sobrescrito que retorne as informações do veículo.

3. Crie as seguintes subclasses que herdam de `Vehicle`:
   - `Car`: tarifa por hora de R$ 5,00
   - `Motorcycle`: tarifa por hora de R$ 3,00
   - `Truck`: tarifa por hora de R$ 10,00

4. Cada subclasse deve sobrescrever o método `calculateParkingFee(int hours)` para aplicar a tarifa correta.

5. Crie uma classe de teste chamada `ParkingApp` com o método `main`. No `main`:
   - Crie um vetor (`ArrayList`) de veículos.
   - Adicione pelo menos um veículo de cada tipo.
   - Para cada veículo, calcule e exiba o valor a pagar para um período de 4 horas de estacionamento.

#### Exemplo de saída esperada
```
Carro - Placa: ABC-1234 - Marca: Toyota - Modelo: Corolla
Valor a pagar por 4h: R$ 20.00

Moto - Placa: XYZ-5678 - Marca: Honda - Modelo: CG 160
Valor a pagar por 4h: R$ 12.00

Caminhão - Placa: KLM-9090 - Marca: Volvo - Modelo: FH 540
Valor a pagar por 4h: R$ 40.00
```

#### Envio

1. Sincronize seu repositório com o repositório principal da disciplina
1. Crie, dentro do diretório `/challenges/03-parking/submissions/` o diretório `seu-nome/src`
1. Desenvolva o programa dentro do diretório `seu-nome/src`
1. Salve os arquivos, faça um commit e envie um pull request para o respositório da disciplina
1. Submeter link do pull request no ambiente virtual
