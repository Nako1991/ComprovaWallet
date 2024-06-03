package View;

import javax.swing.*;
import java.awt.*;

public class VentanaLogueo extends JFrame {
    public VentanaLogueo() {
        setTitle("Ingreso");
        Dimension dim = calcularDimensionPantalla();
        int ancho = dim.width;
        int alto = dim.height;
        setSize(ancho,alto);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel ventanaLogin = new JPanel();
        ventanaLogin.setLayout(new GridLayout(3, 2));

        JLabel etiquetaUsuario = new JLabel("Model.Usuario:");
        JTextField userText = new JTextField(20);
        JLabel etiquetaPassword = new JLabel("Contraseña:");
        JPasswordField textoPassword = new JPasswordField(20);
        JButton botonLogin = new JButton("LOGIN");

        ventanaLogin.add(etiquetaUsuario);
        ventanaLogin.add(userText);
        ventanaLogin.add(etiquetaPassword);
        ventanaLogin.add(textoPassword);
        ventanaLogin.add(new JLabel());
        ventanaLogin.add(botonLogin);

        add(ventanaLogin);
    }


    private Dimension calcularDimensionPantalla(){
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        return tamañoPantalla;
    }
}
