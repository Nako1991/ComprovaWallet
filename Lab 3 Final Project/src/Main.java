public class Main {
    public static void main(String[] args) {
        GestorBilleteras programa = new GestorBilleteras();
        programa.gestionar();

        Menu ventana = new Menu();
        ventana.ejecutarMenuPrincipal();
    }
}