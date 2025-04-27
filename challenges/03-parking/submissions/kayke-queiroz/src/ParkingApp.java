import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        
        // Adicionando veículos de cada tipo
        vehicles.add(new Car("ATF-1903", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XAB-9308", "Honda", "CG 160"));
        vehicles.add(new Truck("KMK-9320", "Volvo", "FH 540"));
        
        int parkingHours = 5;
        
        System.out.println("Tarifas calculadas para 5 horas:\n");
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("Veículo: " + vehicle);
            System.out.printf("Valor a pagar por %dh: R$ %.2f%n%n", 
                            parkingHours, vehicle.calculateParkingFee(parkingHours));
        }
    }
}