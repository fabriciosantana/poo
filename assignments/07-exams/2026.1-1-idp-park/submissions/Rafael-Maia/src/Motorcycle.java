public class Motorcycle extends Vehicle {
    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        validateStay(hours);

        if (hours >= 8) {
            return 24.0;
        }

        return hours * 3.0;
    }

    @Override
    public String toString() {
        return "Moto " + super.toString();
    }
}
