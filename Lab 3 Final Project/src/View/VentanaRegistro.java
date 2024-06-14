package View;

import Controller.ControladorVentanaRegistro;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidUserAlreadyExists;
import Exceptions.InvalidWrongUserFormat;
import Exceptions.invalidWrongUserFormat;
import Interface.DimensionPantalla;
import Interface.IconoVentanas;
import Repositorio.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro implements DimensionPantalla, IconoVentanas {
    private ControladorVentanaRegistro controladorVentanaRegistro;
    private static JFrame ventanaRegistro = new JFrame();
    public VentanaRegistro(Repositorio repositorio) {
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

                try {
                    controladorVentanaRegistro.registrarUsuario("juancito", "lalala");
                } catch (InvalidWrongUserFormat exception) {
                    throw new RuntimeException(exception);
                } catch (InvalidWrongPasswordFormat exception) {
                    throw new RuntimeException(exception);
                } catch (InvalidUserAlreadyExists exception) {
                    throw new RuntimeException(exception);
                }


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

    public void mostrarVentana(){
        ventanaRegistro.setVisible(true);
    }

}
