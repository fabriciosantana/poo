import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PurchaseReport {

    public static void accumulate(ArrayList<String> clientes, ArrayList<Double> totais, String cliente, double valor) {
        int index = clientes.indexOf(cliente);
        if (index == -1) {
            clientes.add(cliente);
            totais.add(valor);
        } else {
            totais.set(index, totais.get(index) + valor);
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java PurchaseReport <arquivo de entrada> <arquivo de saída>");
            return;
        }

        Path entrada = Path.of(args[0]);
        Path saida = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(entrada);

            for (String linha : linhas) {
                String[] campos = linha.split(",");
                if (campos.length < 3) {
                    continue;
                }

                try {
                    String cliente = campos[0].trim();
                    double valor = Double.parseDouble(campos[2].trim());
                    accumulate(clientes, totais, cliente, valor);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido na linha: " + linha);
                }
            }

            List<String> saidaLinhas = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                saidaLinhas.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(saida, saidaLinhas);
        } catch (IOException e) {
            System.out.println("Erro ao acessar arquivo: " + e.getMessage());
        }
    }
}
