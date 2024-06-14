package View;

import Controller.ControladorVentanaRegistro;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidUserAlreadyExists;
import Exceptions.InvalidWrongUserFormat;
import Exceptions.InvalidWrongUserFormat;
import Interface.DimensionPantalla;
import Interface.IconoVentanas;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class VentanaRegistro implements DimensionPantalla, IconoVentanas {

    private Repositorio repositorio;
    private ControladorVentanaRegistro controladorVentanaRegistro;
    Scanner scanner = new Scanner(System.in);
    private static JFrame ventanaRegistro = new JFrame();

    public VentanaRegistro(Repositorio repositorio) {
        this.repositorio = repositorio;
        this.controladorVentanaRegistro = new ControladorVentanaRegistro(repositorio);
    }

    public void ejecutarVentanaRegistro(){

        ventanaRegistro.setTitle("Registro");
        iconoVentanaGrafica(ventanaRegistro);
        Dimension dimPantalla = calcularDimensionPantalla();
        ventanaRegistro.setSize(dimPantalla);
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
        JButton botonRegister = new JButton("REGISTER");
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
            System.out.println("Ingrese el nombre de usuario a registrar: ");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese el nombre de usuario a registrar: ");
            String password = scanner.nextLine();
            controladorVentanaRegistro.registrarUsuario(repositorio, usuario, password);
            System.out.println("Usuario registrado con exito.");
        }
        catch(InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat exception) {
            System.out.println("El usuario no se ha registrado.");
        }
    }

    public void mostrarVentana(){
        ventanaRegistro.setVisible(true);
    }
}
