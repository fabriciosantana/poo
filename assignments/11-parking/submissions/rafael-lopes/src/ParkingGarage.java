import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.00;

        if (hours > 24) {
            hours = 24;
        }

        if (hours > 3) {
            charge += Math.ceil(hours - 3) * 0.50;
        }

        if (charge > 10.00) {
            charge = 10.00;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cliente = 1;
        double total = 0.0;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            if (horas < 0 || horas > 24) {
                System.out.println("Por favor, insira um valor entre 0 e 24.");
                continue;
            }

            double taxa = calculateCharges(horas);
            total += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}
