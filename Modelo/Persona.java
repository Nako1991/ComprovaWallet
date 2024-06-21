package Modelo;
import Interface.Generador;
import org.json.JSONObject;

public class Persona {

    private String id;
    private String nombreApellido;
    private String cuil;

    public Persona(String nombreApellido) {
        this.nombreApellido = nombreApellido;
        this.cuil = Generador.generarCuil();
        this.id = Generador.generarID("PS");
    }

    public Persona(String id, String nombreApellido, String cuil) {
        this.id = id;
        this.nombreApellido = nombreApellido;
        this.cuil = cuil;
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

    public JSONObject toJSON() {
        JSONObject jsonPersona = new JSONObject();
        jsonPersona.put("ID", this.id);
        jsonPersona.put("Nombre", this.nombreApellido);
        jsonPersona.put("CUIL", this.cuil);

        return jsonPersona;
    }

    public static Persona fromJSON(JSONObject personaJSON) {
        return new Persona(personaJSON.getString("ID"), personaJSON.getString("Nombre"), personaJSON.getString("CUIL"));
    }
}
