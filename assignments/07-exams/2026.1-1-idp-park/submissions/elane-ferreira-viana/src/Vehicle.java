import java.util.ArrayList;

public abstract class Vehicle {

    private String plate;
    private String brand;
    private String model;

    public Vehicle(String plate, String brand, String model) {

        this.plate = plate;
        this.brand = brand;
        this.model = model;

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

    public void setPlate(String plate) { 
        this.plate = plate; 
    }

    public void setBrand(String brand) { 
        this.brand = brand; 
    }

    public void setModel(String model) { 
        this.model = model; 
    }

    public abstract void calculateParkingFee(int hours);

    public String toString() {
        return "Placa: " + plate + " - Marca: " + brand + " - Modelo: " + model;
    }
}
    

    public class ParkingApp{
        public static void main(String[] args) {
            ArrayList<Vehicle> veiculos = new ArrayList<>();

            veiculos.add(new Car("ABC-1234", "Toyota", "Corolla"));
            veiculos.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
            veiculos.add(new Truck("KLM-9090", "Volvo", "FH 540"));

            for (Vehicle v : veiculos) {
                v.calculateParkingFee(4);
        }
        }
    }

