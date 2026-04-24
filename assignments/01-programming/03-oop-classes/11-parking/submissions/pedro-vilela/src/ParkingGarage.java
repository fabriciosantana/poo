import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        final double MINIMUM_CHARGE = 2.00;
        final double RATE_PER_HOUR  = 0.50;
        final double MAXIMUM_CHARGE = 10.00;
        final double FREE_HOURS     = 3.0;

        double charge;

        if (hours <= FREE_HOURS) {
            charge = MINIMUM_CHARGE;
        } else {
            double extraHours = Math.ceil(hours - FREE_HOURS);
            charge = MINIMUM_CHARGE + extraHours * RATE_PER_HOUR;
        }

        return Math.min(charge, MAXIMUM_CHARGE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int    customerCount = 0;
        double totalRevenue  = 0.0;

        System.out.println("=== Cálculo de Taxas de Estacionamento ===\n");

        while (true) {
            System.out.print(
                "Digite o número de horas estacionadas para o cliente (ou -1 para sair): "
            );

            double hours = scanner.nextDouble();

            if (hours == -1) {
                break;
            }

            customerCount++;
            double charge = calculateCharges(hours);
            totalRevenue += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n%n",
                              customerCount, charge);
        }

        System.out.println("==========================================");
        System.out.printf("Total arrecadado ontem: $%.2f%n", totalRevenue);

        scanner.close();
    }
}