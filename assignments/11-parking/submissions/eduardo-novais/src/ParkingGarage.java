import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        if (hours <= 0) {
            return 2.0;
        }

        if (hours <= 3.0) {
            return 2.00;
        }

        if (hours >= 24) {
            return 10.00;
        }

        double hoursExtra = Math.ceil(hours - 3.0);
        double tax = 2.00 + (hoursExtra * 0.50);

        if (tax > 10.00) {
            return 10.00;
        }

        return tax;
    }

    public static void main(String[] args) {
        double totalTax = 0.0;

        int count = 1;

        Scanner input = new Scanner(System.in);

        double hours = 0;

        while (hours != -1) {
            try {
                System.out.print("Digite o número de horas para o cliente " + count + " (ou -1 para sair): ");

                hours = input.nextDouble();

                if (hours != -1) {
                    double tax = calculateCharges(hours);

                    System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n%n", count, tax);

                    totalTax += tax;
                    count++;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Entrada inválida. Por favor, digite um número.\n");

                input.next();
            }
        }

        System.out.printf("Total arrecadado: $%.2f%n", totalTax);

        input.close();
    }
}