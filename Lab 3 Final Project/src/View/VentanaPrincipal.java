package View;
import Interface.DimensionPantalla;
import Interface.IconoVentanas;
import Model.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
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

//    private JFrame ventanaPrincipal;
//    private JPanel columna;
//    private JButton login;
//    private JButton register;
//    private JButton salir;
//    private VentanaLogueo ventanaLogueo;
//    private VentanaRegistro ventanaRegistro;

    public VentanaPrincipal() {
        this.inicializarVentanaPrincipal();
    }

    private void inicializarVentanaPrincipal() {

        inicializarFrameVentanaPrincipal();
        inicializarPanelLateralLogin();
        //inicializarPanelComprobantes();

//        ventanaPrincipal = new JFrame("ComprovaWallet");
//        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Dimension dimensionPantalla = calcularDimensionPantalla();
//        int ancho = dimensionPantalla.width;
//        int alto = dimensionPantalla.height;
//        ventanaPrincipal.setSize(dimensionPantalla);
//        ventanaPrincipal.setLayout(new BorderLayout());
//
//        iconoVentanaGrafica(ventanaPrincipal);
//
//        JPanel panelVentanaPrincipal = new ImagenFondoMenu(dimensionPantalla);
//        panelVentanaPrincipal.setLayout(new BorderLayout());
//        ventanaPrincipal.add(panelVentanaPrincipal);
//
//        componentesVentanaPrincipal(panelVentanaPrincipal, ventanaPrincipal);
//        columna = new JPanel();
//        agregarColumna(columna, panelVentanaPrincipal, ancho, alto);
//
//        ventanaPrincipal.setVisible(true);

    }

    private void inicializarFrameVentanaPrincipal() {
        this.setTitle("ComprovaWallet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dimensionPantalla = calcularDimensionPantalla();
        this.setBounds(0, 0, (int)dimensionPantalla.getWidth(), (int)dimensionPantalla.getHeight());
        setUndecorated(true);
        this.getContentPane().setLayout(new AbsoluteLayout());
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



    private void componentesVentanaPrincipal(JPanel componentes, JFrame ventanaPrincipal){

        ventanaLogueo = new VentanaLogueo();
        ventanaRegistro = new VentanaRegistro();

        //componentes.setLayout(null);
        ///Creamos boton login
        login = new JButton("LOGIN");
        botonLogin(componentes, login);

        ///Creamos boton register
        register = new JButton("REGISTER");
        botonRegister(componentes,register);

        ///Creamos boton salir
        salir = new JButton("SALIR");
        botonSalir(componentes, salir);

        ///Dandole interaccion al boton login:
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaLogueo ventana
                ventanaLogueo.ejecutarVentanaLogeo();
                ventanaLogueo.mostrarVentana();
            }
        });
        ///Dandole interaccion al boton register:
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistro.ejecutarVentanaRegistro();
                ventanaRegistro.mostrarVentana();
            }
        });

        ///Dandole interaccion al boton salir:
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void botonRegister(JPanel componentes, JButton register){
        register.setBounds(50,450,200,100);
        Font letra = new Font("Segoe UI", Font.BOLD, 34);
        register.setFont(letra);
        LineBorder linea = new LineBorder(Color.BLUE,10,false);
        register.setBorder(linea);
        componentes.add(register);
    }

    public void botonLogin(JPanel componentes, JButton login){
        login.setBounds(50, 250, 200, 100);
        Font letra = new Font("Segoe UI", Font.BOLD, 34);
        login.setFont(letra);
        LineBorder linea = new LineBorder(Color.BLUE,10,false);
        login.setBorder(linea);
        componentes.add(login);
    }

    public void botonSalir(JPanel componentes, JButton salir){
        salir.setBounds(90,700,100,50);
        Font letra = new Font("Segoe UI", Font.BOLD, 24);
        salir.setFont(letra);
        LineBorder linea = new LineBorder(Color.BLUE,5,false);
        salir.setBorder(linea);
        componentes.add(salir);
    }

    public void agregarColumna(JPanel columna,JPanel imagen,int ancho, int alto){
        ///Creamos el color personalizado:
        Color colorColumna = new Color(9,21,88);
        ///Agregando la columna
        columna.setBackground(colorColumna);
        columna.setBounds(0, 0, (ancho / 5), alto);
        ///Agregando una linea a la columna
        LineBorder linea = new LineBorder(Color.BLUE,10,true);
        columna.setBorder(linea);
        imagen.add(columna);
    }
}
