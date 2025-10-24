public class SensorReading {
    private String sensorId;
    private double temperatura;

    public SensorReading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperatura = temperature;
    }
    public String getSensorId() {
        return sensorId;
    }
    public double getTemperature() {
        return temperatura;
    }
}