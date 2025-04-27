public class Truck extends vehicle {
    public Truck(String plate, String brand, String model) {
        super(plate, model, brand);
    }

    @Override
    public int calculateParkingFee(int hours) {
        return 10 * hours;
    }

}
