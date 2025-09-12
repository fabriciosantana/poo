import java.util.Scanner;

public class ParkingGarage {

    // Método que calcula a taxa de estacionamento
    public static double calculateCharges(double hours) {
        double charge = 2.0; // valor mínimo até 3 horas

        if (hours > 3) {
            // arredondar para cima o número de horas adicionais
            int extraHours = (int) Math.ceil(hours - 3);
            charge = 2.0 + extraHours * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0; // máximo por 24h
        }

        return charge;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0;
        int client = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = input.nextDouble();

            if (hours == -1) {
                break; // encerra programa
            }

            if (hours < 0 || hours > 24) {
                System.out.println("Número de horas inválido! Digite entre 0 e 24.");
                continue;
            }

            double charge = calculateCharges(hours);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", client, charge);

            total += charge;
            client++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);

        input.close();
    }
}
