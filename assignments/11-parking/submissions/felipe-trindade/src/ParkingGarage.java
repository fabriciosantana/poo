import java.util.Scanner;
import java.util.Locale;

public class ParkingGarage{
    public static double calculateCharges(double horas){
        double valor = 2.0;

        if (horas > 3){
            valor += 0.5 * (Math.ceil(horas) - 3);
        }
        if(valor > 10.0){
            valor = 10.0;
        }
        return valor;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        double total = 0;
        int cliente = 1;
        double horas;

        System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
        horas = sc.nextDouble();

        while(horas != -1){
            double taxa = calculateCharges(horas);
            total += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: %.2f\n", cliente, taxa);
            cliente++;

            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            horas = sc.nextDouble();
        }
        System.out.printf("Total arrecadado ontem: $%.2f\n", total);

        sc.close();
    }
}
