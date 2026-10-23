package pruebamysql.actividad5.controlador;

import pruebamysql.actividad5.dao.*;
import pruebamysql.actividad5.modelo.beans.Vuelo;
import pruebamysql.actividad5.vista.Vista;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Vista VISTA = new Vista();
    private static final VueloDAO VUELO_DAO = new VueloDAOImpl();
    private static final ClienteDAO CLIENTE_DAO = new ClienteDAOImpl();
    private static final ReservaDAO RESERVA_DAO = new ReservaDAOImpl();

    public static void main(String[] args) {
        int opcion;
        try {

            CLIENTE_DAO.crearTabla();
            VUELO_DAO.crearTabla();
            RESERVA_DAO.crearTabla();

            do {
                opcion = VISTA.solicitarOpcionMenu();
                try {

                    switch (opcion) {
                        case 1 -> darDeAltaVuelo();
                        case 2 -> buscarVuelos();
                        case 3 -> reservarVuelo();
                        case 0 -> mostrarMensajeSalida();
                        default -> mostrarMensajeError();
                    }
                } catch (SQLException e) {
                    VISTA.mostrarMensaje("Ha ocurrido un error SQL: " + e.getMessage());
                }
            } while (opcion != 0);
        } catch (SQLException e) {
            VISTA.mostrarMensaje("Error al crear las tablas: " + e.getMessage());
        }

    }

    private static void darDeAltaVuelo() throws SQLException {
        VUELO_DAO.insertar(VISTA.solicitarDatosVuelo());
        VISTA.mostrarMensaje("El vuelo ha sido insertado correctamente.");
    }

    private static void buscarVuelos() throws SQLException {
        switch (VISTA.solicitarOpcionBusqueda()) {
            case 1 -> VISTA.mostrarVuelos(VUELO_DAO.buscarPorFechaSalida(VISTA.solicitarFecha()));
            case 2 -> VISTA.mostrarVuelos(VUELO_DAO.buscarPorOrigen(VISTA.solicitarCiudad()));
            case 3 -> VISTA.mostrarVuelos(VUELO_DAO.buscarPorDestino(VISTA.solicitarCiudad()));
        }
    }

    private static void reservarVuelo() throws SQLException {
        long codigoCliente = VISTA.solicitarCodigoCliente();
        String codigoVuelo = VISTA.solicitarCodigoVuelo();

        if (RESERVA_DAO.existe(codigoCliente, codigoVuelo)) {
            VISTA.mostrarMensaje("Usted ya ha reservado el vuelo.");
            return;
        }

        if (!CLIENTE_DAO.existe(codigoCliente)) {
            VISTA.mostrarMensaje("El cliente no existe.");
            return;
        }

        if (!VUELO_DAO.descontarPlaza(codigoVuelo)) {
            VISTA.mostrarMensaje("El vuelo no existe o no quedan plazas.");
            return;
        }

        RESERVA_DAO.insertar(codigoCliente, codigoVuelo);
        VISTA.mostrarMensaje("Vuelo reservado correctamente.");
    }

    private static void mostrarMensajeSalida() {
        VISTA.mostrarMensaje("Has salido del programa.");
    }

    private static void mostrarMensajeError() {
        VISTA.mostrarMensaje("Opción no válida.");
    }

}
