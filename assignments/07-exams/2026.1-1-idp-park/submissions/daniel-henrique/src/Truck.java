public class Truck extends Vehicle {


    private static final double BASE_TARIFF = 10.0;

    public Truck(String registrationPlate, String make, String modelType) {

        super(registrationPlate, make, modelType);
    }

    @Override
    public double calculateParkingFee(int hoursParked) {
    
        return hoursParked * BASE_TARIFF;
    }

    @Override
    public String toString() {
       
        StringBuilder sb = new StringBuilder("Caminhão - ");
        sb.append(super.toString());
        return sb.toString();
    }
}