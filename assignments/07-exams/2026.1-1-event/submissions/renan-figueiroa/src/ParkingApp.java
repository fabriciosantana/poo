public class ParkingApp {

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("ABC-1234","Toyota","Corolla");
        vehicles[1] = new Motocycle("XYZ-5678","Honda","CG 160");
        vehicles[2] = new Truck("KLM-9090","Volvo","FH 540");

        for (int i = 0; i < 3; i++) {
            System.out.println(vehicles[i]);
        }
    }
    
}
