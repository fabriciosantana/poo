import java.util.Scanner;


public class SensorMonitorApp {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            SensorMonitor monitor = new SensorMonitor();
            int invalidReadings = 0; 

            System.out.println("--- Monitor de Sensores ---");
            System.out.println("Digite as leituras no formato SENSOR_ID;TEMPERATURA");
            System.out.println("Digite 'FIM' para encerrar a coleta de dados.");

            while(true){
                System.out.print("> ");
                String line = scanner.nextLine();

                if(line.equalsIgnoreCase("FIM")){
                    break;
                }

                try{
                    monitor.addReading(line);
                    System.out.println("Leitura adicionada com sucesso.");
                } catch(InvalidReadingException e) {
                    System.err.println("Erro: " + e.getMessage());
                    invalidReadings++;

                }
            }

            System.out.println("\nResumo da Coleta ");
            System.out.println("Leituras válidas: " + monitor.getValidReadingCount());
            System.out.println("Leituras ignoradas (inválidas): " + invalidReadings);
            System.out.println("=====================\n");

            System.out.println("Consulte a temperatura média de um sensor ou digite 'SAIR'.");
            while (true) {
                System.out.print("Consultar sensor: ");
                String sensorId = scanner.nextLine();

                if (sensorId.equalsIgnoreCase("SAIR")) {
                    break;
                }

                try {
                    double average = monitor.averageFor(sensorId);
                    System.out.printf("Média para o sensor '%s': %.2f°C\n", sensorId, average);
                } catch (SensorNotFoundException e) {
                    System.err.println("Erro: " + e.getMessage());
                }
        }

        
    }finally{
        System.out.println("\nPrograma encerrado.");
    }
    }
}
