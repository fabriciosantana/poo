public class Motocycle extends Vehicle{
    public Motocycle(String plate, String brand, String model) {
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
