public class Motorcycle extends Vehicle {

    public Motorcycle(String plate, String brand, String model){
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int horas){
        return horas * 3;
    }
}