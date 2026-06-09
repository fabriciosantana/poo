import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <arquivo_entrada> <arquivo_saida>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(inputPath);

            for (String linha : linhas) {
                String[] campos = linha.split(",");

                if (campos.length < 3) {
                    continue;
                }

                String nomeCliente = campos[0];
                double valor;

                try {
                    valor = Double.parseDouble(campos[2]);
                } catch (NumberFormatException e) {
                    continue;
                }

                int index = clientes.indexOf(nomeCliente);

                if (index >= 0) {
                    totais.set(index, totais.get(index) + valor);
                } else {
                    clientes.add(nomeCliente);
                    totais.add(valor);
                }
            }

            ArrayList<String> saida = new ArrayList<>();

            for (int i = 0; i < clientes.size(); i++) {
                saida.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(outputPath, saida);

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
        }
    }
}
