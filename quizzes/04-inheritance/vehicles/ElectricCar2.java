
class Automobile {
    private final String drive() { return "Driving vehicle"; }
}

class Car extends Automobile {
    protected String drive() { return "Driving car"; }
}

public class ElectricCar2 extends Car {
    public static void main(String[] wheels) {
        final Car car = new ElectricCar2();
        System.out.print(car.drive());
    }
}
