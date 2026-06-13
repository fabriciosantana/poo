package flix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class main {

    private static final String URL = "jdbc:postgresql://localhost:5432/dvd_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "sua_senha_aqui";

    public static void main(String[] args) {

        String filePath = "./data/new_films.txt";
        List<Film> filmsToImport = FilmFileReader.readFilms(filePath);
        
        System.out.println("Total de filmes encontrados para importação: " + filmsToImport.size());

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexão com o banco dvd_rental estabelecida com sucesso!");

            String insertSql = "INSERT INTO film (title, language_id, rental_duration, rental_rate, replacement_cost) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                for (Film film : filmsToImport) {
                    insertStmt.setString(1, film.getTitle());
                    insertStmt.setInt(2, film.getLanguageId());
                    insertStmt.setInt(3, film.getRentalDuration());
                    insertStmt.setDouble(4, film.getRentalRate());
                    insertStmt.setDouble(5, film.getReplacementCost());
                    insertStmt.addBatch();
                }
                int[] rowsInserted = insertStmt.executeBatch();
                System.out.println(rowsInserted.length + " novos filmes importados com sucesso.");
            }

            String updateSql = "UPDATE film SET rental_rate = rental_rate * 1.1";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                int rowsUpdated = updateStmt.executeUpdate();
                System.out.println("Valor de locação atualizado em 10% para " + rowsUpdated + " filmes.");
            }

            String selectSql = "SELECT title, rental_rate FROM film WHERE rental_duration = 99";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                
                System.out.println("\n--- FILMES COM DURACÃO DE LOCAÇÃO IGUAL A 99 ---");
                boolean encontrou = false;
                while (rs.next()) {
                    encontrou = true;
                    String title = rs.getString("title");
                    double rentalRate = rs.getDouble("rental_rate");
                    System.out.printf("Título: %-30s | Nova Taxa: R$ %.2f%n", title, rentalRate);
                }
                if (!encontrou) {
                    System.out.println("Nenhum filme encontrado com duração de locação igual a 99.");
                }
                System.out.println("------------------------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Erro na execução das operações do Banco de Dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}