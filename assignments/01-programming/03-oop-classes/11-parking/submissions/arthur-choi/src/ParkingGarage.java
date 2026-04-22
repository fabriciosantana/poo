import java.util.Scanner;

public class ParkingGarage {

    private int cliente;
    private double horas;

    public static double calculateCharges(int hours) {
        double rate = 0.5; // $0.50 por hora
        if(hours <= 3) {
            return 2; // $2 para as primeiras 3 horas
        } else{
            return Math.min(2 + (hours - 3) * 0.5, 10); // $2 para as primeiras 3 horas e $0.50 para cada hora adicional. O valor máximo é $10
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cliente = 1;
        double total = 0;
        double horas;

        while(true){
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            horas = scanner.nextDouble();
            if(horas == -1) {
                break;
            }
            double charge = calculateCharges((int) horas);
            total += charge;
            System.out.println("Cliente " + cliente + ": Taxa de estacionamento: $" + String.format("%.2f", charge));
            cliente++;
        }
        System.out.println("Total arrecadado ontem: $" + String.format("%.2f", total));

    }
}
