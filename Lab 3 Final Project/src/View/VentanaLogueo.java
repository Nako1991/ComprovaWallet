package View;

import Interface.DimensionPantalla;
import Interface.IconoVentanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogueo implements DimensionPantalla, IconoVentanas {
    private static JFrame ventanaLogin = new JFrame("Inicio de Sesión");
    public VentanaLogueo() {}

    public void ejecutarVentanaLogeo(){
        iconoVentanaGrafica(ventanaLogin);
        Dimension dimensionPantalla = calcularDimensionPantalla();
        ventanaLogin.setSize(dimensionPantalla);
        ventanaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaLogin.setLocationRelativeTo(null);

        ///Creando el panel de logeo
        JPanel panelLogin = new JPanel(new GridBagLayout());
        JButton botonLogin = new JButton("LOGIN");
        JButton botonBack = new JButton("BACK");
        panelVentanaLogueo(panelLogin,botonLogin,botonBack);

        ///Probando darle interaccion al boton back:
        botonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaLogin.setVisible(false);
            }
        });
    }

    public void panelVentanaLogueo(JPanel panelLogin, JButton botonLogin, JButton botonBack){
        panelLogin.setLayout(new GridLayout(3, 2));
        ///CREACION DEL FORMULARIO:
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        JTextField userText = new JTextField(20);
        JLabel etiquetaPassword = new JLabel("Contraseña:");
        JPasswordField textoPassword = new JPasswordField(20);

        panelLogin.add(etiquetaUsuario);
        panelLogin.add(userText);
        panelLogin.add(etiquetaPassword);
        panelLogin.add(textoPassword);
        panelLogin.add(botonBack);
        panelLogin.add(botonLogin);
        ventanaLogin.add(panelLogin);
    }

    public void mostrarVentana(){
        ventanaLogin.setVisible(true);
    }

}





