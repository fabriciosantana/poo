class TubeLight extends Light { // (2) Subclass uses the extends clause.
    // Instance fields:
    private int tubeLength; // Length in millimeters
    private int tubeDiameter; // Diameter in millimeters
    
    // Non-zero argument constructor
    TubeLight(int noOfWatts, boolean indicator, String location,
    int tubeLength, int tubeDiameter) {
        super(noOfWatts, indicator, location); // Calling constructor in superclass.
        this.tubeLength = tubeLength;
        this.tubeDiameter = tubeDiameter;
    }
    
    // Instance methods:
    public int getTubeLength() { return tubeLength; }
        public void printInfo() {
        System.out.println("From the subclass:");
        System.out.println("Tube length (mm): " + getTubeLength());
        System.out.println("Tube diameter (mm): " + tubeDiameter);
        System.out.println();
        System.out.println("From the superclass:");
        System.out.println("Wattage: " + noOfWatts); // Inherited.
        // System.out.println("Indicator: " + indicator); // (3) Not inherited.
        System.out.println("Location: " + location); // Inherited.
        // System.out.println("Counter: " + counter); // (4) Not inherited.
        switchOn(); // Inherited
        switchOff(); // Inherited
        System.out.println("Indicator: " + isOn()); // Inherited.
        // System.out.println("Location: " + getLocation()); // (5) Not inherited.
        System.out.println("Number of lights: " + getCount());// Inherited.
    }
}