package pruebamysql.actividad5.modelo.beans;

import java.time.LocalDateTime;

public class Vuelo {
    private long codigoVuelo;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDateTime fechaYHoraLlegada;
    private LocalDateTime fechaYHoraSalida;
    private int numeroPlazaslibres;

    public Vuelo(long codigoVuelo, String ciudadOrigen, String ciudadDestino, LocalDateTime fechaYHoraLlegada, LocalDateTime fechaYHoraSalida, int numeroPlazaslibres) {
        this.codigoVuelo = codigoVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaYHoraLlegada = fechaYHoraLlegada;
        this.fechaYHoraSalida = fechaYHoraSalida;
        this.numeroPlazaslibres = numeroPlazaslibres;
    }

    public long getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(long codigoVuelo) {
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

    public int getNumeroPlazaslibres() {
        return numeroPlazaslibres;
    }

    public void setNumeroPlazaslibres(int numeroPlazaslibres) {
        this.numeroPlazaslibres = numeroPlazaslibres;
    }
}
