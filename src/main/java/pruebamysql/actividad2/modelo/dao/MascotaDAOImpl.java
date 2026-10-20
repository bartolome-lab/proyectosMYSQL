package pruebamysql.actividad2.modelo.dao;

import pruebamysql.actividad2.modelo.beans.Mascota;
import pruebamysql.actividad2.modelo.procesos.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MascotaDAOImpl implements MascotaDAO {

    private static final String CREAR_TABLA = """
            CREATE TABLE IF NOT EXISTS mascotas (
                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                nombre VARCHAR(100) NOT NULL,
                especie VARCHAR(50) NOT NULL,
                raza VARCHAR(50),
                id_persona INT NOT NULL,
                FOREIGN KEY (id_persona) REFERENCES usuarios(id) ON DELETE CASCADE
            )
            """;

    @Override
    public void crearTabla() throws SQLException {
        try (Connection connection = ConexionBD.obtenerConexion();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREAR_TABLA);
        }
    }

    @Override
    public void guardarTodas(List<Mascota> mascotas) throws SQLException {
        try (Connection connection = ConexionBD.obtenerConexion();
             Statement statement = connection.createStatement()) {
            for (Mascota mascota : mascotas) {
                statement.executeUpdate(crearInsert(mascota));
            }
        }
    }

    private String crearInsert(Mascota mascota) {
        return "INSERT INTO mascotas (nombre, especie, raza, id_persona) VALUES ('"
                + mascota.getNombre() + "', '"
                + mascota.getEspecie() + "', '"
                + mascota.getRaza() + "', "
                + mascota.getIdPersona() + ")";
    }
}
