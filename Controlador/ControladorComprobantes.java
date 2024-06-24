package Controlador;
import Exceptions.InvalidNonExistentReceipt;
import Modelo.Comprobante;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorComprobantes {

    public ControladorComprobantes() {}

    public static void agregarComprobante(Usuario usuarioLogueado, Comprobante nuevoComprobante) {
        ArrayList<Comprobante> comprobantes = usuarioLogueado.getComprobantes();
        comprobantes.add(nuevoComprobante);
        usuarioLogueado.setComprobantes(comprobantes);
        guardarCambiosUsuario(usuarioLogueado);

    }

    public static boolean eliminarComprobante(Usuario usuarioLogueado, String codigoTransferencia) throws InvalidNonExistentReceipt {
        ArrayList<Comprobante> comprobantes = usuarioLogueado.getComprobantes();

        for(Comprobante comprobante : comprobantes) {

            if( comprobante.getCodigoDeTransferencia().equals(codigoTransferencia) ) {
                comprobantes.remove(comprobante);
                usuarioLogueado.setComprobantes(comprobantes);
                guardarCambiosUsuario(usuarioLogueado);
                return true;
            }
        }
        throw new InvalidNonExistentReceipt("El comprobante no existe");
    }

    public static void mostrarComprobantes(Usuario usuarioLogueado) {
        ArrayList<Comprobante> comprobantes = usuarioLogueado.getComprobantes();

        if( comprobantes.isEmpty() )
            System.out.println("\nNo hay ningun comprobante registrado");
        else
            for( Comprobante comprobante : comprobantes )
                System.out.println("\n " + comprobante.toString());
    }

    public static Comprobante getComprobante(Usuario usuarioLogueado, String codigoTransferencia) throws InvalidNonExistentReceipt {
        ArrayList<Comprobante> comprobantes = usuarioLogueado.getComprobantes();

        for( Comprobante comprobante : comprobantes )
            if( comprobante.getCodigoDeTransferencia().equals(codigoTransferencia) )
                return comprobante;

        throw new InvalidNonExistentReceipt("El comprobante no existe");
    }

    public static void modificarEstadoDeComprobante(Usuario usuarioLogueado, String estado, String codigoDeTransferencia) {
        ArrayList<Comprobante> comprobantes = usuarioLogueado.getComprobantes();
        Comprobante comprobanteModificado = new Comprobante();

        for( Comprobante comprobante : comprobantes )
            if ( comprobante.getCodigoDeTransferencia().equals(codigoDeTransferencia) )
                comprobanteModificado = comprobante;
        comprobanteModificado.setEstadoDeComprobante(estado);

        reemplazarComprobante(usuarioLogueado, comprobanteModificado);
    }

    public static void reemplazarComprobante(Usuario usuarioLogueado, Comprobante comprobanteAGuardar) {
        ArrayList<Comprobante> comprobantes = usuarioLogueado.getComprobantes();
        ArrayList<Comprobante> comprobantesModificado = new ArrayList<>();

        for( Comprobante comprobante : comprobantes ) {
            if ( !comprobante.getCodigoDeTransferencia().equals(comprobanteAGuardar.getCodigoDeTransferencia()) ) {
                comprobantesModificado.add(comprobante);
            }
            else
                comprobantesModificado.add(comprobanteAGuardar);
        }
        usuarioLogueado.setComprobantes(comprobantesModificado);
        guardarCambiosUsuario(usuarioLogueado);
    }

    public static void guardarCambiosUsuario(Usuario usuarioLogueado) {
        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
        if ( repositorio != null ) {
            repositorio.put(usuarioLogueado.getUsuario(), usuarioLogueado);
            ControladorArchivoUsuarios.grabarRepositorioEnArchivo(repositorio);
        }
        else
            System.out.println("\nError: El repositorio es nulo");
    }
}
