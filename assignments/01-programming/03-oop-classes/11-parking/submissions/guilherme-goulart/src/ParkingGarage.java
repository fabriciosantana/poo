import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        double hoursCeiled = Math.ceil(hours); 
        double charge = 0.0;
        if (hoursCeiled <= 3) {
            charge = 2.0;
        } else if (hoursCeiled > 3 && hoursCeiled <= 24) {
            charge = 2.0 + (hoursCeiled - 3) * 0.5;
        } else {
            charge = 10.0;
        }
        return Math.min(charge, 10.0); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int clienteCount = 0;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hoursParked = scanner.nextDouble();

            if (hoursParked == -1) {
                break;
            }

            double currentCharge = calculateCharges(hoursParked);
            System.out.println("Cliente " + (++clienteCount) + ": Taxa de estacionamento: $" + currentCharge);
            totalArrecadado += currentCharge;
        }
        System.out.println("Total arrecadado ontem: $" + totalArrecadado);
    }
}
