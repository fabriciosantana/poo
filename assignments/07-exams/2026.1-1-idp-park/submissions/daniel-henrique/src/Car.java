public class Car extends Vehicle {


    private static final double HOURLY_RATE = 5.0;

    public Car(String licensePlate, String brand, String model) {
     
        super(licensePlate, brand, model);
    }

    @Override
    public double calculateParkingFee(int totalHours) {
  
        return totalHours * HOURLY_RATE;
    }

    @Override
    public String toString() {
       
        return String.format("Carro - %s", super.toString());
    }
}