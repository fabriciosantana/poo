import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PurchaseReport {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java PurchaseReport <arquivoEntrada> [arquivoSaida]");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = args.length >= 2 ? Path.of(args[1]) : Path.of("report.txt");

        ArrayList<String> customers = new ArrayList<>();
        ArrayList<Double> totals = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(inputPath);

            for (String line : lines) {
                processLine(line, customers, totals);
            }

            Files.write(outputPath, buildReport(customers, totals));
            System.out.println("Relatorio gerado em: " + outputPath);
        } catch (IOException exception) {
            System.out.println("Erro ao ler ou escrever arquivo: " + exception.getMessage());
        }
    }

    private static void processLine(String line, ArrayList<String> customers, ArrayList<Double> totals) {
        String[] fields = line.split(",");

        if (fields.length < 3) {
            return;
        }

        String customer = fields[0].trim();
        String valueText = fields[2].trim();

        try {
            double value = Double.parseDouble(valueText);
            int customerIndex = customers.indexOf(customer);

            if (customerIndex >= 0) {
                totals.set(customerIndex, totals.get(customerIndex) + value);
            } else {
                customers.add(customer);
                totals.add(value);
            }
        } catch (NumberFormatException exception) {
            System.out.println("Linha ignorada por valor invalido: " + line);
        }
    }

    private static ArrayList<String> buildReport(ArrayList<String> customers, ArrayList<Double> totals) {
        ArrayList<String> reportLines = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++) {
            reportLines.add(customers.get(i) + ": " + totals.get(i));
        }

        return reportLines;
    }
}
