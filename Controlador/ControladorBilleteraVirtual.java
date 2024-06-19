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
        guardarCambios(usuarioLogueado);
    }

    public static boolean eliminarBilleteraVirtual(Usuario usuarioLogueado, String nombreBanco) throws InvalidNonExistentVirtualWallet {

        ArrayList<BilleteraVirtual> billeterasVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();

        for(BilleteraVirtual billeteraVirtualBuffer : billeterasVirtualesBuffer) {

            if(billeteraVirtualBuffer.getUnBanco().getBanco().equals(nombreBanco)) {
                billeterasVirtualesBuffer.remove(billeteraVirtualBuffer);
                usuarioLogueado.setBilleterasVirtuales(billeterasVirtualesBuffer);
                guardarCambios(usuarioLogueado);
                return true;
            }
        }
        throw new InvalidNonExistentVirtualWallet("La billetera virtual no existe");
    }

    public static void guardarCambios(Usuario usuarioLogueado) {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
        repositorio.put(usuarioLogueado.getUsuario(), usuarioLogueado);
        ControladorArchivoUsuarios.grabarRepositorioEnArchivo(repositorio);
    }

    public static void mostrarBilleterasVirtual(Usuario usuarioLogueado) {

        ArrayList<BilleteraVirtual> billeteraVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();

        if(billeteraVirtualesBuffer.isEmpty()) System.out.println("\nNo hay ninguna billetera virtual registrada");

        else {
            for(BilleteraVirtual billeteraVirtualBuffer : usuarioLogueado.getBilleterasVirtuales())System.out.println("\n " + billeteraVirtualBuffer.toString());
        }
    }

    public static BilleteraVirtual getBilleteraVirtual(Usuario usuarioLogueado, String nombreBanco) throws InvalidNonExistentVirtualWallet {

        ArrayList<BilleteraVirtual> billeterasVirtualesBuffer = usuarioLogueado.getBilleterasVirtuales();

        for(BilleteraVirtual billeteraVirtual : billeterasVirtualesBuffer)
            if(billeteraVirtual.getUnBanco().getBanco().equals(nombreBanco)) return billeteraVirtual;

        throw new InvalidNonExistentVirtualWallet("La billetera virtual no existe");
    }
}
