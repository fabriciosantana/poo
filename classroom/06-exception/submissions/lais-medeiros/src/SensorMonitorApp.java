import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SensorMonitor monitor = new SensorMonitor();
            int validCount = 0;
            int invalidCount = 0;
            
            while (true) {
                System.out.print("Digite a leitura (ou FIM para encerrar): ");
                String line = scanner.nextLine().trim();
                
                if (line.equalsIgnoreCase("FIM")) {
                    break;
                }
                
                try {
                    monitor.addReading(line);
                    validCount++;
                } catch (InvalidReadingException e) {
                    System.out.println("Leitura inválida: " + e.getMessage());
                    invalidCount++;
                }
            }
            
            System.out.println("Quantidade de leituras válidas: " + validCount);
            System.out.println("Quantidade de leituras ignoradas por erro: " + invalidCount);
            
            while (true) {
                System.out.print("Digite o ID do sensor para consultar a média (ou SAIR para encerrar): ");
                String sensorId = scanner.nextLine().trim();
                
                if (sensorId.equalsIgnoreCase("SAIR")) {
                    break;
                }
                
                try {
                    double average = monitor.averageFor(sensorId);
                    System.out.println("Média para o sensor " + sensorId + ": " + average);
                } catch (SensorNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) { 
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}