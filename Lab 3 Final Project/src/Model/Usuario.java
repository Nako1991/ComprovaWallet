package Model;

import Interface.GeneradorID;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario implements GeneradorID {

    private String id;
    private String usuario;
    private String contraseña;
    private ArrayList<BilleteraVirtual> billeterasVirtuales;
    private ArrayList<Comprobante> historialDeComprobantes;

    public Usuario() {
        this.usuario = "";
        this.contraseña = "";
        this.id = generarID("US");
        this.billeterasVirtuales = new ArrayList<>();
        this.historialDeComprobantes = new ArrayList<>();
    }

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id = generarID("US");
        this.billeterasVirtuales = new ArrayList<>();
        this.historialDeComprobantes = new ArrayList<>();
    }

    public String getUsuario() { return usuario; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public String toString() {
        return "CUENTA" + "\n" +
                " TEST ID UNICO: " + id + "\n" +
                " Contraseña: " + contraseña + "\n" +
                " Billetera Virtuales: " + billeterasVirtuales + "\n" +
                " Comprobantes: " + billeterasVirtuales + "\n";
    }

    public JSONObject toJSON() {

        JSONObject jsonUsuario = new JSONObject();
        jsonUsuario.put("ID:", this.id);
        jsonUsuario.put("Usuario:", this.usuario);
        jsonUsuario.put("Contraseña:", this.contraseña);

        JSONArray jsonBilleteras = new JSONArray();
        for(BilleteraVirtual billeteraBuffer : this.billeterasVirtuales) {
            jsonBilleteras.put(billeteraBuffer.toJSON());
        }
        jsonUsuario.put("Billeteras:", jsonBilleteras);

        JSONArray jsonHistorialDeComprobantes = new JSONArray();
        for(Comprobante comprobanteBuffer : this.historialDeComprobantes) {
            jsonHistorialDeComprobantes.put(comprobanteBuffer.toJSON());
        }
        jsonUsuario.put("Comprobantes:", jsonHistorialDeComprobantes);

        return jsonUsuario;
    }

    public void addBilleteraVirtual(BilleteraVirtual billeteraVirtual) {
        this.billeterasVirtuales.add(billeteraVirtual);
    }
}
