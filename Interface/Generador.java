package Interface;

import Controlador.ControladorArchivoUsuarios;
import Exceptions.Validaciones;
import Modelo.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    static String generarCVU() {
        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
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

            if ( unoODosNombres == 2 && !nombreVaron1.equals(nombreVaron2) )
                nombreYApellido = formatearDeEnumAString(nombreVaron1.name()) + " " +  formatearDeEnumAString(nombreVaron2.name()) + " ";
            else
                nombreYApellido = formatearDeEnumAString(nombreVaron1.name()) + " ";
        }
        else if ( hombreOMujer == 1 ) {

            NombresMujeres[] nombresMujeres = NombresMujeres.values();
            NombresMujeres nombreMujer1 = nombresMujeres[random.nextInt(nombresMujeres.length)];
            NombresMujeres nombreMujer2 = nombresMujeres[random.nextInt(nombresMujeres.length)];

            if ( unoODosNombres == 2 && !nombreMujer1.equals(nombreMujer2) )
                nombreYApellido = formatearDeEnumAString(nombreMujer1.name()) + " " + formatearDeEnumAString(nombreMujer2.name()) + " ";
            else
                nombreYApellido = formatearDeEnumAString(nombreMujer1.name()) + " ";

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

    static String generarCuil() {
        Random random = new Random();

        int primerDigito = random.nextInt(10);
        int segundoDigito = random.nextInt(10);

        String cuil = String.format("%d%d-", primerDigito, segundoDigito);

        for (int i = 0; i < 8; i++) {

            cuil += random.nextInt(10);

        }
        cuil += "-";
        int ultimoDigito = random.nextInt(10);
        cuil += ultimoDigito;

        return cuil;
    }

    static Persona generarPersona() {

        String nombreYApellido = generarNombreYApellido();

        return new Persona(nombreYApellido);

    }

    static BilleteraVirtual generarBilleteraVirtual() {

        Persona persona = generarPersona();
        String nombreBanco = generarNombreBanco();
        Banco banco = new Banco(nombreBanco);

        return new BilleteraVirtual(persona,banco);
    }

    static String generarCodigoDeTransferencia() {
        StringBuilder codigo = new StringBuilder(11);
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int digito = random.nextInt(10);
            codigo.append(digito);
        }
        return codigo.toString();
    }

    static String generadorDeFecha() {
        Random random = new Random();

        int año = 1970 + random.nextInt(55);
        int mes = random.nextInt(12) + 1;
        int diaMaximo = diaMaximoDeEseMes(año,mes);
        int dia = random.nextInt(diaMaximo) + 1;

        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes -1, dia);

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(calendario.getTime());

        return fechaFormateada;
    }
    static int diaMaximoDeEseMes(int año, int mes) {
        Calendar calendarario = Calendar.getInstance();
        calendarario.set(año,mes - 1, 1);
        return calendarario.get(Calendar.DAY_OF_MONTH);
    }

    static double generarMonto() {

        Random random = new Random();
        double min = 500;
        double max = 250000;

        double monto = min + (max - min) * random.nextDouble();

        return monto;
    }

    static String generarEstadoDeTransferencia() {
        String[] estados = {"Enviado", "Pendiente", "Rechazado"};
        Random random = new Random();
        int estado = random.nextInt(estados.length);
        return estados[estado];
    }

    static String generarEstadoDeComprobante() {
        String[] estados = {"Recibido", "Confirmado", "Archivado"};
        Random random = new Random();
        int estado = random.nextInt(estados.length);
        return estados[estado];
    }

    static Banco generarBanco() {
        String nombreBanco = generarNombreBanco();
        return new Banco(nombreBanco);
    }

    static Comprobante generarComprobante() {
        return new Comprobante();
    }
    
}
