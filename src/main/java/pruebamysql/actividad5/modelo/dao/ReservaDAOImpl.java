package pruebamysql.actividad5.modelo.dao;

import pruebamysql.actividad5.modelo.procesos.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservaDAOImpl implements ReservaDAO{

    private static final String CREAR_TABLA = """
    CREATE TABLE IF NOT EXISTS reserva (
        codigoCliente BIGINT NOT NULL,
        codigoVuelo VARCHAR(20) NOT NULL,
        PRIMARY KEY (codigoCliente, codigoVuelo),
        FOREIGN KEY (codigoCliente) REFERENCES cliente(codigoCliente),
        FOREIGN KEY (codigoVuelo) REFERENCES vuelo(codigoVuelo)
        ) 
        """;

    private static final String INSERTAR_RESERVA = """
        INSERT INTO reserva (codigoCliente,codigoVuelo) VALUES(?,?)
        """;

    @Override
    public void insertar(long codigoCliente, String codigoVuelo) throws SQLException {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(INSERTAR_RESERVA)) {
            ps.setLong(1, codigoCliente);
            ps.setString(2, codigoVuelo);
            ps.executeUpdate();
        }
    }

    @Override
    public void crearTabla() throws SQLException {
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement()) {
            statement.execute(CREAR_TABLA);
        }
    }
}
