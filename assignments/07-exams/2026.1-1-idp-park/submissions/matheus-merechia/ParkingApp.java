import java.util.ArrayList;
import java.util.Scanner;



public class ParkingApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Digite o número de veículos a serem cadastrados: ");
        int numVehicles = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numVehicles; i++) {
            System.out.println("\nVeículo #" + (i + 1));
            System.out.print("Tipo (carro/moto/caminhão): ");           
            String tipo = scanner.nextLine();            
            System.out.print("Placa: ");            
            String placa = scanner.nextLine();            
            System.out.print("Marca: ");            
            String marca = scanner.nextLine();            
            System.out.print("Modelo: ");            
            String modelo = scanner.nextLine();            
            Vehicle vehicle;            
        
            if (tipo.equalsIgnoreCase("carro")) {                
                vehicle = new Car(placa, marca, modelo);            
            } else if (tipo.equalsIgnoreCase("moto")) {               
                vehicle = new Motorcycle(placa, marca, modelo);            

            } else if (tipo.equalsIgnoreCase("caminhão")) {                
                vehicle = new Truck(placa, marca, modelo);           
            } else {                
                System.out.println("Tipo inválido! Usando carro como padrão.");                
                return;            
            }            
            vehicles.add(vehicle);       
        }        
        System.out.print("\nDigite a quantidade de horas: ");        
        int horas = scanner.nextInt();        
        System.out.println("\n--- RESULTADO ---");        
        for (Vehicle vehicle : vehicles) {            
            System.out.println(vehicle);            
            System.out.println("Valor a pagar por " + horas + " horas: R$ " + vehicle.calculateParkingFee(horas));            
            System.out.println();        
        }        
        scanner.close();    
    }
}



