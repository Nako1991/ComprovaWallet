package Exceptions;
import Controlador.ControladorArchivoUsuarios;
import Modelo.BilleteraVirtual;
import Modelo.Usuario;

import java.util.HashMap;
import java.io.File;
import java.util.Map;

public class Validaciones {

    public Validaciones() {}

    public static boolean invalidFileIsEmpty(String rutaAlArchivo) throws InvalidFileIsEmpty {
        if(rutaAlArchivo == null || rutaAlArchivo.isEmpty())
            throw new InvalidFileIsEmpty("No hay usuarios registrados");

        File file = new File(rutaAlArchivo);
        if(!file.exists() || file.length() == 0)
            throw new InvalidFileIsEmpty("No hay usuarios registrados. El archivo no existe o está vacío.");

        return true;
    }

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

    public static boolean invalidWrongUserFormat(String nombreUsuario) throws InvalidWrongUserFormat {
        if(nombreUsuario.matches(".*[a-zA-Z].*")) return true;
        else throw new InvalidWrongUserFormat("El nombre del usuario no es válido");
    }

    public static boolean invalidUserAlreadyExists(String nombreUsuario) throws InvalidUserAlreadyExists {

        HashMap<String, Usuario> repositorio = ControladorArchivoUsuarios.cargarRepositorioDesdeArchivo();

        if(repositorio.containsKey(nombreUsuario)) throw new InvalidUserAlreadyExists("El usuario ya existe");
        else return true;
    }

    public static boolean invalidUserDoesntExists(String nombreUsuario, HashMap<String, Usuario> mapaUsuariosRegistrados) throws InvalidUserDoesntExists {

        if(mapaUsuariosRegistrados.containsKey(nombreUsuario)) return true;
        else throw new InvalidUserDoesntExists("El usuario no existe");
    }

    public static boolean invalidCVUAlreadyExists(String cvu, HashMap<String, Usuario> mapaUsuariosRegistrados) throws InvalidCVUAlreadyExists, InvalidNonExistentVirtualWallet {

            for(Map.Entry<String, Usuario> entry : mapaUsuariosRegistrados.entrySet())
                for(BilleteraVirtual billeteraVirtualBuffer : entry.getValue().getBilleterasVirtuales())
                    if((billeteraVirtualBuffer.getBanco().getCvu().equals(cvu))) throw new InvalidCVUAlreadyExists("El cvu ya existe");

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

    public static boolean invalidCuilFormat(String cuil) throws InvalidCuilFormat {

        if(cuil.matches("^\\d{2}-\\d{8}-\\d$")) return true;

        else throw new InvalidCuilFormat("Formato de cuil inválido");
    }
}
