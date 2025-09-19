class Light { // (1)
    
    // Instance fields:
    int noOfWatts; // Wattage
    private boolean indicator; // On or off
    protected String location; // Placement
    
    // Static field:
    private static int counter; // Number of Light objects created
    
    // Non-zero argument constructor:
    Light(int noOfWatts, boolean indicator, String location) {
        this.noOfWatts = noOfWatts;
        this.indicator = indicator;
        this.location = location;
        ++counter; // Increment counter.
    }

    // Instance methods:
    public void switchOn() { indicator = true; }
    public void switchOff() { indicator = false; }
    public boolean isOn() { return indicator; }
    private String getLocation() { return location; }

    // Static methods:
    public static int getCount() { return counter; }
}