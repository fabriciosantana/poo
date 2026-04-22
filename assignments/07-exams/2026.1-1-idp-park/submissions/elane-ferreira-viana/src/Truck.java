public class Truck {
    public class Truck extends Vehicle{
        public Truck(String plate, String brand, String model){
            super(plate, brand, model);
        }

        @Override
            public void calculateParkingFee(int hours) {
                double fee = 10.0 * hours;
                System.out.printf("Caminhão - %s%nValor a pagar por %dh: R$ %.2f%n%n",
                        this.toString(), hours, fee);
            }
        }
    
}
