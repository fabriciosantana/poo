public class ParkingApp{
    public static void main(String[] args){
        Car car = new Car("ABC-1234", "Toyota", "Corolla");
        Truck truck = new Truck("KLM-9090", "Volvo", "FH 540");
        Motorcycle moto = new Motorcycle("XYZ-5678", "Honda", "CG 160");
        
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = car;
        vehicles[1] = moto;
        vehicles[2] = truck;

        for(Vehicle currentVehicle: vehicles){
            System.out.println(currentVehicle);
            System.out.println(currentVehicle.calculateParkingFee(4));
        }
    }
}