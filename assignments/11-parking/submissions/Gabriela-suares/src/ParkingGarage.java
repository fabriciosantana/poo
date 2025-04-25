import java.util.Scanner;

public class ParkingGarage {

public static double calculateCharges(double hours) {
        if (hours <= 3) {
        return 2.00;
        } else {
         double charge = 2.00 + (Math.ceil(hours - 3) * 0.50);
        return Math.min(charge, 10.00);
}
}

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        int client = 1;

while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();
            if (hours == -1) break;

double charge = calculateCharges(hours);
            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n", client, charge);
            total += charge;
            client++;
        }

System.out.printf("Total arrecadado ontem: R$%.2f%n", total);
scanner.close();
}
}
