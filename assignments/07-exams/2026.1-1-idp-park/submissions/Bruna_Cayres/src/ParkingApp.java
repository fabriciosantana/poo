import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car carro = new Car("ABC-1234", "Toyota", "Corolla");
        Motorcycle moto = new Motorcycle("XYZ-5678", "Honda", "CG 160");
        Truck caminhao = new Truck("KLM-9090", "Volvo", "FH 540");

        vehicles.add(carro);
        vehicles.add(moto);
        vehicles.add(caminhao);

        for (Vehicle veiculo : vehicles) {
            double valor = veiculo.calculateParkingFee(4);
            

            if (veiculo instanceof Car) {
                System.out.print("Carro - ");
            } else if (veiculo instanceof Motorcycle) {
                System.out.print("Moto - ");
            } else if (veiculo instanceof Truck) {
                System.out.print("Caminhão - ");
            }
            
            System.out.println(veiculo.toString());
            System.out.println("Valor a pagar por 4h: R$ " + valor + "0\n");
        }
    }
}