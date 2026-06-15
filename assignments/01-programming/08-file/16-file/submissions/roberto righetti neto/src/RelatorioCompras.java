import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        String inputPath = args.length > 0 ? args[0] : "compras.txt";
        String outputPath = args.length > 1 ? args[1] : "report.txt";

        Path input = Path.of(inputPath);
        Path output = Path.of(outputPath);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(input);

            for (String linha : linhas) {
                String[] campos = linha.split(",");

                if (campos.length < 3) {
                    continue;
                }

                String cliente = campos[0].trim();
                double valor;

                try {
                    valor = Double.parseDouble(campos[2].trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                int indice = clientes.indexOf(cliente);

                if (indice >= 0) {
                    totais.set(indice, totais.get(indice) + valor);
                } else {
                    clientes.add(cliente);
                    totais.add(valor);
                }
            }

            ArrayList<String> relatorio = new ArrayList<>();

            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(output, relatorio);

            System.out.println("Relatório gerado em: " + output.toAbsolutePath());

            for (String linha : relatorio) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao processar os arquivos: " + e.getMessage());
        }
    }
}
