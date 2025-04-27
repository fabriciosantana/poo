public class Motorcycle extends Vehicle {
    private static final double RATE_PER_HOUR = 3.0;

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return RATE_PER_HOUR * hours;
    }

    @Override
    public String toString() {
        return "Moto - " + super.toString();
    }
}
