public class Vehicle{

    private String plate;
    private String brand;
    private String model;

        public Vehicle(String plate, String brand, String model ){
            this.plate = plate;
            this.brand = brand;
            this.model = model;

        }

    public String getPlate() {return plate;}
    public void setPlate(String plate) {this.plate = plate;}
    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

        public float calculateParkingFee(int hours){

            float fare = 0;

            return (fare*hours);
        }

        public String toString(){
            String vehicle = "Veículo";
            int hours = 4;
            System.out.println(vehicle + " - Placa: " + getPlate() + " - Marca: " + getBrand() + " - Modelo: " + getModel()); 
            float fare = calculateParkingFee(hours);
            return ("Valor a pagar por" +hours+ ": R$ "+fare+ "\n");
        }
    }
