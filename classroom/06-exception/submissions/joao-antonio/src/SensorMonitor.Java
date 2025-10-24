import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SensorMonitor {
    private Map<String, List<Double>> readingsBySensor = new HashMap<>();

    public void addReading(String rawInput) throws InvalidReadingException {
        if (rawInput == null || !rawInput.contains(";")) {
            throw new InvalidReadingException("Formato inválido. Use ID;Temperatura.");
        }

        String[] parts = rawInput.split(";");

        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Forneça exatamente um ID e uma temperatura.");
        }

        String sensorId = parts[0].trim();

        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("O identificador do sensor não pode ser vazio.");
        }
        try {
            double temperature = Double.parseDouble(parts[1].trim());
            if (temperature < -30 || temperature > 55) {
                throw new InvalidReadingException("Temperatura fora da faixa permitida (-30°C a 55°C).");
            }
            this.readings.add(new SensorReading(sensorId, temperature));
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("O valor da temperatura deve ser um número válido.");
        }
    }
    public double averageFor(String id) throws SensorNotFoundException {
        List<Double> sensorData = readings.get(id);
        if (sensorData == null || sensorData.isEmpty()) {
            throw new SensorNotFoundException("Não há leituras registradas para o sensor informado.");
        }

        double soma = 0;
        for (double t : sensorData) soma += t;
        return soma / sensorData.size();
    }

    public int getTotalReadings() {
        int total = 0;
        for (List<Double> list : readings.values()) total += list.size();
        return total;
    }
}
