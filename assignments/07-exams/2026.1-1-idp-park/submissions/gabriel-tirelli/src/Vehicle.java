public abstract class Vehicle {

    // Atributos
    private String plate;
    private String brand;
    private String model;

    // Construtor
    public Vehicle(
        String plate,
        String brand,
        String model
    ){
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    // Getters e Setters
    public void setPlate(String plate){
        this.plate = plate;
    }
    public String getPlate(){
        return this.plate;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return this.brand;
    }

    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }

    public abstract double calculateParkingFee(int hours);

    @Override
    public String toString(){

        String tipo = "";
        if (this instanceof Car) {
            tipo = "Carro";
        } else if (this instanceof Motorcycle) {
            tipo = "Moto";
        } else if (this instanceof Truck) {
            tipo = "Caminhão";
        } else {
            tipo = "Veículo";
        }

        return (tipo + " - " + "Placa: " + this.plate + " - Marca: " + this.brand + " - Modelo: " + this.model);
    
    }

}
