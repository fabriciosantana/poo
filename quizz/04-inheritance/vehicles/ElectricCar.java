package vehicles; 

class Automobile {
    private final String drive() { return "Driving vehicle"; } 
} 

class Car extends Automobile {
    protected String drive() { return "Driving car"; } 
} 
    
public class ElectricCar extends Car {

    @Override
    public final String drive() { return "Driving electric car"; }

    public static void main(String[] wheels) {
        final Car car = new ElectricCar();

        System.out.print(car.drive());
    }
}