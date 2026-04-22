public class Car extends Vehicle {
    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override 
    public double calculateParkingFree(int hours) {
        return hours * 5.0;
    }

    @Override
    public String toString() {
        return "Car - " + super.toString();
    }
}