import java.util.Locale;
import java.util.Scanner;

public class ParkingGarage {

    private static final double MINIMUM_CHARGE = 2.00;
    private static final double HOURLY_CHARGE = 0.50;
    private static final double MAXIMUM_CHARGE = 10.00;
    private static final double HOURS_IN_MINIMUM_CHARGE = 3.0;
    private static final double MAXIMUM_HOURS = 24.0;

    public static double calculateCharges(double hours) {
        double charge = MINIMUM_CHARGE;
        if (hours > HOURS_IN_MINIMUM_CHARGE) {
            // fracao de hora adicional e cobrada como hora cheia
            charge += Math.ceil(hours - HOURS_IN_MINIMUM_CHARGE) * HOURLY_CHARGE;
        }
        if (charge > MAXIMUM_CHARGE) {
            charge = MAXIMUM_CHARGE;
        }
        return charge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        double totalCharges = 0.0;
        int customer = 1;
        boolean finished = false;

        while (!finished) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            if (!scanner.hasNext()) {
                System.out.println();
                finished = true;
            } else if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido. Digite um número de horas.");
                scanner.next();
            } else {
                double hours = scanner.nextDouble();
                if (hours == -1) {
                    finished = true;
                } else if (hours >= 0 && hours <= MAXIMUM_HOURS) {
                    double charge = calculateCharges(hours);
                    totalCharges += charge;
                    System.out.printf(Locale.US, "Cliente %d: Taxa de estacionamento: $%.2f%n", customer, charge);
                    customer++;
                } else {
                    System.out.println("Valor inválido. Informe de 0 a 24 horas.");
                }
            }
        }

        System.out.printf(Locale.US, "Total arrecadado ontem: $%.2f%n", totalCharges);
        scanner.close();
    }
}
