public class Motorcycle extends Vehicle {
    private static final double HOURLY_RATE = 3.00;

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * HOURLY_RATE;
    }

    @Override
    public String toString() {
        return "Moto - Placa: " + getPlate() + " - Marca: " + getBrand() + " - Modelo: " + getModel();
    }
}
