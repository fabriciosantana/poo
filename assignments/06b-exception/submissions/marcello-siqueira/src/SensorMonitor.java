import java.util.ArrayList;

public class SensorMonitor {

    private static final double MIN_TEMPERATURE = -30.0;
    private static final double MAX_TEMPERATURE = 55.0;

    private final ArrayList<SensorReading> readings = new ArrayList<SensorReading>();

    public void addReading(String rawInput) throws InvalidReadingException {
        if (rawInput == null) {
            throw new InvalidReadingException("A leitura não pode ser nula.");
        }

        // limite -1 preserva partes vazias no fim: "S1;" e "S1;20;" nao passam como validas
        String[] parts = rawInput.split(";", -1);
        if (parts.length != 2) {
            throw new InvalidReadingException(
                    "Formato inválido. Use SENSOR_ID;TEMPERATURA, por exemplo S1;23.5.");
        }

        String sensorId = parts[0].trim();
        if (sensorId.isEmpty()) {
            throw new InvalidReadingException("O identificador do sensor não pode estar vazio.");
        }

        String temperatureText = parts[1].trim();
        if (temperatureText.isEmpty()) {
            throw new InvalidReadingException("A temperatura não pode estar vazia.");
        }

        double temperature;
        try {
            temperature = Double.parseDouble(temperatureText);
        } catch (NumberFormatException exception) {
            throw new InvalidReadingException("A temperatura \"" + temperatureText
                    + "\" não é um número válido. Use ponto como separador decimal.", exception);
        }

        // parseDouble aceita "NaN", que passaria pelas comparacoes de faixa
        if (Double.isNaN(temperature)) {
            throw new InvalidReadingException("A temperatura \"" + temperatureText
                    + "\" não é um número válido.");
        }

        if (temperature < MIN_TEMPERATURE || temperature > MAX_TEMPERATURE) {
            throw new InvalidReadingException("A temperatura " + temperatureText
                    + " °C está fora da faixa permitida de -30 °C a 55 °C.");
        }

        readings.add(new SensorReading(sensorId, temperature));
    }

    public double averageFor(String sensorId) throws SensorNotFoundException {
        if (sensorId == null || sensorId.trim().isEmpty()) {
            throw new SensorNotFoundException("Nenhum sensor foi informado para a consulta.");
        }

        String searchedId = sensorId.trim();
        double sum = 0.0;
        int count = 0;
        for (SensorReading reading : readings) {
            if (reading.getSensorId().equals(searchedId)) {
                sum += reading.getTemperature();
                count++;
            }
        }

        if (count == 0) {
            throw new SensorNotFoundException(
                    "Não há leituras registradas para o sensor \"" + searchedId + "\".");
        }

        return sum / count;
    }

    public int totalReadings() {
        return readings.size();
    }
}
