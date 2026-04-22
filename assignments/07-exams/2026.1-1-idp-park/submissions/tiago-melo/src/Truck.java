public class Truck extends Vehicle {
    private static final double PRICE_PER_HOUR = 10.0;

    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * PRICE_PER_HOUR;
    }

    @Override
    public String toString() {
        return "Caminhao - " + super.toString();
    }
}
