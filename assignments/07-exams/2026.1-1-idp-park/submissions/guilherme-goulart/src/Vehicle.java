public abstract class Vehicle {
    private String plate;
    private String brand;
    private String model;

    public Vehicle(String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public abstract double calculateParkingFee(int hours);

    @Override
    public String toString() {
        return String.format("Placa: %s - Marca: %s - Modelo: %s", plate, brand, model);
    }
}

class Car extends Vehicle {
    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * 5.00;
    }

    @Override
    public String toString() {
        return "Carro - " + super.toString();
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * 3.00;
    }

    @Override
    public String toString() {
        return "Moto - " + super.toString();
    }
}

class Truck extends Vehicle {
    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        return hours * 10.00;
    }

    @Override
    public String toString() {
        return "Caminhão - " + super.toString();
    }
}