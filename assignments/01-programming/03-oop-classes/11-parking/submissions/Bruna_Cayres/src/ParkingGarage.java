import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int clienteCount = 1;

        System.out.println("--- Sistema de Tarifação de Estacionamento ---");

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            // Condição de parada do programa
            if (horas == -1) {
                break;
            }

            // Validação simples para evitar entradas impossíveis
            if (horas < 0 || horas > 24) {
                System.out.println("Entrada inválida. Nenhum carro permanece por mais de 24 horas (ou horas negativas).");
                continue;
            }

            // Calcula a taxa para o cliente atual
            double taxa = calculateCharges(horas);
            totalArrecadado += taxa;

            // Exibe o resultado para o cliente atual
            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n", clienteCount, taxa);
            clienteCount++;
        }

        // Exibe o total arrecadado ao final do dia
        System.out.println("----------------------------------------------");
        System.out.printf("Total arrecadado ontem: R$%.2f%n", totalArrecadado);
        
        scanner.close();
    }

    /**
     * Calcula a taxa de estacionamento com base nas horas.
     * * @param hours O número de horas estacionadas.
     * @return O valor a ser cobrado.
     */
    public static double calculateCharges(double hours) {
        // Taxa mínima para até 3 horas
        double taxa = 2.00; 

        // Se passar de 3 horas, adiciona a cobrança extra
        if (hours > 3.0) {
            // Math.ceil arredonda para cima. Assim, qualquer "fração de hora" vira uma hora cheia para cobrança.
            // Ex: 5.5 horas - 3.0 = 2.5 horas extras. Math.ceil(2.5) = 3.0 horas a serem cobradas.
            double horasExtras = Math.ceil(hours - 3.0);
            taxa += (horasExtras * 0.50);
        }

        // A taxa máxima não pode ultrapassar R$10.00
        if (taxa > 10.00) {
            taxa = 10.00;
        }

        return taxa;
    }
}