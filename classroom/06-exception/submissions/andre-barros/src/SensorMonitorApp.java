import java.util.Locale;
import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();

        try (Scanner sc = new Scanner(System.in)) {
            sc.useLocale(Locale.US); 

            System.out.println("Monitor de Sensores — Digite leituras no formato SENSOR_ID;TEMPERATURA");
            System.out.println("Exemplos:  S1;23.5   ou   sala-01;19,8");
            System.out.println("Digite FIM para encerrar a coleta.");

            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("FIM")) break;

                try {
                    monitor.addReading(line);
                    System.out.println("Leitura registrada com sucesso.");
                } catch (InvalidReadingException e) {
                    System.out.println("Leitura ignorada: " + e.getMessage());
                }
            }

            System.out.printf("Coleta encerrada. Leituras válidas: %d | Ignoradas por erro: %d%n",
                    monitor.totalReadings(), monitor.totalIgnored());

            System.out.println();
            System.out.println("Consulta de média por sensor.");
            System.out.println("Informe o SENSOR_ID (ou pressione Enter para sair):");

            while (true) {
                String sensorId = sc.nextLine().trim();
                if (sensorId.isEmpty()) break;

                try {
                    double avg = monitor.averageFor(sensorId);
                    System.out.printf("Média do sensor %s: %.2f °C%n", sensorId, avg);
                } catch (SensorNotFoundException e) {
                    System.out.println("Não foi possível calcular a média: " + e.getMessage());
                }

                System.out.println("Informe outro SENSOR_ID (ou Enter para sair):");
            }

        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}
