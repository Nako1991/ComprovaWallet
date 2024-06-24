package Controlador;
import Exceptions.Validaciones;
import Modelo.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ControladorLogueoUsuarios {

    public ControladorLogueoUsuarios() {

        if (ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo().isEmpty())
            ControladorArchivoUsuarios.crearArchivoUsuariosDummy();
            //ControladorArchivoUsuarios.mostrarArchivo();
    }

    public Usuario loguearUsuario(String nombreUsuario) {
        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();
        Usuario usuarioLogueado = repositorio.get(nombreUsuario);

        return usuarioLogueado;
    }
}
