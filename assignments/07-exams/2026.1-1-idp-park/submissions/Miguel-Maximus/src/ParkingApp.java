import java.util.ArrayList;
import java.util.List;

public class ParkingApp {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("BRA-2025", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("MTO-9876", "Yamaha", "Fazer 250"));
        vehicles.add(new Truck("TRK-4400", "Volvo", "FH 540"));

        int hours = 4;

        for (Vehicle vehicle : vehicles) {
            double fee = vehicle.calculateParkingFee(hours);
            System.out.println(vehicle);
            System.out.printf("Valor a pagar por %dh: R$ %.2f%n%n", hours, fee);
        }
    }
}
