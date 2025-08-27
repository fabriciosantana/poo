import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double charge = 2.00;
        if (hours > 3) {
            charge += (Math.ceil(hours) - 3) * 0.50;
        }
        if (charge > 10.00) {
            charge = 10.00;
        }
        return charge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double hoursParked = 0;
        double totalCharges = 0;
        int clientCount = 0;

        System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
        hoursParked = scanner.nextDouble();

        while (hoursParked != -1) {
            clientCount++;
            double currentCharge = calculateCharges(hoursParked);
            totalCharges += currentCharge;
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f\n", clientCount, currentCharge);

            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hoursParked = scanner.nextDouble();
        }

        System.out.printf("Total arrecadado ontem: $%.2f\n", totalCharges);
        scanner.close();
    }
}


