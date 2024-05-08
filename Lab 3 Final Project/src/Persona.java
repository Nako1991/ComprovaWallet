public class Persona {
    private String nombreApellido;
    private String cuil;
    private String id;

    public Persona(String nombreApellido, String cuil, String id) {
        this.nombreApellido = nombreApellido;
        this.cuil = cuil;
        this.id = id;
    }
    public String getNombreApellido() { return nombreApellido; }
    public void setNombreApellido(String nombreApellido) { this.nombreApellido = nombreApellido; }
    public String getCuil() { return cuil; }
    public void setCuil(String cuil) { this.cuil = cuil; }
    public String getId() { return id; }

}
