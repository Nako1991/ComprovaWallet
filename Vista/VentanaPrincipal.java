package Vista;
import Controlador.ControladorBilleteraVirtual;
import Controlador.ControladorLogueoUsuarios;
import Controlador.ControladorRegistroUsuarios;
import Exceptions.InvalidUserDoesntExists;
import Exceptions.InvalidWrongPasswordFormat;
import Exceptions.InvalidWrongUserFormat;
import Exceptions.Validaciones;
import Interface.DimensionPantalla;
import Modelo.Config;
import Modelo.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VentanaPrincipal extends JFrame implements DimensionPantalla {

    private Scanner scanner = new Scanner(System.in);
    private ControladorRegistroUsuarios controladorRegistroUsuarios;
    private ControladorLogueoUsuarios controladorLogueoUsuarios;
    private ControladorBilleteraVirtual controladorBilleteraVirtual;

    private JLayeredPane panelVentanaPrincipal;

    private JPanel panelFondo;
    private JLabel fondoVentanaPrincipal;
    private JButton botonPanelLogueo; //TEST
    private JButton botonPanelBilleteras; //TEST

    private JPanel panelLateralLogueo;
    private JLabel fondoPanelLateral1;
    private JLabel iconoUsuario;
    private JLabel textoUsuario;
    private JFormattedTextField campoUsuario;
    private JLabel textoContraseña;
    private JPasswordField campoContraseña;
    private JButton botonLogueo;
    private JButton botonRegistrar;
    private JButton botonSalir;

    private JLabel cartelUsuarioLogueo;
    private JLabel cartelUsuarioInvalido;

    private JLabel cartelUsuarioExistente;
    private JLabel cartelContraseñaInvalida;

    private JPanel panelLateralBilleteras;
    private JLabel fondoPanelLateral2;

    private Usuario usuarioLogueado;

    public VentanaPrincipal() {
        inicializarVentanaPrincipal();
        this.setLocationRelativeTo(null);
    }

    private void inicializarVentanaPrincipal() {
        inicializarControladores();
        inicializarPanelFondo();
        inicializarPanelLateralLogueo();
        inicializarPanelLateralBilleteras();
        inicializarPanelVentanaPrincipal();
        inicializarFrameVentanaPrincipal();
    }

    ///INICIALIZACION PANEL FONDO
    private void inicializarPanelFondo() {
        inicializarFondoVentanaPrincipal();
        inicializarBotonesPanelFondo(); //TEST
        inicializarComponentesPanelFondo();
    }

    private void inicializarFondoVentanaPrincipal() {
        fondoVentanaPrincipal = new JLabel();
        fondoVentanaPrincipal.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "background.jpg")); ///TODO comprobacion de null
        fondoVentanaPrincipal.setOpaque(true);
    }

    private void inicializarBotonesPanelFondo() { //TEST
        inicializarBotonPanelLogueo();
        inicializarBotonPanelBilleteras();
    }

    private void inicializarBotonPanelLogueo() { //TEST
        botonPanelLogueo = new JButton();
        botonPanelLogueo.setText("PanelLogueo");
        botonPanelLogueo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonPanelLogueoActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonPanelBilleteras() { //TEST
        botonPanelBilleteras = new JButton();
        botonPanelBilleteras.setText("PanelBilleteras");
        botonPanelBilleteras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonPanelBilleterasActionPerformed(evt);
            }
        });
    }

    private void inicializarComponentesPanelFondo() {
        panelFondo = new JPanel();
        panelFondo.setLayout(new AbsoluteLayout());
        panelFondo.add(botonPanelBilleteras, new AbsoluteConstraints(700, 260, 110, -1));
        panelFondo.add(botonPanelLogueo, new AbsoluteConstraints(700, 210, 110, -1));
        panelFondo.add(fondoVentanaPrincipal, new AbsoluteConstraints(0, 0, -1, -1));
    }

    ///INICIALIZACION PANEL LATERAL LOGUEO
    private void inicializarPanelLateralLogueo() {
        inicializarFondoPanelLateralLogueo();
        inicializarImagenPanelLateralLogueo();
        inicializarCamposPanelLateralLogueo();
        inicializarBotonesPanelLateralLogueo();
        inicializarComponentesPanelLateralLogueo();
    }

    private void inicializarControladores() {
        controladorRegistroUsuarios = new ControladorRegistroUsuarios();
        controladorLogueoUsuarios = new ControladorLogueoUsuarios();
        controladorBilleteraVirtual = new ControladorBilleteraVirtual();
    }

    private void inicializarFondoPanelLateralLogueo() {
        fondoPanelLateral1 = new JLabel();
        fondoPanelLateral1.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "panelLateral.jpg")); ///TODO verificar q no sea null
    }

    private void inicializarImagenPanelLateralLogueo() {
        iconoUsuario = new JLabel();
        iconoUsuario.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "logo.jpeg"));
        iconoUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
    }

    private void inicializarCamposPanelLateralLogueo() {
        inicializarTextoUsuario();
        inicializarCampoUsuario();
        inicializarTextoContraseña();
        inicializarCampoContraseña();
        ///TOCADO POR BRI
        inicializarCartelLogueoUsuario();
        inicializarCartelUsuarioExistente();
        inicializarCartelUsuarioInvalido();
        inicializarCartelContraseñaInvalida();
    }

    private void inicializarTextoUsuario() {
        textoUsuario = new JLabel();
        textoUsuario.setBackground(new Color(0, 51, 153));
        textoUsuario.setFont(new Font("Segoe UI", 0, 24));
        textoUsuario.setForeground(new Color(204, 204, 255));
        textoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        textoUsuario.setText("Usuario");
    }

    private void inicializarCampoUsuario() {
        campoUsuario = new JFormattedTextField();
        campoUsuario.setBackground(new Color(0, 51, 153));
        campoUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        campoUsuario.setForeground(new Color(204, 204, 255));
        campoUsuario.setToolTipText("");
        campoUsuario.setFont(new Font("Segoe UI", 1, 24));
    }

    private void inicializarTextoContraseña() {
        textoContraseña = new JLabel();
        textoContraseña.setBackground(new Color(0, 51, 153));
        textoContraseña.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoContraseña.setForeground(new Color(204, 204, 255));
        textoContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        textoContraseña.setText("Contraseña");
    }

    private void inicializarCampoContraseña() {
        campoContraseña = new JPasswordField();
        campoContraseña.setBackground(new Color(0, 51, 153));
        campoContraseña.setFont(new Font("Segoe UI", 1, 24));
        campoContraseña.setForeground(new Color(204, 204, 255));
        campoContraseña.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
    }

    private void inicializarBotonesPanelLateralLogueo() {
        inicializarBotonLogueo();
        inicializarBotonRegistrar();
        inicializarBotonSalir();
    }

    private void inicializarBotonLogueo() {
        botonLogueo = new JButton();
        botonLogueo.setBackground(new Color(0, 51, 102));
        botonLogueo.setFont(new Font("Segoe UI", 1, 24));
        botonLogueo.setForeground(new Color(204, 204, 255));
        botonLogueo.setText("LOGIN");
        botonLogueo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonLogueoActionPerformed(evt);
            }
        });
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
    }

    private void inicializarComponentesPanelLateralLogueo() {
        panelLateralLogueo = new JPanel();
        panelLateralLogueo.setLayout(new AbsoluteLayout());
        panelLateralLogueo.add(botonSalir, new AbsoluteConstraints(50, 960, 190, 60));
        panelLateralLogueo.add(botonRegistrar, new AbsoluteConstraints(50, 660, 190, 60));
        panelLateralLogueo.add(botonLogueo, new AbsoluteConstraints(50, 570, 190, 60));
        panelLateralLogueo.add(campoContraseña, new AbsoluteConstraints(20, 490, 250, 40));
        panelLateralLogueo.add(textoContraseña, new AbsoluteConstraints(20, 430, 250, 50));
        panelLateralLogueo.add(campoUsuario, new AbsoluteConstraints(20, 370, 250, 40));
        panelLateralLogueo.add(textoUsuario, new AbsoluteConstraints(20, 310, 250, 50));
        ///TOCADO POR BRI
        panelLateralLogueo.add(cartelUsuarioLogueo,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelUsuarioExistente,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelUsuarioInvalido,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelContraseñaInvalida,new AbsoluteConstraints(20, 800, 250, 50));
        //---------------
        panelLateralLogueo.add(iconoUsuario, new AbsoluteConstraints(20, 30, 250, 250));
        panelLateralLogueo.add(fondoPanelLateral1, new AbsoluteConstraints(0, 0, -1, -1));
    }
    ///TOCADO POR BRI
    public void inicializarCartelLogueoUsuario() {
        cartelUsuarioLogueo = new JLabel();
        cartelUsuarioLogueo.setBackground(new Color(046,139,87));
        cartelUsuarioLogueo.setOpaque(true);
        cartelUsuarioLogueo.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioLogueo.setForeground(new Color(204, 204, 255));
        cartelUsuarioLogueo.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioLogueo.setToolTipText("");
        cartelUsuarioLogueo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        cartelUsuarioLogueo.setText("Inicio de sesión exitoso");
        cartelUsuarioLogueo.setVisible(false);
    }

    public void inicializarCartelUsuarioInvalido() {
        cartelUsuarioInvalido = new JLabel();
        cartelUsuarioInvalido.setBackground(new Color(139,000,000));
        cartelUsuarioInvalido.setOpaque(true);
        cartelUsuarioInvalido.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioInvalido.setForeground(new Color(204, 204, 255));
        cartelUsuarioInvalido.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioInvalido.setText("Usuario inválido");
        cartelUsuarioInvalido.setToolTipText("");
        cartelUsuarioInvalido.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));

        cartelUsuarioInvalido.setVisible(false);
    }

    public void inicializarCartelContraseñaInvalida() {
        cartelContraseñaInvalida = new JLabel();
        cartelContraseñaInvalida.setBackground(new Color(139,000,000));
        cartelContraseñaInvalida.setOpaque(true);
        cartelContraseñaInvalida.setFont(new Font("Segoe UI", 0, 24));
        cartelContraseñaInvalida.setForeground(new Color(204, 204, 255));
        cartelContraseñaInvalida.setHorizontalAlignment(SwingConstants.CENTER);
        cartelContraseñaInvalida.setToolTipText("");
        cartelContraseñaInvalida.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        cartelContraseñaInvalida.setText("Contraseña inválida");
        cartelContraseñaInvalida.setVisible(false);
    }

    public void inicializarCartelUsuarioExistente() {
        cartelUsuarioExistente = new JLabel();
        cartelUsuarioExistente.setBackground(new Color(139,000,000));
        cartelUsuarioExistente.setOpaque(true);
        cartelUsuarioExistente.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioExistente.setForeground(new Color(204, 204, 255));
        cartelUsuarioExistente.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioExistente.setToolTipText("");
        cartelUsuarioExistente.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
        cartelUsuarioExistente.setText("El usuario ya existe");
        cartelUsuarioExistente.setVisible(false);
    }

    ///INICIALIZACION PANEL LATERAL BILLETERAS
    private void  inicializarPanelLateralBilleteras() {
        inicializarFondoPanelLateralBilleteras();
        inicializarComponentesPanelLateralBilleteras();
    }

    private void inicializarFondoPanelLateralBilleteras() {
        fondoPanelLateral2 = new JLabel();
        fondoPanelLateral2.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "panelLateral.jpg"));
    }

    private void inicializarComponentesPanelLateralBilleteras() {
        panelLateralBilleteras = new JPanel();
        panelLateralBilleteras.setLayout(new AbsoluteLayout());
        panelLateralBilleteras.add(fondoPanelLateral2, new AbsoluteConstraints(0, 0, -1, -1));
    }

    ///INICIALIZACION PANEL VENTANA PRINCIPAL
    private void inicializarPanelVentanaPrincipal() {
        panelVentanaPrincipal = new JLayeredPane();
        panelVentanaPrincipal.setLayout(new AbsoluteLayout());
        panelVentanaPrincipal.add(panelLateralLogueo, new AbsoluteConstraints(0, 0, 320, -1));
        panelVentanaPrincipal.add(panelLateralBilleteras, new AbsoluteConstraints(0, 0, -1, -1));
        panelVentanaPrincipal.add(panelFondo, new AbsoluteConstraints(0, 0, -1, -1));
    }

    ///INICIALIZACION FRAME VENTANA PRINCIPAL
    private void inicializarFrameVentanaPrincipal() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(new Rectangle(0, 0, 1920, 1080));
        this.setUndecorated(true);
        this.getContentPane().setLayout(new AbsoluteLayout());

        try {
            this.setIconImage(ImageIO.read(new File(Config.getCarpetaImagenes() + "logo.jpeg")));
        } catch (IOException err){
            System.out.println("ERROR--->" + err.getMessage());
        }

        this.getContentPane().add(panelVentanaPrincipal, new AbsoluteConstraints(0, 0, -1, -1));

        this.pack();
    }

    private void botonSalirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void botonRegistrarActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void botonLogueoActionPerformed(ActionEvent evt) {
        loguearUsuario();
    }

    private void loguearUsuario() {

        char[] contraseñaArray = campoContraseña.getPassword();
        String contraseña = new String(contraseñaArray);

        try {
            usuarioLogueado = controladorLogueoUsuarios.loguearUsuario(campoUsuario.getText(), contraseña);
        }
        catch(InvalidWrongUserFormat | InvalidWrongPasswordFormat | InvalidUserDoesntExists exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        if(usuarioLogueado != null) {

            System.out.println(contraseña);
            if( !Validaciones.contraseñaVerificada(contraseña) ) {

                cartelContraseñaInvalida.setVisible(true);
                cartelContraseñaInvalida.setVisible(false);
            }
            else {
                cartelUsuarioLogueo.setVisible(true);
                Timer temporizador = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panelLateralLogueo.setVisible(false);
                        panelLateralBilleteras.setVisible(true);
                    }
                });
                temporizador.setRepeats(false);
                temporizador.start();
                cartelUsuarioLogueo.setVisible(false);
            }
        }
        else {
            cartelUsuarioInvalido.setVisible(true);
        }
    }

    private void botonPanelLogueoActionPerformed(ActionEvent evt) { ///TEST
        panelLateralLogueo.setVisible(true);
        panelLateralBilleteras.setVisible(false);
    }

    private void botonPanelBilleterasActionPerformed(ActionEvent evt) { ///TEST
        panelLateralLogueo.setVisible(false);
        panelLateralBilleteras.setVisible(true);
    }

}
