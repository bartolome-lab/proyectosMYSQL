package pruebamysql.actividad5.dao;

import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {

    private static final String CREAR_TABLA = """
            CREATE TABLE IF NOT EXISTS cliente (
                codigoCliente BIGINT PRIMARY KEY AUTO_INCREMENT,
                nombreCompleto VARCHAR(200) NOT NULL
                )
            """;

    private static final String EXISTE_CLIENTE =
            "SELECT codigoCliente FROM cliente WHERE codigoCliente = ?";

    @Override
    public void crearTabla() throws SQLException {
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement()) {
            statement.execute(CREAR_TABLA);
        }
    }

    @Override
    public boolean existe(long codigoCliente) throws SQLException {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(EXISTE_CLIENTE)) {
            ps.setLong(1, codigoCliente);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}