import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class VentanaPrincipal {
    public VentanaPrincipal() {}

    public void ejecutarVentanaPrincipal(){
        JFrame ventanaMenu = new JFrame("ComprovaWallet");
        ///Cambiando icono de la ventana:
        iconoVentanaGrafica(ventanaMenu);
        ventanaMenu.setSize(400,300);
        ventanaMenu.setLocationRelativeTo(null);
        ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imagenFondoMenu imagen = new imagenFondoMenu();
        imagen.setLayout(new BorderLayout());
        ventanaMenu.add(imagen);

        componentesVentanaPrincipal(imagen);

        ///Colocamos los componentes de esta ventana

        ///Hacemos visible la ventana
        ventanaMenu.setVisible(true);

    }

    private void componentesVentanaPrincipal(JPanel componentes){
        componentes.setLayout(null);
        ///Creando etiqueta
        JLabel label = new JLabel("HOLA SWING");
        ///posicion y tamaño:
        label.setBounds(150, 20, 100, 25);
        componentes.add(label);

        ///Creamos un boton
        JButton boton = new JButton("Login");
        boton.setBounds(150, 60, 100, 25);
        componentes.add(boton);

        ///Probando darle interaccion al boton:
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Boton pulsado");
            }
        });
    }

    public void iconoVentanaGrafica(JFrame ventana){
        try {
            Image icono = ImageIO.read(new File("C:\\Users\\Brisa Ortiz\\Documents\\GitHub\\Lab-3-Final-Project\\logo.jpeg"));
            ventana.setIconImage(icono);
        }catch (IOException err){
            System.out.println("ERROR--->" + err.getMessage());
        }
    }

}
