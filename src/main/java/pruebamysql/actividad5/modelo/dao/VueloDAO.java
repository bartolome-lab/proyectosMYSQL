package pruebamysql.actividad5.modelo.dao;

import pruebamysql.actividad5.modelo.beans.Vuelo;

import java.sql.SQLException;
import java.util.List;

public interface VueloDAO {
    public void insertar(Vuelo vuelo) throws SQLException;

    public boolean buscarPorFechaSalida(Vuelo vuelo) throws SQLException;

    public List buscarOrigen(Vuelo vuelo) throws SQLException;

    public boolean buscarPorDestino(Vuelo vuelo) throws SQLException;
}
