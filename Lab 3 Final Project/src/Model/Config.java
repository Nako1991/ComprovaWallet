package Model;

public class Config { ///Esta config es local, se encuentra en gitignore
    /// Agregar la direccion de la carpeta de imagenes de tu pc aca
    private static String carpetaImagenes = "C:\\Users\\Olmos\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\img\\";

    public Config() {}
    public static String getCarpetaImagenes() { return carpetaImagenes; }
    public static void setCarpetaImagenes(String carpetaImagenes) { Config.carpetaImagenes = carpetaImagenes; }

    @Override
    public String toString() {
        return "Config{" +
                "carpetaImagenes='" + carpetaImagenes + '\'' +
                '}';
    }
}