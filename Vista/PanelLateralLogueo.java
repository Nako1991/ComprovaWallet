package Vista;

import Controlador.ControladorBilleteraVirtual;
import Controlador.ControladorLogueoUsuarios;
import Exceptions.Validaciones;
import Interface.MessageListener;
import Modelo.Config;
import Modelo.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PanelLateralLogueo extends JPanel {

    private List<MessageListener> escuchas;

    ControladorLogueoUsuarios controladorLogueoUsuarios;
    ControladorBilleteraVirtual controladorBilleteraVirtual;

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

    public PanelLateralLogueo() {
        inicializarPanelLateralLogueo();
    }

    ///INICIALIZACION PANEL LATERAL LOGUEO
    private void inicializarPanelLateralLogueo() {
        inicializarEscuchas();
        inicializarControladores();
        inicializarFondoPanelLateralLogueo();
        inicializarImagenPanelLateralLogueo();
        inicializarCamposPanelLateralLogueo();
        inicializarBotonesPanelLateralLogueo();
        inicializarComponentesPanelLateralLogueo();
    }


    private void inicializarControladores() {
        controladorLogueoUsuarios = new ControladorLogueoUsuarios();
        controladorBilleteraVirtual = new ControladorBilleteraVirtual();
    }

    private void inicializarEscuchas() {
        escuchas = new ArrayList<>();
    }

    public void agregarEscuchas(MessageListener escucha) {
        escuchas.add(escucha);
    }

    private void notificarEscuchas(String mensaje) {
        for (MessageListener escucha : escuchas)
            escucha.mensajeRecibido(mensaje);
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
        textoContraseña.setFont(new Font("Segoe UI", 0, 24));
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
    }

    private void inicializarCartelLogueoUsuario() {
        cartelUsuarioLogueo = new JLabel();
        cartelUsuarioLogueo.setBackground(new Color(0, 51, 153));
        cartelUsuarioLogueo.setOpaque(true);
        cartelUsuarioLogueo.setFont(new Font("Segoe UI", 0, 24));
        cartelUsuarioLogueo.setForeground(new Color(204, 204, 255));
        cartelUsuarioLogueo.setHorizontalAlignment(SwingConstants.CENTER);
        cartelUsuarioLogueo.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(046,139,87)));
        cartelUsuarioLogueo.setText("Iniciando sesión");
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
        cartelUsuarioRegistrado.setText("Usuario registrado");
        cartelUsuarioRegistrado.setVisible(false);
    }

    private void inicializarCartelFormatoUsuarioIncorrecto() {
        cartelFormatoUsuarioIncorrecto = new JLabel();
        cartelFormatoUsuarioIncorrecto.setBackground(new Color(0, 51, 153));
        cartelFormatoUsuarioIncorrecto.setOpaque(true);
        cartelFormatoUsuarioIncorrecto.setFont(new Font("Segoe UI", 0, 24));
        cartelFormatoUsuarioIncorrecto.setForeground(new Color(204, 204, 255));
        cartelFormatoUsuarioIncorrecto.setHorizontalAlignment(SwingConstants.CENTER);
        cartelFormatoUsuarioIncorrecto.setText("Formato usuario inválido");
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
        cartelFormatoContraseñaIncorrecto.setText("Formato contraseña inválido");
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
        cartelUsuarioExistente.setText("Usuario existente");
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

                //loguearUsuario();
                notificarEscuchas("datos");
            }
        });
    }

//    private void loguearUsuario() {
//        char[] contraseñaArray = campoContraseña.getPassword();
//        String contraseña = new String(contraseñaArray);
//
//        Usuario usuarioLogueado = controladorLogueoUsuarios.loguearUsuario(campoUsuario.getText());
//
//        if (usuarioLogueado == null) {
//            cartelUsuarioInvalido.setVisible(true);
//        } else if (!Validaciones.contraseñaVerificada(contraseña)) {
//            cartelContraseñaInvalida.setVisible(true);
//        } else {
//            cartelUsuarioLogueo.setVisible(true);
//            Timer temporizadorLogueado = new Timer(2000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    //DEBE ENVIARSE COMO MENSAJE A PANEL BILLETERA desde VentanaPrincipal
////                    textoUsuarioLogueado.setText(usuarioLogueado.getUsuario());
////                    panelLateralLogueo.setVisible(false);
////                    panelLateralBilleteras.setVisible(true);
////                    botonGenerarComprobante.setVisible(true); //TEST
////                    mostrarComprobantesUsuarioLogueado(usuarioLogueado);
////                    mostrarBilleterasExistentes();
//                }
//            });
//            temporizadorLogueado.setRepeats(false);
//            temporizadorLogueado.start();
//        }
//
//        Timer temporizadorOcultarCarteles = new Timer(5000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ocultarCarteles();
//            }
//        });
//        temporizadorOcultarCarteles.setRepeats(false);
//        temporizadorOcultarCarteles.start();
//
//    }

    private void inicializarBotonRegistrar() {
        botonRegistrar = new JButton();
        botonRegistrar.setBackground(new Color(0, 51, 102));
        botonRegistrar.setFont(new Font("Segoe UI", 1, 24));
        botonRegistrar.setForeground(new Color(204, 204, 255));
        botonRegistrar.setText("REGISTER");
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                //botonRegistrarActionPerformed(evt);
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

                //botonSalirActionPerformed(evt);
            }
        });
    }

    private void inicializarComponentesPanelLateralLogueo() {
        this.setLayout(new AbsoluteLayout());
        this.add(botonSalir, new AbsoluteConstraints(50, 960, 190, 60));
        this.add(botonRegistrar, new AbsoluteConstraints(50, 660, 190, 60));
        this.add(botonLogueo, new AbsoluteConstraints(50, 570, 190, 60));
        this.add(campoContraseña, new AbsoluteConstraints(20, 490, 250, 40));
        this.add(textoContraseña, new AbsoluteConstraints(20, 430, 250, 50));
        this.add(campoUsuario, new AbsoluteConstraints(20, 370, 250, 40));
        this.add(textoUsuario, new AbsoluteConstraints(20, 310, 250, 50));
        this.add(iconoLogueo, new AbsoluteConstraints(20, 30, 250, 250));
        this.add(cartelUsuarioLogueo,new AbsoluteConstraints(20, 800, 250, 50));
        this.add(cartelUsuarioInvalido,new AbsoluteConstraints(20, 800, 250, 50));
        this.add(cartelContraseñaInvalida,new AbsoluteConstraints(20, 800, 250, 50));
        this.add(cartelUsuarioExistente,new AbsoluteConstraints(20, 800, 250, 50));
        this.add(cartelUsuarioRegistrado,new AbsoluteConstraints(20, 800, 250, 50));
        this.add(cartelFormatoUsuarioIncorrecto,new AbsoluteConstraints(20, 1000, 250, 50)); //TOQUETEADO
        this.add(cartelFormatoContraseñaIncorrecto,new AbsoluteConstraints(20, 800, 250, 50));
        this.add(fondoPanelLateral1, new AbsoluteConstraints(0, 0, -1, -1));
        this.setVisible(true);
    }

}
