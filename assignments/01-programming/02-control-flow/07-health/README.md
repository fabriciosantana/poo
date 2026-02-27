### Registros de Saúde Ditigal

**Referência:** DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects.* 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.  

---

### **Descrição**  

A informatização dos registros de saúde tem sido um tópico de destaque devido a preocupações com **privacidade e segurança**. No entanto, a digitalização desses registros pode **facilitar o compartilhamento de informações médicas** entre diferentes profissionais da área da saúde, melhorando a qualidade dos atendimentos, reduzindo erros de prescrição e contribuindo para a eficiência dos tratamentos.  

Neste exercício, você deve projetar uma **classe chamada `HealthProfile`** para armazenar e processar as informações básicas de um paciente. Os atributos da classe devem incluir:  
- **Nome** (`firstName`)  
- **Sobrenome** (`lastName`)  
- **Gênero** (`gender`)  
- **Data de nascimento** (`dayOfBirth`, `monthOfBirth`, `yearOfBirth`)  
- **Altura** (`heightInInches`, em polegadas)  
- **Peso** (`weightInPounds`, em libras)  

A classe deve possuir **métodos para calcular e retornar**:  
- **Idade do paciente em anos**  
- **Frequência cardíaca máxima e faixa de frequência cardíaca alvo** (conforme [Calculadora de frequência cardíaca alvo](./06-heart))  
- **Índice de Massa Corporal (BMI)** *(conforme [Calculadora do Índice de Massa Corporal](./01-imc))*  

O programa deve solicitar os dados do usuário, instanciar um objeto da classe `HealthProfile` e imprimir as informações do paciente, incluindo idade, **IMC**, frequência cardíaca máxima e a faixa de frequência cardíaca alvo. O programa também deve exibir a **tabela de valores do IMC**.

---

### **Especificação**  

1. O programa deve solicitar os seguintes dados do usuário:  
   ```bash
   Digite seu primeiro nome: João  
   Digite seu sobrenome: Silva  
   Digite seu gênero (M/F): M  
   Digite sua data de nascimento (dia, mês e ano separados por espaço): 15 08 1990  
   Digite sua altura em polegadas: 70  
   Digite seu peso em libras: 180  
   ```  

2. O programa deve calcular e exibir:  
   ```bash
   Nome: João Silva  
   Gênero: Masculino  
   Data de nascimento: 15/08/1990  
   Idade: 34 anos  
   Altura: 70 polegadas  
   Peso: 180 libras  
   Índice de Massa Corporal (BMI): 25.8  
   Frequência cardíaca máxima: 186 bpm  
   Faixa de frequência cardíaca alvo: 93 bpm - 158 bpm  
   ```  

3. O programa deve exibir a **tabela de referência do BMI**, conforme abaixo:  

   | **BMI**     | **Classificação**            |  
   |-------------|-----------------------------|  
   | **Menos de 18.5**  | Abaixo do peso           |  
   | **18.5 – 24.9**   | Peso normal              |  
   | **25.0 – 29.9**   | Sobrepeso                |  
   | **30.0 ou mais**  | Obesidade                |  

---

### **Requisitos de Implementação**  

1. O programa deve conter uma **classe chamada `HealthProfile`**.  
2. A classe `HealthProfile` deve conter os seguintes **atributos privados**:  
   - `firstName` (String) → Primeiro nome da pessoa.  
   - `lastName` (String) → Sobrenome da pessoa.  
   - `gender` (char) → Gênero (`M` para masculino, `F` para feminino).  
   - `dayOfBirth` (int) → Dia de nascimento.  
   - `monthOfBirth` (int) → Mês de nascimento.  
   - `yearOfBirth` (int) → Ano de nascimento.  
   - `heightInInches` (double) → Altura em polegadas.  
   - `weightInPounds` (double) → Peso em libras.  

3. A classe deve possuir um **construtor** que recebe os atributos acima como parâmetros.  
4. A classe deve conter **métodos de acesso (`get` e `set`)** para cada atributo.  
5. A classe deve conter os seguintes **métodos públicos**:  
   - `calculateAge(int currentYear)`: Retorna a **idade** do usuário.  
   - `calculateMaxHeartRate()`: Retorna a **frequência cardíaca máxima**.  
   - `calculateTargetHeartRate()`: Retorna a **faixa de frequência cardíaca alvo (mínimo e máximo)**.  
   - `calculateBMI()`: Retorna o **Índice de Massa Corporal (BMI)**, usando a fórmula:  
     \[
     BMI = \frac{peso (lbs) \times 703}{altura (in)^2}
     \]  

6. O programa principal (`main`) deve:  
   - Solicitar os dados do usuário.  
   - Criar um objeto `HealthProfile` com os dados fornecidos.  
   - Exibir as informações do usuário.  
   - Calcular e exibir a idade, a **frequência cardíaca máxima**, a **faixa de frequência cardíaca alvo** e o **BMI**.  
   - Exibir a **tabela de referência do BMI**.  

