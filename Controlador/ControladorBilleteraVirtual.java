package Controlador;
import Exceptions.InvalidNonExistentVirtualWallet;
import Modelo.BilleteraVirtual;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorBilleteraVirtual {

    public ControladorBilleteraVirtual() {}

    public static void agregarBilleteraVirtual(Usuario usuarioLogueado, BilleteraVirtual nuevaBilleteraVirtual) {

        ArrayList<BilleteraVirtual> billeterasVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();
        billeterasVirtualesBuffer.add(nuevaBilleteraVirtual);
        usuarioLogueado.setBilleterasVirtuales(billeterasVirtualesBuffer);
        guardarCambiosUsuario(usuarioLogueado);

    }

    public static boolean eliminarBilleteraVirtual(Usuario usuarioLogueado, String nombreBanco) throws InvalidNonExistentVirtualWallet {

        ArrayList<BilleteraVirtual> billeterasVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();

        for(BilleteraVirtual billeteraVirtualBuffer : billeterasVirtualesBuffer) {

            if(billeteraVirtualBuffer.getBanco().equals(nombreBanco)) {
                billeterasVirtualesBuffer.remove(billeteraVirtualBuffer);
                usuarioLogueado.setBilleterasVirtuales(billeterasVirtualesBuffer);
                guardarCambiosUsuario(usuarioLogueado);
                return true;
            }
        }
        throw new InvalidNonExistentVirtualWallet("La billetera virtual no existe");
    }

    public static void guardarCambiosUsuario(Usuario usuarioLogueado) {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
        if (repositorio != null) {
            System.out.println(repositorio.get(usuarioLogueado.getUsuario())); //TEST
            repositorio.put(usuarioLogueado.getUsuario(), usuarioLogueado);
            System.out.println(repositorio.get(usuarioLogueado.getUsuario())); //TEST
            ControladorArchivoUsuarios.grabarRepositorioEnArchivo(repositorio);
        } else {
            System.out.println("Error: El repositorio es nulo.");
        }

    }

    public static void mostrarBilleterasVirtuales(Usuario usuario) {

        ArrayList<BilleteraVirtual> billeterasVirtuales = usuario.getBilleterasVirtuales();

        if( billeterasVirtuales.isEmpty() )
            System.out.println("\nNo hay ninguna billetera virtual registrada");
        else
            for( BilleteraVirtual billetera : billeterasVirtuales )
                System.out.println("\n " + billetera.toString());
    }

    public static BilleteraVirtual getBilleteraVirtual(Usuario usuarioLogueado, String nombreBanco) throws InvalidNonExistentVirtualWallet {

        ArrayList<BilleteraVirtual> billeterasVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();

        for( BilleteraVirtual billeteraVirtual : billeterasVirtualesBuffer )
            if( billeteraVirtual.getBanco().getBanco().equals(nombreBanco) ) return billeteraVirtual;

        throw new InvalidNonExistentVirtualWallet("La billetera virtual no existe");
    }
}
