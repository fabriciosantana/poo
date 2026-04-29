public class Car extends Vehicle {
    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }

    @Override
    public double calculateParkingFee(int hours) {
        validateStay(hours);

        if (hours >= 12) {
            return 60.0;
        }

        return hours * 5.0;
    }

    @Override
    public String toString() {
        return "Carro " + super.toString();
    }
}
