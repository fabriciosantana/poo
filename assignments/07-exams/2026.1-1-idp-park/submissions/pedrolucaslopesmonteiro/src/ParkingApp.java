import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> veiculos = new ArrayList<>();

        veiculos.add(new Car("ABC-1234", "Toyota", "Corolla"));
        veiculos.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        veiculos.add(new Truck("KLM-9090", "Volvo", "FH 540"));
 

    int hours = 4;

    for (Vehicle v : veiculos) {
        System.out.println(v);
        System.out.printf("Valor a pagar por %dh: R$ %.2f%n%n", hours, v.calculateParkingFee(hours));
       }
    }
}