import java.util.ArrayList;

public class ParkingApp {
    public static void main(String[] args) {
        ArrayList <vehicle> veiculos = new ArrayList<>();

        veiculos.add(new car("REJ-5E54", "Volkswagen", "Polo"));
        veiculos.add(new Motorcycle("JRE-7833", "Honda", "Biz"));
        veiculos.add(new Truck("GJS-9804", "Volvo", "FH"));
        
        int hours = 4;

        for (int i = 0; i < veiculos.size(); i++) {
            vehicle veiculo = veiculos.get(i);
            System.out.println(veiculo);
            System.out.println("Valor a pagar por 4 horas: R$: "+veiculo.calculateParkingFee(hours) );
            System.out.println("");
            
        }
    }
}
