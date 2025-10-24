import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {
    private List<SensorReading> readings;
    
    public SensorMonitor() {
        this.readings = new ArrayList<>();
    }
    
    public void addReading(String line) throws InvalidReadingException {
        // Separar as partes da linha
        String[] parts = line.split(";");
        
        // Validar formato da linha
        if (parts.length != 2) {
            throw new InvalidReadingException("Formato inválido. Use: SENSOR_ID;TEMPERATURA_EM_CELSIUS");
        }
        
        String sensorId = parts[0].trim();
        String temperatureStr = parts[1].trim();
        
        // Validar se o identificador não está vazio
        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("Identificador do sensor não pode estar vazio");
        }
        
        // Validar se a temperatura é um número
        double temperature;
        try {
            temperature = Double.parseDouble(temperatureStr);
        } catch (NumberFormatException e) {
            throw new InvalidReadingException("Temperatura deve ser um número válido");
        }
        
        // Validar faixa de temperatura (-30°C a 55°C)
        if (temperature < -30 || temperature > 55) {
            throw new InvalidReadingException("Temperatura deve estar entre -30°C e 55°C");
        }
        
        // Adicionar leitura válida
        readings.add(new SensorReading(sensorId, temperature));
    }
    
    public double averageFor(String sensorId) throws SensorNotFoundException {
        List<Double> temperatures = new ArrayList<>();
        
        // Buscar todas as leituras do sensor
        for (SensorReading reading : readings) {
            if (reading.getSensorId().equals(sensorId)) {
                temperatures.add(reading.getTemperature());
            }
        }
        
        // Verificar se existem leituras para o sensor
        if (temperatures.isEmpty()) {
            throw new SensorNotFoundException("Não há leituras para o sensor: " + sensorId);
        }
        
        // Calcular média
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        
        return sum / temperatures.size();
    }
    
    public int getValidReadingsCount() {
        return readings.size();
    }
}
