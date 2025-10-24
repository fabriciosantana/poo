import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();

        try (Scanner scanner = new Scanner(System.in)) {
            String inputLine;

            System.out.println("--- Monitor de Sensores ---");
            System.out.println("Digite aas leituras no formato: SENSOR_ID;TEMPERATURA");
            System.out.println("Digite 'FIM' para encerrar a coleta.");

            while (true) {
                System.out.print("> ");
                inputLine = scanner.nextLine();
                
                if (inputLine.trim().equalsIgnoreCase("FIM")) {
                    break;
                }

                try {
                    monitor.addReading(inputLine);
                    System.out.println("Leitura válida armazenada.");
                } catch (InvalidReadingException e) {
                    System.err.println("ERRO na Leitura: " + e.getMessage());
                }
            }

            System.out.println("\n--- Resumo da Coleta ---");
            System.out.printf("Leituras válidas armazenadas: %d\n", monitor.getValidReadingsCount());
            System.out.printf("Leituras ignoradas por erro: %d\n", monitor.getIgnoredReadingsCount());

            System.out.println("\n--- Consulta de Média ---");
            System.out.print("Digite o ID do sensor para consultar a temperatura média (ou ENTER para pular): ");
            String sensorId = scanner.nextLine().trim();

            if (!sensorId.isEmpty()) {
                try {
                    double average = monitor.averageFor(sensorId);
                    System.out.printf("A temperatura média para o sensor '%s' é: %.2f °C\n", sensorId, average);
                } catch (SensorNotFoundException e) {
                    System.err.println("ERRO na Consulta: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        } 
        
        finally {
            System.out.println("Programa encerrado.");
        }
    }
}