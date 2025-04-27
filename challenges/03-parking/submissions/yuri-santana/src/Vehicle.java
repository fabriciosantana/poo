public abstract class Vehicle {
  private String plate;
  private String brand;
  private String model;

  public Vehicle(String plate, String brand, String model) {
    this.plate = plate;
    this.brand = brand;
    this.model = model;
  }

  public double calculateParkingFee(int hours) {
    return 0.0;
  }

  @Override
  public String toString() {
    return " - Placa: " + this.plate + " - Marca: " + this.brand + " - Modelo: " + this.model;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}