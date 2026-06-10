import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path entrada = (args.length >= 1)
                ? Path.of(args[0])
                : Path.of("..", "..", "..", "data", "compras.txt");
        Path saida = (args.length >= 2) ? Path.of(args[1]) : Path.of("report.txt");

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(entrada);

            for (String linha : linhas) {
                String[] campos = linha.split(",", -1);
                if (campos.length < 3) {
                    continue;
                }

                String nomeCliente = campos[0].trim();
                String valorTexto = campos[2].trim();

                if (nomeCliente.isEmpty() || valorTexto.isEmpty()) {
                    continue;
                }

                double valor;
                try {
                    valor = Double.parseDouble(valorTexto);
                } catch (NumberFormatException e) {
                    continue;
                }

                int indice = clientes.indexOf(nomeCliente);
                if (indice >= 0) {
                    totais.set(indice, totais.get(indice) + valor);
                } else {
                    clientes.add(nomeCliente);
                    totais.add(valor);
                }
            }

            StringBuilder relatorio = new StringBuilder();
            for (int i = 0; i < clientes.size(); i++) {
                if (i > 0) {
                    relatorio.append(System.lineSeparator());
                }
                relatorio.append(clientes.get(i)).append(": ").append(totais.get(i));
            }

            Files.writeString(saida, relatorio.toString());
            System.out.println("Relatório gerado em: " + saida.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Erro ao ler ou gravar o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
