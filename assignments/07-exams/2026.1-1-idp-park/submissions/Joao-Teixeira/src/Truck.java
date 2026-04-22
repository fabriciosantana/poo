public class Truck extends Vehicle {
        
    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public int calculateParkingFee(int hours) {
        this.setHours(hours);
        this.setFee(hours * 10);
        return this.getFee();
    }
}
