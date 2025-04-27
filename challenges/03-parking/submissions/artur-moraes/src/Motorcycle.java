public class Motorcycle extends Vehicle {

    public Motorcycle(String plate, String brand, String model){
        super(plate, brand, model); //pega de vehicle
    }

    @Override // sobrescreve o metodo de calcular a taxa
    public double calculateParkingFee(int hours){
        return 3.0*hours; // R$3 por hora pra motos
    }

    @Override //sobrescreve o metodo toString
    public String toString(){
        return "Veículo: Moto - " + super.toString(); // pega de vehicle
    }
    
}
