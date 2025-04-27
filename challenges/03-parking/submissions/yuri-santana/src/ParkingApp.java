import java.util.ArrayList;
import java.util.List;

public class ParkingApp {
  public static void main(String[] args) {
      List<Vehicle> listaVeiculos = new ArrayList<>();
      Car car = new Car("111", "Porsche", "911 Turbo S");
      Truck truck = new Truck("222", "Ford", "sei la");
      Motorcycle motorcycle = new Motorcycle("333", "Honda", "ninja");
      listaVeiculos.add(car);
      listaVeiculos.add(motorcycle);
      listaVeiculos.add(truck);

      for (Vehicle vehicle : listaVeiculos) {
        System.out.println(vehicle);
        System.out.println("o valor a pagar por 4h: R$ " + vehicle.calculateParkingFee(4) + "\n");
      }
  }
}
