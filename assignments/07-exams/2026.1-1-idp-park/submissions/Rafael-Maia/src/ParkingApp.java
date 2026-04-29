import java.util.ArrayList;
import java.util.Locale;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> parkedVehicles = new ArrayList<>();

        parkedVehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        parkedVehicles.add(new Motorcycle("XYZ-5678", "Honda ", "CG 160"));
        parkedVehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        System.out.println("Movimentacao do patio");
        System.out.println();

        for (int i = 0; i < parkedVehicles.size(); i++) {
            Vehicle currentVehicle = parkedVehicles.get(i);
            int currentHours = 4;
            double amount = currentVehicle.calculateParkingFee(currentHours);

            System.out.printf(Locale.US, "%s | %dh | R$ %.2f%n",
                    currentVehicle,
                    currentHours,
                    amount);
        }
    }
}
