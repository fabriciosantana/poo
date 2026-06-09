package br.edu.idp.cc.poo.dvdrental.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final String CONFIG_FILE = "application.properties";
    private static final String URL_PROPERTY = "database.url";
    private static final String USER_PROPERTY = "database.user";
    private static final String PASSWORD_PROPERTY = "database.password";

    public static Connection getConnection() throws SQLException {
        Properties properties = loadProperties();

        return DriverManager.getConnection(
            properties.getProperty(URL_PROPERTY),
            properties.getProperty(USER_PROPERTY),
            properties.getProperty(PASSWORD_PROPERTY)
        );
    }

    private static Properties loadProperties() throws SQLException {
        Properties properties = new Properties();

        try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new SQLException("Arquivo de configuracao nao encontrado: " + CONFIG_FILE);
            }

            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new SQLException("Erro ao ler arquivo de configuracao: " + CONFIG_FILE, e);
        }
    }
}
