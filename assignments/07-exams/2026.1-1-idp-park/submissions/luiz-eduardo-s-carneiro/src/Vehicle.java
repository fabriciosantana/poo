public abstract class Vehicle{
    
    private String plate;
    private String brand;
    private String model;

    public Vehicle(String plate, String brand, String model){
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public void setPlate(String plate){ this.plate = plate; }
    public void setBrand(String brand){ this.brand = brand; }
    public void setModel(String model){ this.model = model; }

    public String getPlate(){ return plate; }
    public String getBrand(){ return brand; }
    public String getModel(){ return model; }

    public abstract String calculateParkingFee(int hours);

    @Override
    public String toString(){
        return String.format("Placa: %s - Marca: %s - Modelo: %s",
                            getPlate(), getBrand(), getModel());
    }
}