public class Car extends Vehicle {

    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public int calculateParkingFee(int hours) {
        this.setHours(hours);
        this.setFee(hours * 5);
        return this.getFee();
    }
}
