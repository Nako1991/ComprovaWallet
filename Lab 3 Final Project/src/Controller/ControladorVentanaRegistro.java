package Controller;

import Exceptions.*;
import Model.Usuario;

import Model.Config;
import Repositorio.Repositorio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ControladorVentanaRegistro {

    private Repositorio repositorio;

    public ControladorVentanaRegistro(Repositorio repositorio) {
        this.repositorio = repositorio;
        this.crearArchivoUsuariosDummy();
        this.cargarUsuariosDesdeArchivo();
    }

    public boolean registrarUsuario(String nombreUsuario, String contraseña) throws InvalidWrongUserFormat, InvalidUserAlreadyExists, InvalidWrongPasswordFormat {
        boolean usuarioComprobado = false;
        this.repositorio.mostrarTodos();

        try {
            Validaciones.invalidWrongUserFormat(nombreUsuario);
            Validaciones.invalidUserAlreadyExists(nombreUsuario, repositorio.getRepositorio());
            Validaciones.invalidWrongPasswordFormat(contraseña);

            //Garbar en el repositorio el usuario creado y luego subirlo al archivo
        }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("\nError: " + exception.getMessage());
        }

        this.repositorio.mostrarTodos();
        return usuarioComprobado;
    }

    private static void crearArchivoUsuariosDummy() {
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

    public void cargarUsuariosDesdeArchivo() {
        try {
            //String rutaAlArchivo = Config.getCarpetaRaiz() + "usuariosRegistrados.json";
            Validaciones.invalidFileIsEmpty(Config.getCarpetaRaiz() + "usuariosRegistrados.json");
            JSONArray usuariosJSONArray = new JSONArray(JSONUtilities.downloadJSON(Config.getCarpetaRaiz() + "usuariosRegistrados.json"));

            for(int i = 0 ; i < usuariosJSONArray.length() ; i++) {
                JSONObject usuarioJSON = usuariosJSONArray.getJSONObject(i);
                Usuario usuarioAAgregar = Usuario.fromJSON(usuarioJSON);
                this.repositorio.agregarUsuario(usuarioAAgregar);
            }
        }
        catch(InvalidFileIsEmpty exception) {
            System.out.println("\nError: " + exception.getMessage());
        }
        catch(JSONException exception) {
            exception.printStackTrace();
        }
    }
}
