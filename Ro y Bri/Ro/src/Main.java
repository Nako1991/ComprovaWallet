import Controller.ControladorBilleteraVirtual;
import Interface.GeneradorComprobante;
import Model.*;
import View.VentanaPrincipal;

import java.util.ArrayList;

public class Main implements GeneradorComprobante {

    public static void main(String[] args) {
//        VentanaPrincipal ventana = new VentanaPrincipal();
//        ventana.ejecutarVentanaPrincipal();

        Usuario usuarioLogueado = new Usuario();
        usuarioLogueado.setUsuario("Rocio_Ortiz_2002");
        usuarioLogueado.setContraseña("RocioOrtiz2002@");

        Persona personaBuffer = new Persona("Rocio Ortiz", "21-44145495-9");
        Banco bancoBuffer = new Banco("Mercado Pago", "Rouse02");
        BilleteraVirtual billeteraVirtuales = new BilleteraVirtual(personaBuffer, bancoBuffer, "APIIII");

        Persona personaBuffer2 = new Persona("Brisa Ortiz", "21-44145495-9");
        Banco bancoBuffer2 = new Banco("Prex", "Britany02");
        BilleteraVirtual billeteraVirtuales2 = new BilleteraVirtual(personaBuffer, bancoBuffer, "hhh");

        ArrayList<BilleteraVirtual> billeteras = new ArrayList<>();
        billeteras.add(billeteraVirtuales);
        billeteras.add(billeteraVirtuales2);
        usuarioLogueado.setBilleterasVirtuales(billeteras);

        ArrayList<Comprobante> comprobantes = new ArrayList<>();
        Comprobante comprob1 = GeneradorComprobante.generarComprobanteAleatorio(usuarioLogueado);
        Comprobante comprob2 = GeneradorComprobante.generarComprobanteAleatorio(usuarioLogueado);
        comprobantes.add(comprob1);
        comprobantes.add(comprob2);

        System.out.println("\nUSUARIO LOGUEADO\n" + usuarioLogueado.toString());
    }

}