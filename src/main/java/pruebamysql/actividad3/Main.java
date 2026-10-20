package pruebamysql.actividad3;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final Scanner teclado = new Scanner(System.in);
    private static final String URL = "jdbc:mysql://localhost:3306/pepito";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        System.out.print("Usuario: ");
        String usuario = teclado.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = teclado.nextLine();

        if (comprobarLogin(usuario, contrasena)) {
            System.out.println("Acceso conseguido");
        } else {
            System.out.println("Acceso denegado");
        }
    }

    private static boolean comprobarLogin(String usuario, String contrasena) {
        String sql = "select * from usuarios where nombre = ? and password = ?";

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, usuario);
            statement.setString(2, contrasena);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException e) {
            System.out.println("Error con la base de datos: " + e.getMessage());
            return false;
        }
    }
}