import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DvdRentalApp {

    public static void main(String[] args) {
        // declaracao de variavel do tipo Properties
        Properties props = new Properties();


        try (InputStream input = Files.newInputStream(Path.of("db.properties"))) {

            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de configuração: " + e.getMessage());
            return;
        }

        // Atribui o valor de cada linha ao que seria sua respectivas variaveis
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false); 

            System.out.println("=== Filmes disponíveis ===");
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT film_id, title, release_year FROM film LIMIT 5")) {

                while (rs.next()) {
                    System.out.printf("ID: %d | Título: %s | Ano: %s%n",
                            rs.getInt("film_id"),
                            rs.getString("title"),
                            rs.getString("release_year"));
                }
            }

            System.out.println("\n=== Buscar ator pelo sobrenome ===");
            String sobrenome = "Chase";
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT actor_id, first_name, last_name FROM actor WHERE last_name = ?")) {
                ps.setString(1, sobrenome);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.printf("Ator: %s %s (ID: %d)%n",
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getInt("actor_id"));
                    }
                }
            }

            System.out.println("\n=== Inserir categoria temporária ===");
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO category (name, last_update) VALUES (?, CURRENT_TIMESTAMP)",
                    Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, "TEMP_CATEGORY");
                int rowsInserted = ps.executeUpdate();

                if (rowsInserted > 0) {
                    try (ResultSet keys = ps.getGeneratedKeys()) {
                        if (keys.next()) {
                            int newId = keys.getInt(1);
                            System.out.println("Categoria inserida com ID: " + newId);
                        }
                    }
                }
            }

            System.out.println("\n=== Metadados da tabela film ===");
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM film LIMIT 1")) {

                ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("Coluna %d: %s (%s)%n", i, meta.getColumnName(i), meta.getColumnTypeName(i));
                }
            }

            conn.rollback();
            System.out.println("\nRollback executado. Categoria não foi salva.");

        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados: " + e);
        }
    }
}
