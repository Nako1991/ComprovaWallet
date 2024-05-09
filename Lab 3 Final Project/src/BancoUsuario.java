public class BancoUsuario extends Banco {
    private double saldo;

    public BancoUsuario(String alias, String cvu, double saldo) {
        super(alias, cvu);
        this.saldo = saldo;
    }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    @Override
    public String toString() {
        return "\n Saldo: " + saldo + "\n";
    }
}
