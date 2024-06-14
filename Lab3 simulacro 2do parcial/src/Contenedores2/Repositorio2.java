package Contenedores2;

import Interfaces.ControladorDeContenedores;
import Modelo.ContenidoAV;

import java.util.HashMap;

public class Repositorio2 implements ControladorDeContenedores<ContenidoAV> {
    HashMap< String, ContenidoAV > repositorio;

    public Repositorio2() {
        repositorio = new HashMap<>();
    }
    public Repositorio2(HashMap<String, ContenidoAV> repositorio) {
        this.repositorio = repositorio;
    }

    public HashMap<String, ContenidoAV> getRepositorio() { return repositorio; }
    public void setRepositorio(HashMap<String, ContenidoAV> repositorio) { this.repositorio = repositorio; }

    @Override
    public void agregar(ContenidoAV contenido) {
        repositorio.put( contenido.getId(), contenido );
    }

    @Override
    public ContenidoAV remover(String id) {
        if( repositorio.containsKey(id) ) {
            repositorio.remove(id);
            return repositorio.get(id);
        }
        return null;
    }

    @Override
    public void mostrar(String id) {
        if( repositorio.containsKey(id) )
            System.out.println(repositorio.get(id).toString());
    }

    @Override
    public void mostrarTodo() {
        for ( ContenidoAV contenido : repositorio.values() )
            System.out.println(contenido);
    }

    @Override
    public ContenidoAV leer(String id) {
        if( repositorio.containsKey(id) )
            return repositorio.get(id);
        return null;
    }

    @Override
    public Boolean modificar(ContenidoAV contenido) {
        if( repositorio.containsKey(contenido.getId()) ) {
            repositorio.put(contenido.getId(), contenido);
            System.out.println("El contenido ha sido modificado con exito");
        }
        return false;
    }

    @Override
    public void filtrarPorContenido(String tipo) {
        for( ContenidoAV contenido : repositorio.values() ) {
            if( contenido.getClass().getSimpleName().equals(tipo) )
                System.out.println(contenido);
        }
    }
}
