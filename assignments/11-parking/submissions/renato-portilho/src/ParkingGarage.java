import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalAcumulado = 0;
        boolean para = true;
        int numCliente = 1;
        while (para == true) {

            System.out.println("Digite o número de horas estacionadas: ");
            double hours = scanner.nextDouble();

            if (hours == -1) {
                para = false;
            } else if (hours > 0) {

                double pagamento = calculateCharges(hours);
                totalAcumulado += pagamento;

                System.out.println("Cliente " + numCliente + ": Taxa de estacionamento: " + pagamento);
                numCliente++;
                pagamento = 0;

            }

        }
        System.out.println("Total acumulado ontem: $" + totalAcumulado + "0");
    }

    public static double calculateCharges(double hours) {

        if (hours == -1) {
            return 0;
        } else if (hours <= 3) {
            return 2.0;
        } else if (hours > 3 && hours < 24) {
            return 2.0 + (hours - 3) * 0.5;
        } else if (hours <= 24) {
            return 10.0;
        } else {
            return -1.0;
        }

    }

}