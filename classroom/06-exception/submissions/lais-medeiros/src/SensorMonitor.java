import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {
    private Map<String, List<Double>> readings = new HashMap<>(); 

    public void addReading(String line) throws InvalidReadingException {
        String[] parts = line.split(";");
        
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido: deve ser SENSOR_ID;Temperatura");
        }
        
        String sensorId = parts[0].trim();
        
        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("Identificador do sensor não pode ser vazio");
        }
        
        try {
            double temperature = Double.parseDouble(parts[1].trim());
            
            if (temperature < -30 || temperature > 55) {
                throw new InvalidReadingException("Temperatura fora da faixa: deve ser entre -30 e 55 graus Celsius");
            }
            
            readings.computeIfAbsent(sensorId, k -> new ArrayList<>()).add(temperature);
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura não é um número válido");
        }
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> temps = readings.get(sensorId);
        
        if (temps == null || temps.isEmpty()) {
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor " + sensorId);
        }
        
        double sum = 0;
        for (double temp : temps) {
            sum += temp;
        }
        return sum / temps.size();
    }
}