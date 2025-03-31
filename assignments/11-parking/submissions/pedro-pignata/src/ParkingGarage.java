import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = (hours > 0) ? 2.0 : 0.0;

        if (hours > 3) {
            charge += (hours - 3) * 0.5;
        }

        return Math.min(charge, 10.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalArrecadado = 0;
        int customerCount = 0;

        while (true) {
            System.out.println("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            
            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida! Digite um número entre 0 e 24.");
                scanner.next();
                continue;
            }
            
            double hours = scanner.nextDouble();

            if (hours == -1) {
                break;
            }

            if (hours < 0 || hours > 24) {
                System.out.println("Número inválido de horas! Digite um valor entre 0 e 24.");
                continue;
            }

            customerCount++;

            double charge = calculateCharges(hours);
            totalArrecadado += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", customerCount, charge);
        }

        System.out.printf("Total arrecadado: $%.2f%n", totalArrecadado);
        scanner.close();
    }
}
