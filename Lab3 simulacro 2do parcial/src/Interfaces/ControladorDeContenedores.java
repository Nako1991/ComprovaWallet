package Interfaces;


import Modelo.ContenidoAV;

public interface ControladorDeContenedores<T> {
    void agregar(T contenido);
    T remover(String id);
    T leer(String id);
    void mostrar(String id);
    void mostrarTodo();
    Boolean modificar(ContenidoAV contenido);
    void filtrarPorContenido(String tipo);
}
