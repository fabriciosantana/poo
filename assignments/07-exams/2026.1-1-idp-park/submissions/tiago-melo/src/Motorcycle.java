public class Motorcycle extends Vehicle {
    private static final double PRICE_PER_HOUR = 3.0;

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * PRICE_PER_HOUR;
    }

    @Override
    public String toString() {
        return "Moto - " + super.toString();
    }
}
