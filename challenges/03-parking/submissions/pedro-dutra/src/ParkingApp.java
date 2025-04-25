import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("ppd-0906", "Lamborghini", "Veneno"));
        vehicles.add(new Motorcycle("XYZ-5678", "Ducati", "Superleggera V4"));
        vehicles.add(new Truck("KLM-9090", "Mercedes-Benz", "Actros 2651 6x4"));

        int hours = 4;

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
            System.out.printf("Valor a pagar por %dh: R$ %.2f\n\n", hours, vehicle.calculateParkingFee(hours));
        }
    }
}

