public abstract class Vehicle { // plate, brand, model 
    private String plate;
    private String brand;
    private String model;

    // classe construtora
    public Vehicle (String plate, String brand, String model) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    
    }

    //getters and setters 
    public String getPlate () { return plate; }
    public void setPlace(String plate) {
        this.plate = plate;
    }

    public String getBrand () { return brand; }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() { return brand; }
    public void setmodel(String model) { 
        this.model = model; 
    }
    // abstrato
    public abstract double calculateParkingFee(int hours);

    @Override 
     public String toString() {
        return "Placa: " + plate + " - Marca: " + brand + " - Modelo: " + model;
    }
}

    

