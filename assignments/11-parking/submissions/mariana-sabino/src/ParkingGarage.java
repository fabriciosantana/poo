import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.0;

        if (hours > 3) {
            charge += (Math.ceil(hours - 3)) * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        double totalReceita = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = leitor.nextDouble();

            if (horas == -1) {
                break;
            }

            double taxa = calculateCharges(horas);
            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n", cliente, taxa);

            totalReceita += taxa;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: R$%.2f%n", totalReceita);

        leitor.close();
    }
}
