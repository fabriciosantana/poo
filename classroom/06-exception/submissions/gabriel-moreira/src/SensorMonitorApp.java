import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Monitor de Leituras de Temperatura ---");
            System.out.println("Digite leituras no formato SENSOR_ID;TEMPERATURA_EM_CELSIUS.");
            System.out.println("Digite 'FIM' para encerrar a coleta.");

            String input;
            while (true) {
                System.out.print("Leitura (ou FIM): ");
                input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("FIM")) {
                    break;
                }

                try {
                    monitor.addReading(input);
                    System.out.println("Leitura válida armazenada.");
                } catch (InvalidReadingException e) {
                    System.err.println("ERRO na leitura: " + e.getMessage());
                }
            }

            System.out.println("\n--- Relatório de Coleta ---");
            System.out.println("Leituras válidas armazenadas: " + monitor.getTotalValidReadings());
            System.out.println("Leituras ignoradas por erro: " + monitor.getTotalIgnoredReadings());
            
            System.out.println("\n--- Consulta de Média ---");
            System.out.print("Digite o ID do sensor para consultar a média (ou ENTER para pular): ");
            String sensorConsulta = scanner.nextLine().trim();
            
            if (!sensorConsulta.isEmpty()) {
                try {
                    double media = monitor.averageFor(sensorConsulta);
                    System.out.printf("A temperatura média para o sensor '%s' é: %.2f °C\n", sensorConsulta, media);
                } catch (SensorNotFoundException e) {
                    System.err.println("ERRO na consulta: " + e.getMessage());
                }
            }

        } finally {
            System.out.println("\nPrograma encerrado.");
        }
    }
}