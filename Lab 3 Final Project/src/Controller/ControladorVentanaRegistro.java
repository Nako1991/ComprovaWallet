package Controller;

import Interface.ControladorArchivo;

public class ControladorVentanaRegistro implements ControladorArchivo {

    public ControladorVentanaRegistro() {
        if(cargarRepositorioDesdeArchivo() == null) {
            this.crearArchivo();
            this.mostrarArchivo();
        }
        else {
            this.cargarRepositorioDesdeArchivo();
            this.mostrarArchivo();
        }
    }

}
