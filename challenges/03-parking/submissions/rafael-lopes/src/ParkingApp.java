import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("FER-9090", "Ferrari", "SF90"));
        vehicles.add(new Motorcycle("HRL-7777", "Harley Davidson", "Fat Boy"));
        vehicles.add(new Truck("MRC-2025", "Mercedes", "Actros"));

        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
            System.out.printf("Valor a pagar por 4h: R$ %.2f\n\n", v.calculateParkingFee(4));
        }
    }
}
