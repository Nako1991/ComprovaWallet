package Controlador;
import Modelo.Usuario;

import java.util.HashMap;

public class ControladorLogueoUsuarios {

    public ControladorLogueoUsuarios() {

        if (ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo().isEmpty()) {

            ControladorArchivoUsuarios.crearArchivoUsuariosDummy();
        }
            //ControladorArchivoUsuarios.mostrarArchivo();
    }

    public Usuario loguearUsuario(String nombreUsuario, String contraseña) {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
        Usuario usuarioALoguear = repositorio.get(nombreUsuario);

        return usuarioALoguear;
    }
}
