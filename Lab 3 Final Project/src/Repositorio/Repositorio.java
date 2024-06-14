package Repositorio;

import Model.Usuario;

import java.util.HashMap;
import java.util.Map;

public class Repositorio {

    private HashMap<String, Usuario> repositorio;

    public Repositorio() { this.repositorio = new HashMap<>(); }
    public Repositorio(HashMap<String, Usuario> repositorio) { this.repositorio = repositorio; }

    public HashMap<String, Usuario> getRepositorio() { return this.repositorio; }
    public void setRepositorio(HashMap<String, Usuario> repositorio) { this.repositorio = repositorio; }

    public void agregarUsuario(Usuario usuario) {
        this.repositorio.put(usuario.getUsuario(), usuario);
    }

    public Usuario leerUsuario(String claveUsuario) {
        if( this.repositorio.containsKey(claveUsuario) )
            return this.repositorio.get(claveUsuario);
        else
            return null;
    }

    public void modificarUsuario(Usuario usuario) {
        if( this.repositorio.containsKey(usuario.getUsuario()) )
            this.repositorio.put(usuario.getUsuario(), usuario);
    }

    public Usuario eliminarUsuario(Usuario usuario) {
        Usuario usuarioEliminado = null;
        if( this.repositorio.containsValue(usuario) ) {
            usuarioEliminado = usuario;
            this.repositorio.remove(usuario);
        }
        return usuarioEliminado;
    }

    public void mostrarTodos() {
        for(Usuario usuario : repositorio.values())
            System.out.println(usuario.toString());
    }
}
