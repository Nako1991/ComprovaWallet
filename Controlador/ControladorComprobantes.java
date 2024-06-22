package Controlador;
import Exceptions.InvalidNonExistentReceipt;
import Modelo.Comprobante;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorComprobantes {

    public ControladorComprobantes() {}

    public static void agregarComprobante(Usuario usuario, Comprobante nuevoComprobante) {

        ArrayList<Comprobante> comprobantes = usuario.getComprobantes();
        comprobantes.add(nuevoComprobante);
        usuario.setComprobantes(comprobantes);
        guardarCambiosUsuario(usuario);

    }

    public static boolean eliminarComprobante(Usuario usuario, String codigoTransferencia) throws InvalidNonExistentReceipt {

        ArrayList<Comprobante> comprobantes = usuario.getComprobantes();

        for(Comprobante comprobante : comprobantes) {

            if(comprobante.getCodigoTransferencia().equals(codigoTransferencia)) {
                comprobantes.remove(comprobante);
                usuario.setComprobantes(comprobantes);
                guardarCambiosUsuario(usuario);
                return true;
            }
        }
        throw new InvalidNonExistentReceipt("El comprobante no existe");
    }

    public static void guardarCambiosUsuario(Usuario usuarioLogueado) {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
        if (repositorio != null) {
            repositorio.put(usuarioLogueado.getUsuario(), usuarioLogueado);
            ControladorArchivoUsuarios.grabarRepositorioEnArchivo(repositorio);
        } else {
            System.out.println("Error: El repositorio es nulo.");
        }

    }

    public static void mostrarComprobantes(Usuario usuario) {

        ArrayList<Comprobante> comprobantes = usuario.getComprobantes();

        if( comprobantes.isEmpty() )
            System.out.println("\nNo hay ningun comprobante registrado");
        else
            for( Comprobante comprobante : comprobantes )
                System.out.println("\n " + comprobante.toString());
    }

    public static Comprobante getBilleteraVirtual(Usuario usuarioLogueado, String codigoTransferencia) throws InvalidNonExistentReceipt {

        ArrayList<Comprobante> comprobantes = usuarioLogueado.getComprobantes();

        for( Comprobante comprobante : comprobantes )
            if( comprobante.getCodigoTransferencia().equals(codigoTransferencia) )
                return comprobante;

        throw new InvalidNonExistentReceipt("El comprobante no existe");
    }
}
