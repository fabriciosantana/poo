public class Car extends Vehicle {

    public Car(String plate, String brand, String model){
        super(plate, brand, model); //"pega" de vehicle
    }

    @Override //sobrescreve o metodo de calcular taxa
    public double calculateParkingFee(int hours){
        return 5.0*hours; //R$5 por hora carros
    }

    @Override // sobrescreve o metodo toString
    public String toString(){
        return "Veículo: carro - " + super.toString();//pega de vehicle
    }
    
}
