import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        if (hours <= 3.0) {
            return 2.0;
        }

        if (hours >= 24.0) {
            return 10.0;
        }

        double additionalHours = Math.ceil(hours - 3.0);
        double charge = 2.0 + (additionalHours * 0.5);

        return Math.min(charge, 10.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int clientNumber = 1;
        double total = 0.0;

        while (true) {
            System.out.print("Digite o numero de horas estacionadas para o cliente (ou -1 para sair): ");

            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada invalida. Tente novamente.");
                scanner.next();
                continue;
            }

            double hours = scanner.nextDouble();

            if (hours == -1.0) {
                break;
            }

            double charge = calculateCharges(hours);
            total += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", clientNumber, charge);
            clientNumber++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}