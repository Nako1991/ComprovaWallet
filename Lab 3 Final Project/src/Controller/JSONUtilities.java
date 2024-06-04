package Controller;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtilities {

    public JSONUtilities() {}

    ///PARA GUARDAR UN JSON ARRAY A UN ARCHIVO
    public static void uploadJSON(JSONArray jsonArray, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo+".json");
            file.write(jsonArray.toString());
            file.flush();
            file.close();
        }catch (IOException err){
            System.out.println("ERROR---> " + err.getMessage());
        }
    }
    ///PARA GUARDAR UN JSON OBJECT A UN ARCHIVO
    public static void uploadJSON(JSONObject jsonObject, String archivo) {
        try {
            FileWriter file = new FileWriter(archivo+".json");
            file.write(jsonObject.toString());
            file.flush();
            file.close();
        }
        catch (IOException err){
            System.out.println("ERROR---> " + err.getMessage());
        }
    }

    ///DESCARGAR INFO DEL ARCHIVO: Nos sirve para mostrar lo que contiene el archivo, si es un JSONArray o un JSONObject
    public static String downloadJSON(String archivo) {
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(Paths.get(archivo+".json")));
        }
        catch (IOException err){
            System.out.println("ERROR--> " + err.getMessage());
        }
        return contenido;
    }

}
