import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args){

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CB500"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        int hours = 4;

    for (Vehicle veiculos : vehicles) {
    double fee = veiculos.calculateParkingFee(hours);
    System.out.println(veiculos.toString());
    System.out.printf("Valor a pagar por %dh: R$ %.2f%n", hours, fee);
    }
  }
}

