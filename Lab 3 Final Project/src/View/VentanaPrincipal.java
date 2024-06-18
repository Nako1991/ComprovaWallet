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

    private JButton botonSalir;
    private JButton botonLogueo;
    private JButton botonRegistrar;
    private JLabel iconoUsuario;
    private JLabel textoUsuario;
    private JFormattedTextField campoUsuario;
    private JLabel textoContraseña;
    private JPasswordField campoContraseña;
    private JLabel fondoPanelLateral;
    private JLabel fondoPantallaPrincipal;

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
        dimensionPantalla = calcularDimensionPantalla();
        this.setBounds(0, 0, (int)dimensionPantalla.getWidth(), (int)dimensionPantalla.getHeight());
        setUndecorated(true);
        this.getContentPane().setLayout(new AbsoluteLayout());

        inicializarFondoVentanaPrincipal();
    }


    private void inicializarFondoVentanaPrincipal() {
        fondoPantallaPrincipal.setIcon(new ImageIcon(this.iconoVentanaGrafica())); // NOI18N
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
        botonSalir.setBackground(new Color(0, 51, 102));
        botonSalir.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
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

    private void inicializarComponentesPanelLateralLogin() {
        inicializarIconoUsuario();
        inicializarTextoUsuario();
        inicializarCampoUsuario();
        inicializarTextoContraseña();
        inicializarCampoContraseña();
        inicializarFondoPanelLateralLogin();
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

    private void inicializarCampoUsuario() {
        campoUsuario.setBackground(new Color(0, 51, 153));
        campoUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        campoUsuario.setForeground(new Color(204, 204, 255));
        campoUsuario.setToolTipText("");
        campoUsuario.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        getContentPane().add(campoUsuario, new AbsoluteConstraints(20, 370, 250, 40));
    }

    private void inicializarTextoContraseña() {
        textoContraseña.setBackground(new Color(0, 51, 153));
        textoContraseña.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoContraseña.setForeground(new Color(204, 204, 255));
        textoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        textoContraseña.setText("Contraseña");
        getContentPane().add(textoContraseña, new AbsoluteConstraints(20, 430, 250, 50));
    }

    private void inicializarCampoContraseña() {
        campoContraseña.setBackground(new Color(0, 51, 153));
        campoContraseña.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        campoContraseña.setForeground(new Color(204, 204, 255));
        campoContraseña.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        getContentPane().add(campoContraseña, new AbsoluteConstraints(20, 490, 250, 40));
    }

    private void inicializarFondoPanelLateralLogin() {
        fondoPanelLateral.setIcon(new ImageIcon(getClass().getResource("/Imagenes/panelLateral.jpg"))); // NOI18N
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

//    private JFrame ventanaPrincipal;
//    private JPanel columna;
//    private JButton login;
//    private JButton register;
//    private JButton salir;
//    private VentanaLogueo ventanaLogueo;
//    private VentanaRegistro ventanaRegistro;
//
//
//    private void componentesVentanaPrincipal(JPanel componentes, JFrame ventanaPrincipal){
//
//        ventanaLogueo = new VentanaLogueo();
//        ventanaRegistro = new VentanaRegistro();
//
//        //componentes.setLayout(null);
//        ///Creamos boton login
//        login = new JButton("LOGIN");
//        botonLogin(componentes, login);
//
//        ///Creamos boton register
//        register = new JButton("REGISTER");
//        botonRegister(componentes,register);
//
//        ///Creamos boton salir
//        salir = new JButton("SALIR");
//        botonSalir(componentes, salir);
//
//        ///Dandole interaccion al boton login:
//        login.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                VentanaLogueo ventana
//                ventanaLogueo.ejecutarVentanaLogeo();
//                ventanaLogueo.mostrarVentana();
//            }
//        });
//        ///Dandole interaccion al boton register:
//        register.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ventanaRegistro.ejecutarVentanaRegistro();
//                ventanaRegistro.mostrarVentana();
//            }
//        });
//
//        ///Dandole interaccion al boton salir:
//        salir.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//    }
//
//    public void botonRegister(JPanel componentes, JButton register){
//        register.setBounds(50,450,200,100);
//        Font letra = new Font("Segoe UI", Font.BOLD, 34);
//        register.setFont(letra);
//        LineBorder linea = new LineBorder(Color.BLUE,10,false);
//        register.setBorder(linea);
//        componentes.add(register);
//    }
//
//    public void botonLogin(JPanel componentes, JButton login){
//        login.setBounds(50, 250, 200, 100);
//        Font letra = new Font("Segoe UI", Font.BOLD, 34);
//        login.setFont(letra);
//        LineBorder linea = new LineBorder(Color.BLUE,10,false);
//        login.setBorder(linea);
//        componentes.add(login);
//    }
//
//    public void botonSalir(JPanel componentes, JButton salir){
//        salir.setBounds(90,700,100,50);
//        Font letra = new Font("Segoe UI", Font.BOLD, 24);
//        salir.setFont(letra);
//        LineBorder linea = new LineBorder(Color.BLUE,5,false);
//        salir.setBorder(linea);
//        componentes.add(salir);
//    }
//
//    public void agregarColumna(JPanel columna,JPanel imagen,int ancho, int alto){
//        ///Creamos el color personalizado:
//        Color colorColumna = new Color(9,21,88);
//        ///Agregando la columna
//        columna.setBackground(colorColumna);
//        columna.setBounds(0, 0, (ancho / 5), alto);
//        ///Agregando una linea a la columna
//        LineBorder linea = new LineBorder(Color.BLUE,10,true);
//        columna.setBorder(linea);
//        imagen.add(columna);
//    }
}
