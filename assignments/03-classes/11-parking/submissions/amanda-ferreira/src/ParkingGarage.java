import java.util.Scanner;

public class ParkingGarage{
    public static double calculateCharges(double hours){
        if(hours <= 3) {
            return 2.00;
        }

        double extra = Math.ceil(hours - 3);
        double charge = 2.00 + extra * 0.50;

        return Math.min(charge, 10.00);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            double custo = calculateCharges(horas);
            total += custo;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, custo);
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);
        scanner.close();
    }
}