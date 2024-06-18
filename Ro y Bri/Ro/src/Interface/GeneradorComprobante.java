package Interface;
import Model.Banco;
import Model.BilleteraVirtual;
import Model.Comprobante;
import Model.Usuario;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public interface GeneradorComprobante {

    //Del arreglo de billeteras virtuales, el usuarioLogueado tendrá una abierta a la cual le llegarán comprobantes
    //Por el momento, bancoOrigen va a tener la primer billetera virtual del usuario logueado. Completar la parte lógica para que funcione correctamente
    static Comprobante generarComprobanteAleatorio(Usuario usuarioLogueado) {

        String[] nombreBancos = {
            "Mercado Pago",
            "Ualá",
            "Cuenta DNI",
            "BNA+",
            "Modo",
            "Banco Patagonia",
            "Brubank",
            "Naranja x",
            "Banco Francés",
            "Prex",
            "Banco Supervielle",
            "Personal Pay"
        };

        String[] estadosTransferencia = {
            "Enviada",
            "Pendiente",
            "Rechazada"
        };

        Random random = new Random();

        String codigoTransferencia = generarCodigoTransferencia(random);
        String fechaTransderencia = generarFecha();
        double montoTransferencia = generarMonto(random);
        Banco bancoOrigen = generarBancoOrigenAleatorio(usuarioLogueado, random);
        Banco bancoDestino = generarBancoDestinoAleatorio(random, nombreBancos);
        String estadoTransferencia = generarEstadoTransferencia(estadosTransferencia, random);

        return new Comprobante(codigoTransferencia, fechaTransderencia, montoTransferencia, bancoOrigen, bancoDestino, estadoTransferencia);
    }

    static String generarCodigoTransferencia(Random random) {

        String digitos = "0123456789";
        int longuitudCodigoTransferencia = 11;
        StringBuilder codigoTransferenciaBuffer = new StringBuilder();

        for(int i = 0; i < longuitudCodigoTransferencia; i++)
            codigoTransferenciaBuffer.append(digitos.charAt(random.nextInt(digitos.length())));

        String codigoTransferencia = String.valueOf(codigoTransferenciaBuffer);
        return codigoTransferencia;
    }

    static String generarFecha() {

        // Fecha inicial: 24 de junio de 2023
        long minimoDia = new GregorianCalendar(2023, Calendar.JUNE, 24).getTimeInMillis();
        // Fecha final: fecha actual
        long maximoDia = System.currentTimeMillis();
        long diaRandom = ThreadLocalRandom.current().nextLong(minimoDia, maximoDia);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(new Date(diaRandom));
    }

    static double generarMonto(Random random) {
        return 1000.0 + (5000.0 - 1000.0) * random.nextDouble();
    }

    //Revisar este método por completo
    static Banco generarBancoOrigenAleatorio(Usuario usuarioLogueado, Random random) {

        ArrayList<BilleteraVirtual> billeterasVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();

        if(billeterasVirtualesBuffer != null || !(billeterasVirtualesBuffer.isEmpty())) {

            int indexAleatorio = random.nextInt(billeterasVirtualesBuffer.size());
            return billeterasVirtualesBuffer.get(indexAleatorio).getUnBanco();
        }
        return null;
    }

    static Banco generarBancoDestinoAleatorio(Random random, String[] nombreBancos) {

        String nombreBanco = nombreBancos[random.nextInt(nombreBancos.length)];
        String alias = "Pepita123"; //Aquí habria que implementar la interfaz que genera el alias aleatorio

        return new Banco(nombreBanco, alias);
    }

    static String generarEstadoTransferencia(String[] estadosTransferencia, Random random) {

        int indexAleatorio = random.nextInt(estadosTransferencia.length);
        return estadosTransferencia[indexAleatorio];
    }
}
