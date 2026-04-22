import java.util.Scanner;

public class ParkingGarage {
    public static double calculateCharges(double hours) {
    double fee = 2.0;
    
    if (hours > 3.0) {
        fee = 2.0 + (int)(hours - 3) * 0.5;
    }
    if (fee > 10.0) {
        fee = 10.0;
    }
    
    return fee;
}
    private static class Cliente{
        private int id;
        private double charge;

        public Cliente(int id, double hours){
            this.id = id;
            this.charge = calculateCharges(hours);
        }
        public void display(){
            System.out.printf("Cliente %d: Taxa de estacionamento: $%.2f%n", id, charge);
        }

        public double getCharge() {return charge;}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalCollected = 0.0;
        int clientCount = 0;

        while (true) {
            System.out.print("Digite o número de horas estacionadas para o cliente (ou -1 para sair): ");
            if(!scanner.hasNextDouble()){
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
                continue;
            }
            double input = scanner.nextDouble();

            if (input == -1) {
                break;
            }

            clientCount++;
            Cliente c = new Cliente(clientCount, input);
            c.display();
            
            totalCollected += c.getCharge();
        }
            System.out.printf("Total arrecadado ontem: $%.2f%n", totalCollected);

            scanner.close();
    }
}
