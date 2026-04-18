import java.util.Scanner;

public class ParkingGarage {
    /**
     * Calculates parking charges based on hours parked.
     * @param hours Number of hours parked (can be fractional).
     * @return Charge amount in dollars.
     */
    public static double calculateCharges(double hours) {
        if (hours <= 0) {
            return 0.0;
        }
        double charge = 2.0; // minimum charge for up to 3 hours
        if (hours > 3) {
            double extraHours = Math.ceil(hours - 3); // charge for each additional hour or fraction
            charge += extraHours * 0.5;
        }
        // maximum charge for a 24‑hour period
        if (charge > 10.0) {
            charge = 10.0;
        }
        return charge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int clientNumber = 1;
        double totalCollected = 0.0;
        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();
            if (hours == -1) {
                break;
            }
            double charge = calculateCharges(hours);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", clientNumber, charge);
            totalCollected += charge;
            clientNumber++;
        }
        System.out.printf("Total arrecadado ontem: $%.2f%n", totalCollected);
        scanner.close();
    }
}
