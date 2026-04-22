public class Car extends Vehicle {
    private static final double PRICE_PER_HOUR = 5.0;

    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * PRICE_PER_HOUR;
    }

    @Override
    public String toString() {
        return "Carro - " + super.toString();
    }
}
