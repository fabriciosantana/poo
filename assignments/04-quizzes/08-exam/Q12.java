import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q12 {
    public static void main(String[] args){

        // Exemplo didatico: configure credenciais locais antes de executar.
        String url = "jdbc:postgresql://<HOST>:<PORT>/<DATABASE>";
        String user = "<USER>";
        String password = "<PASSWORD>";

        final String INSERT_FILM = 
                        """
                        INSERT INTO film
                        (title, language_id, rental_duration, rental_rate, replacement_cost) 
                        VALUES (? , ?, ?, ?, ?)
                        """;

        final String DELETE_FILM_BY_ID = "DELETE FROM film WHERE film_id > ?";
        
        try(Connection dvdRentalConnection = DriverManager.getConnection(url, user, password);
            PreparedStatement insertFilmStatement = dvdRentalConnection.prepareStatement(INSERT_FILM);
            PreparedStatement deleteFilmStatement = dvdRentalConnection.prepareStatement(DELETE_FILM_BY_ID);
            ){
                
                insertFilmStatement.setString(1, "Novo Filme");
                insertFilmStatement.setInt(2, 1);
                insertFilmStatement.setInt(3, 5);
                insertFilmStatement.setDouble(4, 9.99);
                insertFilmStatement.setDouble(5, 99.99);

                insertFilmStatement.executeUpdate();

                deleteFilmStatement.setInt(1, 1000);

                deleteFilmStatement.executeUpdate();

        } catch(SQLException sqle){
            System.out.println("Erro: " + sqle);
        }
    }
}
