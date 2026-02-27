
### Monitoramento da Frequência Cardíaca

Referência: Fonte:DEITEL, Paul; DEITEL, Harvey. Java: How to Program, Early Objects. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.

#### Descrição

Ao se exercitar, você pode usar um monitor de frequência cardíaca para verificar se sua frequência permanece dentro de uma faixa segura sugerida por seus treinadores e médicos. De acordo com a American Heart Association (AHA) (https://www.heart.org/en), **a fórmula para calcular sua frequência cardíaca máxima em batimentos por minuto é 220 menos sua idade em anos**. Sua frequência cardíaca alvo é uma faixa de 50–85% de sua frequência cardíaca máxima. 
```
Observação: essas fórmulas são estimativas fornecidas pela AHA. As frequências cardíacas máxima e alvo podem variar com base na saúde, condicionamento físico e sexo do indivíduo. Sempre consulte um médico ou profissional de saúde qualificado antes de começar ou modificar um programa de exercícios.
```
Crie uma classe chamada `HeartRates`. Os atributos da classe devem incluir o `primeiro nome`, o `sobrenome` e a `data de nascimento` da pessoa (consistindo em atributos separados para o `mês`, `dia` e `ano` de nascimento). Sua classe deve ter um `construtor` que receba esses dados como parâmetros. Para cada atributo, forneça os métodos `set` e `get`. A classe também deve incluir `um método que calcule e retorne a idade da pessoa (em anos)` , `um método que calcule e retorne a frequência cardíaca máxima da pessoa` e `um método que calcule e retorne a frequência cardíaca alvo da pessoa`.

Escreva um aplicativo Java que solicite as informações da pessoa, instancie um objeto da classe HeartRates e imprima as informações desse objeto — incluindo o primeiro nome, o sobrenome e a data de nascimento da pessoa — e então calcule e imprima a idade da pessoa em (anos), frequência cardíaca máxima e intervalo de frequência cardíaca alvo.

#### Especificação

1. O programa deve calcular a `frequência cardíaca máxima` e a `faixa de frequência cardíaca alvo` de um indivíduo com base na sua idade.
2. A `frequência cardíaca máxima` é calculada usando a fórmula:
   \[
   \text{Frequência Cardíaca Máxima} = 220 - \text{idade}
   \]
3. A `faixa de frequência cardíaca alvo` é calculada como **50% a 85%** da frequência cardíaca máxima:
   \[
   \text{Frequência Alvo Mínima} = \text{Frequência Cardíaca Máxima} \times 0.50
   \]
   \[
   \text{Frequência Alvo Máxima} = \text{Frequência Cardíaca Máxima} \times 0.85
   \]
4. O programa deve solicitar as seguintes informações do usuário:
```bash
Digite seu primeiro nome: João
Digite seu sobrenome: Silva
Digite sua data de nascimento (dia, mês e ano separados por espaço): 15 08 1990
```
5. O programa deve imprimir as seguintes informações:
```bash
Nome: João Silva
Data de nascimento: 15/08/1990
Idade: 34 anos
Frequência cardíaca máxima: 186 bpm
Faixa de frequência cardíaca alvo: 93 bpm - 158 bpm
```

#### **Requisitos de Implementação**
1. O programa deve conter uma **classe chamada `HeartRates`**.
2. A classe `HeartRates` deve conter os seguintes atributos privados:
   - `firstName` (String) → Primeiro nome da pessoa.
   - `lastName` (String) → Sobrenome da pessoa.
   - `dayOfBirth` (int) → Dia de nascimento.
   - `monthOfBirth` (int) → Mês de nascimento.
   - `yearOfBirth` (int) → Ano de nascimento.
3. A classe deve possuir um **construtor** que recebe os atributos acima como parâmetros.
4. A classe deve conter **métodos de acesso (`get` e `set`)** para cada atributo.
5. A classe deve conter os seguintes métodos públicos:
   - `calculateAge(int currentYear)`: Retorna a **idade** do usuário.
   - `calculateMaxHeartRate()`: Retorna a **frequência cardíaca máxima**.
   - `calculateTargetHeartRate()`: Retorna a **faixa de frequência cardíaca alvo (mínimo e máximo)**.
6. O programa principal (`main`) deve:
   - Solicitar os dados do usuário.
   - Criar um objeto `HeartRates` com os dados fornecidos.
   - Exibir as informações do usuário.
   - Calcular e exibir a idade, a frequência cardíaca máxima e a faixa de frequência cardíaca alvo.