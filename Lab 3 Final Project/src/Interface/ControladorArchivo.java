package Interface;

import Controller.JSONUtilities;
import Exceptions.*;
import Model.Config;
import Model.Usuario;
import Repositorio.Repositorio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

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

    default void mostrarArchivo(Repositorio repositorio) {
        repositorio.mostrarTodos();
    }

    default Repositorio cargarUsuariosDesdeArchivo() {

        Repositorio repositorio = new Repositorio();
        try {
            Validaciones.invalidFileIsEmpty(Config.getCarpetaRaiz() + "usuariosRegistrados.json");
            JSONArray usuariosJSONArray = new JSONArray(
                    JSONUtilities.downloadJSON(Config.getCarpetaRaiz() + "usuariosRegistrados.json"));

            for(int i = 0 ; i < usuariosJSONArray.length() ; i++) {
                JSONObject usuarioJSON = usuariosJSONArray.getJSONObject(i);
                Usuario usuarioAAgregar = Usuario.fromJSON(usuarioJSON);
                repositorio.agregarUsuario(usuarioAAgregar);
                return  repositorio;
            }
        }
        catch(InvalidFileIsEmpty exception) {
            System.out.println("\nError: " + exception.getMessage());
        }
        catch(JSONException exception) {
            System.out.println("\nError: " + exception.getMessage());
        }
        return null;
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

    default Boolean registrarUsuario(Repositorio repositorio, String nombreUsuario, String contraseña) throws InvalidWrongUserFormat, InvalidUserAlreadyExists, InvalidWrongPasswordFormat {
        boolean usuarioComprobado = false;

        try {
            Validaciones.invalidWrongUserFormat(nombreUsuario);
            Validaciones.invalidUserAlreadyExists(nombreUsuario, repositorio.getRepositorio());
            Validaciones.invalidWrongPasswordFormat(contraseña);

            //Garbar en el repositorio el usuario creado y luego subirlo al archivo
            Usuario nuevoUsuario = new Usuario(nombreUsuario, contraseña);
            repositorio.agregarUsuario(nuevoUsuario);

            JSONObject nuevoUsuarioJSON = nuevoUsuario.toJSON();
            JSONArray usuariosJSONArray = new JSONArray(JSONUtilities.downloadJSON(Config.getCarpetaRaiz() + "usuariosRegistrados.json"));
            usuariosJSONArray.put(nuevoUsuarioJSON);
            JSONUtilities.uploadJSON(usuariosJSONArray, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
        }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            throw exception;
        }

        return usuarioComprobado;
    }

    default void testRegistrarUsuarios(Repositorio repositorio){

        try {
            registrarUsuario(repositorio, "juancito", "lalala"); }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("\nError: " + exception.getMessage()); }

        try {
            registrarUsuario(repositorio, "Rouse02", "Rouse025%"); }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("\nError: " + exception.getMessage()); }

        try {
            registrarUsuario(repositorio, "Rouse02", "Rouse025#"); }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("\nError: " + exception.getMessage()); }
    }

}
