import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {
    public static void main(String[] args) {


        List<Vehicle> garage = new ArrayList<>();

        
        garage.add(new Car("ABC-1234", "Toyota", "Corolla"));
        garage.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        garage.add(new Truck("KLM-9090", "Volvo", "FH 540"));

       
        final int STAY_DURATION = 4;

  
        garage.forEach(v -> {
            double fee = v.calculateParkingFee(STAY_DURATION);
            
            System.out.println(v.toString());
            System.out.printf("Custo total para %dh: R$ %.2f%n%n", STAY_DURATION, fee);
        });
    }
}