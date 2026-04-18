import java.util.Scanner;

public class ParkingGarage {

    private int cliente;
    private double horas;


    public static double calculateCharges(double hours){
        double taxa;
        if(hours <= 3){
            taxa = 2.00;
        }else{
            double extra = Math.ceil(hours - 3);
            taxa = 2 + (0.5*extra);
        }

        if (taxa > 10.00) {
            taxa = 10.00;
        }

        return taxa;

    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int cliente = 1;
        double total = 0;
        double horas;

        while (true) {
            System.out.print("Digite o número de horas estacionadas (ou -1 para sair): ");
            horas = ler.nextDouble();

            if (horas == -1) {
                break;
            }

            double taxa = calculateCharges(horas);

            System.out.println("Cliente " + cliente + ": Taxa = $" + taxa);

            total += taxa;
            cliente++;
        }

        System.out.println("Total arrecadado: $" + total);

        ler.close();
    }
}


