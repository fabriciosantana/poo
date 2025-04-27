public class Car extends Vehicle {
    private float tarifaHora = 5f;   

    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public float calculateParkingFee(int hours) {
        return this.tarifaHora * hours;
    }
}
