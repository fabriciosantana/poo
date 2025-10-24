import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {
    private final Map<String, List<Double>> sensorData;
    private int validReadingsCount;
    private int ignoredReadingsCount;

    public SensorMonitor() {
        this.sensorData = new HashMap<>();
        this.validReadingsCount = 0;
        this.ignoredReadingsCount = 0;
    }

    public void addReading(String reading) throws InvalidReadingException {
        if (reading == null || reading.trim().isEmpty()) {
            throw new InvalidReadingException("A leitura não pode ser vazia.");
        }

        String[] parts = reading.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Use SENSOR_ID;TEMPERATURA.");
        }

        String sensorId = parts[0].trim();
        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("O ID do sensor não pode ser vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(parts[1].trim());
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("A temperatura deve ser um número válido.");
        }

        if (temperature < -30 || temperature > 55) {
            throw new InvalidReadingException("A temperatura está fora da faixa permitida (-30°C a 55°C).");
        }

        sensorData.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(temperature);
        validReadingsCount++;
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        if (!sensorData.containsKey(sensorId)) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor: " + sensorId);
        }

        List<Double> readings = sensorData.get(sensorId);
        return readings.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
    
    public int getValidReadingsCount() {
        return validReadingsCount;
    }

    public int getIgnoredReadingsCount() {
        return ignoredReadingsCount;
    }
    
    public void incrementIgnoredCount() {
        this.ignoredReadingsCount++;
    }
}
