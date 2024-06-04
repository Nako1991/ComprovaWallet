package Controller;

public class Validaciones {

    public Validaciones() {}

    //Verificamos si una cadena de texto está vacía
    public static boolean validarFileIsEmpty(String rutaAlArchivo) throws InvalidFileIsEmpty {
        if(rutaAlArchivo == null || rutaAlArchivo.isEmpty()) throw new InvalidFileIsEmpty("No hay usuarios registrados");
        else return true;
    }

    //Verificamos que la contraseña tenga 8 dígitos, al menos una mayúscula, un número y un caracter especial
    public static boolean validarContraseña(String password) throws InvalidPasswordException {
        if (password.matches("\\d{8}") &&
            password.matches(".*[A-Z].*") &&
            password.matches(".*\\d.*") &&
            password.matches(".*[!@#$%^&*()\\[\\]{};:,.<>?\\/\\\\].*")) return true;
        else throw new InvalidPasswordException("La contraseña debe contener al menos 8 caracteres, una mayúscula, un número y un caracter especial");
    }

    //Verificamos que el nombre de usuario solo contenga letras minúsculas y mayúsculas
    public static boolean validarUsuario(String nombreUsuario) throws InvalidUser {
        if(nombreUsuario.matches(".*[a-zA-Z].*")) return true;
        else throw new InvalidUser("El nombre del usuario no es válido");
    }
}
