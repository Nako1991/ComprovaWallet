package Interface;

import Controller.JSONUtilities;
import Exceptions.*;
import Model.Config;
import Model.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public interface ControladorArchivo {

    default void crearArchivo() {
        JSONObject jsonObjVacio = new JSONObject();

        try {
            FileWriter fileWriter = new FileWriter(Config.getCarpetaRaiz() + "usuariosRegistrados.json");
            fileWriter.write(jsonObjVacio.toString());
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException exception) {
            System.out.println("\nError: " + exception.getMessage());
        }
    }

    default HashMap<String, Usuario> cargarRepositorioDesdeArchivo() {
        HashMap<String, Usuario> repositorio = new HashMap<>();

        try {
            Validaciones.invalidFileIsEmpty(Config.getCarpetaRaiz() + "usuariosRegistrados.json");
            JSONArray usuariosJSONArray = new JSONArray(JSONUtilities.downloadJSON(Config.getCarpetaRaiz() + "usuariosRegistrados.json"));

            for(int i = 0 ; i < usuariosJSONArray.length() ; i++) {
                JSONObject usuarioJSON = usuariosJSONArray.getJSONObject(i);
                Usuario usuarioAAgregar = Usuario.fromJSON(usuarioJSON);
                repositorio.put(usuarioAAgregar.getUsuario(), usuarioAAgregar);
            }
            return  repositorio;
        }
        catch(InvalidFileIsEmpty | JSONException exception) {
            System.out.println("\nError: " + exception.getMessage());
        }
        return null;
    }

    default void grabarRepositorioEnArchivo(HashMap<String, Usuario> repositorio) {
        JSONArray usuariosJSONArray = new JSONArray();
        if( !repositorio.isEmpty() ) {
            for (Usuario usuario : repositorio.values()) {
                JSONObject usuarioJSON = usuario.toJSON();
                usuariosJSONArray.put(usuarioJSON);
            }
            JSONUtilities.uploadJSON(usuariosJSONArray, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
        }
    }

    default void mostrarArchivo() {
        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        for(Usuario usuario : repositorio.values())
            System.out.println(usuario.toString());
    }

    default void registrarUsuario(String nombreUsuario, String contraseña) throws InvalidWrongUserFormat, InvalidUserAlreadyExists, InvalidWrongPasswordFormat {
        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        try {
            Validaciones.invalidWrongUserFormat(nombreUsuario);
            Validaciones.invalidUserAlreadyExists(nombreUsuario, repositorio);
            Validaciones.invalidWrongPasswordFormat(contraseña);

            Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña);

            JSONObject nuevoUsuarioJSON = nuevoUsuario.toJSON();
            JSONArray usuariosJSONArray = new JSONArray(JSONUtilities.downloadJSON(Config.getCarpetaRaiz() + "usuariosRegistrados.json"));
            usuariosJSONArray.put(nuevoUsuarioJSON);
            JSONUtilities.uploadJSON(usuariosJSONArray, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
        }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            throw exception;
        }
    }

    default Usuario leerUsuario(String claveUsuario) {
        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        if( repositorio.containsKey(claveUsuario) )
            return repositorio.get(claveUsuario);
        else
            return null;
    }

    default void modificarUsuario(Usuario usuario) {
        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        if( repositorio.containsKey(usuario.getUsuario()) ) {
            repositorio.put(usuario.getUsuario(), usuario);
            grabarRepositorioEnArchivo(repositorio);
        }
    }

    default Usuario eliminarUsuario(Usuario usuario) {
        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        Usuario usuarioEliminado = null;
        if( repositorio.containsValue(usuario) ) {
            usuarioEliminado = usuario;
            repositorio.remove(usuario);
            grabarRepositorioEnArchivo(repositorio);
        }
        return usuarioEliminado;
    }

    default void testRegistrarUsuarios(){
        try {
            registrarUsuario("juancito", "lalala"); }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("\nError: " + exception.getMessage()); }

        try {
            registrarUsuario("Rouse02", "Rouse025%"); }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("\nError: " + exception.getMessage()); }

        try {
            registrarUsuario("Rouse02", "Rouse025#"); }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("\nError: " + exception.getMessage()); }
    }

    default void crearArchivoUsuariosDummy() {
        Usuario usuario1 = new Usuario("Ro", "asd123");
        Usuario usuario2 = new Usuario("Nano", "dsa321");
        Usuario usuario3 = new Usuario("Bri", "suerteConMate");

        JSONObject user1JSON = usuario1.toJSON();
        JSONObject user2JSON = usuario2.toJSON();
        JSONObject user3JSON = usuario3.toJSON();

        JSONArray usuarios = new JSONArray();
        usuarios.put(user1JSON);
        usuarios.put(user2JSON);
        usuarios.put(user3JSON);
        JSONUtilities.uploadJSON(usuarios, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
    }

}
