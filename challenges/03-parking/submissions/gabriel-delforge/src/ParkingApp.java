
import java.util.ArrayList;
import java.util.List;

public class ParkingApp {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        int hours = 4;
        for (Vehicle v : vehicles) {
            System.out.println(v);
            System.out.printf("Valor a pagar por %dh: R$ %.2f%n%n", hours, v.calculateParkingFee(hours));
        }
    }
}
