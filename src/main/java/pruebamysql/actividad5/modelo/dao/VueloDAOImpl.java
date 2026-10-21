package pruebamysql.actividad5.modelo.dao;

import pruebamysql.actividad5.modelo.beans.Vuelo;
import pruebamysql.actividad5.modelo.procesos.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VueloDAOImpl implements VueloDAO {

    private final static String BUSCAR_POR_ORIGEN =
            "SELECT * FROM vuelo WHERE ciudadOrigen = ?";

    private final static String BUSCAR_POR_DESTINO =
            "SELECT * FROM vuelo WHERE ciudadDestino = ?";

    private final static String BUSCAR_POR_FECHA_SALIDA =
            "SELECT * FROM vuelo WHERE fechaYHoraSalida = ?";

    private final static String INSERTAR_VUELO = """
            INSERT INTO vuelo(
            codigoVuelo,
            ciudadOrigen,
            ciudadDestino,
            fechaYHoraLlegada,
            fechaYHoraSalida,
            numeroPlazaslibres)
            values (?,?,?,?,?,?)
            """;

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
    public boolean buscarPorFechaSalida(Vuelo vuelo) throws SQLException {

    }

    @Override
    public List<Vuelo> buscarOrigen(Vuelo vuelo) throws SQLException {
        List<Vuelo> vuelos = new ArrayList<>();

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(BUSCAR_POR_ORIGEN)) {

            ps.setString(2, vuelo.getCiudadOrigen());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vuelo vuelo1 = new Vuelo(rs.getString("codigoVuelo"),
                            rs.getString("ciudadOrigen"),
                            rs.getString("ciudadDestino"),
                            rs.get(4),
                            rs.getObject(5),
                            rs.getInt(6));
                }

            }
        }

        return null;
    }

    @Override
    public boolean buscarPorDestino(Vuelo vuelo) throws SQLException {

    }
}
