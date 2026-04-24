import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            if (horas < 0 || horas > 24) {
                System.out.println("Valor inválido! Digite um número entre 0 e 24.");
                continue;
            }

            double taxa = calculateCharges(horas);

            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f\n", cliente, taxa);

            total += taxa;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: R$%.2f\n", total);

        scanner.close();
    }

    public static double calculateCharges(double hours) {

        double charge = 2.0;

        if (hours > 3) {
            double extraHours = Math.ceil(hours - 3);
            charge += extraHours * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
    }
}
