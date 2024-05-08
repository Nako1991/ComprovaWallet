import java.util.ArrayList;

public class Cuenta {
    private String usuario;
    private String contraseña;
    private String id;
    private ArrayList<BilleteraVirtual> billeterasVirtuales;

    public Cuenta(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.billeterasVirtuales = new ArrayList<>();
    }
    public String getUsuario() { return usuario; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

}
