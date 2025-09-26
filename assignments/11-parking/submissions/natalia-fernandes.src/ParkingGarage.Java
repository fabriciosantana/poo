import java.util.Scanner;

public class ParkingGarage {

    // metodo para calcular a taxa de estacionamento
    public static double calculateCharges(double hours) {
        double charge = 2.0; // taxa minima para ate 3 horas

        if (hours > 3) {
            // adiciona 0.50 por hora extra acima de 3
            charge += (Math.ceil(hours - 3)) * 0.50;
        }

        // limite maximo de 10
        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0.0; // acumula total arrecadado
        int cliente = 1;    // contador de clientes

        while (true) {
            System.out.print("Digite o numero de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = input.nextDouble();

            // condicao de parada
            if (horas == -1) {
                break;
            }

            // calcula taxa para o cliente atual
            double taxa = calculateCharges(horas);

            // mostra resultado para o cliente
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", cliente, taxa);

            // soma no total arrecadado
            total += taxa;

            // avanca para proximo cliente
            cliente++;
        }

        // mostra total final
        System.out.printf("Total arrecadado ontem: $%.2f%n", total);

        input.close();
    }
}
