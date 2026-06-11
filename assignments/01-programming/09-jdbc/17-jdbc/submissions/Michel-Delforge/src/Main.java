import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dvd_rental";
        String user = "postgres";
        String password = "postgres";

        String filePath = "data/new_films.txt";

        FilmFileReader reader = new FilmFileReader();
        List<Film> films = reader.readFilms(filePath);

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = connection.prepareStatement(insertSql)) {
                for (Film film : films) {
                    stmt.setString(1, film.getTitle());
                    stmt.setInt(2, film.getLanguageId());
                    stmt.setInt(3, film.getRentalDuration());
                    stmt.setDouble(4, film.getRentalRate());
                    stmt.setDouble(5, film.getReplacementCost());
                    stmt.executeUpdate();
                }
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";

            try (PreparedStatement stmt = connection.prepareStatement(updateSql)) {
                stmt.executeUpdate();
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";

            try (PreparedStatement stmt = connection.prepareStatement(selectSql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    System.out.println(rs.getString("title") + " - " + rs.getDouble("rental_rate"));
                }
            }

        } catch (Exception e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        }
    }
}