import java.util.Scanner;

public class ParkingGarage {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double totalArrecadado = 0.0;
            int clienteNumero = 1;
            
            while (true) {
                System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
                double horas = scanner.nextDouble();
                
                if (horas == -1) {
                    break;
                }
                
                if (horas < 0 || horas > 24) {
                    System.out.println("Horas inválidas. Digite um valor entre 0 e 24.");
                    continue;
                }
                
                double taxa = calculateCharges(horas);
                totalArrecadado += taxa;
                
                System.out.printf("Cliente %d: Taxa de estacionamento: R$%.2f%n", clienteNumero, taxa);
                clienteNumero++;
            }
            
            System.out.printf("Total arrecadado ontem: R$%.2f%n", totalArrecadado);
        }
    }

    public static double calculateCharges(double hours) {
        double taxaMinima = 2.00;
        double taxaMaxima = 10.00;
        double taxaPorHoraExtra = 0.50;
        double horasLimite = 3.0;
        
        if (hours <= horasLimite) {
            return taxaMinima;
        }
        
        
        double horasExtras = Math.ceil(hours - horasLimite);
        double taxa = taxaMinima + (horasExtras * taxaPorHoraExtra);
        
        
        return Math.min(taxa, taxaMaxima);
    }
}