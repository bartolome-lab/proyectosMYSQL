package pruebamysql.actividad4.modelo.beans;

public class Mascota {
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private Long idPersona;

    public Mascota() {}

    public Mascota(String nombre, String especie, String raza, Long idPersona) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.idPersona = idPersona;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public Long getIdPersona() { return idPersona; }
    public void setIdPersona(Long idPersona) { this.idPersona = idPersona; }
}
