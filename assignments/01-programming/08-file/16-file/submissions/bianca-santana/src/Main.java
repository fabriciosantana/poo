import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Uso: java Main <arquivo-entrada> <arquivo-saida>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        List<String> lines = Files.readAllLines(inputPath);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 3) continue;

            String nome = parts[0].trim();
            double valor;
            try {
                valor = Double.parseDouble(parts[2].trim());
            } catch (NumberFormatException e) {
                continue;
            }

            int index = clientes.indexOf(nome);
            if (index == -1) {
                clientes.add(nome);
                totais.add(valor);
            } else {
                totais.set(index, totais.get(index) + valor);
            }
        }

        ArrayList<String> outputLines = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            outputLines.add(clientes.get(i) + ": " + totais.get(i));
        }

        Files.write(outputPath, outputLines);
        System.out.println("Relatório gerado em: " + outputPath);
    }
}
