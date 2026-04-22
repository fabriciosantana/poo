import java.util.ArrayList;
import java.util.Locale;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        int parkingHours = 4;
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            System.out.printf(Locale.US, "Valor a pagar por %dh: R$ %.2f%n%n", parkingHours, vehicle.calculateParkingFee(parkingHours));
        }
    }
}
