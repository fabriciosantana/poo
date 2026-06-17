import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ActorExportApp {
    public static void main(String[] args) {
        Properties props = new Properties();
        
        // Carregar o arquivo db.properties usando java.nio.file.Files.newInputStream
        try (InputStream input = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo db.properties: " + e.getMessage());
            return;
        }

        String dbUrl = props.getProperty("db.url");
        String dbUser = props.getProperty("db.user");
        String dbPassword = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        if (dbUrl == null || dbUser == null || dbPassword == null || csvPath == null) {
            System.err.println("Propriedades de configuracao do banco ou do CSV ausentes no db.properties.");
            return;
        }

        List<ActorExport> actors = new ArrayList<>();

        // Conectar ao banco de dados e obter os dados
        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                actors.add(new ActorExport(id, firstName, lastName));
            }

        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
            return;
        }

        // Gravar no arquivo CSV
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();
            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }
            System.out.println("Exportacao concluida com sucesso! Arquivo gerado: " + csvPath);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        }
    }
}
