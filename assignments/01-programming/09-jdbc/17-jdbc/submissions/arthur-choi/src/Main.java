import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        LeitorArquivo leitor = new LeitorArquivo();
        List<Film> filmes = leitor.lerFilmes("data/new_films.txt");

        String url = "jdbc:postgresql://localhost:5432/dvd_rental";
        String usuario = "postgres";
        String senha = "1234";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha)){
            System.out.println("Conexão estabelecida com sucesso!");
            //insert
            String sqlInsert = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
    
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                for (int i = 0; i < filmes.size(); i++) {
                    Film filme = filmes.get(i);
                    pstmt.setString(1, filme.getTitle());
                    pstmt.setInt(2, filme.getLanguageId());
                    pstmt.setInt(3, filme.getRentalDuration());
                    pstmt.setDouble(4, filme.getRentalRate());
                    pstmt.setDouble(5, filme.getReplacementCost());
                    
                    pstmt.executeUpdate();
                }
                System.out.println("Dados inseridos com sucesso!");
                
            } catch (SQLException e) {
                System.out.println("Erro ao inserir dados: " + e.getMessage());
            }

            //update
            String sqlUpdate = "UPDATE film SET rental_rate = rental_rate * 1.1";
            
            try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                // Executa a atualização e guarda quantas linhas foram alteradas
                int linhasAfetadas = stmtUpdate.executeUpdate(); 
                System.out.println("Preços atualizados! Filmes afetados: " + linhasAfetadas);
            }

            //select
                String sqlSelect = "SELECT title, rental_rate FROM film WHERE rent_duration = 99";
                
                try (PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
                    ResultSet rs = stmtSelect.executeQuery()) {
                    System.out.println("\n--- Filmes com duração de locação 99 ---");
                    while (rs.next()) {
                    String titulo = rs.getString("title");
                    double taxa = rs.getDouble("rental_rate");
                    System.out.println("- " + titulo + " | Taxa: " + taxa);
                }          
            }   
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
