package Controller;
import Model.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorVentanaRegistro {

    private static final String FILE_PATH = "usuariosRegistrados.json";
    HashMap<String, Usuario> usuariosRegistrados;

    public ControladorVentanaRegistro() {
        this.usuariosRegistrados = new HashMap<>();
    }




 /*   public ControladorVentanaRegistro() {}

    public static boolean registrarUsuario(String nombreUsuario, String contraseñaUsuario) {
        boolean usuarioComprobado = false;

        ArrayList<String> usuarios = JSONUtilities.downloadJSON("usuarios.JSON");

    }
 */
}
