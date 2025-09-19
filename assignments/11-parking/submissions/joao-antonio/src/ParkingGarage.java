import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        double charge = 0.0;

        if (hours <= 3) {
            charge = 2.00; 
        } else {
            charge = 2.00 + (Math.ceil(hours - 3) * 0.50);
        }

        if (charge > 10.00) {
            charge = 10.00;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalRevenue = 0.0;
        int clientNumber = 1;
        double hoursParked;

        System.out.println("Bem-vindo ao sistema de cálculo de estacionamento!");

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente " + clientNumber + " (ou -1 para sair): ");
            hoursParked = input.nextDouble();

            if (hoursParked == -1) {
                break; 
            }

            if (hoursParked < 0) {
                System.out.println("Por favor, digite um número de horas válido.");
                continue;
            }

            double currentCharge = calculateCharges(hoursParked);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", clientNumber, currentCharge);
            totalRevenue += currentCharge;
            clientNumber++;
        }

        System.out.printf("%nTotal arrecadado ontem: $%.2f%n", totalRevenue);
        input.close();
    }
}