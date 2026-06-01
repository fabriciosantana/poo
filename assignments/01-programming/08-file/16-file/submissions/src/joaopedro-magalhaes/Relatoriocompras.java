import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso incorreto. O programa deve receber dois argumentos:");
            System.out.println("java RelatorioCompras <arquivo_entrada> <arquivo_saida>");
            return;
        }

        Path caminhoEntrada = Paths.get(args[0]);
        Path caminhoSaida = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(caminhoEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    continue;
                }

                String nome = partes[0].trim();
                
                try {
                    double valor = Double.parseDouble(partes[2].trim());

                    int index = clientes.indexOf(nome);
                    if (index != -1) {
                        double novoTotal = totais.get(index) + valor;
                        totais.set(index, novoTotal);
                    } else {
                        clientes.add(nome);
                        totais.add(valor);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valor na linha: \"" + linha + "\". Ignorando.");
                }
            }

            List<String> linhasRelatorio = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                linhasRelatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(caminhoSaida, linhasRelatorio);
            System.out.println("Relatório gerado com sucesso: " + caminhoSaida.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro de E/S: " + e.getMessage());
        }
    }
}