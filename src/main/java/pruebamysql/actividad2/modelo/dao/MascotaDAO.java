package pruebamysql.actividad2.modelo.dao;

import pruebamysql.actividad2.modelo.beans.Mascota;
import java.sql.SQLException;
import java.util.List;

public interface MascotaDAO {

    void crearTabla() throws SQLException;

    void guardarTodas(List<Mascota> mascotas) throws SQLException;
}
