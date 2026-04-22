import java.util.ArrayList;
import java.util.Locale;

public class ParkingApp {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        int hours = 4;

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            double fee = vehicle.calculateParkingFee(hours);
            System.out.println("Valor a pagar por 4h: R$ " + String.format(Locale.US, "%.2f", fee));
            System.out.println();
        }
    }
}

