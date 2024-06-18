package View;

import Controller.ControladorRegistroUsuarios;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidUserAlreadyExists;
import Exceptions.InvalidWrongUserFormat;
import Interface.DimensionPantalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class VentanaRegistro implements DimensionPantalla, IconoVentana {

    Scanner scanner = new Scanner(System.in);
    private ControladorRegistroUsuarios controladorRegistroUsuarios;
    private static JFrame ventanaRegistro = new JFrame();

    public VentanaRegistro() {
        this.controladorRegistroUsuarios = new ControladorRegistroUsuarios();
    }

    public void ejecutarVentanaRegistro(){

        ventanaRegistro.setTitle("Registro");
        iconoVentanaGrafica(ventanaRegistro);
        Dimension dimPantalla = calcularDimensionPantalla();
        Dimension dimVentanaRegistro = new Dimension((int)dimPantalla.getWidth() / 4, (int)dimPantalla.getHeight() / 4);
        ventanaRegistro.setSize(dimVentanaRegistro);
        ventanaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistro.setLocationRelativeTo(null);

        JPanel ventanaRegister = new JPanel();
        ventanaRegister.setLayout(new GridLayout(4, 4));

        JLabel etiquetaUsuario = new JLabel("Nombre de Usuario:");
        JTextField userText = new JTextField(20);
        JLabel etiquetaPassword = new JLabel("Contraseña: ");
        JPasswordField textoPassword = new JPasswordField(20);
        JLabel etiquetaBilletera = new JLabel("Billetera Virtual:");
        JTextField userBilletera = new JTextField(20);
        JButton botonRegister = new JButton("REGISTRAR");
        JButton botonBack = new JButton("BACK");

        ventanaRegister.add(etiquetaUsuario);
        ventanaRegister.add(userText);
        ventanaRegister.add(etiquetaPassword);
        ventanaRegister.add(textoPassword);
        ventanaRegister.add(etiquetaBilletera);
        ventanaRegister.add(userBilletera);
        botonBack(botonBack,ventanaRegister);
        botonRegister(botonRegister,ventanaRegister);

        ventanaRegistro.add(ventanaRegister);

        botonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistro.setVisible(false);
            }
        });

        botonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registracionUsuario();
            }
        });
    }

    public void mostrarVentana(){
        ventanaRegistro.setVisible(true);
    }

    public void botonBack(JButton back, JPanel ventanaRegister){
        Font letra = new Font("Segoe UI", Font.BOLD, 34);
        back.setFont(letra);
        ventanaRegister.add(back);
    }

    public void botonRegister(JButton register, JPanel ventanaRegister){
        Font letra = new Font("Segoe UI", Font.BOLD, 34);
        register.setFont(letra);
        ventanaRegister.add(register);
    }

    public void registracionUsuario(){
        try {
            ///TODO Transformar a interfaz grafica
            System.out.println("Ingrese el nombre de usuario a registrar: ");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese la contraseña de usuario a registrar: ");
            String password = scanner.nextLine();
            controladorRegistroUsuarios.registrarUsuario(usuario, password);
            System.out.println("Usuario registrado con exito.");
            ventanaRegistro.setVisible(false);
        }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("El usuario no se ha registrado.");
        }
    }
}
