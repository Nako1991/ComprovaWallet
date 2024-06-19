package Controlador;
import Exceptions.InvalidFileIsEmpty;
import Exceptions.Validaciones;
import Modelo.Config;
import Modelo.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ControladorArchivoUsuarios {

    public ControladorArchivoUsuarios() {}

    //Crear un archivo con un JSONObject vacío
    public static void crearArchivo() {

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

    //Crear archivo con usuarios Dummy
    public static void crearArchivoUsuariosDummy() {

        Usuario usuario1 = new Usuario("Rouse", "Rouse484848@@");
        Usuario usuario2 = new Usuario("Nakko", "dsa321");
        Usuario usuario3 = new Usuario("Britany", "suerteConMate");

        JSONObject user1JSON = usuario1.toJSON();
        JSONObject user2JSON = usuario2.toJSON();
        JSONObject user3JSON = usuario3.toJSON();

        JSONArray usuarios = new JSONArray();
        usuarios.put(user1JSON);
        usuarios.put(user2JSON);
        usuarios.put(user3JSON);
        JSONUtilities.uploadJSON(usuarios, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
    }

    //Cargamos el repositorio con los datos grabados en el archivo
    public static HashMap<String, Usuario> cargarRepositorioDesdeArchivo() {

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

    //Grabamos el repositorio en el archivo
    public static void grabarRepositorioEnArchivo(HashMap<String, Usuario> repositorio) {

        JSONArray usuariosJSONArray = new JSONArray();
        if( !repositorio.isEmpty() ) {
            for (Usuario usuario : repositorio.values()) {
                JSONObject usuarioJSON = usuario.toJSON();
                usuariosJSONArray.put(usuarioJSON);
            }
            JSONUtilities.uploadJSON(usuariosJSONArray, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
        }
    }

    //Mostramos el archivo por consola (TEST)
    public static void mostrarArchivo() {

        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        for(Map.Entry<String, Usuario> entry : repositorio.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }

    //Nos traemos un usuario en específico
    public static Usuario leerUsuario(String claveUsuario) {

        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        if( repositorio.containsKey(claveUsuario) )
            return repositorio.get(claveUsuario);
        else
            return null;
    }

    //Modificamos un usuario
    public static void modificarUsuario(Usuario usuario) {

        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        if( repositorio.containsKey(usuario.getUsuario()) ) {
            repositorio.put(usuario.getUsuario(), usuario);
            grabarRepositorioEnArchivo(repositorio);
        }
        else {
            System.out.println("El repositorio no contiene el usuario a modificar.");
        }
    }

    //Eliminar usuario
    public static Usuario eliminarUsuario(Usuario usuario) {

        HashMap<String, Usuario> repositorio = cargarRepositorioDesdeArchivo();

        Usuario usuarioEliminado = null;
        if( repositorio.containsValue(usuario) ) {
            usuarioEliminado = usuario;
            repositorio.remove(usuario);
            grabarRepositorioEnArchivo(repositorio);
        }
        else {
            System.out.println("El repositorio no contiene el usuario a eliminar.");
        }
        return usuarioEliminado;
    }
}
