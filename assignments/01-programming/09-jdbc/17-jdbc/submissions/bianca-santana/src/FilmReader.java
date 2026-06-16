import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmReader {

    public static List<Film> read(String path) {
        List<Film> films = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");
                if (parts.length < 5) continue;
                try {
                    String title = parts[0].trim();
                    int languageId = Integer.parseInt(parts[1].trim());
                    int rentalDuration = Integer.parseInt(parts[2].trim());
                    double rentalRate = Double.parseDouble(parts[3].trim());
                    double replacementCost = Double.parseDouble(parts[4].trim());
                    films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
                } catch (NumberFormatException e) {
                    System.out.println("Linha ignorada: " + lines.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return films;
    }
}
