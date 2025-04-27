// Nome: Allan Samuel Alves do Monte
// Matrícula: 24101279

import java.util.ArrayList;

public class ParkingApp {
    public static void main (String[] args){
        ArrayList<Vehicle> veiculos = new ArrayList<>();

        veiculos.add(new Car("XYZ-6380", "Volkswagen", "Gol"));
        veiculos.add(new Motorcycle("KLO-4526", "Kawasaki", "Ninja"));
        veiculos.add(new Truck("KHD-7829", "Mercedes", "Atego"));

        int hours = 4;

        for (Vehicle v : veiculos) {
            System.out.println(v.toString());
            System.out.printf("Valor a pagar por 4h: R$ %.2f\n\n", v.calculateParkingFee(hours));
        }
    }
}
