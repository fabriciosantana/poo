public class Motorcycle extends vehicle {
    public Motorcycle(String plate, String brand, String model) {
        super(plate, model, brand);
    }

    @Override
    public int calculateParkingFee(int hours) {
        return 3 * hours;
    }
}
