package Modelo;

public abstract class ContenidoAV {
    String id;
    String titulo;
    String autor;
    String fecha;

    public ContenidoAV() {
        this.id = "";
        this.titulo = "";
        this.autor = "";
        this.fecha = "";
    }
    public ContenidoAV(String id, String titulo, String autor, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "id= " + id + "\n" +
                "titulo=" + titulo + "\n" +
                "autor=" + autor + "\n" +
                "fecha=" + fecha + "\n";
    }
}
