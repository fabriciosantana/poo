import java.util.Scanner;

public class SensorMonitorApp {
    public static void main(String[] args) {
        SensorMonitor monitor = new SensorMonitor();
        int ignoradas = 0;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Monitor de Sensores");
            System.out.println("Digite leituras no formato SENSOR_ID;TEMPERATURA (ex: S1;23.5).");
            System.out.println("Digite FIM para encerrar a coleta.\n");

            while (true) {
                System.out.print("> ");
                String linha = sc.nextLine();
                if (linha.equalsIgnoreCase("FIM")) break;

                try {
                    monitor.addReading(linha);
                    System.out.println("✔ Leitura registrada.");
                } catch (InvalidReadingException e) {
                    ignoradas++;
                    System.out.println("✖ Leitura ignorada: " + e.getMessage());
                }
            }

            System.out.printf("%nColeta encerrada.%n");
            System.out.printf("Leituras válidas: %d | Leituras ignoradas: %d%n",
                    monitor.totalReadings(), ignoradas);

            System.out.print("\nInforme o ID do sensor para ver a média: ");
            String id = sc.nextLine().trim();

            try {
                double media = monitor.averageFor(id);
                System.out.printf("Média do sensor %s: %.2f°C%n", id, media);
            } catch (SensorNotFoundException e) {
                System.out.println("✖ " + e.getMessage());
            }
        } finally {
            System.out.println("Programa encerrado.");
        }
    }
}
