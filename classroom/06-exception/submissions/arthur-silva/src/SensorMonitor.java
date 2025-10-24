import java.util.ArrayList;
import java.util.List;

public class SensorMonitor {
    public final List<SensorReading> readings = new ArrayList<>();

    public void addReading(String readingLine) throws InvalidReadingException{
        String[] parts = readingLine.split(";");

        if(parts.length != 2){
            throw new InvalidReadingException("Formato deve ser SENSOR_ID;TEMPERATURA_EM_CELSIUS.");
        }

        String sensorId = parts[0].trim();
        String tempString = parts[1].trim();

        if(sensorId.isEmpty()){
            throw new InvalidReadingException("O identificador do sendor não pode estar vazio.");
        }

        double temperature;
        try{
            temperature = Double.parseDouble(tempString);
        }catch(NumberFormatException e){
            throw new InvalidReadingException("A temperatura deve ser um número válido.");
        }

        if(temperature < -30 || temperature > 55){
            throw new InvalidReadingException("A temperatura deve estar na faixa entre -30°C e 55°C");
        }

        SensorReading reading = new SensorReading(sensorId, temperature);
        this.readings.add(reading);

    }

    public double averageFor (String sensorId) throws SensorNotFoundException{
        double sum = 0.00;
        int count = 0;

        for(SensorReading reading : this.readings){
            if(reading.getSensorId().equalsIgnoreCase(sensorId)){
                sum += reading.getTemperature();
                count++;
            }
        }

        if(count == 0){
            throw new SensorNotFoundException("Não houve nenhuma leitura do sensor.");
        }

        return sum / count;
    }

    public int getValidReadingCount(){
        return this.readings.size();
    }
}
