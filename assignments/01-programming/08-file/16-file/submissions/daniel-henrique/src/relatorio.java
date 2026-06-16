import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Main compras.txt report.txt");
            return;
        }

        Path entrada = Path.of(args[0]);
        Path saida = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            ArrayList<String> linhas = new ArrayList<>(Files.readAllLines(entrada));

            for (String linha : linhas) {
                String[] campos = linha.split(",");

                if (campos.length < 3) {
                    continue;
                }

                String nomeCliente = campos[0].trim();

                try {
                    double valor = Double.parseDouble(campos[2].trim());

                    int indice = -1;

                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).equals(nomeCliente)) {
                            indice = i;
                            break;
                        }
                    }

                    if (indice == -1) {
                        clientes.add(nomeCliente);
                        totais.add(valor);
                    } else {
                        totais.set(indice, totais.get(indice) + valor);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Valor invalido ignorado: " + linha);
                }
            }

            ArrayList<String> relatorio = new ArrayList<>();

            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(saida, relatorio);

        } catch (IOException e) {
            System.out.println("Erro ao ler ou gravar arquivo: " + e.getMessage());
        }
    }
}