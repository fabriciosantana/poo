public abstract class Vehicle {
    
    private String licenseId;
    private String manufacturer;
    private String versionName;

    
    public Vehicle(String licenseId, String manufacturer, String versionName) {
        this.licenseId = licenseId;
        this.manufacturer = manufacturer;
        this.versionName = versionName;
    }


    public abstract double calculateParkingFee(int hours);

    // Getters e Setters refatorados
    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Override
    public String toString() {
      
        return "Placa: " + this.licenseId + 
               " | Marca: " + this.manufacturer + 
               " | Modelo: " + this.versionName;
    }
}