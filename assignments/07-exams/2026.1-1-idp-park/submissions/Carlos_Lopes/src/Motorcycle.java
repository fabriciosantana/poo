public class Motorcycle extends Vehicle{

    public Motorcycle(String plate, String brand, String model) {
        super(plate, brand, model);
    }
@Override
public double calculateParkingFee(int hours){
    double taxa = 3.00;
    double FEE = hours * taxa;
    return FEE;
}

@Override
public String toString(){
        return ("Moto - Placa: " + getPlate() + " Marca: " + getBrand() + " Modelo: " + getModel());
}


}
