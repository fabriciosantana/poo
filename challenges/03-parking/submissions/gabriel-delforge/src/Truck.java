public class Truck extends Vehicle {
    private static final double RATE = 10.0;

    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return RATE * hours;
    }
}
