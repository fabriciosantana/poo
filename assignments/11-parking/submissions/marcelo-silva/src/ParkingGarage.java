import java.util.Locale;
import java.util.Scanner;


public class ParkingGarage {

    
    public static void main(String[] args) {
        // Define o Locale como US para garantir que o Scanner use '.' como separador decimal.
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        double totalReceipts = 0.0;
        int customerCount = 1;

        System.out.println("Cálculo de Taxas de Estacionamento (digite -1 para sair)");
        System.out.println("---------------------------------------------------------");

        // Loop para processar os clientes
        while (true) {
            System.out.printf("Digite o número de horas estacionadas para o cliente %d (ou -1 para sair): ", customerCount);
            double hours = input.nextDouble();

            // Condição de parada do loop
            if (hours == -1) {
                break;
            }

            // Validação para garantir que as horas estão dentro do limite de 24 horas
            if (hours <= 0 || hours > 24) {
                System.out.println("Entrada inválida. Por favor, insira um valor de horas positivo e não superior a 24.");
                continue; // Pula para a próxima iteração do loop
            }

            // Chama o método para calcular a taxa do cliente atual
            double currentCharge = calculateCharges(hours);

            // Adiciona a taxa ao total arrecadado
            totalReceipts += currentCharge;

            // Exibe a taxa para o cliente atual formatada com duas casas decimais
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n%n", customerCount, currentCharge);

            customerCount++;
        }

        System.out.println("---------------------------------------------------------");
        // Exibe o total arrecadado no dia
        System.out.printf("Total arrecadado ontem: $%.2f%n", totalReceipts);

        // Fecha o Scanner para liberar recursos
        input.close();
    }

    /**
     * Calcula a taxa de estacionamento com base no número de horas.
     *
     * @param hours O número de horas que o carro ficou estacionado.
     * @return O valor da taxa de estacionamento a ser cobrada.
     */
    public static double calculateCharges(double hours) {
        double charge;
        final double MINIMUM_FEE = 2.00;
        final double HOURLY_RATE_EXTRA = 0.50;
        final double MAXIMUM_FEE = 10.00;
        final double BASE_HOURS = 3.0;

        // Regra 1: Taxa mínima para até 3 horas.
        if (hours <= BASE_HOURS) {
            charge = MINIMUM_FEE;
        } else {
            // Regra 2: Taxa base mais cobrança por hora adicional ou fração.
            charge = MINIMUM_FEE;

            // Math.ceil arredonda as horas para cima para garantir que qualquer
            // fração de hora seja cobrada como uma hora inteira.
            // Ex: 4.1 horas se tornam 5 horas.
            double totalHoursRoundedUp = Math.ceil(hours);

            // Calcula o custo adicional
            charge += (totalHoursRoundedUp - BASE_HOURS) * HOURLY_RATE_EXTRA;
        }

        // Regra 3: A taxa não pode exceder o valor máximo.
        // Se a taxa calculada for maior que a máxima, ela é ajustada para a taxa máxima.
        if (charge > MAXIMUM_FEE) {
            charge = MAXIMUM_FEE;
        }
        
        // Alternativa para a Regra 3 usando Math.min:
        // charge = Math.min(charge, MAXIMUM_FEE);

        return charge;
    }
}