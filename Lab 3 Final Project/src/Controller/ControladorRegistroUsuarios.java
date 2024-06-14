package Controller;

import Exceptions.InvalidUserAlreadyExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;
import Exceptions.Validaciones;
import Interface.InterfazControladorArchivoUsuarios;
import Model.Config;
import Model.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class ControladorRegistroUsuarios implements InterfazControladorArchivoUsuarios {

    public ControladorRegistroUsuarios() {
        if(cargarRepositorioDesdeArchivo() == null) {
            this.crearArchivo();
        }
        this.mostrarArchivo();
    }

    public void registrarUsuario(String nombreUsuario, String contraseña) throws InvalidWrongUserFormat, InvalidUserAlreadyExists, InvalidWrongPasswordFormat {
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

    public void testRegistrarUsuarios(){
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

    public void crearArchivoUsuariosDummy() {
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
