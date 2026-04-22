public class Motorcycle extends Vehicle{

    public Motorcycle(String plate, String brand, String model){
        super(plate, brand, model);
    }

    @Override
    public String calculateParkingFee(int hours){
        double calc = hours * 3.00;
        return String.format("Valor a pagar por %dh: R$ %.2f\n", hours, calc);
    }

    @Override
    public String toString(){
        return String.format("Moto - %s", super.toString());
    }
}