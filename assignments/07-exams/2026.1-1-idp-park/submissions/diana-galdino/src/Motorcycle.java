public class Motorcycle extends Vehicle {

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    public double calculateParkingFee(int hours) {
        return hours * 3.0;
    }

    public String toString() {
        return "Moto - " + super.toString();
    }
}