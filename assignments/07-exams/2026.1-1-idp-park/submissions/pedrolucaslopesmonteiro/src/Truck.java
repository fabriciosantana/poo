public class Truck extends Vehicle  { // tarifa por hora de R$ 10,00

    public Truck (String plate, String brand, String model) {
        super(plate, brand, model);

    }

    public double calculateParkingFee(int hours) {
        return hours * 10.00;
    } 

    @Override
    public String toString() {
        return "Caminhão - " + super.toString();
    }
    
}
