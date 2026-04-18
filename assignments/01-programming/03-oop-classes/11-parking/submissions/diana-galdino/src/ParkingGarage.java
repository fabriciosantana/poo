import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge;

        if (hours <= 0) {
            return 2.0;
        }

        if (hours > 24.0) {
            hours = 24.0;
        }

        if (hours <= 3.0) {
            charge = 2.0;
        } else {
            charge = 2.0 + Math.ceil(hours - 3.0) * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double hours;
        double total = 0.0;
        int client = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas (ou -1 para sair): ");
            hours = input.nextDouble();

            if (hours == -1) {
                break;
            }

            double charge = calculateCharges(hours);

            System.out.printf("Cliente %d: Taxa: R$%.2f\n", client, charge);

            total += charge;
            client++;
        }

        System.out.printf("\nTotal arrecadado: R$%.2f\n", total);

        input.close();
    }
}