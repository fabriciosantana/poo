import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapToFile {

    public static void main(String[] args) {
        TreeMap<String, Integer> produtos = new TreeMap<>();
        produtos.put("Bananas", 10);
        produtos.put("Maçãs", 5);
        produtos.put("Laranjas", 7);
        produtos.put("Pêras", 12);

        Path arquivo = Path.of("data/treemap.txt");

        StringBuilder conteudo = new StringBuilder();
        for (Map.Entry<String, Integer> item : produtos.entrySet()) {
            conteudo.append(item.getKey())
                    .append("=")
                    .append(item.getValue())
                    .append(System.lineSeparator());
        }

        try {
            Files.writeString(arquivo, conteudo.toString());
            System.out.printf("TreeMap gravado em %s%n", arquivo);
        } catch (IOException ex) {
            System.err.printf("Erro ao escrever TreeMap no arquivo: %s%n", ex.getMessage());
        }
    }
}
