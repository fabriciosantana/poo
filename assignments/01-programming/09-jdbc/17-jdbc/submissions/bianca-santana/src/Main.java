import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) throws Exception {
        String filePath = args.length > 0 ? args[0] : "data/new_films.txt";

        List<Film> films = FilmReader.read(filePath);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Importar filmes
            String insert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insert)) {
                for (Film film : films) {
                    ps.setString(1, film.title);
                    ps.setInt(2, film.languageId);
                    ps.setInt(3, film.rentalDuration);
                    ps.setDouble(4, film.rentalRate);
                    ps.setDouble(5, film.replacementCost);
                    ps.executeUpdate();
                }
                System.out.println(films.size() + " filmes importados.");
            }

            // Atualizar rental_rate em 10%
            String update = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement ps = conn.prepareStatement(update)) {
                int rows = ps.executeUpdate();
                System.out.println(rows + " filmes atualizados (rental_rate +10%).");
            }

            // Listar filmes com rent_duration = 99
            String select = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement ps = conn.prepareStatement(select);
                 ResultSet rs = ps.executeQuery()) {
                System.out.println("\nFilmes com duração de locação = 99:");
                while (rs.next()) {
                    System.out.printf("%-50s R$ %.2f%n", rs.getString("title"), rs.getDouble("rental_rate"));
                }
            }
        }
    }
}
