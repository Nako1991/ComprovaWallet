package Model;

public class Config {
    private String carpetaImagenes = "C:\\Users\\Olmos\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\img";

    public Config() {}
    public String getCarpetaImagenes() { return carpetaImagenes; }
    public void setCarpetaImagenes(String carpetaImagenes) { this.carpetaImagenes = carpetaImagenes; }

    @Override
    public String toString() {
        return "Config{" +
                "carpetaImagenes='" + carpetaImagenes + '\'' +
                '}';
    }
}
