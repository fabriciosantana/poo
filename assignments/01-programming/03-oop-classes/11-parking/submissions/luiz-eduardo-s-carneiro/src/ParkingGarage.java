import java.util.Scanner;

public class ParkingGarage{

    public static double calculateCharges(double hours){
        double taxa = 2;
        if(hours > 3){
            double extraTime = hours - 3; 
            taxa = taxa + extraTime * 0.5;
        } 
        if(taxa > 10){
            taxa = 10;
        }
        return taxa;
    }
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);
        double hours = 0;
        double totalArrecadado = 0;
        int i = 0;
        while(true){
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            hours = scanner.nextDouble();
            if(hours == -1){
                break;
            }
            double taxa = calculateCharges(hours);
            System.out.printf("Cliente %d: Taxa de estacionamento: %.2f\n", ++i, taxa);
            totalArrecadado += taxa;
        }
        System.out.printf("Total arrecadado ontem: %.2f\n", totalArrecadado);
    }
}