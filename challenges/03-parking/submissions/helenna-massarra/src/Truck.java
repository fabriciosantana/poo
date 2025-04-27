public class Truck extends Vehicle {
    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * 10.0;
    }

    @Override
    public String toString() {
        return "Caminhão - " + super.toString();
    }
}
