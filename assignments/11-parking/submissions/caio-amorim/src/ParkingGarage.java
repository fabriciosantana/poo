import java.util.Scanner;

public class ParkingGarage {

    // Calcula a cobrança (cada hora ou fração acima de 3 horas => $0.50 por hora)
    public static double calculateCharges(double hours) {
        if (hours <= 3.0) {
            return 2.0;
        }
        // cobrar por hora ou fração -> usar Math.ceil para contar frações como hora inteira
        double extraHours = Math.ceil(hours - 3.0);
        double charge = 2.0 + extraHours * 0.50;
        if (charge > 10.0) {
            charge = 10.0;
        }
        return charge;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0.0;
        int cliente = 1;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida. Digite um número ou -1.");
                scanner.nextLine();
                continue;
            }
            double horas = scanner.nextDouble();

            if (horas == -1) {
                break;
            }

            if (horas <= 0 || horas > 24) {
                System.out.println("Erro: As horas devem estar entre 0 e 24.");
                continue;
            }

            double taxa = calculateCharges(horas);
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);

            total += taxa;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: $%.2f%n", total);

        scanner.close();
    }
}
