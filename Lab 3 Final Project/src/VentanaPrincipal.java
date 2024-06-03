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
        JFrame ventanaPrincipal = new JFrame("ComprovaWallet");
        ///Cambiando icono de la ventana:
        iconoVentanaGrafica(ventanaPrincipal);

        ///Dimension pantalla:
        Dimension dimPantalla = calcularDimensionPantalla();
        int ancho = dimPantalla.width;
        int alto = dimPantalla.height;

        ventanaPrincipal.setSize(ancho,alto);

        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagenFondoMenu imagen = new ImagenFondoMenu();
        imagen.setLayout(new BorderLayout());
        ventanaPrincipal.add(imagen);

        ///Colocamos los componentes de esta ventana
        componentesVentanaPrincipal(imagen, ventanaPrincipal);
        ///Agregando la columna
        JPanel columna = new JPanel();
        columna.setBackground(Color.black);
        columna.setBounds(0, 0, (ancho / 5), alto);
        imagen.add(columna);
        ///Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

    }

    private void componentesVentanaPrincipal(JPanel componentes, JFrame ventanaPrincipal){
        componentes.setLayout(null);
        ///Creando etiqueta
        JLabel label = new JLabel("HOLA SWING");
        ///posicion y tamaño:
        label.setBounds(150, 20, 100, 25);
        componentes.add(label);

        ///Creamos un boton
        JButton login = new JButton("Login");
        login.setBounds(150, 60, 100, 25);
        componentes.add(login);

        ///Probando darle interaccion al boton:
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaLogueo ventanaLogueo = new VentanaLogueo();
                ventanaLogueo.setVisible(true);
                ///A la ventana principal la ocultamos
                ///ventanaPrincipal.setVisible(false);
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

    private Dimension calcularDimensionPantalla(){
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        return tamañoPantalla;
    }
}
