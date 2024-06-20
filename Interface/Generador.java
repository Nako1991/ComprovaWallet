package Interface;

import Exceptions.Validaciones;
import Modelo.*;

import java.util.*;

public interface Generador {

    static String generarAlias() {

        String[] palabras = {

                "Cirujano", "Arena","Pasado","Flores","Basto","Juicio","Tablero","Alfajor","Florero","Mochila",
                "Abrigo","Reina","Remo","Matemática","Olímpico","Escoba","Vestuario","Silo","Fideos","Ropa",
                "Gaseosa","Guiñar","Grueso","Canguro","Jabón","Altura","Gemelo","Felicidad","Funcionario",
                "Amarillo","Alma","Lagarto","Pantalón","Limón","Lava","Mariposa","Dado","Aluminio","Aire",
                "Mesa","Fino","Entero","Lupa","Consulta","Cruz","Canal","Armario","Baul","Diamante", "Brisa","Rocio",
                "Nako","Hacker","Arajo","Baraja","Turno","Marisco","Arado","Espalda","Biceps","Abogado","Brocolí",
                "Zanahoria","Zapallo","Tomate","Lechuga","Carne","Pollo","Gato","Perro","Lobo","Pajaro","Cantar","Hueco",
                "Cucurucho","Ardilla","Horizonte","Internet","Robo","Arrastrar","Oficial","Joya","Anillo","Reloj","Corazón",
                "Anteojos","León","Ardilla","Tiburón","Pescado","Tinta","Belleza","Fibra","Color","Rabino","Alucinar","Marihuana",
                "Maiz","Cogollo","Flota","Auto","Moto","Barco","Puñetazo","Mosca","Pelo","Flecha","Arco","Volante","Puerta","Madera"
        };

        int longitud = 2;
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < longitud; i++){
            sb.append(palabras[rand.nextInt(palabras.length)]);
            if(i < longitud - 1)  sb.append(".");
        }
        return String.valueOf(sb);
    }

    static String generarAPI() {

        int longitud = 15;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < longitud; i++) sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        String api = String.valueOf(sb);
        return api;
    }

    static String generarCVU(HashMap<String, Usuario> repositorio) {

        String digitos = "0123456789";
        int longuitudCVU = 22;
        StringBuilder cvuBuffer = new StringBuilder();
        Random random = new Random();
        String cvuValido = "";
        boolean resultadoValidacion;

        do {
            try {
                for(int i = 0; i < longuitudCVU; i++) {
                    cvuBuffer.append(digitos.charAt(random.nextInt(digitos.length())));
                }
                cvuValido = String.valueOf(cvuBuffer);
                Validaciones.invalidCVUAlreadyExists(cvuValido, repositorio);
                resultadoValidacion = true;
            }
            catch(Exception exception) {
                System.out.println("\nError: " + exception.getMessage());
                resultadoValidacion = false;
            }
        }while(!resultadoValidacion);

        return cvuValido;
    }

    static String generarID(String identificadorDeClase) {

        int longitudId = 15;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(identificadorDeClase);
        for(int i = 1; i < longitudId; i++) sb.append(caracteres.charAt(random.nextInt(caracteres.length())));
        String idUnico = String.valueOf(sb);
        return idUnico;
    }

    static String generarNombreBanco() {

        Random random = new Random();
        NombresBancos[] nombreBancos = NombresBancos.values();
        NombresBancos nombreBanco = nombreBancos[random.nextInt(nombreBancos.length)];
        String nombreBancoString = formatearDeEnumAString(nombreBanco.name());

        return nombreBancoString;
    }

    static String generarNombreYApellido() {

        Random random = new Random();

        String nombreYApellido = "";

        int hombreOMujer = random.nextInt(0, 2);

        int unoODosNombres = random.nextInt(1, 3);

        int unoODosApellidos = random.nextInt(1, 3);

        if ( hombreOMujer == 0 ) {

            NombresVarones[] nombresVarones = NombresVarones.values();
            NombresVarones nombreVaron1 = nombresVarones[random.nextInt(nombresVarones.length)];
            NombresVarones nombreVaron2 = nombresVarones[random.nextInt(nombresVarones.length)];

            if ( unoODosNombres == 1 )
                nombreYApellido = formatearDeEnumAString(nombreVaron1.name()) + " ";

            else if( unoODosNombres == 2 )
                nombreYApellido = formatearDeEnumAString(nombreVaron1.name()) + " " +  formatearDeEnumAString(nombreVaron2.name()) + " ";
        }
        else if ( hombreOMujer == 1 ) {

            NombresMujeres[] nombresMujeres = NombresMujeres.values();
            NombresMujeres nombreMujer1 = nombresMujeres[random.nextInt(nombresMujeres.length)];
            NombresMujeres nombreMujer2 = nombresMujeres[random.nextInt(nombresMujeres.length)];

            if ( unoODosNombres == 1 )
                nombreYApellido = formatearDeEnumAString(nombreMujer1.name()) + " ";

            else if( unoODosNombres == 2 )
                nombreYApellido = formatearDeEnumAString(nombreMujer2.name()) + " " + formatearDeEnumAString(nombreMujer2.name()) + " ";

        }

        Apellidos[] apellidos = Apellidos.values();
        Apellidos apellido1 = apellidos[random.nextInt(apellidos.length)];

        if ( unoODosApellidos == 1 )
            nombreYApellido = nombreYApellido + formatearDeEnumAString(apellido1.name());

        else if ( unoODosApellidos == 2 ) {

            Apellidos apellido2 = apellidos[random.nextInt(apellidos.length)];
            nombreYApellido = nombreYApellido + formatearDeEnumAString(apellido1.name())  + " " +  formatearDeEnumAString(apellido2.name());

        }

        return nombreYApellido;
    }

    static String formatearDeEnumAString(String stringSinFormato) {
        stringSinFormato = stringSinFormato.replace('_', ' ');
        stringSinFormato = stringSinFormato.toLowerCase();
        String stringFormateado = stringSinFormato.substring(0, 1).toUpperCase() + stringSinFormato.substring(1);

        return stringFormateado;
    }

//    Del arreglo de billeteras virtuales, el usuarioLogueado tendrá una abierta a la cual le llegarán comprobantes
//    Por el momento, bancoOrigen va a tener la primer billetera virtual del usuario logueado. Completar la parte lógica para que funcione correctamente
//    static Comprobante generarComprobanteAleatorio(Usuario usuarioLogueado) {
//
//        String[] nombreBancos = {
//                "Mercado Pago",
//                "Ualá",
//                "Cuenta DNI",
//                "BNA+",
//                "Modo",
//                "Banco Patagonia",
//                "Brubank",
//                "Naranja x",
//                "Banco Francés",
//                "Prex",
//                "Banco Supervielle",
//                "Personal Pay"
//        };
//
//        String[] estadosTransferencia = {
//                "Enviada",
//                "Pendiente",
//                "Rechazada"
//        };
//
//        Random random = new Random();
//
//        String codigoTransferencia = generarCodigoTransferencia(random);
//        String fechaTransderencia = generarFecha();
//        double montoTransferencia = generarMonto(random);
//        Banco bancoOrigen = generarBancoOrigenAleatorio(usuarioLogueado, random);
//        Banco bancoDestino = generarBancoDestinoAleatorio(random, nombreBancos);
//        String estadoTransferencia = generarEstadoTransferencia(estadosTransferencia, random);
//
//        return new Comprobante(codigoTransferencia, fechaTransderencia, montoTransferencia, bancoOrigen, bancoDestino, estadoTransferencia);
//    }
//
//    static String generarCodigoTransferencia(Random random) {
//
//        String digitos = "0123456789";
//        int longuitudCodigoTransferencia = 11;
//        StringBuilder codigoTransferenciaBuffer = new StringBuilder();
//
//        for(int i = 0; i < longuitudCodigoTransferencia; i++)
//            codigoTransferenciaBuffer.append(digitos.charAt(random.nextInt(digitos.length())));
//
//        String codigoTransferencia = String.valueOf(codigoTransferenciaBuffer);
//        return codigoTransferencia;
//    }
//
//    static String generarFecha() {
//
//        // Fecha inicial: 24 de junio de 2023
//        long minimoDia = new GregorianCalendar(2023, Calendar.JUNE, 24).getTimeInMillis();
//        // Fecha final: fecha actual
//        long maximoDia = System.currentTimeMillis();
//        long diaRandom = ThreadLocalRandom.current().nextLong(minimoDia, maximoDia);
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//
//        return formatter.format(new Date(diaRandom));
//    }
//
//    static double generarMonto(Random random) {
//        return 1000.0 + (5000.0 - 1000.0) * random.nextDouble();
//    }
//
//    //Revisar este método por completo
//    static Banco generarBancoOrigenAleatorio(Usuario usuarioLogueado, Random random) {
//
//        ArrayList<BilleteraVirtual> billeterasVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();
//
//        if(billeterasVirtualesBuffer != null || !(billeterasVirtualesBuffer.isEmpty())) {
//
//            int indexAleatorio = random.nextInt(billeterasVirtualesBuffer.size());
//            return billeterasVirtualesBuffer.get(indexAleatorio).getUnBanco();
//        }
//        return null;
//    }
//
//    static Banco generarBancoDestinoAleatorio(Random random, String[] nombreBancos) {
//
//        String nombreBanco = nombreBancos[random.nextInt(nombreBancos.length)];
//        String alias = "Pepita123"; //Aquí habria que implementar la interfaz que genera el alias aleatorio
//
//        return new Banco(nombreBanco, alias);
//    }
//
//    static String generarEstadoTransferencia(String[] estadosTransferencia, Random random) {
//
//        int indexAleatorio = random.nextInt(estadosTransferencia.length);
//        return estadosTransferencia[indexAleatorio];
//    }
}
