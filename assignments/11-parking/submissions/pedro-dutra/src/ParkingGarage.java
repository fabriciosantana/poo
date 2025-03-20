import java.util.Scanner;

public class ParkingGarage {
    // Método para calcular a taxa de estacionamento
    public static double calculateCharges(double hours) {
        if (hours <= 3) {
            return 2.00;
        } else if (hours < 24) {
            double charge = 2.00 + (Math.ceil(hours - 3) * 0.50);
            return Math.min(charge, 10.00);
        } else {
            return 10.00;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();
            
            if (horas == -1) {
                break;
            }
            
            double taxa = calculateCharges(horas);
            totalArrecadado += taxa;
            
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);
            cliente++;
        }
        
        System.out.printf("Total arrecadado ontem: $%.2f%n", totalArrecadado);
        scanner.close();
    }
}
