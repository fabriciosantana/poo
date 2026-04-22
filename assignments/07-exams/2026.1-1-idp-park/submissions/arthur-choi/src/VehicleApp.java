import java.util.ArrayList;

public class VehicleApp {
    public static void main(String[] args) {
        Car car = new Car("ABC-1234", "Toyota", "Corolla");
        Truck truck = new Truck("XYZ-5678", "Volvo", "FH16");
        Motorcycle motorcycle = new Motorcycle("DEF-9012", "Suzuki", "GSX-S 750");

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(motorcycle);
        vehicles.add(truck);

        System.out.println("Carro: " + vehicles.get(0));
        System.out.println("Valor a pagar por 4h: R$" + vehicles.get(0).calculateParkingFee(4));
        System.out.println("\nMoto: " + vehicles.get(1));
        System.out.println("Valor a pagar por 4h: R$" + vehicles.get(1).calculateParkingFee(4));
        System.out.println("\nCaminhão: " + vehicles.get(2));
        System.out.println("Valor a pagar por 4h: R$" + vehicles.get(2).calculateParkingFee(4));

    }
}
