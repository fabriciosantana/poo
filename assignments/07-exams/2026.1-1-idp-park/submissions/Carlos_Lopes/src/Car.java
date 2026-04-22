public class Car extends Vehicle{

    public Car(String plate, String brand, String model) {
        super(plate, brand, model);
    }
@Override
public double calculateParkingFee(int hours){
    double taxa = 5.00;
    double FEE = hours * taxa;
    return FEE;
}

@Override
public String toString(){
        return "Carro - Placa: " + getPlate() + " Modelo: " + getModel() + " Marca: " + getBrand();
}

}