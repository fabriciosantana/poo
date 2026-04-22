import java.util.ArrayList;

public class ParkingApp{
    public static void main(String[] args){

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(4, "ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Truck(4, "KLM-9090", "Volvo", "FH 540"));
        vehicles.add(new Motorcycle(4, "XYZ-5678", "Honda", "CG 160"));

        for(Vehicle currentVehicle: vehicles){
            System.out.println(currentVehicle);
        }
        
    }
}