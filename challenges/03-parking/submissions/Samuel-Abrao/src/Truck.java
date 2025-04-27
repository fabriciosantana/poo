public class Truck extends Vehicle {
    private static final double RATE_PER_HOUR = 10.0;

    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return RATE_PER_HOUR * hours;
    }

    @Override
    public String toString() {
        return "Caminhão - " + super.toString();
    }
}
