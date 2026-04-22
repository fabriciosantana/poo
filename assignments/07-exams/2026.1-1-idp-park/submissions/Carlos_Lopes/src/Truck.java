public class Truck extends Vehicle{

    public Truck(String plate, String brand, String model) {
        super(plate, brand, model);
    }
@Override
public double calculateParkingFee(int hours){
    double taxa = 4.00;
    double FEE = hours * taxa;
    return FEE;
}

@Override
public String toString(){
        return ("Caminho - Placa: " + getPlate() + " - Marca: " + getBrand() + " - Modelo: " + getModel());
}

}

