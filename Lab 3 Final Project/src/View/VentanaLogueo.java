package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JButton botonBack = new JButton("BACK");

        ventanaLogin.add(etiquetaUsuario);
        ventanaLogin.add(userText);
        ventanaLogin.add(etiquetaPassword);
        ventanaLogin.add(textoPassword);
        ventanaLogin.add(botonBack);
        ventanaLogin.add(botonLogin);
        add(ventanaLogin);
        ///Probando darle interaccion al boton:
        botonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }


    private Dimension calcularDimensionPantalla(){
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        return tamañoPantalla;
    }
}
