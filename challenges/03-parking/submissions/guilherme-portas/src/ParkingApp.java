import java.util.ArrayList;

public class ParkingApp {
    public static void main(String... args) {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        int horas = 4;
        for(Vehicle i : vehicles) {
            System.out.println(i.toString());
            System.out.printf("Valor a pagar por " + horas + "h: R$ %.2f %n", i.calculateParkingFee(horas));
            System.out.println("\n");
        }

    }
}