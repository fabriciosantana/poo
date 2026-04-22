public class Motorcycle extends Vehicle {


    private static final double TARIFF_PER_HOUR = 3.0;

    public Motorcycle(String idPlate, String manufacturer, String modelName) {
 
        super(idPlate, manufacturer, modelName);
    }

    @Override
    public double calculateParkingFee(int hoursStayed) {
     
        double totalAmount = hoursStayed * TARIFF_PER_HOUR;
        return totalAmount;
    }

    @Override
    public String toString() {
      
        return "Moto - ".concat(super.toString());
    }
}