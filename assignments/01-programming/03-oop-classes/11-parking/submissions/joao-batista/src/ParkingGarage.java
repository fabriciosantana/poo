import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.00;

        if (hours > 3) {
            charge += (int)(hours - 3) * 0.50;
        }

        return Math.min(charge, 10.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalReceita = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            double taxa = calculateCharges(horas);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);

            totalReceita += taxa;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalReceita);
        scanner.close();
    }
}

