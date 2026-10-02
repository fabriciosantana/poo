import java.util.Locale;
import java.util.Scanner;

public class SensorMonitorApp {

    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        int ignoredReadings = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Monitor de temperatura dos sensores");
            System.out.println("Digite as leituras no formato SENSOR_ID;TEMPERATURA (exemplo: S1;23.5).");
            System.out.println("Digite FIM para encerrar a coleta.");

            boolean collecting = true;
            while (collecting) {
                System.out.print("Leitura: ");
                if (!scanner.hasNextLine()) {
                    System.out.println();
                    System.out.println("Entrada encerrada sem FIM. A coleta foi finalizada.");
                    collecting = false;
                } else {
                    String line = scanner.nextLine().trim();
                    if (line.equalsIgnoreCase("FIM")) {
                        collecting = false;
                    } else {
                        try {
                            monitor.addReading(line);
                            System.out.println("Leitura registrada.");
                        } catch (InvalidReadingException exception) {
                            ignoredReadings++;
                            System.out.println("Leitura ignorada: " + exception.getMessage());
                        }
                    }
                }
            }

            System.out.println();
            System.out.println("Leituras válidas: " + monitor.totalReadings());
            System.out.println("Leituras ignoradas por erro: " + ignoredReadings);

            System.out.println();
            System.out.print("Informe o sensor para consultar a média: ");
            if (scanner.hasNextLine()) {
                String sensorId = scanner.nextLine().trim();
                try {
                    double average = monitor.averageFor(sensorId);
                    System.out.printf(Locale.US, "Média do sensor %s: %.2f °C%n", sensorId, average);
                } catch (SensorNotFoundException exception) {
                    System.out.println("Consulta sem resultado: " + exception.getMessage());
                }
            } else {
                System.out.println();
                System.out.println("Nenhum sensor foi informado para a consulta.");
            }
        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}
