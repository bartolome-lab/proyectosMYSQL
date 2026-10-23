package pruebamysql.actividad5.dao;

import java.sql.SQLException;

public interface ReservaDAO {
    public void insertar(long codigoCliente, String codigoVuelo) throws SQLException;

    public void crearTabla() throws SQLException;

    public boolean existe(long codigoCliente, String codigoVuelo ) throws SQLException;
}
