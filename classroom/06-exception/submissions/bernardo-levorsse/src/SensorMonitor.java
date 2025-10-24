import java.util.*;

public class SensorMonitor {
    private final Map<String, List<Double>> readingsBySensor = new HashMap<>();
    public static final double MIN_C = -30.0;
    public static final double MAX_C = 55.0;

    public void addReading(String rawInput) throws InvalidReadingException {
        if (rawInput == null || rawInput.trim().isEmpty()) {
            throw new InvalidReadingException("Linha vazia.");
        }

        String[] parts = rawInput.split(";");
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Use: SENSOR_ID;TEMPERATURA");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("Identificador do sensor não pode ser vazio.");
        }

        double temp;
        try {
            temp = Double.parseDouble(tempStr.replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura inválida: \"" + tempStr + "\".");
        }

        if (temp < MIN_C || temp > MAX_C) {
            throw new InvalidReadingException(
                String.format("Temperatura fora da faixa permitida (%.0f°C a %.0f°C).", MIN_C, MAX_C)
            );
        }

        readingsBySensor.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(temp);
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> list = readingsBySensor.get(sensorId);
        if (list == null || list.isEmpty()) {
            throw new SensorNotFoundException("Não há leituras para o sensor \"" + sensorId + "\".");
        }
        double sum = 0.0;
        for (double v : list) sum += v;
        return sum / list.size();
    }

    public int totalReadings() {
        int total = 0;
        for (List<Double> l : readingsBySensor.values()) total += l.size();
        return total;
    }
}
