package Modelo;

public class Libro extends ContenidoAV {
    private static String tipo;

    public Libro() {
        super();
        tipo = "Libro";
    }

    public Libro(String id, String titulo, String autor, String fecha) {
        super(id, titulo, autor, fecha);
        tipo = "Libro";
    }

    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "tipo= " + tipo + "\n" +
                super.toString();
    }
}
