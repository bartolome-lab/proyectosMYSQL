package pruebamysql.actividad5.dao;

import pruebamysql.actividad5.modelo.beans.Vuelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VueloDAOImpl implements VueloDAO {

    private static final String BUSCAR_POR_ORIGEN =
            "SELECT * FROM vuelo WHERE ciudadOrigen = ?";

    private static final String BUSCAR_POR_DESTINO =
            "SELECT * FROM vuelo WHERE ciudadDestino = ?";

    private static final String BUSCAR_POR_FECHA_SALIDA =
            "SELECT * FROM vuelo WHERE DATE(fechaYHoraSalida) = ?";

    private static final String CREAR_TABLA = """
            CREATE TABLE IF NOT EXISTS vuelo (
                codigoVuelo VARCHAR(20) PRIMARY KEY, 
                ciudadOrigen VARCHAR(200) NOT NULL,
                ciudadDestino VARCHAR(200) NOT NULL,
                fechaYHoraLlegada DATETIME NOT NULL,
                fechaYHoraSalida DATETIME NOT NULL,
                numeroPlazasLibres INT NOT NULL
                )
            """;

    private static final String INSERTAR_VUELO = """
            INSERT INTO vuelo(
            codigoVuelo,
            ciudadOrigen,
            ciudadDestino,
            fechaYHoraLlegada,
            fechaYHoraSalida,
            numeroPlazasLibres)
            values (?,?,?,?,?,?)
            """;

    private static final String DESCONTAR_PLAZA = """
        UPDATE vuelo
        SET numeroPlazasLibres = numeroPlazasLibres - 1
        WHERE codigoVuelo = ?
        AND numeroPlazasLibres > 0
        """;

    @Override
    public void crearTabla() throws SQLException {
        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement statement = conexion.createStatement()) {
            statement.execute(CREAR_TABLA);
        }
    }

    @Override
    public void insertar(Vuelo vuelo) throws SQLException {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(INSERTAR_VUELO)) {
            ps.setString(1, vuelo.getCodigoVuelo());
            ps.setString(2, vuelo.getCiudadOrigen());
            ps.setString(3, vuelo.getCiudadDestino());
            ps.setObject(4, vuelo.getFechaYHoraLlegada());
            ps.setObject(5, vuelo.getFechaYHoraSalida());
            ps.setInt(6, vuelo.getNumeroPlazasLibres());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Vuelo> buscarPorFechaSalida(LocalDate fechaSalida) throws SQLException {
        List<Vuelo> vuelos = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(BUSCAR_POR_FECHA_SALIDA)) {
            ps.setObject(1, fechaSalida);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vuelos.add(crearVuelo(rs));
                }
            }
        }

        return vuelos;
    }

    @Override
    public List<Vuelo> buscarPorOrigen(String ciudadOrigen) throws SQLException {
        List<Vuelo> vuelos = new ArrayList<>();

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(BUSCAR_POR_ORIGEN)) {

            ps.setString(1, ciudadOrigen);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    vuelos.add(crearVuelo(rs));
                }
            }
        }

        return vuelos;
    }

    @Override
    public List<Vuelo> buscarPorDestino(String ciudadDestino) throws SQLException {
        List<Vuelo> vuelos = new ArrayList<>();

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(BUSCAR_POR_DESTINO)) {

            ps.setString(1, ciudadDestino);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    vuelos.add(crearVuelo(rs));
                }
            }
        }

        return vuelos;
    }

    private Vuelo crearVuelo(ResultSet rs) throws SQLException {
        return new Vuelo(rs.getString("codigoVuelo"),
                rs.getString("ciudadOrigen"),
                rs.getString("ciudadDestino"),
                rs.getObject("fechaYHoraLlegada", LocalDateTime.class),
                rs.getObject("fechaYHoraSalida", LocalDateTime.class),
                rs.getInt("numeroPlazasLibres"));
    }

    @Override
    public boolean descontarPlaza(String codigoVuelo) throws SQLException {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(DESCONTAR_PLAZA)) {
            ps.setString(1, codigoVuelo);
            return ps.executeUpdate() > 0;
        }
    }

}
