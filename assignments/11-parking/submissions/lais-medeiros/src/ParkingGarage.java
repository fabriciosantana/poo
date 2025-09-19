import java.util.Scanner;

public class ParkingGarage {

    public static double calculateCharges(double hours) {
        double taxaMinima = 2.0;
        double taxaMaxima = 10.0;
        double taxaPorHoraExtra = 0.5;
        
        if (hours <= 3) {
            return taxaMinima;
        } else {
            double taxa = taxaMinima + Math.ceil(hours - 3) * taxaPorHoraExtra;
            return Math.min(taxa, taxaMaxima); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalReceita = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            if (horas <= 0 || horas > 24) {
                System.out.println("Entrada inválida! o máximo é 24 horas.");
                continue;
            }

            double taxa = calculateCharges(horas);
            totalReceita += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalReceita);

        scanner.close();
    }
}


