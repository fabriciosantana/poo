import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.00; 

        if (hours > 3) {
            double extraHours = Math.ceil(hours - 3); 
            charge += extraHours * 0.50;
        }

        return Math.min(charge, 10.00); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int clienteNum = 1;

        System.out.println("=== Sistema de Taxas de Estacionamento ===\n");

        while (true) {
            System.out.printf("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) break;

            double taxa = calculateCharges(horas);
            totalArrecadado += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n%n", clienteNum, taxa);
            clienteNum++;
        }

        System.out.printf("%nTotal arrecadado ontem: R$%.2f%n", totalArrecadado);
        scanner.close();
    }
}