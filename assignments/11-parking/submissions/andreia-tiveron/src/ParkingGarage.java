import java.util.Scanner;

public class ParkingGarage{

    public static double calculateCharges(double hours){
        double minTaxa = 2.00;
        double maxTaxa = 10.00;
        double pHora = 0.50;

        if(hours <= 3){
            return minTaxa;
        }else if (hours > 3 && hours < 24) {
            double horaExtra = Math.ceil(hours - 3);
            double taxaTotal = minTaxa + (horaExtra * pHora);
            return Math.min(taxaTotal, maxTaxa);
        }else{
            return maxTaxa;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ganhoTotal = 0.0;
        int contClientes = 0;

        while (true){
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            double hours = scanner.nextDouble();

            if (hours == -1){
                break;
            }

            contClientes++;
            double taxa = calculateCharges(hours);
            ganhoTotal += taxa;

            System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n", contClientes, taxa);     
        }
    
    System.out.printf("Total arrecadado ontem: R$%.2f%n", ganhoTotal);
    scanner.close();
    }
}
