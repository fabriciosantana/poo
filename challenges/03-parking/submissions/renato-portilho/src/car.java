public class car extends vehicle {
    public car(String plate, String brand, String model) {
        super(plate, brand, model);

    }

    @Override
    public int calculateParkingFee(int hours) {

        return 5 * hours;
    }
}
