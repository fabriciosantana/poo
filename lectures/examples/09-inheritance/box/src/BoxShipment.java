class BoxShipment extends BoxWeight{
    double cost; 

    // construct clone of an object 
    BoxShipment(BoxShipment ob) { // pass object to constructor 
        super(ob); 
        cost = ob.cost; 
    } 
    
    // constructor when all parameters are specified 
    BoxShipment(double w, double h, double d, double m, double c) { 
        super(w, h, d, m); // call superclass constructor 
        cost = c; 
    } 
    
    // default constructor 
    BoxShipment() { 
        super(); 
        cost = -1; 
    } 
    
    // constructor used when cube is created 
    BoxShipment(double len, double m, double c) { 
        super(len, m); 
        cost = c; 
    } 
} 
