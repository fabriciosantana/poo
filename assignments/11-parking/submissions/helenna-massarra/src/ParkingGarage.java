import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
        double charge = 2.00;
        if (hours > 3) {
            charge += Math.ceil(hours - 3) * 0.50;
        }
        return Math.min(charge, 10.00);
    }

    public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalReceipts = 0.0;
        int customerNumber = 1;

            while (true) { 
                System.out.println("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
                    double hours = scanner.nextDouble();

                    if (hours == -1) {
                        break;
                    }
                    double charge = calculateCharges(hours);
                    totalReceipts += charge;

                    System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n", customerNumber++, charge);

            
        } 
            System.out.printf("Total arrecadado ontem: R$%.2f%n", totalReceipts);
            scanner.close();
      }
    }

