public class Truck extends Vehicle {
    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        validateStay(hours);

        if (hours >= 10) {
            return 100.0;
        }

        return hours * 10.0;
    }

    @Override
    public String toString() {
        return "Caminhao " + super.toString();
    }
}
