public class Car extends Vehicle { //  `Car`: tarifa por hora de R$ 5,00

    public Car(String plate, String brand, String model) {
        super(plate, brand,model);
    }

    @Override
    public double calculateParkingFee (int hours) {
        return hours * 5.00;
    } 

    @Override
    public String toString() {
        return "Carro - " + super.toString();
    }
}
