import java.util.Locale;
import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours){
        double taxa = 2.00;

        if(hours > 3){
            taxa += 0.5 * (Math.ceil(hours) - 3);  
        }
        if(taxa > 10.00){
            taxa = 10.00;
        }

        return taxa;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        double hours = 0;
        int customer = 1;
        double total = 0;

        while(true){
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hours = sc.nextDouble();

            if(hours == -1){
                break;
            }
            
            double charge = calculateCharges(hours);
            total += charge;

            System.out.printf("Cliente %d : Taxa de estacionamento: %.2f\n", customer, charge);
            customer++;
        }

        System.out.printf("Total arrecadado ontem: %.2f", total);
        sc.close();
        
    }
    
}
