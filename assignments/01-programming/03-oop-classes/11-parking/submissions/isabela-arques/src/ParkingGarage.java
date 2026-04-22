import java.util.Scanner;

public class ParkingGarage {

   
    public static double calculateCharges(double hours) {
        if (hours <= 3.0) {
            return 2.00;
        }

        double additionalHours = hours - 3.0;
        double extraCharge = Math.ceil(additionalHours) * 0.50;
        double totalCharge = 2.00 + extraCharge;

        
        return Math.min(totalCharge, 10.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalRevenue = 0.0;
        int clientNumber = 1;

        System.out.println("=== Sistema de Cobrança - Garagem de Estacionamento ===\n");

        while (true) {
            System.out.printf("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1) {
                break;
            }

            double charge = calculateCharges(hours);

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", clientNumber, charge);
            totalRevenue += charge;
            clientNumber++;
        }

        System.out.printf("%nTotal arrecadado ontem: $%.2f%n", totalRevenue);
        scanner.close();
    }
}