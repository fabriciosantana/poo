import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
            System.out.println("Valor a pagar por 4 horas: R$ " + String.format("%.2f", vehicle.calculateParkingFee(4)));
            System.out.println();
        }
    }
}