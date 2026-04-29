public abstract class Vehicle {
    private final String plate;
    private final String brand;
    private final String model;

    public Vehicle(String plate, String brand, String model) {
        this.plate = plate.trim().toUpperCase();
        this.brand = brand.trim();
        this.model = model.trim();
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    protected void validateStay(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Tempo de permanencia invalido.");
        }
    }

    public abstract double calculateParkingFee(int hours);

    @Override
    public String toString() {
        return plate + " / " + brand + " " + model;
    }
}
