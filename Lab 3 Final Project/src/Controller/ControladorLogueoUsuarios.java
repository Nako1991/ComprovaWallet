package Controller;


import Exceptions.InvalidUserAlreadyExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;
import Exceptions.Validaciones;
import Interface.InterfazControladorArchivoUsuarios;
import Model.Config;
import Model.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class ControladorLogueoUsuarios implements InterfazControladorArchivoUsuarios {

    public ControladorLogueoUsuarios() {
        if(cargarRepositorioDesdeArchivo() == null) {
            this.crearArchivo();
        }
        this.mostrarArchivo();
    }

    public Usuario loguearUsuario(String nombreUsuario, String contraseña) throws InvalidWrongUserFormat, InvalidWrongPasswordFormat {
        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();
        try {
            Usuario usuarioALoguear = new Usuario();
            Validaciones.invalidWrongUserFormat(nombreUsuario);
            Validaciones.invalidWrongPasswordFormat(contraseña);

//            Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña);
//
//            JSONObject nuevoUsuarioJSON = nuevoUsuario.toJSON();
//            JSONArray usuariosJSONArray = new JSONArray(JSONUtilities.downloadJSON(Config.getCarpetaRaiz() + "usuariosRegistrados.json"));
//            usuariosJSONArray.put(nuevoUsuarioJSON);
//            JSONUtilities.uploadJSON(usuariosJSONArray, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
            return usuarioALoguear;
        }
        catch(InvalidWrongUserFormat | InvalidWrongPasswordFormat exception) {
            throw exception;
        }
    }

    /*public static boolean comprobarLogin(String usuario, String contraseña){
        //comprobar el usuario y que devuelva el usuario, luego la contraseña

        return (comprobarUsuario(usuario) && comprobarContraseña(contraseña));
    }*/

    /*private static boolean comprobarUsuario(String usuarioBuscado){
        boolean comprobado = false;


        for( Usuario usuario : usuarios ) {
            if ( usuario.getUsuario().equals(usuarioBuscado) )
                comprobado = true;
        }
        return comprobado;
    }*/

    /*private static boolean comprobarContraseña(String contraseña){
        return 0;
    }*/
}
