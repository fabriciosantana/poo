import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.0;

        if (hours > 3.0) {
            double extraHours = Math.ceil(hours - 3.0);
            charge += extraHours * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double hours;
        double totalReceipts = 0.0;
        int customer = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hours = input.nextDouble();

            if (hours == -1) {
                break;
            }

            double charge = calculateCharges(hours);
            totalReceipts += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", customer, charge);
            customer++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalReceipts);

        input.close();
    }
}