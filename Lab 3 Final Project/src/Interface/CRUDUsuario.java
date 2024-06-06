package Interface;

public interface CRUDUsuario <T,G,H>{
    void create(T dato);
    boolean remove(G dato);
    H lookFor(G dato); ///BUSCAR

}
