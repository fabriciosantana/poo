public class Car extends Vehicle {
    
    public Car(String plate, String brand, String model){
        super(plate,brand,model);
    }

    public double calculateParkingFee(int hours){
        return hours*5;
    }

}
