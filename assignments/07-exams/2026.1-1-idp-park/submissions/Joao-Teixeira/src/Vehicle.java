public abstract class Vehicle {
    private String plate;
    private String brand;
    private String model;
    private int fee;
    private int hours;

    // Construtor
    public Vehicle(String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public String getPlate() { return this.plate; }
    public String getBrand() { return this.brand; }
    public String getModel() { return this.model; }
    public int getFee() { return this.fee; }
    public int getHours() { return this.hours; }

    public void setPlate(String plate) {
        this.plate = plate;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

    public abstract int calculateParkingFee(int hours);

    public String toString() {
        String tipo = this.getClass().getSimpleName();
        if (tipo.equals("Car")) tipo = "Carro";
        else if (tipo.equals("Motorcycle")) tipo = "Moto";
        else if (tipo.equals("Truck")) tipo = "Caminhão";
        else tipo = "Veículo";

        return tipo + " - Placa: " + this.plate + 
               " - Marca: " + this.brand + 
               " - Modelo: " + this.model + 
               "\nValor a pagar por " + this.hours + "h: R$ " + String.format(java.util.Locale.US, "%.2f", (double)this.fee);
    }
}