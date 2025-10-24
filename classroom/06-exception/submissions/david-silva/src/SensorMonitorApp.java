import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Monitor de Sensores ");
            System.out.println("Digite as leituras no formato SENSOR_ID;TEMPERATURA.");
            System.out.println("Digite 'FIM' para encerrar.");
            String input;

            while (true) {
                System.out.print("> ");
                input = scanner.nextLine();

                if ("FIM".equalsIgnoreCase(input)) {
                    break;
                }

                try {
                    monitor.addReading(input);
                    System.out.println("Leitura adicionada com sucesso!");
                } catch (InvalidReadingException e) {
                    System.out.println("ERRO: " + e.getMessage());
                    monitor.incrementIgnoredCount();
                }
            }

            System.out.println("Resumo das Leituras ");
            System.out.println("Leituras válidas: " + monitor.getValidReadingsCount());
            System.out.println("Leituras ignoradas: " + monitor.getIgnoredReadingsCount());

            System.out.println("Consulta de Média ");
            System.out.print("Digite o ID do sensor para consultar a média ou 'FIM' para sair: ");
            String sensorId = scanner.nextLine();

            if (!"FIM".equalsIgnoreCase(sensorId)) {
                try {
                    double average = monitor.averageFor(sensorId);
                    System.out.printf("A temperatura média para o sensor '%s' é %.2f °C.\n", sensorId, average);
                } catch (SensorNotFoundException e) {
                    System.out.println("ERRO: " + e.getMessage());
                }
            }
        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}
