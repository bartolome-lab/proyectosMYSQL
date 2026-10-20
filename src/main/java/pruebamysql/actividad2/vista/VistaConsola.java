package pruebamysql.actividad2.vista;

import pruebamysql.actividad2.modelo.beans.Mascota;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VistaConsola {

    private final Scanner teclado = new Scanner(System.in);

    public Long pedirIdPersona() {
        return Long.parseLong(pedirTexto("Id de la persona: "));
    }

    public List<Mascota> pedirMascotas(Long idPersona) {
        List<Mascota> mascotas = new ArrayList<>();
        do {
            mascotas.add(pedirMascota(idPersona));
        } while (quiereOtra());
        return mascotas;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    private Mascota pedirMascota(Long idPersona) {
        String nombre = pedirTexto("Nombre: ");
        String especie = pedirTexto("Especie: ");
        String raza = pedirTexto("Raza: ");
        return new Mascota(nombre, especie, raza, idPersona);
    }

    private boolean quiereOtra() {
        return pedirTexto("¿Añadir otra mascota? (s/n): ").equalsIgnoreCase("s");
    }

    private String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine().trim();
    }
}
