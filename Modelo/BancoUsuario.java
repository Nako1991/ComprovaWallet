package Modelo;//package Model;
//
//import org.json.JSONObject;
//
//public class BancoUsuario extends Banco {
//
//    private double saldo;
//
//    public BancoUsuario(String alias, String cvu, double saldo) {
//        super(alias, cvu);
//        this.saldo = saldo;
//    }
//
//    public double getSaldo() { return saldo; }
//    public void setSaldo(double saldo) { this.saldo = saldo; }
//
//    @Override
//    public String toString() {
//        return " Saldo: " + saldo + "\n";
//    }
//
//    public JSONObject toJSON() {
//
//        JSONObject jsonBancoUsuario = new JSONObject();
//        jsonBancoUsuario.put("Banco:", this.banco);
//        jsonBancoUsuario.put("Alias:", this.alias);
//        jsonBancoUsuario.put("CVU:", this.cvu);
//        jsonBancoUsuario.put("Saldo:", this.saldo);
//
//        return jsonBancoUsuario;
//    }
//}
