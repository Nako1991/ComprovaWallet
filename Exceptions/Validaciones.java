package Exceptions;
import Controlador.ControladorArchivoUsuarios;
import Modelo.BilleteraVirtual;
import Modelo.Usuario;

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

    //Verificamos que el nombre de usuario no se repita
    public static boolean invalidUserAlreadyExists(String nombreUsuario, HashMap<String, Usuario> mapaUsuariosRegistrados) throws InvalidUserAlreadyExists {

        if(mapaUsuariosRegistrados.containsKey(nombreUsuario)) throw new InvalidUserAlreadyExists("El usuario ya existe");
        else return true;
    }

    //Verificamos si existe un usuario
    public static boolean invalidUserDoesntExists(String nombreUsuario, HashMap<String, Usuario> mapaUsuariosRegistrados) throws InvalidUserDoesntExists {

        if(mapaUsuariosRegistrados.containsKey(nombreUsuario)) return true;
        else throw new InvalidUserDoesntExists("El usuario no existe");
    }

    //Verificamos que el cvu sea único
    public static boolean invalidCVUAlreadyExists(String cvu, HashMap<String, Usuario> mapaUsuariosRegistrados) throws InvalidCVUAlreadyExists, InvalidNonExistentVirtualWallet {

            for(Map.Entry<String, Usuario> entry : mapaUsuariosRegistrados.entrySet())
                for(BilleteraVirtual billeteraVirtualBuffer : entry.getValue().getBilleterasVirtuales())
                    if((billeteraVirtualBuffer.getUnBanco().getCvu().equals(cvu))) throw new InvalidCVUAlreadyExists("El cvu ya existe");

        return true;
    }

    public static boolean contraseñaVerificada(String contraseña) {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();

        for( Usuario usuario : repositorio.values() ) {
            if( usuario.getContraseña().equals(contraseña) ) {
                return true;
            }
        }

        return false;
    }

    public static boolean usuarioVerificado(String nombreUsuario) {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();

        for( Usuario usuario : repositorio.values() ) {
            if( usuario.getUsuario().equals(nombreUsuario) ) {
                return true;
            }
        }

        return false;
    }
}
