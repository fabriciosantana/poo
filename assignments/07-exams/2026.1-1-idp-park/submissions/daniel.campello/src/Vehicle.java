public class Vehicle {
    String model;
    String plate;
    String brand;

    public Vehicle(String model, String plate, String brand) {
        this.model = model;
        this.plate = plate;
        this.brand = brand;
    }

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public String getPlate() {return plate;}

    public void setPlate(String plate) {this.plate = plate;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    

    public int calculateParkingFee(int hours) {
        int tariff = 0;
        
        return tariff; 
    }

    @Override
    public String toString() {
        String tipo = "Veículo";
        if (this instanceof Car) tipo = "Carro";
        else if (this instanceof Motorcycle) tipo = "Moto";
        else if (this instanceof Truck) tipo = "Caminhão";
        
        return tipo + " - Placa: " + plate + " - Marca: " + brand + " - Modelo: " + model;
    }
    public static class Car extends Vehicle {
        public Car(String model, String plate, String brand) {
            super(model, plate, brand);
        }

        @Override
        public int calculateParkingFee(int hours) {
            return hours * 5;
        }

    }
    public static class Motorcycle extends Vehicle {
        public Motorcycle(String model, String plate, String brand) {
            super(model, plate, brand);
        }

        @Override
        public int calculateParkingFee(int hours) {
            return hours * 3;
        }
    }
    public static class Truck extends Vehicle {
        public Truck(String model, String plate, String brand) {
            super(model, plate, brand);
        }

        @Override
        public int calculateParkingFee(int hours) {
            return hours * 10;
        }
    }
}
