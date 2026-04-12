import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        if (hours <= 3.0) {
            return 2.00;
        }

        double horasAdicionais = hours - 3.0;
        double taxaAdicional = Math.ceil(horasAdicionais) * 0.50;
        double taxa = 2.00 + taxaAdicional;

        if (taxa > 10.00) {
            return 10.00;
        }

        return taxa;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int numeroCliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = input.nextDouble();

            if (horas == -1) {
                break;
            }

            double taxa = calculateCharges(horas);

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", numeroCliente, taxa);
            totalArrecadado += taxa;
            numeroCliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalArrecadado);
        input.close();
    }
}