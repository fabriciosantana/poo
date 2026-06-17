import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ActorExportApp {
    public static void main(String[] args) {
        Properties props = new Properties();

        try (var inputStream = Files.newInputStream(Paths.get("db.properties"))) {
            props.load(inputStream);
        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo db.properties: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        if (url == null || user == null || password == null || csvPath == null) {
            System.err.println("Propriedades de banco de dados ou caminho do CSV incompletos no db.properties.");
            return;
        }

        String sql = "SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;";
        ArrayList<ActorExport> actors = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                actors.add(new ActorExport(id, firstName, lastName));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar o banco de dados: " + e.getMessage());
            return;
        }

        try (var writer = Files.newBufferedWriter(Paths.get(csvPath))) {
            writer.write("Id,Nome,Sobrenome");
            writer.newLine();
            for (ActorExport actor : actors) {
                writer.write(actor.toCsvLine());
                writer.newLine();
            }
            System.out.println("Exportação concluída com sucesso! Arquivo gerado em: " + csvPath);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo CSV: " + e.getMessage());
        }
    }
}
