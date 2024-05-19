import java.util.Random;

public class BilleteraVirtual implements GeneradorID{
    private String id;
    private Persona unaPersona;
    private Banco unBanco;
    private String api;

    public BilleteraVirtual(Persona unaPersona, Banco unBanco, String api) {
        this.unaPersona = unaPersona;
        this.unBanco = unBanco;
        this.api = api;
        this.id = generarID();
    }
    public String getId() { return id; }
    public Persona getUnaPersona() { return unaPersona; }
    public Banco getUnBanco() { return unBanco; }
    public String getApi() { return api; }
    public void setApi(String api) { this.api = api; }

    @Override
    public String toString() {
        return "\nBILLETERA VIRTUAL" + '\n' +
                unaPersona + '\n' +
                unBanco + '\n' +
                "\nID UNICO BILLETERA VIRTUAL TEST "+ id + '\n' +
                " API: " + api + '\n';
    }
    @Override
    public String generarID() {
        String letraIncial = "B";
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
