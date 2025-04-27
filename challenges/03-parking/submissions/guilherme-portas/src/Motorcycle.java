public class Motorcycle extends Vehicle {
    private float tarifaHora = 3f;   

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public float calculateParkingFee(int hours) {
        return this.tarifaHora * hours;
    }
}
