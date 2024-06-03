package Model;

public class Persona implements GeneradorID {

    private String id;
    private String nombreApellido;
    private String cuil;

    public Persona(String nombreApellido, String cuil) {
        this.nombreApellido = nombreApellido;
        this.cuil = cuil;
        this.id = generarID("PS");
    }

    public String getNombreApellido() { return nombreApellido; }
    public void setNombreApellido(String nombreApellido) { this.nombreApellido = nombreApellido; }
    public String getCuil() { return cuil; }
    public void setCuil(String cuil) { this.cuil = cuil; }
    public String getId() { return id; }

    @Override
    public String toString() {
        return "PERSONA" + '\n' +
                " Nombre y Apellido: " + nombreApellido + "\n" +
                " ID UNICO TEST: " + id + "\n" +
                " Cuil: " + cuil + "\n";
    }
}
