import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("ABC-1234", "Toyota", "hilux"));
        vehicles.add(new Motorcycle("XYZ-5678", "kavazak", "ninja"));
        vehicles.add(new Truck("KLM-9090", "Mercedes", "cc 200"));

        int hours = 4;

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            System.out.printf("Valor a pagar por %dh: R$ %.2f%n%n", hours, vehicle.calculateParkingFee(hours));
        }
    }
}