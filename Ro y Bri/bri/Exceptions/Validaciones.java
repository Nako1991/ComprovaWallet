package Exceptions;

import Model.Banco;
import Model.BilleteraVirtual;
import Model.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Map;

public class Validaciones {

    public Validaciones() {}

    //Verificamos si una cadena de texto está vacía
    public static boolean invalidFileIsEmpty(String rutaAlArchivo) throws InvalidFileIsEmpty {
        if(rutaAlArchivo == null || rutaAlArchivo.isEmpty())
            throw new InvalidFileIsEmpty("No hay usuarios registrados");

        File file = new File(rutaAlArchivo);
        if(!file.exists() || file.length() == 0)
            throw new InvalidFileIsEmpty("No hay usuarios registrados. El archivo no existe o está vacío.");

        return true;
    }

    //Verificamos que la contraseña tenga 8 dígitos, al menos una mayúscula, un número y un caracter especial
    public static boolean invalidWrongPasswordFormat(String password) throws InvalidWrongPasswordFormat {
        if (password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[-_.#*@<>&$].*")) {
            return false;  // La contraseña es válida
        } else {
            throw new InvalidWrongPasswordFormat("La contraseña debe contener al menos 8 caracteres, una mayúscula, un número y un caracter especial");
        }
    }

    //Verificamos que el nombre de usuario solo contenga letras minúsculas y mayúsculas
    public static boolean invalidWrongUserFormat(String nombreUsuario) throws InvalidWrongUserFormat {
        if(nombreUsuario.matches(".*[a-zA-Z].*")) return true;
        else throw new InvalidWrongUserFormat("El nombre del usuario no es válido");
    }

    public static boolean invalidUserAlreadyExists(String nombreUsuario, HashMap<String, Usuario> mapaUsuariosRegistrados) throws InvalidUserAlreadyExists {

        if(mapaUsuariosRegistrados.containsKey(nombreUsuario)) throw new InvalidUserAlreadyExists("El usuario ya existe");
        else return true;
    }

    public static boolean invalidUserDoesntExists(String nombreUsuario, HashMap<String, Usuario> mapaUsuariosRegistrados) throws InvalidUserDoesntExists {

        if(mapaUsuariosRegistrados.containsKey(nombreUsuario)) return true;
        else throw new InvalidUserDoesntExists("El usuario no existe");
    }

}
