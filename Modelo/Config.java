package Modelo;

public class Config { ///TODO Esta config es local, se encuentra en gitignore
    /// Agregar la direccion de la carpeta de imagenes de tu pc aca
    private static String carpetaRaiz = "C:\\Users\\Brisa Ortiz\\Documents\\GitHub\\Lab-3-Final-Project\\";
    private static String carpetaImagenes = getCarpetaRaiz() + "img\\";

    public Config() {}
    public static String getCarpetaImagenes() { return carpetaImagenes; }
    public static void setCarpetaImagenes(String carpetaImagenes) { Config.carpetaImagenes = carpetaImagenes; }
    public static String getCarpetaRaiz() { return carpetaRaiz; }
    public static void setCarpetaRaiz(String carpetaRaiz) { Config.carpetaRaiz = carpetaRaiz; }

}