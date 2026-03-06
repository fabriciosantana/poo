import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q10 {
    public static void main(String[] args){

        // Exemplo didatico: configure credenciais locais antes de executar.
        String url = "jdbc:postgresql://<HOST>:<PORT>/<DATABASE>";
        String user = "<USER>";
        String password = "<PASSWORD>";

        final String SELECT_FILM_BY_FILM_ID = "Select title, rental_rate from film where film_id = ?";
        final int FILM_ID = 1000;

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = conn.prepareStatement(SELECT_FILM_BY_FILM_ID);
            ){
                pStm.setInt(1, FILM_ID);
                
                try(ResultSet rs = pStm.executeQuery();){
                    while(rs.next()){
                        System.out.println(rs.getString(1) + " - " + rs.getString(2));
                    }
                }
        } catch(SQLException sqle){
            System.out.println("Erro: " + sqle);
        }
    }
}
