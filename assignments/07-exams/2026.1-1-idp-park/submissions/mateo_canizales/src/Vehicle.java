abstract class Vehicle{
    private String plate;
    private String brand;
    private String model;

    public Vehicle(String plate, String brand, String model){
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public String getPlate(){
        return plate;
    }
    public void setplate(String plate){
        this.plate = plate;
    }

    public String getBrand(){
        return this.brand;
    }
    public void setbrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return this.model;
    }
    public void setmodel(String model){
        this.model = model;
    }

    public abstract double calculateParkingFree(int hours);
    public String toString(){
        return "Placa: " + getPlate() + ", Marca: " + getBrand() + ", Modelo: " + getModel();
    }
}