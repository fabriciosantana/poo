import java.util.Scanner;

public class ParkingGarage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cliente = 1;
        double total_arrecadado = 0;
        double hours;
        do {
            System.out.printf("Digite o número de horas estacionadas para o cliente %d (ou -1 para sair): ", cliente);
            hours = scanner.nextDouble();

            if(hours >= 0 && hours <= 24) {
                double valor = calculateCharges(hours);
                System.out.printf("Cliente %d: Taxa de estacionamento: R$ %.2f\n\n", cliente, valor);
                total_arrecadado += valor;
                cliente++;
                hours = -404; // Esse valor significa que as horas precisam ser re-definidas
            }
            else if(hours != -1) System.out.println("Horas inseridas impossíveis ou fora do limite de 24 horas.");
        
        } while (hours != -1 && hours < 0 || hours > 24);
        
        System.out.printf("\n\ntotal_arrecadado arrecadado ontem: R$ %.2f\n", total_arrecadado);
        scanner.close();
    }

    public static double calculateCharges (double hours) {
        double preco;

        if(hours <= 3) preco = 2.0;
        else preco = 2.0 + Math.ceil(hours - 3) * 0.5; 
        
        if(preco > 10.0) preco = 10.0;

        return preco;
    }
}