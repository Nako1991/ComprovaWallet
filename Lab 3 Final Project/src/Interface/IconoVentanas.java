package Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import Model.Config;

public interface IconoVentanas {
    default ImageIcon iconoVentanaGrafica(){
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("img/logo.jpeg"));
            return icono;
        }catch (NullPointerException exception) {
            System.out.println("El archivo logo.jpeg no pudo ser abierto.");
        }
        return null;
    }
}
