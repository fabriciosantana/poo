import java.util.Scanner;

public class ParkingGarage {


    public static double calculateCharges(double hours) {
        if (hours <= 3.0) {
            return 2.00;
        }

        double preco = 2.00 + (Math.ceil(hours - 3.0) * 0.50);


        return Math.min(preco, 10.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        int num_cliente = 1;

        System.out.println("=== Sistema de Cobrança - Garagem de Estacionamento ===\n");

        while (true) {
            System.out.printf("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1) break;

            double preco = calculateCharges(hours);

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", num_cliente, preco);
            total += preco;
            num_cliente++;
        }

        System.out.printf("%nTotal arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}