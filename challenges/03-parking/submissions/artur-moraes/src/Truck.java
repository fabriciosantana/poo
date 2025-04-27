public class Truck extends Vehicle {

    public Truck(String plate, String brand, String model){
        super(plate, brand, model); // pega de vehicle
    }

    @Override //sobrescreve o calculo da taxa
    public double calculateParkingFee(int hours){
        return 10.0*hours; // R$10 por hora caminhões
    }

    @Override //sobrescreve o metodo toString
    public String toString(){
        return "Veículo: Caminhão - " + super.toString(); // pega de vehicle
    }
    
}
