import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PurchaseReport {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java PurchaseReport <inputFile> <outputFile>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<Double> customerTotals = new ArrayList<>();

        try {
            var lines = Files.readAllLines(inputPath);

            for (String line : lines) {
                String[] parts = line.split(",");

                if (parts.length < 3) {
                    continue;
                }

                String customer = parts[0].trim();
                double value;

                try {
                    value = Double.parseDouble(parts[2].trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                int index = customerNames.indexOf(customer);

                if (index >= 0) {
                    customerTotals.set(index, customerTotals.get(index) + value);
                } else {
                    customerNames.add(customer);
                    customerTotals.add(value);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        var reportLines = new ArrayList<String>();

        for (int i = 0; i < customerNames.size(); i++) {
            reportLines.add(customerNames.get(i) + ": " + customerTotals.get(i));
        }

        try {
            Files.write(outputPath, reportLines);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}