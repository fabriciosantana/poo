import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SensorMonitor monitor = new SensorMonitor();
        int invalidReadings = 0;
        
        try {
            System.out.println("Monitor de Sensores");
            System.out.println("Digite as leituras no formato: SENSOR_ID;TEMPERATURA_EM_CELSIUS");
            System.out.println("Digite 'FIM' para encerrar a coleta de dados");
            System.out.println();
            
            // Loop para coletar leituras
            while (true) {
                System.out.print("Leitura: ");
                String input = scanner.nextLine();
                
                // Verificar se o usuário quer encerrar
                if (input.trim().equalsIgnoreCase("FIM")) {
                    break;
                }
                
                try {
                    monitor.addReading(input);
                    System.out.println("Leitura adicionada com sucesso!");
                } catch (InvalidReadingException e) {
                    System.out.println("Erro: " + e.getMessage());
                    invalidReadings++;
                }
            }
            
            // Exibir estatísticas
            System.out.println();
            System.out.println("=== Estatísticas ===");
            System.out.println("Leituras válidas: " + monitor.getValidReadingsCount());
            System.out.println("Leituras ignoradas por erro: " + invalidReadings);
            System.out.println();
            
            // Consultar média de um sensor
            System.out.print("Digite o ID do sensor para consultar a média (ou pressione Enter para pular): ");
            String sensorId = scanner.nextLine().trim();
            
            if (!sensorId.isEmpty()) {
                try {
                    double average = monitor.averageFor(sensorId);
                    System.out.printf("Temperatura média do sensor %s: %.2f°C%n", sensorId, average);
                } catch (SensorNotFoundException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            
        } finally {
            scanner.close();
            System.out.println("Programa encerrado.");
        }
    }
}
