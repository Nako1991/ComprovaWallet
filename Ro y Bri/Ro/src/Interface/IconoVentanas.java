package Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import Model.Config;

public interface IconoVentanas {
    default void iconoVentanaGrafica(JFrame ventana){
        try {
            //String pathImagenLogo = "C:\\Users\\Usuario\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\img\\logo.jpeg";
            Image icono = ImageIO.read(new File(Config.getCarpetaImagenes() + "logo.jpeg"));
            ventana.setIconImage(icono);
        }catch (IOException err){
            System.out.println("ERROR--->" + err.getMessage());
        }
    }
}
