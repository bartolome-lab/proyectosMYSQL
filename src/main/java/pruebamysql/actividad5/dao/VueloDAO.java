package pruebamysql.actividad5.dao;

import pruebamysql.actividad5.modelo.beans.Vuelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface VueloDAO {
    public void insertar(Vuelo vuelo) throws SQLException;

    public List<Vuelo> buscarPorFechaSalida(LocalDate fechaSalida) throws SQLException;

    public List buscarPorOrigen(String ciudadOrigen) throws SQLException;

    public List<Vuelo> buscarPorDestino(String ciudadDestino) throws SQLException;

    public void crearTabla() throws SQLException;

    boolean descontarPlaza(String codigoVuelo) throws SQLException;

}
