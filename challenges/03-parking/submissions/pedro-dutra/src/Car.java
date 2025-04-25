public class Car extends Vehicle {
    private static final double RATE = 5.00;

    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * RATE;
    }

    @Override
    public String toString() {
        return "Carro - " + super.toString();
    }
}
