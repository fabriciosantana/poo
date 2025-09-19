import java.util.Scanner;

public class ParkingGarage {

    // Método para calcular a taxa de estacionamento
    public static double calculateCharges(double hours) {
        // Se valor inválido (0 ou menor), ainda cobra taxa mínima
        if (hours <= 0) {
            return 2.00;
        }

        // Se maior que 24h, aplica taxa máxima
        if (hours > 24) {
            return 10.00;
        }

        // Até 3 horas → taxa fixa de 2.00
        if (hours <= 3.0) {
            return 2.00;
        }

        // Acima de 3h → 2.00 + 0.50 por cada hora/fracionada a mais
        double extraHours = Math.ceil(hours - 3.0); // arredonda para cima
        double charge = 2.00 + (extraHours * 0.50);

        // Limite máximo de 10.00
        return Math.min(charge, 10.00);
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            double taxa = calculateCharges(horas);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);

            total += taxa;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}
