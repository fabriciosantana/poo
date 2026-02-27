### **Cálculo de Taxas de Estacionamento**  

**Referência:** Fonte: DEITEL, Paul; DEITEL, Harvey. *Java: How to Program, Early Objects*. 11. ed. Boston: Pearson, 2017. ISBN 978-0-13-474335-6.  

---

#### **Descrição**  

Uma garagem de estacionamento cobra uma **taxa mínima de R$2.00** para até **3 horas** de permanência.  
- Para cada **hora adicional ou fração de hora**, a garagem cobra **R$0.50 por hora**.  
- A **taxa máxima** para qualquer período de **24 horas** é de **$10.00**.  
- Nenhum carro permanece no estacionamento por mais de **24 horas**.  

O programa deve calcular e exibir as taxas de estacionamento para **cada cliente que utilizou a garagem ontem**.  
- O usuário deve **inserir as horas estacionadas** para cada cliente.  
- O programa deve exibir a taxa de estacionamento para **cada cliente**.  
- Deve ser calculado e exibido o **total arrecadado** ao longo do dia.  

O cálculo das taxas de estacionamento deve ser feito por meio do método **`calculateCharges`**, que recebe como entrada as horas estacionadas e retorna o valor correspondente a ser cobrado.  

---

### **Especificação**  

1. O programa deve calcular a **taxa de estacionamento** para cada cliente com base no número de horas estacionadas.  
2. As regras de cobrança são:  
   - **Até 3 horas:** taxa fixa de **R$2.00**.  
   - **Acima de 3 horas:** cobrança de **R$0.50 por hora extra**.  
   - **Taxa máxima:** **R$10.00 para um período de 24 horas**.  
3. O programa deve solicitar a entrada do usuário conforme o exemplo:  
    ```bash
    Digite o número de horas estacionadas para o cliente (ou -1 para sair): 5.5
    ```
4. Para cada cliente, o programa deve exibir:  
   ```bash
   Cliente 1: Taxa de estacionamento: $3.00
   ```
5. O programa deve manter um **total acumulado** das receitas do estacionamento e exibir ao final:  
   ```bash
   Total arrecadado ontem: $25.50
   ```
   
---

### **Requisitos de Implementação**  

1. O programa deve conter uma **classe chamada `ParkingGarage`**.  
2. A classe `ParkingGarage` deve conter os seguintes métodos estáticos:  
   - **`calculateCharges(double hours)`** → recebe um número `double` representando as horas estacionadas e retorna o valor a ser cobrado.  
   - **`main(String[] args)`** → recebe a entrada do usuário, processa os valores e exibe os resultados.  
3. O programa deve aceitar **valores fracionários** para o número de horas estacionadas.  
4. O programa deve **encerrar** quando o usuário digitar **-1** como entrada.  
5. Utilizar a **classe `Scanner`** para ler as entradas do usuário.  
6. O cálculo da taxa deve ser feito **exclusivamente pelo método `calculateCharges`**, garantindo modularidade.  