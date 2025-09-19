package Lucas_Pontual.src.parking;

import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalArrecadado = 0.0;
        int clienteCount = 0;
        double horasEstacionadas;

        do {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            horasEstacionadas = scanner.nextDouble();

            if (horasEstacionadas == -1) {
                break;
            }

            if (horasEstacionadas < 0) {
                System.out.println("Horas inválidas. Por favor, digite um valor positivo ou -1 para sair.");
                continue;
            }

            clienteCount++;
            double taxa = calculateCharges(horasEstacionadas);
            totalArrecadado += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", clienteCount, taxa);

        } while (true);

        System.out.printf("Total arrecadado ontem: $%.2f%n", totalArrecadado);

        scanner.close();
    }

    public static double calculateCharges(double hours) {
        double taxa = 2.00; // Taxa mínima para até 3 horas

        if (hours > 3) {
            double horasExtras = hours - 3;
            taxa += Math.ceil(horasExtras) * 0.50;
        }

        if (taxa > 10.00) {
            taxa = 10.00; // Taxa máxima para 24 horas
        }
        return taxa;
    }
}


