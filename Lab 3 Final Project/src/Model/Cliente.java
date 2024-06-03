package Model;

import org.json.JSONObject;

public class Cliente implements GeneradorID {

    private String id;
    private Persona persona;
    private Banco banco;
    private String tipoCliente; //Nuevo, Existente, Regular, etc.

    public Cliente(Persona persona, Banco banco, String tipoCliente) {
        this.persona = persona;
        this.banco = banco;
        this.tipoCliente = tipoCliente;
        this.id = generarID("CL");
    }

    public Cliente() {
        this.id = generarID("CL");
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
        return "CLIENTE" + "\n" +
                " " + persona + "\n" +
                " " + banco +  "\n" +
                " Tipo cliente: " + tipoCliente + "\n";
    }

    public JSONObject ToJSON(){
        JSONObject cliente = new JSONObject();
        cliente.put("ID", this.id);
        cliente.put("Persona", this.persona.ToJSON());
        cliente.put("Banco", this.banco.ToJSON());
        cliente.put("Tipo Cliente", this.tipoCliente);
        return cliente;
    }
}
