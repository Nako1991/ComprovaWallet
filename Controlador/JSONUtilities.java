package Controlador;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtilities {

    public JSONUtilities() {}

    public static void uploadJSON(JSONArray jsonArray, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo);
            file.write(jsonArray.toString());
            file.flush();
            file.close();
        }catch (IOException error){
            System.out.println("ERROR:" + error.getMessage());
        }
    }

    public static void uploadJSON(JSONObject jsonObject, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo);
            file.write(jsonObject.toString());
            file.flush();
            file.close();
        }
        catch (IOException error){
            System.out.println("ERROR:" + error.getMessage());
        }
    }

    public static String downloadJSON(String archivo) {
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(Paths.get(archivo)));
        }
        catch (IOException error){
            System.out.println("ERROR:" + error.getMessage());
        }
        return contenido;
    }

}
