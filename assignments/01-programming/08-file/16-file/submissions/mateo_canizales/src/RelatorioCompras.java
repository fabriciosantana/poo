import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Por favor, informe os caminhos dos arquivos de entrada e saída.");
            System.out.println("Exemplo: java RelatorioCompras compras.txt report.txt");
            return;
        }

        String caminhoEntrada = args[0];
        String caminhoSaida = args[1];

        Path pathEntrada = Paths.get(caminhoEntrada);
        Path pathSaida = Paths.get(caminhoSaida);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totaisCompras = new ArrayList<>();

        try {

            List<String> linhas = Files.readAllLines(pathEntrada);

            for (String linha : linhas) {

                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    System.err.println("Linha malformada ignorada: " + linha);
                    continue;
                }

                String nomeCliente = partes[0].trim();
                String valorStr = partes[2].trim();

                try {
                    double valor = Double.parseDouble(valorStr);

                    int index = clientes.indexOf(nomeCliente);
                    if (index != -1) {

                        double totalAtual = totaisCompras.get(index);
                        totaisCompras.set(index, totalAtual + valor);
                    } else {

                        clientes.add(nomeCliente);
                        totaisCompras.add(valor);
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Erro de conversão numérica na linha: " + linha + " -> " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return; // Encerra a execução caso não consiga ler o arquivo base
        }

        List<String> linhasSaida = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            String linhaRelatorio = clientes.get(i) + ": " + totaisCompras.get(i);
            linhasSaida.add(linhaRelatorio);
        }

        try {

            Files.write(pathSaida, linhasSaida);
            System.out.println("Relatório gerado com sucesso em: " + pathSaida.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo de saída: " + e.getMessage());
        }
    }
}