package Model;

public class Config { ///Esta config es local, se encuentra en gitignore
    /// Agregar la direccion de la carpeta de imagenes de tu pc aca
    private static String carpetaImagenes = "C:\\Users\\Olmos\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\img\\";
    private static String carpetaRaiz = "C:\\Users\\Olmos\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\";

    public Config() {}
    public static String getCarpetaImagenes() { return carpetaImagenes; }
    public static void setCarpetaImagenes(String carpetaImagenes) { Config.carpetaImagenes = carpetaImagenes; }
    public static String getCarpetaRaiz() { return carpetaRaiz; }
    public static void setCarpetaRaiz(String carpetaRaiz) { Config.carpetaRaiz = carpetaRaiz; }

}