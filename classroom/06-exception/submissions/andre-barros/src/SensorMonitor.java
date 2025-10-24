import java.util.*;

public class SensorMonitor {

    private final Map<String, List<Double>> readingsBySensor = new HashMap<>();

    private int totalValid = 0;
    private int totalInvalid = 0;

    public static final double MIN_C = -30.0;
    public static final double MAX_C = 55.0;

    public void addReading(String rawInput) throws InvalidReadingException {
        if (rawInput == null) {
            totalInvalid++;
            throw new InvalidReadingException("Entrada vazia.");
        }

        String line = rawInput.trim();
        if (line.isEmpty()) {
            totalInvalid++;
            throw new InvalidReadingException("Linha em branco.");
        }

        String[] parts = line.split(";", -1);
        if (parts.length != 2) {
            totalInvalid++;
            throw new InvalidReadingException("Formato inválido. Use SENSOR_ID;TEMPERATURA (ex.: S1;23.5).");
        }

        String sensorId = parts[0].trim();
        String tempStr  = parts[1].trim();

        if (sensorId.isEmpty()) {
            totalInvalid++;
            throw new InvalidReadingException("Identificador do sensor não pode ser vazio.");
        }

        double temp;
        try {
            temp = Double.parseDouble(tempStr.replace(',', '.'));
        } catch (NumberFormatException e) {
            totalInvalid++;
            throw new InvalidReadingException("Temperatura inválida: não é um número.");
        }

        if (temp < MIN_C || temp > MAX_C) {
            totalInvalid++;
            throw new InvalidReadingException(
                String.format("Temperatura fora da faixa permitida (%.1f°C a %.1f°C).", MIN_C, MAX_C));
        }
        readingsBySensor.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(temp);
        totalValid++;
    }
    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> temps = readingsBySensor.get(sensorId);
        if (temps == null || temps.isEmpty()) {
            throw new SensorNotFoundException(
                "Não há leituras registradas para o sensor: " + sensorId);
        }
        double sum = 0.0;
        for (double t : temps) sum += t;
        return sum / temps.size();
    }

    public int totalReadings() {
        return totalValid;
    }

    public int totalIgnored() {
        return totalInvalid;
    }

    public boolean hasSensor(String sensorId) {
        List<Double> list = readingsBySensor.get(sensorId);
        return list != null && !list.isEmpty();
    }
}
