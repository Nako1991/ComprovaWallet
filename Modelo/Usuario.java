package Modelo;
import Interface.Generador;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Usuario {

    private String id;
    private String usuario;
    private String contraseña;
    private ArrayList<BilleteraVirtual> billeterasVirtuales;
    private ArrayList<Comprobante> historialDeComprobantes;

    public Usuario() {
        this.id = Generador.generarID("US");
        this.usuario = "";
        this.contraseña = "";
        this.billeterasVirtuales = new ArrayList<>();
        this.historialDeComprobantes = new ArrayList<>();
    }

    public Usuario(String usuario, String contraseña) {
        this.id = Generador.generarID("US");
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.billeterasVirtuales = new ArrayList<>();
        this.historialDeComprobantes = new ArrayList<>();
    }

    public Usuario(String id, String usuario, String contraseña, ArrayList<BilleteraVirtual> billeterasVirtuales, ArrayList<Comprobante> historialDeComprobantes) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.billeterasVirtuales = billeterasVirtuales;
        this.historialDeComprobantes = historialDeComprobantes;
    }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public ArrayList<BilleteraVirtual> getBilleterasVirtuales() { return billeterasVirtuales; }
    public void setBilleterasVirtuales(ArrayList<BilleteraVirtual> billeterasVirtuales) { this.billeterasVirtuales = billeterasVirtuales; }

    @Override
    public String toString() {
        return  "CUENTA" + "\n" +
                " Usuario: " + usuario + "\n" +
                " Contraseña: " + contraseña + "\n" +
                " Billeteras Virtuales: " + billeterasVirtuales + "\n" +
                " Comprobantes: " + billeterasVirtuales + "\n";
    }

    public JSONObject toJSON() {

        JSONObject jsonUsuario = new JSONObject();
        jsonUsuario.put("ID", this.id);
        jsonUsuario.put("Usuario", this.usuario);
        jsonUsuario.put("Contraseña", this.contraseña);

        JSONArray jsonBilleteras = new JSONArray();
        for(BilleteraVirtual billeteraBuffer : this.billeterasVirtuales) {
            jsonBilleteras.put(billeteraBuffer.toJSON());
        }
        jsonUsuario.put("Billeteras", jsonBilleteras);

        JSONArray jsonHistorialDeComprobantes = new JSONArray();
        for(Comprobante comprobanteBuffer : this.historialDeComprobantes) {
            jsonHistorialDeComprobantes.put(comprobanteBuffer.toJSON());
        }
        jsonUsuario.put("Comprobantes", jsonHistorialDeComprobantes);

        return jsonUsuario;
    }

    public static Usuario fromJSON(JSONObject usuarioJSON) {

        String id = usuarioJSON.getString("ID");
        String usuario = usuarioJSON.getString("Usuario");
        String contraseña = usuarioJSON.getString("Contraseña");

        JSONArray billeterasVirtualesJSON = usuarioJSON.getJSONArray("Billeteras");
        ArrayList<BilleteraVirtual> billeterasVirtuales = new ArrayList<>();
        for(int i = 0; i < billeterasVirtualesJSON.length(); i++) {
            billeterasVirtuales.add(BilleteraVirtual.fromJSON(billeterasVirtualesJSON.getJSONObject(i)));
        }

        JSONArray comprobantesJSON = usuarioJSON.getJSONArray("Comprobantes");
        ArrayList<Comprobante> comprobantes = new ArrayList<>();
        for(int i = 0; i < comprobantesJSON.length(); i++) {
            comprobantes.add(Comprobante.fromJSON(comprobantesJSON.getJSONObject(i)));
        }

        return new Usuario(
                id,
                usuario,
                contraseña,
                billeterasVirtuales,
                comprobantes);
    }
}
