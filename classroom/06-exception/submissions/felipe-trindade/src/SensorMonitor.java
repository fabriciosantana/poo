import java.util.ArrayList;
import java.util.List;

public class SensorMonitor{

    private List<SensorReading> leituras = new ArrayList<>();

    public void addReading(String entrada) throws InvalidReadingException{
        if(entrada == null || !entrada.contains(";")){
            throw new InvalidReadingException("Formato errado. Use SENSOR_ID;TEMPERATURA.");
        }

        String[] partes = entrada.split(";");
        if(partes.length != 2){
            throw new InvalidReadingException("Digite só o ID e a temperatura, separados por ponto e vírgula.");
        }

        String id = partes[0].trim();
        if(id.isEmpty()){
            throw new InvalidReadingException("O ID do sensor não pode ficar em branco.");
        }

        double temp;
        try{
            temp = Double.parseDouble(partes[1].trim());
        }catch(NumberFormatException e){
            throw new InvalidReadingException("Temperatura inválida, digite um número.");
        }

        if(temp < -30 || temp > 55){
            throw new InvalidReadingException("Temperatura fora do limite(-30 a 55).");
        }

        leituras.add(new SensorReading(id, temp));
    }

    public double averageFor(String id) throws SensorNotFoundException{
        double soma = 0;
        int qtd = 0;

        for(SensorReading l : leituras){
            if(l.getSensorId().equalsIgnoreCase(id)){
                soma += l.getTemperature();
                qtd++;
            }
        }

        if(qtd == 0){
            throw new SensorNotFoundException("Nenhuma leitura encontrada para o sensor " + id + ".");
        }

        return soma / qtd;
    }

    public int totalReadings(){
        return leituras.size();
    }
}