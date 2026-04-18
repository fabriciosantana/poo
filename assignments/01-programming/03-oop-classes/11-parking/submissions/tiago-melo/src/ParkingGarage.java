import java.util.Locale;
import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double horas) {
        if (horas <= 3.0) {
            return 2.0;
        }

        if (horas >= 24.0) {
            return 10.0;
        }

        double horasExtras = Math.ceil(horas - 3.0);
        double taxa = 2.0 + (horasExtras * 0.5);

        return Math.min(taxa, 10.0);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);
        int numeroCliente = 1;
        double total = 0.0;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            double taxa = calculateCharges(horas);
            total += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", numeroCliente, taxa);
            numeroCliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}
