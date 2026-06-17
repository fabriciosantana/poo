import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ArrayList;


public class ActorExportApp{
    public static void main(String[] ags){
        Properties props = new Properties();

        try (InputStream input = Files.newInputStream(Path.of("db.properties"))) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo de configuração: " + e.getMessage());
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String csvPath = props.getProperty("csv.path");

        try(Connection conn = DriverManager.getConnection(url, user, password)){

            conn.setAutoCommit(false); 

            ArrayList<ActorExport> atores = new ArrayList<>();

            try (Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id LIMIT 20;")){
                while (rs.next()) {
                    ActorExport ator = new ActorExport(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
                    atores.add(ator);
                }
            }

            try(var writer = Files.newBufferedWriter(Path.of(csvPath))){
                writer.write("Id,Nome,Sobrenome");
                writer.newLine();
                for(ActorExport ator : atores){
                    writer.write(ator.toCsvLine());
                    writer.newLine();
                }
            } catch(IOException e){
                System.out.println("Erro ao conectar no banco de dados: " + e);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados: " + e);
        }

    }
}