public class Truck extends Vehicle{
    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }
    
    @Override
    public double calculateParkingFee(int hours){
        return hours * 3.00;
    }

    public String toString(){
        return super.toString();
    }

}
