import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        String arquivoEntrada = (args.length > 0) ? args[0] : "compras.txt";
        String arquivoSaida = (args.length > 1) ? args[1] : "report.txt";

        Path pathEntrada = Paths.get(arquivoEntrada);
        Path pathSaida = Paths.get(arquivoSaida);

        ArrayList<String> nomesClientes = new ArrayList<>();
        ArrayList<Double> totaisCompras = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(pathEntrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    continue;
                }

                String nomeCliente = partes[0].trim();
                double valorCompra = 0.0;

                try {
                    valorCompra = Double.parseDouble(partes[2].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Aviso: Valor inválido ignorado na linha: '" + linha + "'");
                    continue;
                }

                int index = nomesClientes.indexOf(nomeCliente);
                
                if (index != -1) {
                    double totalAtual = totaisCompras.get(index);
                    totaisCompras.set(index, totalAtual + valorCompra);
                } else {
                    nomesClientes.add(nomeCliente);
                    totaisCompras.add(valorCompra);
                }
            }

            ArrayList<String> linhasSaida = new ArrayList<>();
            for (int i = 0; i < nomesClientes.size(); i++) {
                linhasSaida.add(nomesClientes.get(i) + ": " + totaisCompras.get(i));
            }

            Files.write(pathSaida, linhasSaida);
            System.out.println("Relatório gerado com sucesso em: " + pathSaida.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro crítico ao processar o arquivo: " + e.getMessage());
        }
    }
}