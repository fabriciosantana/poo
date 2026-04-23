import java.util.ArrayList;
import java.util.Scanner;

public class ParkingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Coloque um Tipo de Veiculo: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Coloque a marca do veiculo: ");
        String model = scanner.nextLine();

        System.out.print("Coloque a Placa do Veiculo: ");
        String plate = scanner.nextLine();

        System.out.print("Coloque o Modelo: ");
        String brand = scanner.nextLine();

        System.out.print("Coloque as horas deestacionamento: ");
        int hours = scanner.nextInt();
        scanner.nextLine();
        
        Vehicle vehicle = null;

        switch (vehicleType.toLowerCase()) {
            case "car":
                vehicle = new Vehicle.Car(model, plate, brand);
                break;
            case "motorcycle":
                vehicle = new Vehicle.Motorcycle(model, plate, brand);
                break;
            case "truck":
                vehicle = new Vehicle.Truck(model, plate, brand);
                break;
            default:
                System.out.println("Veiculo Invalido.");
                break;
        }

        if (vehicle != null) {
            vehicles.add(vehicle);
            int fee = vehicle.calculateParkingFee(hours);
            System.out.println(vehicle);
            System.out.println("Valor a pagar por" + hours + "h: R$ " + fee + ".00");
        }

        scanner.close();
    }
}
