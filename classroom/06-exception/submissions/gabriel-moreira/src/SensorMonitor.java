import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {
    private final Map<String, List<Double>> readings = new HashMap<>();
    private int totalValidReadings = 0;
    private int totalIgnoredReadings = 0;

    public void addReading(String rawInput) throws InvalidReadingException {
        final double MIN_TEMP = -30.0;
        final double MAX_TEMP = 55.0;

        String[] parts = rawInput.split(";");
        if (parts.length != 2) {
            totalIgnoredReadings++;
            throw new InvalidReadingException("Formato inválido. Esperado: SENSOR_ID;TEMPERATURA");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        if (sensorId.isEmpty()) {
            totalIgnoredReadings++;
            throw new InvalidReadingException("Identificador do sensor não pode ser vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(tempStr);
        } catch (NumberFormatException e) {
            totalIgnoredReadings++;
            throw new InvalidReadingException("Temperatura ('" + tempStr + "') não é um número válido.");
        }

        if (temperature < MIN_TEMP || temperature > MAX_TEMP) {
            totalIgnoredReadings++;
            String motivo = String.format("Temperatura %.2f °C fora da faixa permitida (%.0f °C a %.0f °C).", 
                                          temperature, MIN_TEMP, MAX_TEMP);
            throw new InvalidReadingException(motivo);
        }

        readings.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(temperature);
        totalValidReadings++;
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> sensorTemperatures = readings.get(sensorId);

        if (sensorTemperatures == null || sensorTemperatures.isEmpty()) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor ID: " + sensorId);
        }

        double sum = 0;
        for (double temp : sensorTemperatures) {
            sum += temp;
        }

        return sum / sensorTemperatures.size();
    }
    
    public int getTotalValidReadings() {
        return totalValidReadings;
    }

    public int getTotalIgnoredReadings() {
        return totalIgnoredReadings;
    }
}