class ParkingApp {
    public static void main(String[] args) {

        vector<Vehicle> vehicles = new vector<>();

        Vehicle car = new Car("ABC-1234", "Toyota", "Corolla", 4);
        Vehicle motorcycle = new Motorcycle("XYZ-5678", "Honda", "CG 160", 4);
        Vehicle truck = new Truck("KLM-9090 ", "Volvo", "FH 540", 4);

        vehicles.add(car);

        vehicles.add(motorcycle);
        vehicles.add(truck);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}
