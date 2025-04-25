public class Truck extends Vehicle {
    private float tarifaHora = 10f;   

    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public float calculateParkingFee(int hours) {
        return this.tarifaHora * hours;
    }
}
