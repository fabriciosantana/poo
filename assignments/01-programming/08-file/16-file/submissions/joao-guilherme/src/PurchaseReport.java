import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PurchaseReport {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java PurchaseReport <arquivoEntrada> <arquivoSaida>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        ArrayList<String> clientNames = new ArrayList<>();
        ArrayList<Double> clientTotals = new ArrayList<>();

        List<String> lines;
        try {
            lines = Files.readAllLines(inputPath);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        for (String line : lines) {
            String[] fields = line.split(",");
            if (fields.length < 3) {
                continue;
            }

            String name = fields[0];
            double value;
            try {
                value = Double.parseDouble(fields[2]);
            } catch (NumberFormatException e) {
                continue;
            }

            boolean found = false;
            for (int i = 0; i < clientNames.size(); i++) {
                if (clientNames.get(i).equals(name)) {
                    clientTotals.set(i, clientTotals.get(i) + value);
                    found = true;
                    break;
                }
            }
            if (!found) {
                clientNames.add(name);
                clientTotals.add(value);
            }
        }

        ArrayList<String> reportLines = new ArrayList<>();
        for (int i = 0; i < clientNames.size(); i++) {
            reportLines.add(clientNames.get(i) + ": " + clientTotals.get(i));
        }

        try {
            Files.write(outputPath, reportLines);
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de saída: " + e.getMessage());
        }
    }
}