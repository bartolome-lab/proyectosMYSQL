package pruebamysql.actividad5.modelo.beans;

public class Cliente {
    private long codigoCliente;
    private String nombreCompleto;

    public Cliente(long codigoCliente, String nombreCompleto) {
        this.codigoCliente = codigoCliente;
        this.nombreCompleto = nombreCompleto;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
