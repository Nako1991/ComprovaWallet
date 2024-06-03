package Model;

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
}
