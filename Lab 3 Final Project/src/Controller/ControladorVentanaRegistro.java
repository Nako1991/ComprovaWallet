package Controller;

import Exceptions.*;
import Interface.ControladorArchivo;
import Model.Usuario;
import Model.Config;
import Repositorio.Repositorio;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class ControladorVentanaRegistro implements ControladorArchivo {
    private Repositorio repositorio;

    public ControladorVentanaRegistro(Repositorio repositorio) {
        this.repositorio = repositorio;

        if(cargarUsuariosDesdeArchivo() == null) {
            this.crearArchivo();
            this.mostrarArchivo(repositorio);
        }
        else
            this.repositorio = cargarUsuariosDesdeArchivo();
    }



}
