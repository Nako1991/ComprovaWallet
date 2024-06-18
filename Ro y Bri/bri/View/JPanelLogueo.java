package View;

import Controller.ControladorLogueoUsuarios;
import Exceptions.InvalidUserAlreadyExists;
import Exceptions.InvalidUserDoesntExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;
import Model.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelLogueo extends JPanel {
    private JButton botonSalir;
    private JButton botonLogueo;
    private JButton botonRegistrar;
    private JLabel iconoUsuario;
    private JLabel textoUsuario;
    private JFormattedTextField campoUsuario;
    private JLabel textoContraseña;
    private JPasswordField campoContraseña;

    public JPanelLogueo() {}

    private void inicializarPanelLateralLogin() {
        inicializarBotonesPanelLateralLogin();
        inicializarComponentesPanelLateralLogin();
    }

    private void inicializarBotonesPanelLateralLogin() {
        inicializarBotonSalir();
        inicializarBotonLogin();
        inicializarBotonRegistrar();
    }
    private void inicializarBotonSalir() {
        botonSalir.setBackground(new Color(0, 51, 102));
        botonSalir.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonSalir.setForeground(new Color(204, 204, 255));
        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0); ///Si se clickea el boton salir que corte la ejecucion del programa.
            }
        });
        getContentPane().add(botonSalir, new AbsoluteConstraints(50, 960, 190, 60));
    }

    private void inicializarBotonLogin() {
        botonLogueo.setBackground(new Color(0, 51, 102));
        botonLogueo.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonLogueo.setForeground(new Color(204, 204, 255));
        botonLogueo.setText("LOGIN");
        botonLogueo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(botonLogueo, new AbsoluteConstraints(50, 570, 190, 60));

    }
    private void botonLoginActionPerformed(ActionEvent evt){
        String nombreUsuario = this.campoUsuario.getText();
        char[] contraseñaUsuario = this.campoContraseña.getPassword();
        String contraseñaUsuarioString = new String(contraseñaUsuario);

        ControladorLogueoUsuarios controladorUsuarios = new ControladorLogueoUsuarios();
        try {
            Usuario usuarioLogeado = controladorUsuarios.loguearUsuario(nombreUsuario,contraseñaUsuarioString);
        }catch (InvalidWrongUserFormat | InvalidWrongPasswordFormat | InvalidUserDoesntExists err){
            System.out.println("ERROR---> " + err.getMessage());
        }
    }
    private void inicializarBotonRegistrar() {
        botonRegistrar.setBackground(new Color(0, 51, 102));
        botonRegistrar.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonRegistrar.setForeground(new Color(204, 204, 255));
        botonRegistrar.setText("REGISTER");
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrar, new AbsoluteConstraints(50, 660, 190, 60));
    }

    private void botonRegistrarActionPerformed(ActionEvent evt){

    }

    private void inicializarComponentesPanelLateralLogin() {
        inicializarIconoUsuario();
        inicializarTextoUsuario();
        inicializarCampoUsuario();
        inicializarTextoContraseña();
        inicializarCampoContraseña();

    }

    private void inicializarIconoUsuario() {
        iconoUsuario.setIcon(new ImageIcon(getClass().getResource("/Img/logo.jpeg"))); // NOI18N
        iconoUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        getContentPane().add(iconoUsuario, new AbsoluteConstraints(20, 30, 250, 250));
    }

    private void inicializarTextoUsuario() {
        textoUsuario.setBackground(new Color(0, 51, 153));
        textoUsuario.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoUsuario.setForeground(new Color(204, 204, 255));
        textoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        textoUsuario.setText("Usuario");
        getContentPane().add(textoUsuario, new AbsoluteConstraints(20, 310, 250, 50));
    }

    private void inicializarTextoContraseña(){

    }
    private void inicializarCampoContraseña(){

    }

    private void inicializarCampoUsuario(){

    }
}
