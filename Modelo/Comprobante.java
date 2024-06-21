package Modelo;
import Interface.Generador;
import org.json.JSONObject;

public class Comprobante {

    private String id;
    private String codigoTransferencia;
    private String fecha; //Se tiene que modificar a tipo DATE. Lo modificamos por el fromJSON
    private double monto;
    private Banco bancoOrigen;
    private Banco bancoDestino;
    private String estado;

    public Comprobante(String codigoTransferencia, String fecha, double monto, Banco bancoOrigen, Banco bancoDestino, String estado) {
        this.id = Generador.generarID("CP");
        this.codigoTransferencia = codigoTransferencia;
        this.fecha = fecha;
        this.monto = monto;
        this.bancoOrigen = bancoOrigen;
        this.bancoDestino = bancoDestino;
        this.estado = estado;
    }

    public Comprobante(String id, String codigoTransferencia, String fecha, double monto, Banco bancoOrigen, Banco bancoDestino, String estado) {
        this.id = id;
        this.codigoTransferencia = codigoTransferencia;
        this.fecha = fecha;
        this.monto = monto;
        this.bancoOrigen = bancoOrigen;
        this.bancoDestino = bancoDestino;
        this.estado = estado;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCodigoTransferencia() { return codigoTransferencia; }
    public void setCodigoTransferencia(String codigoTransferencia) { this.codigoTransferencia = codigoTransferencia; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public Banco getBancoOrigen() { return bancoOrigen; }
    public void setBancoOrigen(Banco bancoOrigen) { this.bancoOrigen = bancoOrigen; }
    public Banco getBancoDestino() { return bancoDestino; }
    public void setBancoDestino(Banco bancoDestino) { this.bancoDestino = bancoDestino; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return  "COMPROBANTE" + "\n" +
                " Codigo de Transferencia: " + codigoTransferencia + "\n" +
                " Fecha: " + fecha + "\n" +
                " Monto: " + monto + "\n" +
                " Model.Banco Origen: " + bancoOrigen + "\n" +
                " Model.Banco Destino: " + bancoDestino + "\n" +
                " Estado: " + estado + "\n";
    }

    public JSONObject toJSON() {
        JSONObject jsonComprobante = new JSONObject();
        jsonComprobante.put("ID", this.id);
        jsonComprobante.put("CodigoTransferencia", this.codigoTransferencia);
        jsonComprobante.put("Fecha", this.fecha);
        jsonComprobante.put("Monto", this.monto);
        jsonComprobante.put("Banco Origen", this.bancoOrigen);
        jsonComprobante.put("Banco Destino", this.bancoDestino);
        jsonComprobante.put("Estado", this.estado);

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
                bancoJSON.getString("Estado"));
    }
}
