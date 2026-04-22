public class Car {

    public class Car extends Vehicle{
        public Car(String plate, String brand, String model){
            super(plate, brand, model);
        }

        @Override
            public void calculateParkingFee(int hours) {
                double fee = 5.0 * hours;
                System.out.printf("Carro - %s%nValor a pagar por %dh: R$ %.2f%n%n",
                        this.toString(), hours, fee);
            }
        }
    
}
