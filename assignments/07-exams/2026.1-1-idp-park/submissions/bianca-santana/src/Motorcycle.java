class Motorcycle extends Vehicle {
    private int hours;

    public Motorcycle(String plate, String brand, String model, int hours) {
        super(plate, brand, model);
        this.hours = hours;
    }
    public int getHours() { return hours;}
    public void setHours(int hours) {this.hours = hours;}


    @Override
    public int calculateParkingFee(int hours) {
        setHours(hours);
        return getHours() * 3;
    }

    @Override
    public String toString() {
        return "Moto - Placa: " + getPlate() + " - Marca: " + getBrand() + " - Modelo: " + getModel() + "\n" + "Valor a pagar por " + getHours() + "h: R$ " + calculateParkingFee(getHours());
    }

}