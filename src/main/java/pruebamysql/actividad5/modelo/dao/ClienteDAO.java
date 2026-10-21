package pruebamysql.actividad5.modelo.dao;

import java.sql.SQLException;

public interface ClienteDAO {
    public boolean existe(long codigoCliente) throws SQLException;

    public void crearTabla() throws SQLException;

}
