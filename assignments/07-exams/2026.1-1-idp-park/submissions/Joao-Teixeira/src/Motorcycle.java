public class Motorcycle extends Vehicle {

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public int calculateParkingFee(int hours) {
        this.setHours(hours);
        this.setFee(hours * 3);
        return this.getFee();
    }
}