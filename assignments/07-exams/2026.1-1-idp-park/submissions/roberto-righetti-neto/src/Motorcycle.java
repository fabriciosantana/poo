public class Motorcycle extends Vehicle {
    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return 3.0 * hours;
    }

    @Override
    public String toString() {
        return "Moto - " + super.toString();
    }
}
