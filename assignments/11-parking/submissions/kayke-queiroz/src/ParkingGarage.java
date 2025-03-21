import java.util.Scanner;

public class ParkingGarage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hours;
        double total = 0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hours = sc.nextDouble();

            if (hours == -1) {
                System.out.println("\nPrograma encerrado.");
                System.out.printf("Total arrecadado ontem: R$%.2f\n", total);
                break;
            }

            double charge = calculateCharges(hours);
            total += charge;

            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f\n", cliente, charge);
            cliente++;
        }

        sc.close();
    }

    public static double calculateCharges(double hours) {
        if (hours <= 3) {
            return 2.00;
        }
        return Math.min(Math.ceil(hours - 3) * 0.5 + 2, 10.00);
    }
}
