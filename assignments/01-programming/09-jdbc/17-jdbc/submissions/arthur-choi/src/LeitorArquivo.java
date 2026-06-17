import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeitorArquivo {
    public List<Film> lerFilmes(String caminhoArquivo) {
        List<Film> filmes = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));

            for (int i = 1; i < linhas.size(); i++) {
                String[] dados = linhas.get(i).split(";");
                String title = dados[0];
                int languageId = Integer.parseInt(dados[1]);
                int rentalDuration = Integer.parseInt(dados[2]);
                double rentalRate = Double.parseDouble(dados[3]);
                double replacementCost = Double.parseDouble(dados[4]);
                Film filme = new Film(title, languageId, rentalDuration, rentalRate, replacementCost);
                filmes.add(filme);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return filmes;
    }
}