import java.util.Date;

public class Comprobante implements GeneradorID {

    private String id;
    private String codigoTransferencia;
    private Date fecha;
    private double monto;
    private Banco bancoOrigen;
    private Banco bancoDestino; //banco usuario
    private String estado;

    public Comprobante(String codigoTransferencia, Date fecha, double monto, Banco bancoOrigen, Banco bancoDestino, String estado) {
        this.id = generarID("CP");
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
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
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
                " Banco Origen: " + bancoOrigen + "\n" +
                " Banco Destino: " + bancoDestino + "\n" +
                " Estado: " + estado + "\n";
    }
}
