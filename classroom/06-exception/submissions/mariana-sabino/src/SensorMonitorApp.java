import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SensorMonitor monitor = new SensorMonitor();

        try {
            System.out.println("=== Monitor de Sensores ===");
            System.out.println("Digite leituras no formato SENSOR_ID;TEMPERATURA ou 'FIM' para encerrar.");

            while (true) {
                String line = leitor.nextLine().trim();
                if (line.equalsIgnoreCase("FIM")) {
                    break;
                }

                try {
                    monitor.addReading(line);
                    System.out.println("Leitura registrada com sucesso.");
                } catch (InvalidReadingException e) {
                    monitor.incrementInvalid();
                    System.out.println("Leitura inválida: " + e.getMessage());
                }
            }

            System.out.println("\nResumo:");
            System.out.println("Leituras válidas: " + monitor.getValidCount());
            System.out.println("Leituras inválidas: " + monitor.getInvalidCount());

            System.out.print("\nDigite o ID do sensor para consultar a média: ");
            String sensorId = leitor.nextLine().trim();

            try {
                double media = monitor.averageFor(sensorId);
                System.out.printf("Temperatura média do sensor %s: %.2f °C%n", sensorId, media);
            } catch (SensorNotFoundException e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } finally {
            System.out.println("Programa encerrado.");
            leitor.close();
        }
    }
}
