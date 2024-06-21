package Modelo;
import Interface.Generador;
import org.json.JSONObject;

public class BilleteraVirtual {

    private String id;
    private Persona persona;
    private Banco banco;
    private String api;

    public BilleteraVirtual(String id, Persona unaPersona, Banco unBanco, String api) {
        this.persona = unaPersona;
        this.banco = unBanco;
        this.api = api;
        this.id = id;
    }

    public BilleteraVirtual(Persona unaPersona, Banco unBanco) {
        this.persona = unaPersona;
        this.banco = unBanco;
        this.api = Generador.generarAPI();
        this.id = Generador.generarID("BV");
    }

    public String getId() { return id; }
    public Persona getPersona() { return persona; }
    public Banco getBanco() { return banco; }
    public String getApi() { return api; }
    public void setApi(String api) { this.api = api; }

    @Override
    public String toString() {
        return  "BILLETERA VIRTUAL" + "\n" +
                " " + persona + "\n" +
                " " + banco + "\n" +
                " ID: "+ id + "\n" +
                " API: " + api + "\n";
    }

    public JSONObject toJSON() {
        JSONObject jsonBilleteraVirtual = new JSONObject();
        jsonBilleteraVirtual.put("ID", this.id);
        jsonBilleteraVirtual.put("Persona", this.persona.toJSON());
        jsonBilleteraVirtual.put("Banco", this.banco.toJSON());
        jsonBilleteraVirtual.put("API", this.api);

        return jsonBilleteraVirtual;
    }

    public static BilleteraVirtual fromJSON(JSONObject billeteraVirtual) {

        String id = billeteraVirtual.getString("ID");
        Persona persona = Persona.fromJSON(billeteraVirtual.getJSONObject("Persona"));
        Banco banco = Banco.fromJSON(billeteraVirtual.getJSONObject("Banco"));
        String api = billeteraVirtual.getString("API");

        return new BilleteraVirtual(
                id,
                persona,
                banco,
                api);
    }
}
