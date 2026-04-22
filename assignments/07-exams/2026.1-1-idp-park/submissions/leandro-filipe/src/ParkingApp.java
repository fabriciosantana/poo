abstract class Vehicle{

    protected String plate;
    protected String brand;
    protected String model;

    Vehicle(String plate, String brand, String model){

        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    // metodos set get

    public String getPlate() {
        return plate;
    
    }


    public void setPlate(String plate){
        this.plate = plate;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public abstract double calculateParkingFee(int hours);

    
    @Override
    public String toString() {
        return "Placa: " + plate + " - Marca: " + brand + " - Modelo: " + model;
    }
}

class Car extends Vehicle {
    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    
    @Override
    public double calculateParkingFee(int hours) {
        return 5.00 * hours;
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
        return 3.00 * hours;
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
        return 10.00 * hours;
    }

    @Override
    public String toString() {
        return "Caminhão - " + super.toString();
    }
}


public class ParkingApp {
    public static void main(String[] args) {
        
        ArrayList<Vehicle> parkedVehicles = new ArrayList<>();

        
        parkedVehicles.add(new Car("ABC-1234", "Toyota", "Corolla"));
        parkedVehicles.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
        parkedVehicles.add(new Truck("KLM-9090", "Volvo", "FH 540"));

        int parkingHours = 4;

        
        for (Vehicle v : parkedVehicles) {
            System.out.println(v.toString());
        
            System.out.printf(java.util.Locale.US, "Valor a pagar por %dh: R$ %.2f\n\n", 
                              parkingHours, v.calculateParkingFee(parkingHours));
        }
    }
}