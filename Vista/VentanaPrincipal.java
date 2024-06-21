package Vista;
import Controlador.ControladorArchivoUsuarios;
import Controlador.ControladorBilleteraVirtual;
import Controlador.ControladorLogueoUsuarios;
import Controlador.JSONUtilities;
import Exceptions.*;
import Interface.DimensionPantalla;
import Interface.Generador;
import Modelo.BilleteraVirtual;
import Modelo.Config;
import Modelo.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VentanaPrincipal extends JFrame implements DimensionPantalla {

    private Scanner scanner = new Scanner(System.in);
    private ControladorLogueoUsuarios controladorLogueoUsuarios;
    private ControladorBilleteraVirtual controladorBilleteraVirtual;

    private JLayeredPane panelVentanaPrincipal;

    private JPanel panelFondo;
    private JLabel fondoVentanaPrincipal;
    private JButton botonPanelLogueo; //TEST
    private JButton botonPanelBilleteras; //TEST

    private JPanel panelLateralLogueo;
    private JLabel fondoPanelLateral1;
    private JLabel iconoLogueo;
    private JLabel textoUsuario;
    private JFormattedTextField campoUsuario;
    private JLabel textoContraseña;
    private JPasswordField campoContraseña;
    private JButton botonLogueo;
    private JButton botonRegistrar;
    private JButton botonSalir;

    private JLabel cartelUsuarioLogueo;
    private JLabel cartelUsuarioInvalido;
    private JLabel cartelContraseñaInvalida;

    private JLabel cartelUsuarioRegistrado;
    private JLabel cartelFormatoUsuarioIncorrecto;
    private JLabel cartelFormatoContraseñaIncorrecto;
    private JLabel cartelUsuarioExistente;

    private JPanel panelLateralBilleteras;
    private JLabel fondoPanelLateral2;
    private JLabel iconoUsuario;
    private JLabel textoUsuarioLogueado;
    private JLabel cartelBilleteraAgregada;
    private JButton botonBilletera1;
    private JButton botonBilletera2;
    private JButton botonBilletera3;
    private JButton botonBilletera4;
    private JButton botonBilletera5;
    private JButton botonAgregarBilletera;
    private JButton botonCerrarSesion;
    private JButton botonSalirPanelBilleteras;

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
        inicializarParametrosDeTesteo(); ///TEST
    }

    private void  inicializarParametrosDeTesteo() { //TEST
        ///SETEANDO ENTORNO DE TESTEO
        panelLateralLogueo.setVisible(false);
        panelLateralBilleteras.setVisible(true);
        botonBilletera1.setVisible(true);
        botonBilletera2.setVisible(true);
        botonBilletera3.setVisible(true);
        botonBilletera4.setVisible(true);
        botonBilletera5.setVisible(true);
        ///CARGANDO USUARIO REGISTRADO DEFAULT
        usuarioLogueado = ControladorArchivoUsuarios.leerUsuario("Rouse");
        textoUsuarioLogueado.setText(usuarioLogueado.getUsuario());
        ControladorBilleteraVirtual.mostrarBilleterasVirtuales(usuarioLogueado);
        System.out.println(usuarioLogueado);
        ///PROBANDO GENERADORES UNO POR UNO
        System.out.println(Generador.generarCVU());
        System.out.println(Generador.generarAlias());
        System.out.println(Generador.generarNombreBanco());
        System.out.println(Generador.generarID("PS"));
        System.out.println(Generador.generarCuil());
        System.out.println(Generador.generarNombreYApellido());
        System.out.println(Generador.generarPersona());
        System.out.println(Generador.generarBilleteraVirtual());
        ///COPIANDO BILLETERAS VIRTUALES DEL USUARIO EN UN ARRAY (VACIO DEFAULT)
        ArrayList<BilleteraVirtual> billeterasVirtuales = usuarioLogueado.getBilleterasVirtuales();
        System.out.println("\n1" + billeterasVirtuales);
        ///CARGANDO 2 BILLETERAS VIRTUALES GENERADAS AL USUARIO
        billeterasVirtuales.add(Generador.generarBilleteraVirtual());
        System.out.println("\n2" + billeterasVirtuales);
        billeterasVirtuales.add(Generador.generarBilleteraVirtual());
        System.out.println("\n3" + billeterasVirtuales);
        ///GUARDANDO LAS BILLETERAS EN EL USUARIO
        usuarioLogueado.setBilleterasVirtuales(billeterasVirtuales);
        System.out.println("\n4" + usuarioLogueado.getBilleterasVirtuales());
        ///GUARDANDO LOS DATOS DE LAS BILLETERAS EN EL JSON
        ControladorBilleteraVirtual.guardarCambiosUsuario(usuarioLogueado);
        System.out.println("\ncambios guardados");
        ///CARGANDO DATOS DESDE EL JSON NUEVAMENTE
        usuarioLogueado = ControladorArchivoUsuarios.leerUsuario(usuarioLogueado.getUsuario());
        System.out.println("\ndesde json" + usuarioLogueado);

    }

    ///INICIALIZACION CONTROLADORES8
    private void inicializarControladores() {
        controladorLogueoUsuarios = new ControladorLogueoUsuarios();
        controladorBilleteraVirtual = new ControladorBilleteraVirtual();
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

    private void inicializarFondoPanelLateralLogueo() {
        fondoPanelLateral1 = new JLabel();
        fondoPanelLateral1.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "panelLateral.jpg")); ///TODO verificar q no sea null
    }

    private void inicializarImagenPanelLateralLogueo() {
        iconoLogueo = new JLabel();
        iconoLogueo.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "logo.jpeg"));
        iconoLogueo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
    }

    private void inicializarCamposPanelLateralLogueo() {
        inicializarTextoUsuario();
        inicializarCampoUsuario();
        inicializarTextoContraseña();
        inicializarCampoContraseña();
        inicializarCarteles();
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

    private void inicializarCarteles() {
        inicializarCartelLogueoUsuario();
        inicializarCartelUsuarioInvalido();
        inicializarCartelContraseñaInvalida();

        inicializarCartelUsuarioRegistrado();
        inicializarCartelFormatoUsuarioIncorrecto();
        inicializarCartelFormatoContraseñaIncorrecto();
        inicializarCartelUsuarioExistente();
        inicializarCartelBilleteraAgregada();
    }

    private void inicializarCartelLogueoUsuario() {
        cartelUsuarioLogueo = new JLabel();
        cartelUsuarioLogueo.setBackground(new Color(0, 51, 153));
        cartelUsuarioLogueo.setOpaque(true);
        cartelUsuarioLogueo.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioLogueo.setForeground(new Color(204, 204, 255));
        cartelUsuarioLogueo.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioLogueo.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(046,139,87)));
        cartelUsuarioLogueo.setText("Iniciando Sesion");
        cartelUsuarioLogueo.setVisible(false);
    }

    private void inicializarCartelUsuarioInvalido() {
        cartelUsuarioInvalido = new JLabel();
        cartelUsuarioInvalido.setBackground(new Color(0, 51, 153));
        cartelUsuarioInvalido.setOpaque(true);
        cartelUsuarioInvalido.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioInvalido.setForeground(new Color(204, 204, 255));
        cartelUsuarioInvalido.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioInvalido.setText("Usuario inválido");
        cartelUsuarioInvalido.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(139,000,000)));
        cartelUsuarioInvalido.setVisible(false);
    }

    private void inicializarCartelContraseñaInvalida() {
        cartelContraseñaInvalida = new JLabel();
        cartelContraseñaInvalida.setBackground(new Color(0, 51, 153));
        cartelContraseñaInvalida.setOpaque(true);
        cartelContraseñaInvalida.setFont(new Font("Segoe UI", 0, 24));
        cartelContraseñaInvalida.setForeground(new Color(204, 204, 255));
        cartelContraseñaInvalida.setHorizontalAlignment(SwingConstants.CENTER);
        cartelContraseñaInvalida.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(139,000,000)));
        cartelContraseñaInvalida.setText("Contraseña inválida");
        cartelContraseñaInvalida.setVisible(false);
    }

    private void inicializarCartelUsuarioRegistrado() {
        cartelUsuarioRegistrado = new JLabel();
        cartelUsuarioRegistrado.setBackground(new Color(0, 51, 153));
        cartelUsuarioRegistrado.setOpaque(true);
        cartelUsuarioRegistrado.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioRegistrado.setForeground(new Color(204, 204, 255));
        cartelUsuarioRegistrado.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioRegistrado.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(046,139,87)));
        cartelUsuarioRegistrado.setText("Usuario Registrado");
        cartelUsuarioRegistrado.setVisible(false);
    }

    private void inicializarCartelFormatoUsuarioIncorrecto() {
        cartelFormatoUsuarioIncorrecto = new JLabel();
        cartelFormatoUsuarioIncorrecto.setBackground(new Color(0, 51, 153));
        cartelFormatoUsuarioIncorrecto.setOpaque(true);
        cartelFormatoUsuarioIncorrecto.setFont(new Font("Segoe UI", 0, 24));
        cartelFormatoUsuarioIncorrecto.setForeground(new Color(204, 204, 255));
        cartelFormatoUsuarioIncorrecto.setHorizontalAlignment(SwingConstants.CENTER);
        cartelFormatoUsuarioIncorrecto.setText("Formato Usuario Invalido");
        cartelFormatoUsuarioIncorrecto.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(139,000,000)));
        cartelFormatoUsuarioIncorrecto.setVisible(false);
    }

    private void inicializarCartelFormatoContraseñaIncorrecto() {
        cartelFormatoContraseñaIncorrecto = new JLabel();
        cartelFormatoContraseñaIncorrecto.setBackground(new Color(0, 51, 153));
        cartelFormatoContraseñaIncorrecto.setOpaque(true);
        cartelFormatoContraseñaIncorrecto.setFont(new Font("Segoe UI", 0, 24));
        cartelFormatoContraseñaIncorrecto.setForeground(new Color(204, 204, 255));
        cartelFormatoContraseñaIncorrecto.setHorizontalAlignment(SwingConstants.CENTER);
        cartelFormatoContraseñaIncorrecto.setText("Formato contraseña invalido");
        cartelFormatoContraseñaIncorrecto.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(139,000,000)));
        cartelFormatoContraseñaIncorrecto.setVisible(false);
    }

    private void inicializarCartelUsuarioExistente() {
        cartelUsuarioExistente = new JLabel();
        cartelUsuarioExistente.setBackground(new Color(0, 51, 153));
        cartelUsuarioExistente.setOpaque(true);
        cartelUsuarioExistente.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioExistente.setForeground(new Color(204, 204, 255));
        cartelUsuarioExistente.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioExistente.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(139,000,000)));
        cartelUsuarioExistente.setText("El usuario ya existe");
        cartelUsuarioExistente.setVisible(false);
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
        panelLateralLogueo.add(iconoLogueo, new AbsoluteConstraints(20, 30, 250, 250));
        panelLateralLogueo.add(cartelUsuarioLogueo,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelUsuarioInvalido,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelContraseñaInvalida,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelUsuarioExistente,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelUsuarioRegistrado,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelFormatoUsuarioIncorrecto,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(cartelFormatoContraseñaIncorrecto,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(fondoPanelLateral1, new AbsoluteConstraints(0, 0, -1, -1));
    }

    ///INICIALIZACION PANEL LATERAL BILLETERAS
    private void  inicializarPanelLateralBilleteras() {
        inicializarFondoPanelLateralBilleteras();
        inicializarImagenPanelLateralBilleteras();
        inicializarCamposPanelLateralBilleteras();
        inicializarBotonesPanelLateralBilleteras();
        inicializarComponentesPanelLateralBilleteras();
    }

    private void inicializarFondoPanelLateralBilleteras() {
        fondoPanelLateral2 = new JLabel();
        fondoPanelLateral2.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "panelLateral.jpg"));
    }

    private void inicializarImagenPanelLateralBilleteras() {
        iconoUsuario = new JLabel();
        iconoUsuario.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "IconoUsuario.png"));
        iconoUsuario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(204, 204, 255)));
    }

    private void inicializarCamposPanelLateralBilleteras() {
        textoUsuarioLogueado = new JLabel();
        textoUsuarioLogueado.setBackground(new Color(0, 51, 153));
        textoUsuarioLogueado.setFont(new Font("Segoe UI", 0, 24));
        textoUsuarioLogueado.setForeground(new Color(204, 204, 255));
        textoUsuarioLogueado.setHorizontalAlignment(SwingConstants.CENTER);
        textoUsuarioLogueado.setText("");
    }

    private void inicializarBotonesPanelLateralBilleteras() {
        inicializarBotonAgregarBilletera();
        inicializarBotonCerrarSesion();
        inicializarBotonSalirPanelBilleteras();
        inicializarBotonBilletera1();
        inicializarBotonBilletera2();
        inicializarBotonBilletera3();
        inicializarBotonBilletera4();
        inicializarBotonBilletera5();
    }

    private void inicializarBotonAgregarBilletera() {
        botonAgregarBilletera = new JButton();
        botonAgregarBilletera.setBackground(new Color(0, 51, 102));
        botonAgregarBilletera.setFont(new Font("Segoe UI", 1, 24));
        botonAgregarBilletera.setForeground(new Color(204, 204, 255));
        botonAgregarBilletera.setText("+ Billetera");
        botonAgregarBilletera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonAgregarBilleteraActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonCerrarSesion() {
        botonCerrarSesion = new JButton();
        botonCerrarSesion.setBackground(new Color(0, 51, 102));
        botonCerrarSesion.setFont(new Font("Segoe UI", 1, 24));
        botonCerrarSesion.setForeground(new Color(204, 204, 255));
        botonCerrarSesion.setText("Cerrar Sesion");
        botonCerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonSalirPanelBilleteras() {
        botonSalirPanelBilleteras = new JButton();
        botonSalirPanelBilleteras.setBackground(new Color(0, 51, 102));
        botonSalirPanelBilleteras.setFont(new Font("Segoe UI", 1, 24));
        botonSalirPanelBilleteras.setForeground(new Color(204, 204, 255));
        botonSalirPanelBilleteras.setText("Salir");
        botonSalirPanelBilleteras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
    }

    private void inicializarCartelBilleteraAgregada(){
        cartelBilleteraAgregada = new JLabel();
        cartelBilleteraAgregada.setBackground(new Color(0, 51, 153));
        cartelBilleteraAgregada.setOpaque(true);
        cartelBilleteraAgregada.setFont(new Font("Segoe UI", 0, 24));
        cartelBilleteraAgregada.setForeground(new Color(204, 204, 255));
        cartelBilleteraAgregada.setHorizontalAlignment(SwingConstants.CENTER);
        ///Configurar para que se vea todo el texto del cartel
        cartelBilleteraAgregada.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(046,139,87)));
        cartelBilleteraAgregada.setText("Billetera Agregada");
        cartelBilleteraAgregada.setVisible(false);
    }

    private void inicializarBotonBilletera1() {
        botonBilletera1 = new JButton();
        botonBilletera1.setBackground(new Color(0, 170, 228));
        botonBilletera1.setFont(new Font("Segoe UI", 1, 24));
        botonBilletera1.setForeground(new Color(204, 204, 255));
        botonBilletera1.setText("");
        botonBilletera1.setVisible(false);
        botonBilletera1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonBilletera1ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera2() {
        botonBilletera2 = new JButton();
        botonBilletera2.setBackground(new Color(0, 170, 228));
        botonBilletera2.setFont(new Font("Segoe UI", 1, 24));
        botonBilletera2.setForeground(new Color(204, 204, 255));
        botonBilletera2.setText("");
        botonBilletera2.setVisible(false);
        botonBilletera2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonBilletera2ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera3() {
        botonBilletera3 = new JButton();
        botonBilletera3.setBackground(new Color(0, 170, 228));
        botonBilletera3.setFont(new Font("Segoe UI", 1, 24));
        botonBilletera3.setForeground(new Color(204, 204, 255));
        botonBilletera3.setText("");
        botonBilletera3.setVisible(false);
        botonBilletera3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonBilletera3ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera4() {
        botonBilletera4 = new JButton();
        botonBilletera4.setBackground(new Color(0, 170, 228));
        botonBilletera4.setFont(new Font("Segoe UI", 1, 24));
        botonBilletera4.setForeground(new Color(204, 204, 255));
        botonBilletera4.setText("");
        botonBilletera4.setVisible(false);
        botonBilletera4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonBilletera4ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera5() {
        botonBilletera5 = new JButton();
        botonBilletera5.setBackground(new Color(0, 170, 228));
        botonBilletera5.setFont(new Font("Segoe UI", 1, 24));
        botonBilletera5.setForeground(new Color(204, 204, 255));
        botonBilletera5.setText("");
        botonBilletera5.setVisible(false);
        botonBilletera5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonBilletera5ActionPerformed(evt);
            }
        });
    }

    private void inicializarComponentesPanelLateralBilleteras() {
        panelLateralBilleteras = new JPanel();
        panelLateralBilleteras.setLayout(new AbsoluteLayout());
        panelLateralBilleteras.add(botonSalirPanelBilleteras, new AbsoluteConstraints(50, 960, 190, 60));
        panelLateralBilleteras.add(botonCerrarSesion, new AbsoluteConstraints(50, 870, 190, 60));
        panelLateralBilleteras.add(botonAgregarBilletera, new AbsoluteConstraints(50, 790, 190, 60));
        panelLateralBilleteras.add(botonBilletera1, new AbsoluteConstraints(20, 350, 250, 50));
        panelLateralBilleteras.add(botonBilletera2, new AbsoluteConstraints(20, 430, 250, 50));
        panelLateralBilleteras.add(botonBilletera3, new AbsoluteConstraints(20, 510, 250, 50));
        panelLateralBilleteras.add(botonBilletera4, new AbsoluteConstraints(20, 590, 250, 50));
        panelLateralBilleteras.add(botonBilletera5, new AbsoluteConstraints(20, 670, 250, 50));
        panelLateralBilleteras.add(cartelBilleteraAgregada, new AbsoluteConstraints(20, 740, 250, 40));
        panelLateralBilleteras.add(textoUsuarioLogueado, new AbsoluteConstraints(20, 290, 250, 50));
        panelLateralBilleteras.add(iconoUsuario, new AbsoluteConstraints(20, 20, 250, 250));
        panelLateralBilleteras.add(fondoPanelLateral2, new AbsoluteConstraints(0, 0, -1, -1));
        panelLateralBilleteras.setVisible(false);
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

    ///FUNCIONALIDADES BOTONES
    private void botonSalirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void botonRegistrarActionPerformed(ActionEvent evt) {
        registrarUsuario();
    }

    private void botonLogueoActionPerformed(ActionEvent evt) {
        loguearUsuario();
    }

    private void botonCerrarSesionActionPerformed(ActionEvent evt) {
        usuarioLogueado = null;
        panelLateralLogueo.setVisible(true);
        panelLateralBilleteras.setVisible(false);
        textoUsuarioLogueado.setText("");
        ocultarCarteles();
    }

    private void botonAgregarBilleteraActionPerformed(ActionEvent evt) {
        agregarBilletaraVirtual();
    }

    private void registrarUsuario() {

        char[] contraseñaArray = campoContraseña.getPassword();
        String contraseña = new String(contraseñaArray);

        try {
            Validaciones.invalidWrongUserFormat(campoUsuario.getText());
            Validaciones.invalidUserAlreadyExists(campoUsuario.getText());
            Validaciones.invalidWrongPasswordFormat(contraseña);

            Usuario nuevoUsuario = new Usuario(campoUsuario.getText(), contraseña);

            JSONObject nuevoUsuarioJSON = nuevoUsuario.toJSON();
            JSONArray usuariosJSONArray = new JSONArray(JSONUtilities.downloadJSON(Config.getCarpetaRaiz() + "usuariosRegistrados.json"));
            usuariosJSONArray.put(nuevoUsuarioJSON);
            JSONUtilities.uploadJSON(usuariosJSONArray, Config.getCarpetaRaiz() + "usuariosRegistrados.json");
            cartelUsuarioRegistrado.setVisible(true);
            loguearUsuario();
        }
        catch(InvalidWrongUserFormat exception) {
            cartelFormatoUsuarioIncorrecto.setVisible(true);
            System.out.println("Error: " + exception.getMessage());
        }
        catch(InvalidWrongPasswordFormat exception) {
            cartelFormatoContraseñaIncorrecto.setVisible(true);
            System.out.println("Error: " + exception.getMessage());
        }
        catch(InvalidUserAlreadyExists exception) {
            cartelUsuarioExistente.setVisible(true);
            System.out.println("Error: " + exception.getMessage());
        }

        Timer temporizadorOcultarCarteles = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocultarCarteles();
            }
        });
        temporizadorOcultarCarteles.setRepeats(false);
        temporizadorOcultarCarteles.start();
    }


    private void loguearUsuario() {

        char[] contraseñaArray = campoContraseña.getPassword();
        String contraseña = new String(contraseñaArray);

        usuarioLogueado = controladorLogueoUsuarios.loguearUsuario(campoUsuario.getText(), contraseña);

        if ( usuarioLogueado == null ) {
            cartelUsuarioInvalido.setVisible(true);
        }
        else if ( !Validaciones.contraseñaVerificada(contraseña) ) {
            cartelContraseñaInvalida.setVisible(true);
        }
        else {
            cartelUsuarioLogueo.setVisible(true);
            Timer temporizadorLogueado = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textoUsuarioLogueado.setText(usuarioLogueado.getUsuario());
                    panelLateralLogueo.setVisible(false);
                    panelLateralBilleteras.setVisible(true);

                }
            });
            temporizadorLogueado.setRepeats(false);
            temporizadorLogueado.start();
        }

        Timer temporizadorOcultarCarteles = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocultarCarteles();
            }
        });
        temporizadorOcultarCarteles.setRepeats(false);
        temporizadorOcultarCarteles.start();

    }

    private void agregarBilletaraVirtual() {

        ControladorBilleteraVirtual.agregarBilleteraVirtual(usuarioLogueado,Generador.generarBilleteraVirtual());
        ArrayList<BilleteraVirtual> bufferBilletera = usuarioLogueado.getBilleterasVirtuales();
        int contadorBotones = 1;

        if (contadorBotones < 6) {
            if (contadorBotones == 1) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera1.setVisible(true);
                botonBilletera1.setText(bufferBilletera.get(0).getBanco().getBanco());
            }
            else if (contadorBotones == 2) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera2.setVisible(true);
                botonBilletera2.setText(bufferBilletera.get(1).getBanco().getBanco());
            }
            else if (contadorBotones == 3) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera3.setVisible(true);
                botonBilletera3.setText(bufferBilletera.get(2).getBanco().getBanco());
            }
            else if (contadorBotones == 4) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera4.setVisible(true);
                botonBilletera4.setText(bufferBilletera.get(3).getBanco().getBanco());
            }
            else if (contadorBotones == 5) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera5.setVisible(true);
                botonBilletera5.setText(bufferBilletera.get(4).getBanco().getBanco());
            }
        }
        Timer temporizadorLogueado = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cartelBilleteraAgregada.setVisible(false);
            }
        });
        temporizadorLogueado.setRepeats(false);
        temporizadorLogueado.start();
    }

    private void ocultarCarteles() {
        cartelUsuarioRegistrado.setVisible(false);
        cartelFormatoUsuarioIncorrecto.setVisible(false);
        cartelFormatoContraseñaIncorrecto.setVisible(false);
        cartelUsuarioExistente.setVisible(false);
        cartelUsuarioInvalido.setVisible(false);
        cartelContraseñaInvalida.setVisible(false);
        cartelUsuarioLogueo.setVisible(false);
    }

    private void botonPanelLogueoActionPerformed(ActionEvent evt) { ///TEST
        panelLateralLogueo.setVisible(true);
        panelLateralBilleteras.setVisible(false);
    }

    private void botonPanelBilleterasActionPerformed(ActionEvent evt) { ///TEST
        panelLateralLogueo.setVisible(false);
        panelLateralBilleteras.setVisible(true);
    }

    private void botonBilletera1ActionPerformed(ActionEvent evt) {

    }

    private void botonBilletera2ActionPerformed(ActionEvent evt) {

    }

    private void botonBilletera3ActionPerformed(ActionEvent evt) {

    }

    private void botonBilletera4ActionPerformed(ActionEvent evt) {

    }

    private void botonBilletera5ActionPerformed(ActionEvent evt) {

    }

}
