public class Motorcycle extends Vehicle {
    public Motorcycle(String plate, String brand, String model){
        super(plate, brand, model);
    }
    
    @Override
    public double calculateParkingFee(int hours){
        return hours * 3.0;
    }

    @Override
    public String toString(){
        return "Veículo: Moto - " + super.toString();
    }
}
