import java.util.ArrayList;
import java.util.Random;

public class Usuario implements GeneradorID {

    private String id;
    private String usuario;
    private String contraseña;
    private ArrayList<BilleteraVirtual> billeterasVirtuales;

    public Usuario() {
        this.usuario = "";
        this.contraseña = "";
        this.id = generarID("US");
        this.billeterasVirtuales = new ArrayList<>();
    }

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id = generarID("US");
        this.billeterasVirtuales = new ArrayList<>();
    }

    public String getUsuario() { return usuario; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public void addBilleteraVirtual(BilleteraVirtual billeteraVirtual) { this.billeterasVirtuales.add(billeteraVirtual); }

    @Override
    public String toString() {
        return "CUENTA" + "\n" +
                " Usuario: " + usuario + "\n" +
                " Contraseña: " + contraseña + "\n" +
                " TEST ID UNICO: " + id + "\n" +
                " Billetera Virtual: " + billeterasVirtuales + "\n";
    }
}
