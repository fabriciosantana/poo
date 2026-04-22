public class Truck  extends Vehicle{
        public Truck(String plate, String brand, String model) {

        super(plate, brand, model);
    }

    @Override
        public float calculateParkingFee(int hours){

            float fare = 10;

            return (fare*hours);
        }

    @Override

        public String toString(){
            String vehicle = "Caminhão";
            int hours = 4;
            System.out.println(vehicle + " - Placa: " + getPlate() + " - Marca: " + getBrand() + " - Modelo: " + getModel()); 
            float fare = calculateParkingFee(hours);
            return ("Valor a pagar por" +hours+ ": R$ "+fare)+"\n";
        }
        
}
