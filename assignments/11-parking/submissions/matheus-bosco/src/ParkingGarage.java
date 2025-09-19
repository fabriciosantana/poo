import java.util.Scanner;

public class ParkingGarage {



    // Método que calcula a taxa com base nas horas

    public static double calculateCharges(double hours) {
        double charge = 2.0; // valor mínimo para até 3 horas

        if (hours > 3) {
            charge += (Math.ceil(hours - 3)) * 0.5; //      cada hora ou fração acima de 3
        }

        // taxa máxima   é R$10,00
        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
    }




    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double totalReceita = 0.0; // acumulador do total arrecadado
        int cliente = 1;           // contador de clientes

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double horas = input.nextDouble();

            if (horas == -1) {
                break; // encerra o loop quando usuário digita -1
            }

            double taxa = calculateCharges(horas);
            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n", cliente, taxa);

            totalReceita += taxa;
            cliente++;
        }

        System.out.printf("Total arrecadado ontem: R$%.2f%n", totalReceita);

        input.close();
    }
}
