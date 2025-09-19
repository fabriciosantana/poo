import java.util.Scanner;

public class ParkingGarage {

    // Método que calcula a taxa com base nas horas estacionadas
    public static double calculateCharges(double hours) {
        double charge = 2.0; // taxa mínima para até 3 horas

        if (hours > 3.0) {
            charge += (Math.ceil(hours) - 3) * 0.5; // cobra por hora ou fração acima de 3
        }

        if (charge > 10.0) {
            charge = 10.0; // máximo por 24h
        }

        return charge;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = sc.nextDouble();

            if (hours == -1) {
                break;
            }

            if (hours <= 0 || hours > 24) {
                System.out.println("Erro: as horas devem estar entre 0 e 24.");
                continue;
            }

            double charge = calculateCharges(hours);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, charge);

            total += charge;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);

        sc.close();
    }
}
