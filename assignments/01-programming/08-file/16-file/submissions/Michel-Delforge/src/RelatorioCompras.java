import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras compras.txt report.txt");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();
        ArrayList<String> relatorio = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(inputPath);

            for (String linha : linhas) {
                String[] dados = linha.split(",");

                if (dados.length < 3) {
                    continue;
                }

                String nomeCliente = dados[0].trim();
                String valorTexto = dados[2].trim();

                try {
                    double valor = Double.parseDouble(valorTexto);
                    boolean encontrado = false;

                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).equals(nomeCliente)) {
                            totais.set(i, totais.get(i) + valor);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        clientes.add(nomeCliente);
                        totais.add(valor);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Linha ignorada por valor inválido: " + linha);
                }
            }

            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(outputPath, relatorio);

        } catch (IOException e) {
            System.out.println("Erro ao ler ou gravar arquivo: " + e.getMessage());
        }
    }
}