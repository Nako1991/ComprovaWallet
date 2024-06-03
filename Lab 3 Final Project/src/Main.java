import Controller.GestorBilleteras;
import View.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {

        GestorBilleteras programa = new GestorBilleteras();
        programa.gestionar();

        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.ejecutarVentanaPrincipal();
    }
}





