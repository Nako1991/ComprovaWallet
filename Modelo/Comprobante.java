package Modelo;
import Interface.Generador;
import org.json.JSONObject;

public class Comprobante {

    private String id;
    private String codigoTransferencia;
    private String fecha;
    private double monto;
    private Banco bancoOrigen;
    private Banco bancoDestino;
    private String estadoDeTransferencia;
    private String estadoDeComprobante;

    public Comprobante() {
        this.id = Generador.generarID("CP");
        this.codigoTransferencia = Generador.generarCodigoDeTransferencia();
        this.fecha = Generador.generadorDeFecha();
        this.monto = Generador.generarMonto();
        this.bancoOrigen = Generador.generarBanco();
        this.bancoDestino = Generador.generarBanco();
        this.estadoDeTransferencia = Generador.generarEstadoDeTransferencia();
        this.estadoDeComprobante = Generador.generarEstadoDeComprobante();
    }

    public Comprobante(Banco bancoOrigen) {
        this.id = Generador.generarID("CP");
        this.codigoTransferencia = Generador.generarCodigoDeTransferencia();
        this.fecha = Generador.generadorDeFecha();
        this.monto = Generador.generarMonto();
        this.bancoOrigen = bancoOrigen;
        this.bancoDestino = Generador.generarBanco();
        this.estadoDeTransferencia = Generador.generarEstadoDeTransferencia();
        this.estadoDeComprobante = Generador.generarEstadoDeComprobante();
    }

    public Comprobante(String id, String codigoTransferencia, String fecha, double monto, Banco bancoOrigen, Banco bancoDestino, String estadoDeTransferencia, String estadoDeComprobante) {
        this.id = id;
        this.codigoTransferencia = codigoTransferencia;
        this.fecha = fecha;
        this.monto = monto;
        this.bancoOrigen = bancoOrigen;
        this.bancoDestino = bancoDestino;
        this.estadoDeTransferencia = estadoDeTransferencia;
        this.estadoDeComprobante = estadoDeComprobante;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCodigoDeTransferencia() { return codigoTransferencia; }
    public void setCodigoTransferencia(String codigoTransferencia) { this.codigoTransferencia = codigoTransferencia; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public Banco getBancoOrigen() { return bancoOrigen; }
    public void setBancoOrigen(Banco bancoOrigen) { this.bancoOrigen = bancoOrigen; }
    public Banco getBancoDestino() { return bancoDestino; }
    public void setBancoDestino(Banco bancoDestino) { this.bancoDestino = bancoDestino; }
    public String getEstadoDeTransferencia() { return estadoDeTransferencia; }
    public void setEstadoDeTransferencia(String estadoDeTransferencia) { this.estadoDeTransferencia = estadoDeTransferencia; }
    public String getEstadoDeComprobante() { return estadoDeComprobante; }
    public void setEstadoDeComprobante(String estadoDeComprobante) { this.estadoDeComprobante = estadoDeComprobante; }

    @Override
    public String toString() {
        return  "COMPROBANTE" + "\n" +
                " Codigo de Transferencia: " + codigoTransferencia + "\n" +
                " Fecha: " + fecha + "\n" +
                " Monto: " + monto + "\n" +
                " Origen: " + bancoOrigen + "\n" +
                " Destino: " + bancoDestino + "\n" +
                " Estado De Transferencia: " + estadoDeTransferencia + "\n" +
                " Estado De Comprobante: " + estadoDeComprobante;
    }

    public JSONObject toJSON() {
        JSONObject jsonComprobante = new JSONObject();
        jsonComprobante.put("ID", this.id);
        jsonComprobante.put("CodigoTransferencia", this.codigoTransferencia);
        jsonComprobante.put("Fecha", this.fecha);
        jsonComprobante.put("Monto", this.monto);
        jsonComprobante.put("Banco Origen", this.bancoOrigen.toJSON());
        jsonComprobante.put("Banco Destino", this.bancoDestino.toJSON());
        jsonComprobante.put("EstadoTransferencia", this.estadoDeTransferencia);
        jsonComprobante.put("EstadoComprobante", this.estadoDeComprobante);

        return jsonComprobante;
    }

    public static Comprobante fromJSON(JSONObject bancoJSON) {
        Banco bancoOrigen = Banco.fromJSON(bancoJSON.getJSONObject("Banco Origen"));
        Banco bancoDestino = Banco.fromJSON(bancoJSON.getJSONObject("Banco Destino"));

        return new Comprobante(
                bancoJSON.getString("ID"),
                bancoJSON.getString("CodigoTransferencia"),
                bancoJSON.getString("Fecha"),
                bancoJSON.getDouble("Monto"),
                bancoOrigen,
                bancoDestino,
                bancoJSON.getString("EstadoTransferencia"),
                bancoJSON.getString("EstadoComprobante"));
    }
}
