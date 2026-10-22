package pruebamysql.actividad5.modelo.dao;

import java.sql.SQLException;

public interface ReservaDAO {
    public void insertar(long codigoCliente, String codigoVuelo) throws SQLException;

    public void crearTabla() throws SQLException;
}
