import java.util.Scanner;
import java.util.Locale;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        if (hours <= 3.0) {
            return 2.00;
        } else {
            double extraHours = Math.ceil(hours - 3.0);
            double charge = 2.00 + (extraHours * 0.50);
            if (charge > 10.00) {
                return 10.00;
            } else {
                return charge;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        double totalReceipts = 0.0;
        int customerNumber = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1) {
                break;
            }

            double charge = calculateCharges(hours);
            totalReceipts += charge;

            System.out.printf(Locale.US, "Cliente %d: Taxa de estacionamento: $%.2f\n", customerNumber, charge);
            customerNumber++;
        }

        System.out.printf(Locale.US, "Total arrecadado ontem: $%.2f\n", totalReceipts);
        scanner.close();
    }
}
