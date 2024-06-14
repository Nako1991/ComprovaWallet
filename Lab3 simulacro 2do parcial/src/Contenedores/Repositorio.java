package Contenedores;

import Interfaces.ControladorDeContenedores;
import Modelo.ContenidoAV;

import java.util.HashMap;

public class Repositorio implements ControladorDeContenedores<ContenidoAV> {
    HashMap<String, ContenidoAV> repositorio;

    public Repositorio() {
        repositorio = new HashMap<>();
    }

    public Repositorio(HashMap<String, ContenidoAV> repositorio) {
        this.repositorio = repositorio;
    }
    public HashMap<String, ContenidoAV> getRepositorio() { return repositorio; }
    public void setRepositorio(HashMap<String, ContenidoAV> repositorio) { this.repositorio = repositorio; }

    @Override
    public void agregar(ContenidoAV contenido) {
        repositorio.put( contenido.getId() , contenido );
    }

    @Override
    public ContenidoAV remover(String id) {
        if( repositorio.containsKey(id) ) {
            repositorio.remove(id);
            return repositorio.get(id);
        }
        else {
            return null;
        }
    }

    @Override
    public void mostrar(String id) {
        if( !repositorio.containsKey(id) ) {
            System.out.println("El objeto no se encuentra en la biblioteca");
        }
        else {
            System.out.println( repositorio.get(id) );
        }
    }

    @Override
    public void mostrarTodo() {
        if( repositorio.isEmpty() ) {
            System.out.println("El repositorio esta vacio.");
        }
        else {
            for ( ContenidoAV contenido : repositorio.values() ) {
                System.out.println(contenido);
            }
        }
    }

    @Override
    public ContenidoAV leer(String id) {
        if( repositorio.containsKey(id) )
            return repositorio.get(id);
        return null;
    }

    @Override
    public void filtrarPorContenido(String tipo) {
        for( ContenidoAV contenido : repositorio.values() ) {
            if( contenido.getClass().getSimpleName().equals(tipo) )
                System.out.println(contenido);
        }
    }
}
