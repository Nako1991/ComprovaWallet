package Model;

import org.json.JSONObject;

public class Banco {

    protected String banco;
    protected String alias;
    protected String cvu;

    public Banco() {
        this.banco = "";
        this.alias = "";
        this.cvu = "";
    }

    public Banco(String banco, String alias, String cvu) {
        this.banco = banco;
        this.alias = alias;
        this.cvu = cvu;
    }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public String getCvu() { return cvu; }
    public void setCvu(String cvu) { this.cvu = cvu; }
    public String getBanco() { return banco; }
    public void setBanco(String banco) {  this.banco = banco; }

    @Override
    public String toString() {
        return  "BANCO" + "\n" +
                " Alias: " + alias + "\n" +
                " CVU: " + cvu + "\n";
    }

    public JSONObject toJSON() {

        JSONObject jsonBanco = new JSONObject();
        jsonBanco.put("Banco", this.banco);
        jsonBanco.put("Alias", this.alias);
        jsonBanco.put("CVU", this.cvu);

        return jsonBanco;
    }

    public static Banco fromJSON(JSONObject bancoJSON) {
        return new Banco(
                bancoJSON.getString("Banco"),
                bancoJSON.getString("Alias"),
                bancoJSON.getString("CVU"));
    }
}
