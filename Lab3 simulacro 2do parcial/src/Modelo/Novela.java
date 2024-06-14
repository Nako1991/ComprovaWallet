package Modelo;

public class Novela extends ContenidoAV {
    private static String tipo;

    public Novela() {
        super();
        tipo = "Novela";
    }

    public Novela(String id, String titulo, String autor, String fecha) {
        super(id, titulo, autor, fecha);
        tipo = "Novela";
    }

    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return "tipo= " + tipo + "\n" +
                super.toString();
    }
}