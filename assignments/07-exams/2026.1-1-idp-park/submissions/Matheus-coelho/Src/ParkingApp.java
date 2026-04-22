import java.util.ArrayList;
import java.util.Locale;

public class ParkingApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        
        // Adicionar veículos
        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));
        
        // Calcular e exibir tarifa para 4 horas
        int hours = 4;
        for (Vehicle vehicle : vehicles) {
            double fee = vehicle.calculateParkingFee(hours);
            System.out.println(vehicle);
            System.out.printf("Valor a pagar por %dh: R$ %.2f%n", hours, fee);
            System.out.println();
        }
    }
}
