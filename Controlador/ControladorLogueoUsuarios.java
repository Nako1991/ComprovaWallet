package Controlador;
import Exceptions.*;
import Modelo.Usuario;

import java.util.HashMap;

public class ControladorLogueoUsuarios {

    public ControladorLogueoUsuarios() {

        if(ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo() == null)
            ControladorArchivoUsuarios.crearArchivoUsuariosDummy();
        ControladorArchivoUsuarios.mostrarArchivo();
    }

    public Usuario loguearUsuario(String nombreUsuario, String contraseña) throws InvalidWrongUserFormat, InvalidWrongPasswordFormat, InvalidUserDoesntExists {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();

        Validaciones.invalidWrongUserFormat(nombreUsuario);
        Validaciones.invalidWrongPasswordFormat(contraseña);
        Validaciones.invalidUserDoesntExists(nombreUsuario, repositorio);

        Usuario usuarioALoguear = repositorio.get(nombreUsuario);

        return usuarioALoguear;
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
