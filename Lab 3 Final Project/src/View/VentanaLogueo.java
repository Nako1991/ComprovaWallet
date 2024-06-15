package View;
import Controller.ControladorLogueoUsuarios;
import Exceptions.InvalidUserDoesntExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;
import Interface.DimensionPantalla;
import Interface.IconoVentanas;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class VentanaLogueo implements DimensionPantalla, IconoVentanas {

    private Scanner scanner = new Scanner(System.in);
    private ControladorLogueoUsuarios controladorLogueoUsuarios = new ControladorLogueoUsuarios();
    private static JFrame ventanaLogueo = new JFrame("Inicio de Sesión");

    public VentanaLogueo() {

    }

    public void ejecutarVentanaLogeo(){
        iconoVentanaGrafica(ventanaLogueo);
        Dimension dimensionPantalla = calcularDimensionPantalla();
        Dimension dimPantalla = calcularDimensionPantalla();
        Dimension dimVentanaRegistro = new Dimension((int)dimPantalla.getWidth() / 4, (int)dimPantalla.getHeight() / 4);
        ventanaLogueo.setSize(dimVentanaRegistro);
        ventanaLogueo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaLogueo.setLocationRelativeTo(null);

        ///Creando el panel de logeo
        JPanel panelLogin = new JPanel(new GridBagLayout());
        JButton botonLogin = new JButton("LOGIN");
        JButton botonBack = new JButton("BACK");
        panelVentanaLogueo(panelLogin,botonLogin,botonBack);

        botonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaLogueo.setVisible(false);
            }
        });

        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { ingresarUsuario(); }
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
        ventanaLogueo.add(panelLogin);
    }

    public void mostrarVentana(){
        ventanaLogueo.setVisible(true);
    }

    public Usuario ingresarUsuario() {
        try {
            ///TODO Transformar a interfaz grafica
            System.out.println("Ingrese el nombre de usuario a loguear: ");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese la contraseña de usuario a loguear: ");
            String password = scanner.nextLine();
            controladorLogueoUsuarios.loguearUsuario(usuario, password);
            Usuario usuarioALoguear = new Usuario(usuario, password);

            System.out.println("Usuario logueado con exito.");
            ventanaLogueo.setVisible(false);
            return usuarioALoguear;
        }
        catch(InvalidWrongUserFormat | InvalidWrongPasswordFormat | InvalidUserDoesntExists exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return null;
    }

}





