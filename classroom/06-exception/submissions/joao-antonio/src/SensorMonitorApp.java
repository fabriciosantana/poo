import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        int ignoredReadings = 0;

        System.out.println("Insira as leituras no formato: (ID;Temperatura).");
        System.out.println("Digite (FIM) para encerrar a coleta.");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                if ("FIM".equalsIgnoreCase(input)) {
                    break;
                }
                try {
                    monitor.addReading(input);
                } catch (InvalidReadingException e) {
                    System.out.println("Error: " + e.getMessage());
                    ignoredReadings++;
                }
            }
            System.out.println("\n--- Resultado ---");
            System.out.println("Leituras válidas: " + monitor.getTotalReadings());
            System.out.println("\nLeituras ignoradas: " + ignoredReadings);
            System.out.println("----------------------\n");

            System.out.print("Consulte a temperatura média por sensor. Digite o ID do sensor: ");
            String sensorIdToQuery = scanner.nextLine();

            try {
                double average = monitor.averageFor(sensorIdToQuery);
                System.out.printf("A temperatura média para o sensor '%s' é: %.2f°C%n", sensorIdToQuery, average);
            } catch (SensorNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } finally {
            System.out.println("\nPrograma encerrado.");
        }
    }
}