package Model;

import org.json.JSONObject;

public class Banco {

    protected String banco;
    protected String alias;
    protected String cvu;

    public Banco() {
        this.alias = "";
        this.cvu = "";
    }

    public Banco(String alias, String cvu) {
        this.alias = alias;
        this.cvu = cvu;
    }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public String getCvu() { return cvu; }
    public void setCvu(String cvu) { this.cvu = cvu; }

    @Override
    public String toString() {
        return  "BANCO" + "\n" +
                " Alias: " + alias + "\n" +
                " CVU: " + cvu + "\n";
    }

    public JSONObject toJSON() {

        JSONObject jsonBanco = new JSONObject();
        jsonBanco.put("Banco:", this.banco);
        jsonBanco.put("Alias:", this.alias);
        jsonBanco.put("CVU:", this.cvu);

        return jsonBanco;
    }
}
