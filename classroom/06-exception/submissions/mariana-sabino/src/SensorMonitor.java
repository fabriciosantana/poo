import java.util.*;

public class SensorMonitor {
    private Map<String, List<Double>> readings = new HashMap<>();
    private int invalidCount = 0;

    public void addReading(String line) throws InvalidReadingException {
        try {
            String[] parts = line.split(";");
            if (parts.length != 2) {
                throw new InvalidReadingException("Formato inválido. Use SENSOR_ID;TEMPERATURA.");
            }

            String sensorId = parts[0].trim();
            if (sensorId.isEmpty()) {
                throw new InvalidReadingException("Identificador do sensor não pode ser vazio.");
            }

            double temperature = Double.parseDouble(parts[1].trim());
            if (temperature < -30 || temperature > 55) {
                throw new InvalidReadingException("Temperatura fora da faixa permitida (-30 a 55 °C).");
            }

            readings.putIfAbsent(sensorId, new ArrayList<>());
            readings.get(sensorId).add(temperature);

        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura inválida. Deve ser um número.");
        }
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> values = readings.get(sensorId);
        if (values == null || values.isEmpty()) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor: " + sensorId);
        }
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public int getValidCount() {
        return readings.values().stream().mapToInt(List::size).sum();
    }

    public void incrementInvalid() {
        invalidCount++;
    }

    public int getInvalidCount() {
        return invalidCount;
    }
}
