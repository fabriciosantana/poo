public class Car extends Vehicle {

    public Car(String plate, String brand, String model){
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int horas){
        return horas * 5;
    }
}