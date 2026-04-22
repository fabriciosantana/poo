public abstract class Vehicle {
    private String plate;
    private String brand;
    private String model;

    public Vehicle(String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public void setPlate(String value) {this.plate = value;}
    public String getPlate() {return this.plate;};

    public void setBrand(String value) {this.brand = value;}
    public String getBrand() {return this.brand;}

    public void setModel(String value) {this.model = value;}
    public String getModel() {return this.model;}

    public double calculateParkingFee(int hours) {
        return 0;
    };

    @Override
    public String toString() {
        return "Placa: " + plate + " - Marca: " + brand + " - Modelo: " + model;
    }
}