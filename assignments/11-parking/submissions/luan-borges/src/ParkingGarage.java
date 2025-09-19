import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double totalReceipts = 0.0;
        int customerCount = 1;

        System.out.println("--- Sistema de Cálculo de Taxas de Estacionamento ---");

        while (true) {
            System.out.printf("Digite o número de horas estacionadas para o cliente %d (ou -1 para sair): ", customerCount);
            double hoursParked = input.nextDouble();

            if (hoursParked == -1) {
                break;
            }

            if (hoursParked > 0 && hoursParked <= 24) {
                double currentCharge = calculateCharges(hoursParked);
                totalReceipts += currentCharge;
                System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n%n", customerCount, currentCharge);
                customerCount++;
            } else {
                System.out.println("Entrada inválida. Por favor, insira um valor de horas entre 0 e 24.");
            }
        }

        System.out.printf("%nTotal arrecadado ontem: $%.2f%n", totalReceipts);
        input.close();
    }

    public static double calculateCharges(double hours) {
        double charge = 2.00;

        if (hours > 3.0) {
            double extraHours = Math.ceil(hours) - 3.0;
            charge += extraHours * 0.50;
        }

        charge = Math.min(charge, 10.00);
        
        return charge;
    }
}