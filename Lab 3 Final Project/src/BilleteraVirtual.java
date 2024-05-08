public class BilleteraVirtual {
    private String id;
    private Persona unaPersona;
    private Banco unBanco;
    private String api;

    public BilleteraVirtual(String id, Persona unaPersona, Banco unBanco, String api) {
        this.id = id;
        this.unaPersona = unaPersona;
        this.unBanco = unBanco;
        this.api = api;
    }
    public String getId() { return id; }
    public Persona getUnaPersona() { return unaPersona; }
    public Banco getUnBanco() { return unBanco; }
    public String getApi() { return api; }
    public void setApi(String api) { this.api = api; }


}
