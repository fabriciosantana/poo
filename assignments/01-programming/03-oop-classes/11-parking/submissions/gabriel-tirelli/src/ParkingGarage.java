import java.text.DecimalFormat;
import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        double hours, total = 0;

        do { 
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hours = scanner.nextDouble();
            if (hours != -1){
                double price = calculateCharges(hours);
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.println("Cliente "+i+": Taxa de estacionamento: $"+df.format(price));
                total = total + price;
                i++;
            }
        } while (hours!=-1);

        System.out.print("Total arrecadado ontem: $" + total);

        scanner.close();
    }

    public static double calculateCharges(double hours){
        double price;
        if (hours<=3){
            price = 2.0;
        } else if (hours < 24 && hours > 3) {
            price = 2.0 + (hours-3)*0.5;
        } else {
            price = 10.0;
        }
        return price;
    }

}