package pruebamysql.actividad5.controlador;

import pruebamysql.actividad5.modelo.beans.Vuelo;
import pruebamysql.actividad5.modelo.dao.*;
import pruebamysql.actividad5.vista.Vista;

import java.sql.SQLException;

public class Main {
    private static final Vista VISTA = new Vista();
    private static final VueloDAO VUELO_DAO = new VueloDAOImpl();
    private static final ClienteDAO CLIENTE_DAO = new ClienteDAOImpl();
    private static final ReservaDAO RESERVA_DAO = new ReservaDAOImpl();

    public static void main(String[] args) {


        try {
            switch (VISTA.solicitarOpcionMenu()) {
                case 1 -> darDeAltaVuelo();
                case 2 -> buscarVuelos();
                case 3 ->
            }
        } catch (SQLException e) {
            VISTA.mostrarMensaje("Ha ocurrido un error SQL: " + e);
        }
    }

    private static void darDeAltaVuelo() throws SQLException {
        Vuelo vuelo = new Vuelo(VISTA.solicitarDatosVuelo());
        VUELO_DAO.crearTabla();
        VUELO_DAO.insertar(vuelo);
    }

    private static void buscarVuelos() throws SQLException {
        switch (VISTA.solicitarOpcionBusqueda()) {
            case 1 -> VUELO_DAO.buscarPorFechaSalida(VISTA.solicitarFecha());
            case 2 -> VUELO_DAO.buscarPorOrigen(VISTA.solicitarCiudad());
            case 3 -> VUELO_DAO.buscarPorDestino(VISTA.solicitarCiudad());
            default -> VISTA.solicitarOpcionMenu();
        }
    }

    private static void listarVuelos() {

    }

}
