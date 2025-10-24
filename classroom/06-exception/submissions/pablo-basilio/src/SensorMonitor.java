import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorMonitor {
    private Map<String, List<SensorReading>> readingsBySensor;
    
    private int validReadingsCount = 0;
    private int ignoredReadingsCount = 0;

    public SensorMonitor() {
        this.readingsBySensor = new HashMap<>();
    }

    public int getValidReadingsCount() {
        return validReadingsCount;
    }

    public int getIgnoredReadingsCount() {
        return ignoredReadingsCount;
    }

    /**
     * Valida e armazena uma leitura de sensor.
     * @param inputLine A linha de entrada no formato SENSOR_ID;TEMPERATURA
     * @throws InvalidReadingException se a leitura for inválida.
     */
    public void addReading(String inputLine) throws InvalidReadingException {
     
        String[] parts = inputLine.split(";", -1); 

        if (parts.length != 2) {
            ignoredReadingsCount++;
            throw new InvalidReadingException("Formato de leitura inválido. Esperado: SENSOR_ID;TEMPERATURA_EM_CELSIUS");
        }

        String sensorId = parts[0].trim();
        String tempStr = parts[1].trim();

        if (sensorId.isEmpty()) {
            ignoredReadingsCount++;
            throw new InvalidReadingException("ID do sensor não pode ser vazio.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(tempStr);
        } catch (NumberFormatException e) {
            ignoredReadingsCount++;
            throw new InvalidReadingException("Temperatura inválida. Não é um número válido: " + tempStr);
        }

        final double MIN_TEMP = -30.0;
        final double MAX_TEMP = 55.0;

        if (temperature < MIN_TEMP || temperature > MAX_TEMP) {
            ignoredReadingsCount++;
            throw new InvalidReadingException(String.format("Temperatura fora da faixa permitida (%.1f °C a %.1f °C): %.1f °C", MIN_TEMP, MAX_TEMP, temperature));
        }

   
        SensorReading reading = new SensorReading(sensorId, temperature);

        readingsBySensor.putIfAbsent(sensorId, new ArrayList<>());
        
        readingsBySensor.get(sensorId).add(reading);
        
        validReadingsCount++;
    }

    /**
     * @param sensorId O ID do sensor.
     * @return A temperatura média.
     * @throws SensorNotFoundException se não houver leituras para o sensor.
     */
    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<SensorReading> readings = readingsBySensor.get(sensorId);

        if (readings == null || readings.isEmpty()) {
            throw new SensorNotFoundException("Não há leituras registradas para o sensor: " + sensorId);
        }

        double sum = 0;
        for (SensorReading reading : readings) {
            sum += reading.getTemperature();
        }

        return sum / readings.size();
    }
}