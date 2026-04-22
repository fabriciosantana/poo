import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        if (hours <= 0) {
            return 2.0;
        }

        if (hours >= 24) {
            return 10.0;
        }

        if (hours <= 3.0) {
            return 2.0;
        }

        double roundedHours = Math.ceil(hours);
        double charge = 2.0 + ((roundedHours - 3.0) * 0.5);

        if (charge > 10.0) {
            return 10.0;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalCollected = 0.0;
        int clientCount = 0;

        while (true) {
            System.out.print("Enter parked hours for client (or -1 to stop): ");

            if (!scanner.hasNextDouble()) {
                scanner.next();
                continue;
            }

            double hours = scanner.nextDouble();
            if (hours == -1.0) {
                break;
            }

            clientCount++;
            double charge = calculateCharges(hours);
            totalCollected += charge;

            System.out.printf("Client %d: Parking charge: $%.2f%n", clientCount, charge);
        }

        System.out.printf("Total collected: $%.2f%n", totalCollected);
        scanner.close();
    }
}
