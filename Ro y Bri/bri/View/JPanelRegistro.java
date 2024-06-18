package View;

import Controller.ControladorLogueoUsuarios;
import Controller.ControladorRegistroUsuarios;
import Exceptions.InvalidUserAlreadyExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class JPanelRegistro extends JPanel {
    private JButton botonSalir;
    private JButton botonRegistrar;
    private JLabel nombreUsuario;
    private JFormattedTextField campoNombreUsuario;
    private JLabel contraseñaUsuario;
    private JPasswordField campoContraseñaUsuario;

    public JPanelRegistro() {}

    private void inicializarPanelLateralRegistro() {
        inicializarBotonesPanelLateralRegistro();
        inicializarComponentesPanelLateralRegistro();
    }
    private void inicializarBotonesPanelLateralRegistro() {
        inicializarBotonSalir();
        inicializarBotonRegistrar();
    }

    private void inicializarBotonSalir(){
        ///VA LA PERSONALIZACION DEL BOTON SALIR

        this.botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false); ///Ocultamos el panel
            }
        });

    }
    private void inicializarBotonRegistrar(){
        ///VA LA PERSONALIZACION DEL BOTON REGISTRAR
        this.botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ///VA LA INTERACCION CUANDO SE CLICKEA EL BOTON
                botonRegistrarActionPerformed(evt);
            }
        });
    }
    private void botonRegistrarActionPerformed(ActionEvent evt){
        String nombreUsuario = this.campoNombreUsuario.getText();
        char[] contraseñaUsuario = this.campoContraseñaUsuario.getPassword();
        String contraseñaUsuarioString = new String(contraseñaUsuario);

        ControladorRegistroUsuarios controladorRegistro = new ControladorRegistroUsuarios();
        try {
            controladorRegistro.registrarUsuario(nombreUsuario,contraseñaUsuarioString);
            ///Una vez que registramos el usuario que se oculte el panel para luego loguear
            setVisible(false);
        }catch (InvalidWrongUserFormat | InvalidUserAlreadyExists | InvalidWrongPasswordFormat err){
            System.out.println("ERROR---> " + err.getMessage());
        }
    }
    private void inicializarComponentesPanelLateralRegistro() {
        inicializarTextoUsuario();
        inicializarCampoUsuarioRegistro();
        inicializarTextoContraseña();
        inicializarCampoContraseñaRegistro();
    }
    private void inicializarTextoUsuario(){
        nombreUsuario.setBackground(new Color(0, 51, 153));
        nombreUsuario.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        nombreUsuario.setForeground(new Color(204, 204, 255));
        nombreUsuario.setText("Usuario");
        ///AÑADIR MAS PERSONALIZACION

    }
    private void inicializarCampoUsuarioRegistro(){

    }
    private void inicializarTextoContraseña(){
        contraseñaUsuario.setBackground(new Color(0, 51, 153));
        contraseñaUsuario.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        contraseñaUsuario.setForeground(new Color(204, 204, 255));
        contraseñaUsuario.setText("Contraseña");

    }
    private void inicializarCampoContraseñaRegistro(){

    }

}
