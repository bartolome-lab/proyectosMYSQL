package pruebamysql.actividad2.controlador;

import pruebamysql.actividad2.modelo.beans.Mascota;
import pruebamysql.actividad2.modelo.dao.MascotaDAO;
import pruebamysql.actividad2.modelo.dao.MascotaDAOImpl;
import pruebamysql.actividad2.vista.VistaConsola;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        MascotaDAO mascotaDAO = new MascotaDAOImpl();

        try {
            mascotaDAO.crearTabla();

            Long idPersona = vista.pedirIdPersona();
            List<Mascota> mascotas = vista.pedirMascotas(idPersona);

            mascotaDAO.guardarTodas(mascotas);
            vista.mostrarMensaje(mascotas.size() + " mascota(s) guardada(s) para la persona " + idPersona);
        } catch (SQLException e) {
            vista.mostrarMensaje("Error con la base de datos: " + e.getMessage());
        }
    }
}
