import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (int i = 1; i < lines.size(); i++) {
                String[] data = lines.get(i).split(";");

                if (data.length == 5) {
                    String title = data[0];
                    int languageId = Integer.parseInt(data[1]);
                    int rentalDuration = Integer.parseInt(data[2]);
                    double rentalRate = Double.parseDouble(data[3]);
                    double replacementCost = Double.parseDouble(data[4]);

                    films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return films;
    }
}