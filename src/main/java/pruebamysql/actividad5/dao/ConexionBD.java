package pruebamysql.actividad5.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/mi_bd";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234";

    private ConexionBD() {
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}