package Model;

import org.json.JSONObject;

public class BilleteraVirtual implements GeneradorID {

    private String id;
    private Persona unaPersona;
    private Banco unBanco;
    private String api;

    public BilleteraVirtual(Persona unaPersona, Banco unBanco, String api) {
        this.unaPersona = unaPersona;
        this.unBanco = unBanco;
        this.api = api;
        this.id = generarID("BV");
    }

    public String getId() { return id; }
    public Persona getUnaPersona() { return unaPersona; }
    public Banco getUnBanco() { return unBanco; }
    public String getApi() { return api; }
    public void setApi(String api) { this.api = api; }

    @Override
    public String toString() {
        return  "BILLETERA VIRTUAL" + "\n" +
                " " + unaPersona + "\n" +
                " " + unBanco + "\n" +
                " ID UNICO BILLETERA VIRTUAL TEST "+ id + "\n" +
                " API: " + api + "\n";
    }

    public JSONObject toJSON() {

        JSONObject jsonBilleteraVirtual = new JSONObject();
        jsonBilleteraVirtual.put("ID:", this.id);
        jsonBilleteraVirtual.put("Persona:", this.unaPersona.toJSON());
        jsonBilleteraVirtual.put("Banco:", this.unBanco.toJSON());
        jsonBilleteraVirtual.put("API: ", this.api);

        return jsonBilleteraVirtual;
    }
}
