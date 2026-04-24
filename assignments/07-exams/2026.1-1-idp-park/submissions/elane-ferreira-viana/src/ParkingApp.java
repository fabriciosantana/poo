public class ParkingApp{
        public static void main(String[] args) {
            ArrayList<Vehicle> veiculos = new ArrayList<>();

            veiculos.add(new Car("ABC-1234", "Toyota", "Corolla"));
            veiculos.add(new Motorcycle("XYZ-5678", "Honda", "CG 160"));
            veiculos.add(new Truck("KLM-9090", "Volvo", "FH 540"));

            for (Vehicle v : veiculos) {
                v.calculateParkingFee(4);
        }
        }
    }

