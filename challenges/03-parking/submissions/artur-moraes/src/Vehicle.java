public abstract class Vehicle {

    private String plate;
    private String brand;
    private String model;

    //construtor
    public Vehicle(String plate, String brand, String model){
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }
    
    //gets
    public String getPlate(){
        return plate;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    //sets
    public void setPlate(String plate){
        this.plate = plate;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    //metodo pra sobrescrever nas subclasses
    public abstract double calculateParkingFee(int hours);

    //metodo toString sobrescrito
    @Override //sobrescrição
    public String toString(){
        return "Placa: " + plate + " - Marca: " + brand + " - Modelo: "+ model;
    }
}
