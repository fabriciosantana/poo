import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        if (hours <= 3) {
            return 2.00;
        }

        double extraHours = Math.ceil(hours - 3);
        double charge = 2.00 + extraHours * 0.50;

        return Math.min(charge, 10.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        int customer = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1) {
                break;
            }

            double charge = calculateCharges(hours);
            total += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", customer, charge);
            customer++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}