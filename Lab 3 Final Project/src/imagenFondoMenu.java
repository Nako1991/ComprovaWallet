import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class imagenFondoMenu extends JPanel {
    private Image imagen;

    public imagenFondoMenu(){
        try {
            imagen = ImageIO.read(new File("C:\\Users\\Brisa Ortiz\\Documents\\GitHub\\Lab-3-Final-Project\\background.jpg"));
        }catch (IOException err){
            System.out.println("ERROR---> " + err.getMessage());
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            // Dibujar la imagen
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
