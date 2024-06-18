package View;
import Interface.DimensionPantalla;
import Interface.IconoVentanas;
import Model.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements DimensionPantalla, IconoVentanas {

    private Usuario usuarioLogueado;
    private Dimension dimensionPantalla;

    private JLabel fondoPantallaPrincipal;
    private JLabel fondoPanelLateral;
    private JButton botonSalir;
    private JButton botonLogueo;
    private JButton botonRegistrar;
    private JLabel iconoUsuario;
    private JLabel textoUsuario;
    private JFormattedTextField campoUsuario;
    private JLabel textoContraseña;
    private JPasswordField campoContraseña;

    public VentanaPrincipal() {
        this.inicializarVentanaPrincipal();
    }

    private void inicializarVentanaPrincipal() {
        inicializarFrameVentanaPrincipal();
        inicializarPanelLateralLogin();
        //inicializarPanelComprobantes();
        pack();
    }

    private void inicializarFrameVentanaPrincipal() {
        this.setTitle("ComprovaWallet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dimensionPantalla = calcularDimensionPantalla();
        this.setBounds(0, 0, (int)dimensionPantalla.getWidth(), (int)dimensionPantalla.getHeight());
        setUndecorated(true);
        this.getContentPane().setLayout(new AbsoluteLayout());

        inicializarFondoVentanaPrincipal();
        this.setLocationRelativeTo(null);
    }


    private void inicializarFondoVentanaPrincipal() {
        fondoPantallaPrincipal = new JLabel();
        fondoPantallaPrincipal.setIcon(new ImageIcon("C:\\Users\\Olmos\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\background.jpg"));
        getContentPane().add(fondoPantallaPrincipal, new AbsoluteConstraints(0, 0, -1, -1));
    }

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
        botonSalir = new JButton();
        botonSalir.setBackground(new Color(0, 51, 102));
        botonSalir.setFont(new Font("Segoe UI", 1, 24));
        botonSalir.setForeground(new Color(204, 204, 255));
        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new AbsoluteConstraints(50, 960, 190, 60));
    }

    private void inicializarBotonLogin() {
        botonLogueo = new JButton();
        botonLogueo.setBackground(new Color(0, 51, 102));
        botonLogueo.setFont(new Font("Segoe UI", 1, 24));
        botonLogueo.setForeground(new Color(204, 204, 255));
        botonLogueo.setText("LOGIN");
        botonLogueo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(botonLogueo, new AbsoluteConstraints(50, 570, 190, 60));

    }

    private void inicializarBotonRegistrar() {
        botonRegistrar = new JButton();
        botonRegistrar.setBackground(new Color(0, 51, 102));
        botonRegistrar.setFont(new Font("Segoe UI", 1, 24));
        botonRegistrar.setForeground(new Color(204, 204, 255));
        botonRegistrar.setText("REGISTER");
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrar, new AbsoluteConstraints(50, 660, 190, 60));
    }

    private void inicializarComponentesPanelLateralLogin() {
        inicializarFondoPanelLateral();
        inicializarIconoUsuario();
        inicializarTextoUsuario();
        inicializarCampoUsuario();
        inicializarTextoContraseña();
        inicializarCampoContraseña();
    }

    private void inicializarIconoUsuario() {
        iconoUsuario = new JLabel();
        iconoUsuario.setIcon(new ImageIcon("C:\\Users\\Olmos\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\logo.jpeg"));
        iconoUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        getContentPane().add(iconoUsuario, new AbsoluteConstraints(20, 30, 250, 250));
    }

    private void inicializarTextoUsuario() {
        textoUsuario = new JLabel();
        textoUsuario.setBackground(new Color(0, 51, 153));
        textoUsuario.setFont(new Font("Segoe UI", 0, 24));
        textoUsuario.setForeground(new Color(204, 204, 255));
        textoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        textoUsuario.setText("Usuario");
        getContentPane().add(textoUsuario, new AbsoluteConstraints(20, 310, 250, 50));
    }

    private void inicializarCampoUsuario() {
        campoUsuario = new JFormattedTextField();
        campoUsuario.setBackground(new Color(0, 51, 153));
        campoUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        campoUsuario.setForeground(new Color(204, 204, 255));
        campoUsuario.setToolTipText("");
        campoUsuario.setFont(new Font("Segoe UI", 1, 24));
        getContentPane().add(campoUsuario, new AbsoluteConstraints(20, 370, 250, 40));
    }

    private void inicializarTextoContraseña() {
        textoContraseña = new JLabel();
        textoContraseña.setBackground(new Color(0, 51, 153));
        textoContraseña.setFont(new Font("Segoe UI", 0, 24));
        textoContraseña.setForeground(new Color(204, 204, 255));
        textoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        textoContraseña.setText("Contraseña");
        getContentPane().add(textoContraseña, new AbsoluteConstraints(20, 430, 250, 50));
    }

    private void inicializarCampoContraseña() {
        campoContraseña = new JPasswordField();
        campoContraseña.setBackground(new Color(0, 51, 153));
        campoContraseña.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        campoContraseña.setForeground(new Color(204, 204, 255));
        campoContraseña.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        getContentPane().add(campoContraseña, new AbsoluteConstraints(20, 490, 250, 40));
    }

    private void inicializarFondoPanelLateral() {
        fondoPanelLateral = new JLabel();
        fondoPanelLateral.setIcon(new ImageIcon("C:\\Users\\Olmos\\Documents\\GitHub\\Lab-3-Final-Project\\Lab 3 Final Project\\src\\panelLateral.jpg"));
        getContentPane().add(fondoPanelLateral, new AbsoluteConstraints(-10, 0, 320, 1080));
    }

    ///ACCIONES
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void botonLoginActionPerformed(java.awt.event.ActionEvent evt) {
        ///TODO implementacion del boton login
    }

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        ///TODO implementacion del boton registrar
    }



}
