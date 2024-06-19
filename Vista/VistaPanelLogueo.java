package Vista;
import Controlador.ControladorLogueoUsuarios;
import Exceptions.InvalidUserDoesntExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;
import Modelo.Usuario;

public abstract class VistaPanelLogueo {

    public static Usuario ingresarUsuario(String usuario, String contraseña, ControladorLogueoUsuarios controladorLogueoUsuarios) {

        try {
            Usuario usuarioLogueado = controladorLogueoUsuarios.loguearUsuario(usuario, contraseña);
            return usuarioLogueado;
        }
        catch(InvalidWrongUserFormat | InvalidWrongPasswordFormat | InvalidUserDoesntExists exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return null;
    }
}
