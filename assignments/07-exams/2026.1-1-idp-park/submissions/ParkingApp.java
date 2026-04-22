public abstract class vehicle {
    private string  plate;
    private string  brand;
    private string  model;

    public vehicle(string plate, string brand, string model){
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public string getplate() {
        return plate;
    }

    public void string setplate(string plate) {
        this.plate = plate;
    }

    public string getbrand() {
        return brand;
    }

    public void string setbrand(string brand) {
        this.brand = brand;
    }

    public string getmodel() {
        return model;
    }

    public void string setmodel(string model) {
        this.model = model;
    } 
    
    public abstract double
    calculateParkingFee(int hours);

    @override
    public string tostring() {
        return "placa:  " + plate +
               "- marca:  " + brand +
               "- modelo:  " + model +
    }
} 

public class car extends vehicle {
    public car(string plate, string brand, string model) {
        super(plate, brand, model)
    }


    @override
            public double calculateParkingFee(int hours) {
                return hours * 5.0;
            }

    @override
    public string tostring() {
        return "carro -> "
         + super.tostring();
    }
}

public class motocycle extends vehicle {
    public motocycle(string plate, string brand, string model) {
        super(plate, brand, model);
    }

    @override
    public double calculateParkingFee(int hours){
        return hours * 2.5;
    }

    @override
    public string tostring() {
        return "moto -> " +
        super.tostring();
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











