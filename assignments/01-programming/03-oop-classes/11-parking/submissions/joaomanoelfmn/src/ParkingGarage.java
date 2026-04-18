import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double totalReceipts = 0.0;
        int customerCount = 0;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = input.nextDouble();

            if (hours == -1) {
                break;
            }

            customerCount++;
            double charge = calculateCharges(hours);
            totalReceipts += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n%n", customerCount, charge);
        }

        System.out.printf("%nTotal arrecadado ontem: $%.2f%n", totalReceipts);
        
        input.close();
    }

    public static double calculateCharges(double hours) {
        double minFee = 2.00;
        double maxFee = 10.00;
        double extraHourlyRate = 0.50;
        double baseHours = 3.0;

        if (hours <= baseHours) {
            return minFee;
        }

        double extraHours = Math.ceil(hours - baseHours);
        double totalCharge = minFee + (extraHours * extraHourlyRate);

        return (totalCharge > maxFee) ? maxFee : totalCharge;
    }
}