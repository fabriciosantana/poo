public class Motorcycle extends Vehicle {
    private static final double RATE = 3.00;

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * RATE;
    }

    @Override
    public String toString() {
        return "Moto - " + super.toString();
    }
}
