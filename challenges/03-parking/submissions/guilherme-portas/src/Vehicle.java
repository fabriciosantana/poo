public abstract class Vehicle {
    private String placa;
    private String marca;
    private String modelo;

    public Vehicle(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public float calculateParkingFee(int hours) {
        return 10f;
    }

    @Override
    public String toString() {
        String nomeClasse = getClass().getName(), nomePtbr;
        if(nomeClasse == "Car") nomePtbr = "Carro";
        else if(nomeClasse == "Motorcycle") nomePtbr = "Moto";
        else if(nomeClasse == "Truck") nomePtbr = "Caminhão";
        else nomePtbr = "Desconhecido";

        return "Veículo: " + nomePtbr +
               " - Placa: " + getPlaca() +
               " - Marca: " + getMarca() +
               " - Modelo: " + getModelo();
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getModelo() {
        return this.modelo;
    }
}