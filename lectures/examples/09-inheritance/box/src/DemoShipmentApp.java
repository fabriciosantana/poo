class DemoShipmentApp { 
    public static void main(String[] args) { 
        BoxShipment shipment1 = new BoxShipment(10, 20, 15, 10, 3.41); 
        BoxShipment shipment2 = new BoxShipment(2, 3, 4, 0.76, 1.28); 
        double vol; 

        vol = shipment1.volume(); 
        System.out.println("Volume of shipment1 is " + vol); 
        System.out.println("Weight of shipment1 is " + shipment1.weight); 
        System.out.println("Shipping cost: $" + shipment1.cost); 
        System.out.println();

        vol = shipment2.volume(); 
        System.out.println("Volume of shipment2 is " + vol); 
        System.out.println("Weight of shipment2 is " + shipment2.weight); 
        System.out.println("Shipping cost: $" + shipment2.cost); 
    } 
}