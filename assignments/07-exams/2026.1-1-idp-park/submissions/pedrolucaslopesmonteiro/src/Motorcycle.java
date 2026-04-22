public class Motorcycle extends Vehicle{   //`Motorcycle`: tarifa por hora de R$ 3,00
    
    public Motorcycle(String plate, String brand, String model){
        super(model, brand, model);
    }

    public double calculateParkingFee(int hours) {
        return hours * 3.00;
    }

    @Override
    public String toString() {
        return "Moto - " + super.toString();
    }
}
