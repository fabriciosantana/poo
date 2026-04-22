import java.util.ArrayList;

public class ParkingApp {

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(); 
        
        vehicles.add(new Car("ABC-1234","Toyota","Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090","Volvo","FH 540"));

        for (int i = 0; i < 3; i++){
            System.out.println(vehicles.get(i).toString());
            System.out.printf("Valor a pagar por 4h: R$ %.2f%n",vehicles.get(i).calculateParkingFee(4));
            System.out.println("");
        }   

    }
}
