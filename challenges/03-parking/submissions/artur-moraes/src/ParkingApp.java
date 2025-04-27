import java.util.ArrayList;

public class ParkingApp {

    public static void main(String[] args){

        //criar arraylist      
        ArrayList<Vehicle> vehicles = new ArrayList<>(); 

        //adicionando veiculos no arraylist
        vehicles.add(new Car ("ABC-1234", "Toyota", "Corolla"));
        vehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        vehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        int hours = 4; // alterar aqui pra mudar numero de horas

        for(Vehicle v : vehicles){
            System.out.println(v.toString());
            System.out.printf("Valor a pagar por %dh: R$ %.2f\n\n", hours, v.calculateParkingFee(hours));
        }
    }


}
