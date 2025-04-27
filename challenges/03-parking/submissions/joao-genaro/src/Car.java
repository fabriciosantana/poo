public class Car extends Vehicle {
    private static final double RATE = 5.0;

    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * RATE;
    }

    @Override
    public String toString() {
        return "Carro - Placa: " + getPlate()
             + " - Marca: " + getBrand()
             + " - Modelo: " + getModel();
    }
}