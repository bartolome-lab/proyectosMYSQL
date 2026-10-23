package pruebamysql.actividad5.modelo.beans;

import java.time.LocalDateTime;

public class Vuelo {
    private String codigoVuelo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDateTime fechaYHoraLlegada;
    private LocalDateTime fechaYHoraSalida;
    private int numeroPlazasLibres;

    public Vuelo(String codigoVuelo, String ciudadOrigen, String ciudadDestino, LocalDateTime fechaYHoraLlegada, LocalDateTime fechaYHoraSalida, int numeroPlazasLibres) {
        this.codigoVuelo = codigoVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaYHoraLlegada = fechaYHoraLlegada;
        this.fechaYHoraSalida = fechaYHoraSalida;
        this.numeroPlazasLibres = numeroPlazasLibres;
    }

    public Vuelo(Vuelo vuelo) {
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public LocalDateTime getFechaYHoraLlegada() {
        return fechaYHoraLlegada;
    }

    public void setFechaYHoraLlegada(LocalDateTime fechaYHoraLlegada) {
        this.fechaYHoraLlegada = fechaYHoraLlegada;
    }

    public LocalDateTime getFechaYHoraSalida() {
        return fechaYHoraSalida;
    }

    public void setFechaYHoraSalida(LocalDateTime fechaYHoraSalida) {
        this.fechaYHoraSalida = fechaYHoraSalida;
    }

    public int getNumeroPlazasLibres() {
        return numeroPlazasLibres;
    }

    public void setNumeroPlazasLibres(int numeroPlazasLibres) {
        this.numeroPlazasLibres = numeroPlazasLibres;
    }

    @Override
    public String toString() {
        return "Código de vuelo: " + codigoVuelo
                + "\nciudad de origen: " + ciudadOrigen
                + "\nciudad de destino: " + ciudadDestino
                + "\nfecha y hora de salida: " + fechaYHoraSalida
                + "\nfecha y hora de llegada: " + fechaYHoraLlegada
                + "\nnúmero de plazas libres: " + numeroPlazasLibres;
    }
}
