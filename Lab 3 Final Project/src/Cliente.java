import java.util.Random;

public class Cliente implements GeneradorID{
    private String id;
    private Persona persona;
    private Banco banco;
    private String tipoCliente; //Nuevo, Existente, Regular, etc.

    public Cliente(String id, Persona persona, Banco banco, String tipoCliente) {
        this.id = id;
        this.persona = persona;
        this.banco = banco;
        this.tipoCliente = tipoCliente;
        this.id = generarID();
    }

    public Cliente() {
        this.id = "";
        this.persona = null;
        this.tipoCliente = "";
        this.banco = null;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }
    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }
    public Banco getBanco() { return banco; }
    public void setBanco(Banco banco) { this.banco = banco; }

    @Override
    public String toString() {
        return "CLIENTE" + '\n' +
                persona + '\n' +
                banco + '\n' +
                " Tipo cliente: " + tipoCliente + '\n';
    }

    @Override
    public String generarID() {
        String letraIncial = "C";
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
