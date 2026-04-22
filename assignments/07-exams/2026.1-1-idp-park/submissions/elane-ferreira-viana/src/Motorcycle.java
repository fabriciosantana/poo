public class Motorcycle extends Vehicle{
        public Motorcycle(String plate, String brand, String model){
            super(plate, brand, model);
        }

        @Override
            public void calculateParkingFee(int hours) {
                double fee = 3.0 * hours;
                System.out.printf("Moto - %s%nValor a pagar por %dh: R$ %.2f%n%n",
                        this.toString(), hours, fee);
            }
        }
