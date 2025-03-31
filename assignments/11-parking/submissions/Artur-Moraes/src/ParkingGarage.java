import java.util.Scanner;

public class ParkingGarage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        double total = 0;
        int cliente = 1;
        double preco;

        while (true) { 
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1) break; // Sai do loop se o usuário digitar -1
            if (hours <= 0 || hours > 24) {
                System.out.println("Erro: O número de horas deve estar entre 0.1 e 24.");
                continue;
            }
            preco = calculateCharges(hours);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f\n", cliente, preco);
            total += preco;
            cliente++;
        } 

        System.out.printf("Total arrecadado ontem: $%.2f\n", total);
        scanner.close();
    }

    public static double calculateCharges(double hours) {
        if (hours <= 3) {
            return 2.00;
        }
        if (hours <= 19) {
            double taxaExtra = Math.ceil(hours - 3) * 0.5;
            return taxaExtra + 2.00;
        }
        return 10.00;
    }
}
