package pruebamysql.actividad5.vista;

import pruebamysql.actividad5.modelo.beans.Vuelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Vista {

    private static final Scanner TECLADO = new Scanner(System.in);

    public int solicitarOpcionMenu() {
        System.out.print("""
                1 - Dar de alta un vuelo.
                2 - Buscar vuelo.
                3 - Reservar un vuelo.
                0 - Salir.
                Seleccione una opción: 
                """);
        return Integer.parseInt(TECLADO.nextLine());
    }

    public int solicitarOpcionBusqueda() {
        System.out.print("""
                1 - Fecha salida.
                2 - Ciudad de origen.
                3 - Ciudad de destino.
                0 - Volver.
                Seleccione cómo quiere buscar el vuelo: 
                """);
        return Integer.parseInt(TECLADO.nextLine());
    }

    public String solicitarCiudad() {
        System.out.println("Escriba la ciudad: ");
        return TECLADO.nextLine();
    }

    public LocalDate solicitarFecha() {
        System.out.println("Escriba una fecha (ejemplo: 2010-10-20): ");
        return LocalDate.parse(TECLADO.nextLine());
    }

    public void mostrarVuelos(List<Vuelo> vuelos) {
        if (vuelos.isEmpty()) {
            System.out.println("No se han encontrado vuelos.");
        }
        for (Vuelo vuelo : vuelos) {
            System.out.println(vuelo);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String solicitarCodigoVuelo() {
        System.out.println("Escriba el código del vuelo: ");
        return TECLADO.nextLine();
    }

    public long solicitarCodigoCliente() {
        System.out.println("Escriba el código del cliente: ");
        return Long.parseLong(TECLADO.nextLine());
    }

    public Vuelo solicitarDatosVuelo() {
        String codigoVuelo = solicitarCodigoVuelo();
        System.out.println("Escriba la ciudad de origen del vuelo: ");
        String ciudadOrigen = TECLADO.nextLine();
        System.out.println("Escriba la ciudad de destino del vuelo: ");
        String ciudadDestino = TECLADO.nextLine();
        System.out.println("Escriba la fecha y hora de salida del vuelo (ejemplo: 2026-12-03T10:30): ");
        LocalDateTime fechaYHoraSalida = LocalDateTime.parse(TECLADO.nextLine());
        System.out.println("Escriba la fecha y la hora de llegada del vuelo (ejemplo: 2026-12-04T11:45): ");
        LocalDateTime fechaYHoraLlegada = LocalDateTime.parse(TECLADO.nextLine());
        System.out.println("Escriba el número de plazas del vuelo: ");
        int numeroPlazas = Integer.parseInt(TECLADO.nextLine());
        return new Vuelo(codigoVuelo, ciudadOrigen, ciudadDestino, fechaYHoraLlegada, fechaYHoraSalida, numeroPlazas);
    }

}