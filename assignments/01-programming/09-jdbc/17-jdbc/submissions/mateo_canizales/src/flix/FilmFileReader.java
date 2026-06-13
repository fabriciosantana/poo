package flix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilmFileReader {

    public static List<Film> readFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);
            
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(";");
                
                String title = data[0];
                int languageId = Integer.parseInt(data[1]);
                int rentalDuration = Integer.parseInt(data[2]);
                double rentalRate = Double.parseDouble(data[3]);
                double replacementCost = Double.parseDouble(data[4]);

                films.add(new Film(title, languageId, rentalDuration, rentalRate, replacementCost));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de filmes: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro de conversão de dados no arquivo: " + e.getMessage());
        }

        return films;
    }
}