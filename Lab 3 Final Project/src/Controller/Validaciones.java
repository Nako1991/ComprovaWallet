package Controller;

public class Validaciones {

    public Validaciones(){}

    public static boolean verificarFileIsEmpty(String rutaAlArchivo) throws InvalidFileIsEmpty {

        if(rutaAlArchivo == null || rutaAlArchivo.isEmpty()) throw new InvalidFileIsEmpty("No hay usuarios registrados");
        else return true;
    }
}
