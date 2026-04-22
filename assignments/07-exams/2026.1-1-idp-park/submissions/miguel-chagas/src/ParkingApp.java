import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> Veiculos = new ArrayList<>();

        Veiculos.add(new Car("ABC-1234","Toyota","Corolla"));
        Veiculos.add(new Motocycle("XYZ-5678","Honda","CG 160"));
        Veiculos.add(new Truck("KLM-9090","Volvo","FH 540"));

        for(Vehicle v : Veiculos){
            System.out.println(v.toString());
        }

    }    
}
