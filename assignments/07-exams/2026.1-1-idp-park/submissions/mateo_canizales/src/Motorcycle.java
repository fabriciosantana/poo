public class Motorcycle extends Vehicle {
    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override 
    public double calculateParkingFree(int hours) {
        return hours * 3.0;
    }

    @Override
    public String toString() {
        return "Motorcycle - " + super.toString();
    }
}