import java.util.Scanner;

public class ParkingGarage {

    private int cliente;
    private double horas;

    public static double calculateCharges(double hours) {
        if (hours <= 0) {return 2.0;}

        if (hours >= 24) {return 10.0;}

        if (hours <= 3.0) {return 2.0;}

        double roundedHours = Math.ceil(hours);
        double charge = 2.0 + ((roundedHours - 3.0) * 0.5);

        if (charge > 10.0) {return 10.0;}
        return charge;
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
            double charge = calculateCharges(horas);
            total += charge;
            System.out.println("Cliente " + cliente + ": Taxa de estacionamento: $" + String.format("%.2f", charge));
            cliente++;
        }
        System.out.println("Total arrecadado ontem: $" + String.format("%.2f", total));

    }
}
