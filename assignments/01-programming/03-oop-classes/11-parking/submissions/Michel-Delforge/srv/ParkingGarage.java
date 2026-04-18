import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        if (hours <= 0) return 2.00;
        if (hours >= 24) return 10.00;

        double charge = 2.00;

        if (hours > 3) {
            double extraHours = Math.ceil(hours - 3);
            charge += extraHours * 0.50;
        }

        return Math.min(charge, 10.00);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double hours;
        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hours = input.nextDouble();

            if (hours == -1) break;

            double charge = calculateCharges(hours);
            total += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, charge);
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        input.close();
    }
}//final