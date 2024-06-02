import java.util.ArrayList;
import java.util.Random;

public class Usuario implements GeneradorID{
    private String id;
    private String usuario;
    private String contraseña;
    private ArrayList<BilleteraVirtual> billeterasVirtuales;

    public Usuario() {
        this.usuario = "";
        this.contraseña = "";
        this.billeterasVirtuales = new ArrayList<>();
    }
    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id = generarID();
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

    @Override
    public String generarID() {
        String letraIncial = "U";
        int longitudId = 15;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(letraIncial);
        for(int i = 1; i < longitudId; i++) sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        String idUnico = String.valueOf(sb);
        return idUnico;
    }
}
