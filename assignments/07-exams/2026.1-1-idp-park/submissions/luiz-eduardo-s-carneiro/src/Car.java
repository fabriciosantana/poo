public class Car extends Vehicle{

    private int hours;

    public Car(int hours, String plate, String brand, String model){
        super(plate, brand, model);

        this.hours = hours;
    }

    @Override
    public double calculateParkingFee(int hours){
        return hours * 5.00;
    }

    @Override
    public String toString(){
        return String.format("Carro - %s\nValor a pagar por %dh: R$ %.2f\n", super.toString(), hours, calculateParkingFee(hours));
    }
}