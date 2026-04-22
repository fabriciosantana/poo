import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("REK1G58", "Ford", "Mustang Shelby GT 350R"));
        vehicles.add(new Car("JEU1059", "Ferrari", "F40"));
        vehicles.add(new Motorcycle("PIU7777", "Harley-Davidson", "Iron 883"));
        vehicles.add(new Truck("FJD3859", "Volvo", "FH 540"));

        int horas = 4;

        for (int i = 0; i < vehicles.size(); i++) {
            
            Vehicle veiculoAtual = vehicles.get(i);
            
            System.out.println(veiculoAtual.toString());
            
            double fee = veiculoAtual.calculateParkingFee(horas);
            
            System.out.printf("Valor a pagar por %dh: R$ %.2f\n\n", horas, fee);
        }
    }
}