package Modelo;

import Interface.Generador;
import org.json.JSONObject;

public class Cliente {

    private String id;
    private Persona persona;
    private Banco banco;
    private String tipoCliente; //Nuevo, Existente, Regular, etc.

    public Cliente(Persona persona, Banco banco, String tipoCliente) {
        this.persona = persona;
        this.banco = banco;
        this.tipoCliente = tipoCliente;
        this.id = Generador.generarID("CL");
    }

    public Cliente() {
        this.id = Generador.generarID("CL");
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

    public JSONObject toJSON() {
        JSONObject jsonCliente = new JSONObject();
        jsonCliente.put("ID:", this.id);
        jsonCliente.put("Persona:", this.persona);
        jsonCliente.put("Banco:", this.banco);
        jsonCliente.put("TipoCliente:", this.tipoCliente);

        return jsonCliente;
    }
}
