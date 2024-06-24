package Controlador;
import Exceptions.InvalidNonExistentVirtualWallet;
import Modelo.BilleteraVirtual;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorBilleteraVirtual {

    public ControladorBilleteraVirtual() {}

    public static void agregarBilleteraVirtual(Usuario usuarioLogueado, BilleteraVirtual nuevaBilleteraVirtual) {
        ArrayList<BilleteraVirtual> billeteras = usuarioLogueado.getBilleterasVirtuales();
        billeteras.add(nuevaBilleteraVirtual);
        usuarioLogueado.setBilleterasVirtuales(billeteras);
        guardarCambiosUsuario(usuarioLogueado);
    }

    public static boolean eliminarBilleteraVirtual(Usuario usuarioLogueado, String nombreBanco) throws InvalidNonExistentVirtualWallet {
        ArrayList<BilleteraVirtual> billeteras = usuarioLogueado.getBilleterasVirtuales();

        for( BilleteraVirtual billetera : billeteras ) {

            if( billetera.getBanco().getNombreBanco().equals(nombreBanco) ) {
                billeteras.remove(billetera);
                usuarioLogueado.setBilleterasVirtuales(billeteras);
                guardarCambiosUsuario(usuarioLogueado);
                return true;
            }
        }
        throw new InvalidNonExistentVirtualWallet("La billetera virtual no existe");
    }

    public static void guardarCambiosUsuario(Usuario usuarioLogueado) {
        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
        if ( repositorio != null ) {
            System.out.println(repositorio.get(usuarioLogueado.getUsuario())); //TEST
            repositorio.put(usuarioLogueado.getUsuario(), usuarioLogueado);
            System.out.println(repositorio.get(usuarioLogueado.getUsuario())); //TEST
            ControladorArchivoUsuarios.grabarRepositorioEnArchivo(repositorio);
        }
        else
            System.out.println("\nError: El repositorio es nulo");
    }

    public static void mostrarBilleterasVirtuales(Usuario usuarioLogueado) {
        ArrayList<BilleteraVirtual> billeteras = usuarioLogueado.getBilleterasVirtuales();

        if( billeteras.isEmpty() )
            System.out.println("\nNo hay ninguna billetera virtual registrada");
        else
            for( BilleteraVirtual billetera : billeteras )
                System.out.println("\n " + billetera.toString());
    }

    public static BilleteraVirtual getBilleteraVirtual(Usuario usuarioLogueado, String nombreBanco) throws InvalidNonExistentVirtualWallet {
        ArrayList<BilleteraVirtual> billeteras = usuarioLogueado.getBilleterasVirtuales();

        for( BilleteraVirtual billetera : billeteras )
            if( billetera.getBanco().getNombreBanco().equals(nombreBanco) ) return billetera;

        throw new InvalidNonExistentVirtualWallet("La billetera virtual no existe");
    }
}
