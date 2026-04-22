import java.util.ArrayList;

public class ParkingApp{

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        System.out.println("Carro - " + vehicles.get(0));

        System.out.printf("Valor a pagar por 4h: R$ %.2f\n", vehicles.get(0).calculateParkingFee(4));

        System.out.println("\nMoto - " + vehicles.get(1));

        System.out.printf("Valor a pagar por 4h: R$ %.2f\n", vehicles.get(1).calculateParkingFee(4));

        System.out.println("\nCaminhão - " + vehicles.get(2));

        System.out.printf("Valor a pagar por 4h: R$ %.2f\n", vehicles.get(2).calculateParkingFee(4));

    }

}
