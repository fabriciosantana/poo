public class Truck extends Vehicle {
    
    public Truck(String plate, String brand, String model){
        super(plate,brand,model);
    };

    public double calculateParkingFee(int hours){
        return hours*10;
    }

}