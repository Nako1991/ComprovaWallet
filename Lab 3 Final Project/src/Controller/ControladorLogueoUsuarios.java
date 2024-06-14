package Controller;
import Exceptions.*;
import Interface.InterfazControladorArchivoUsuarios;
import Model.Config;
import Model.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class ControladorLogueoUsuarios implements InterfazControladorArchivoUsuarios {

    public ControladorLogueoUsuarios() {
        if(cargarRepositorioDesdeArchivo() == null) {
            this.crearArchivoUsuariosDummy();
        }
        this.mostrarArchivo();
    }

    public Usuario loguearUsuario(String nombreUsuario, String contraseña) throws InvalidWrongUserFormat, InvalidWrongPasswordFormat, InvalidUserDoesntExist {

        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();
        try {
            Usuario usuarioALoguear = new Usuario();
            Validaciones.invalidWrongUserFormat(nombreUsuario);
            Validaciones.invalidWrongPasswordFormat(contraseña);
            Validaciones.invalidUserDoesntExist(nombreUsuario, repositorio);
            if( repositorio.containsKey(nombreUsuario) && repositorio.get(contraseña).equals(contraseña)) {
                return usuarioALoguear;
            }
            else return null;
        }
        catch(InvalidWrongUserFormat | InvalidWrongPasswordFormat | InvalidUserDoesntExist exception) {
            throw exception;
        }
    }

}
