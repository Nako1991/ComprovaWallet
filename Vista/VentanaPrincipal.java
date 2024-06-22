package Vista;
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
    private JButton botonBilletera1;
    private JButton botonEliminarBilletera1;
    private JButton botonBilletera2;
    private JButton botonEliminarBilletera2;
    private JButton botonBilletera3;
    private JButton botonEliminarBilletera3;
    private JButton botonBilletera4;
    private JButton botonEliminarBilletera4;
    private JLabel cartelBilleteraAgregada;
    private JLabel cartelLimiteDeBilleteras;
    private JButton botonAgregarBilletera;
    private JButton botonCerrarSesion;
    private JButton botonSalirPanelBilleteras;

    private JPanel panelComprobantes;

    private JPanel comprobante1;
    private JLabel iconoBancoComprobante1;
    private JButton botonConfirmarComprobante1;
    private JButton botonArchivarComprobante1;
    private JLabel montoCoprobante1;
    private JLabel datosComprobante1;
    private JLabel barraEstadoCoprobante1;

    private JPanel comprobante2;
    private JLabel iconoBancoComprobante2;
    private JButton botonConfirmarComprobante2;
    private JButton botonArchivarComprobante2;
    private JLabel montoCoprobante2;
    private JLabel datosComprobante2;
    private JLabel barraEstadoCoprobante2;

    private JPanel comprobante3;
    private JLabel iconoBancoComprobante3;
    private JButton botonConfirmarComprobante3;
    private JButton botonArchivarComprobante3;
    private JLabel montoCoprobante3;
    private JLabel datosComprobante3;
    private JLabel barraEstadoCoprobante3;

    private JPanel comprobante4;
    private JLabel iconoBancoComprobante4;
    private JButton botonConfirmarComprobante4;
    private JButton botonArchivarComprobante4;
    private JLabel montoCoprobante4;
    private JLabel datosComprobante4;
    private JLabel barraEstadoCoprobante4;

    private JPanel comprobante5;
    private JLabel iconoBancoComprobante5;
    private JButton botonConfirmarComprobante5;
    private JButton botonArchivarComprobante5;
    private JLabel montoCoprobante5;
    private JLabel datosComprobante5;
    private JLabel barraEstadoCoprobante5;

    private JPanel comprobante6;
    private JLabel iconoBancoComprobante6;
    private JButton botonConfirmarComprobante6;
    private JButton botonArchivarComprobante6;
    private JLabel montoCoprobante6;
    private JLabel datosComprobante6;
    private JLabel barraEstadoCoprobante6;

    private JPanel comprobante7;
    private JLabel iconoBancoComprobante7;
    private JButton botonConfirmarComprobante7;
    private JButton botonArchivarComprobante7;
    private JLabel montoCoprobante7;
    private JLabel datosComprobante7;
    private JLabel barraEstadoCoprobante7;

    private JPanel comprobante8;
    private JLabel iconoBancoComprobante8;
    private JButton botonConfirmarComprobante8;
    private JButton botonArchivarComprobante8;
    private JLabel montoCoprobante8;
    private JLabel datosComprobante8;
    private JLabel barraEstadoCoprobante8;

    private Usuario usuarioLogueado;

    public VentanaPrincipal() {
        inicializarVentanaPrincipal();
        this.setLocationRelativeTo(null);
    }

    private void inicializarVentanaPrincipal() {
        inicializarControladores();
        inicializarPanelFondo();
        inicializarPanelComprobantes();
        inicializarPanelLateralLogueo();
        inicializarPanelLateralBilleteras();
        inicializarPanelVentanaPrincipal();
        inicializarFrameVentanaPrincipal();
        inicializarTesteos();
    }

    ///TEST
    private void inicializarTesteos() {

        campoUsuario.setText("Rouse");
        campoContraseña.setText("Rouse484848@@");
        loguearUsuario();
        mostrarBilleterasExistentes();
        

    }

    ///INICIALIZACION CONTROLADORES8
    private void inicializarControladores() {
        controladorLogueoUsuarios = new ControladorLogueoUsuarios();
        controladorBilleteraVirtual = new ControladorBilleteraVirtual();
    }

    ///INICIALIZACION PANEL FONDO
    private void inicializarPanelFondo() {
        inicializarFondoVentanaPrincipal();
        inicializarComponentesPanelFondo();
    }

    private void inicializarFondoVentanaPrincipal() {
        fondoVentanaPrincipal = new JLabel();
        fondoVentanaPrincipal.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "background.jpg")); ///TODO comprobacion de null
        fondoVentanaPrincipal.setOpaque(true);
    }

    private void inicializarComponentesPanelFondo() {
        panelFondo = new JPanel();
        panelFondo.setLayout(new AbsoluteLayout());
        panelFondo.add(fondoVentanaPrincipal, new AbsoluteConstraints(0, 0, -1, -1));
    }

    ///INICIALIZAR PANEL COMPROBANTES
    private void inicializarPanelComprobantes() {
        inicializarComprobantes();
        inicializarComponentesPanelComprobantes();
    }

    private void inicializarComprobantes() {
        inicializarComprobante1();
        inicializarComprobante2();
        inicializarComprobante3();
        inicializarComprobante4();
        inicializarComprobante5();
        inicializarComprobante6();
        inicializarComprobante7();
        inicializarComprobante8();
    }

    private void inicializarComprobante1() {
        inicializarIconoBancoComprobante1();
        inicializarBotonesComprobante1();
        inicializarCamposComprobante1();
        inicializarBarraEstadoComprobante1();
        inicializarComponentesComprobante1();
    }

    private void inicializarIconoBancoComprobante1() {
        iconoBancoComprobante1 = new JLabel();
        iconoBancoComprobante1.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante1.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante1.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante1.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante1.setText("MP");
        iconoBancoComprobante1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante1.setOpaque(true);
    }

    private void inicializarBotonesComprobante1() {
        inicializarBotonConfirmarComprobante1();
        inicializarBotonArchivarComprobante1();
    }

    private void inicializarBotonConfirmarComprobante1() {
        botonConfirmarComprobante1 = new JButton();
        botonConfirmarComprobante1.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante1.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante1.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante1.setText("CONFIRMAR");
        botonConfirmarComprobante1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt); //TODO implementacion boton confirmar comprobante 1
            }
        });
    }

    private void inicializarBotonArchivarComprobante1() {
        botonArchivarComprobante1 = new JButton();
        botonArchivarComprobante1.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante1.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante1.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante1.setText("ARCHIVAR");
        botonArchivarComprobante1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante1() {
        inicializarMontoComprobante1();
        inicializarDatosComprobante1();
    }

    private void inicializarMontoComprobante1() {
        montoCoprobante1 = new JLabel();
        montoCoprobante1.setBackground(new Color(0, 102, 204));
        montoCoprobante1.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante1.setForeground(new Color(255, 255, 255));
        montoCoprobante1.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante1.setText("$3.315.151 ");
        montoCoprobante1.setOpaque(true);
    }

    private void inicializarDatosComprobante1() {
        datosComprobante1 = new JLabel();
        datosComprobante1.setBackground(new Color(0, 102, 204));
        datosComprobante1.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante1.setForeground(new Color(255, 255, 255));
        datosComprobante1.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante1.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante1.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante1() {
        barraEstadoCoprobante1 = new JLabel();
        barraEstadoCoprobante1.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante1.setOpaque(true);
    }

    private void inicializarComponentesComprobante1() {
        comprobante1 = new JPanel();
        comprobante1.setBackground(new Color(0, 51, 153));
        comprobante1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante1.setLayout(new AbsoluteLayout());
        comprobante1.add(iconoBancoComprobante1, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante1.add(botonConfirmarComprobante1, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante1.add(botonArchivarComprobante1, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante1.add(montoCoprobante1, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante1.add(datosComprobante1, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante1.add(barraEstadoCoprobante1, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComprobante2() {
        inicializarIconoBancoComprobante2();
        inicializarBotonesComprobante2();
        inicializarCamposComprobante2();
        inicializarBarraEstadoComprobante2();
        inicializarComponentesComprobante2();
    }

    private void inicializarIconoBancoComprobante2() {
        iconoBancoComprobante2 = new JLabel();
        iconoBancoComprobante2.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante2.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante2.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante2.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante2.setText("MP");
        iconoBancoComprobante2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante2.setOpaque(true);
    }

    private void inicializarBotonesComprobante2() {
        inicializarBotonConfirmarComprobante2();
        inicializarBotonArchivarComprobante2();
    }

    private void inicializarBotonConfirmarComprobante2() {
        botonConfirmarComprobante2 = new JButton();
        botonConfirmarComprobante2.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante2.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante2.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante2.setText("CONFIRMAR");
        botonConfirmarComprobante2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonArchivarComprobante2() {
        botonArchivarComprobante2 = new JButton();
        botonArchivarComprobante2.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante2.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante2.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante2.setText("ARCHIVAR");
        botonArchivarComprobante2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante2() {
        inicializarMontoComprobante2();
        inicializarDatosComprobante2();
    }

    private void inicializarMontoComprobante2() {
        montoCoprobante2 = new JLabel();
        montoCoprobante2.setBackground(new Color(0, 102, 204));
        montoCoprobante2.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante2.setForeground(new Color(255, 255, 255));
        montoCoprobante2.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante2.setText("$3.315.151 ");
        montoCoprobante2.setOpaque(true);
    }

    private void inicializarDatosComprobante2() {
        datosComprobante2 = new JLabel();
        datosComprobante2.setBackground(new Color(0, 102, 204));
        datosComprobante2.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante2.setForeground(new Color(255, 255, 255));
        datosComprobante2.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante2.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante2.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante2() {
        barraEstadoCoprobante2 = new JLabel();
        barraEstadoCoprobante2.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante2.setOpaque(true);
    }

    private void inicializarComponentesComprobante2() {
        comprobante2 = new JPanel();
        comprobante2.setBackground(new Color(0, 51, 153));
        comprobante2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante2.setLayout(new AbsoluteLayout());
        comprobante2.add(iconoBancoComprobante2, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante2.add(botonConfirmarComprobante2, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante2.add(botonArchivarComprobante2, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante2.add(montoCoprobante2, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante2.add(datosComprobante2, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante2.add(barraEstadoCoprobante2, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComprobante3() {
        inicializarIconoBancoComprobante3();
        inicializarBotonesComprobante3();
        inicializarCamposComprobante3();
        inicializarBarraEstadoComprobante3();
        inicializarComponentesComprobante3();
    }
    private void inicializarIconoBancoComprobante3() {
        iconoBancoComprobante3 = new JLabel();
        iconoBancoComprobante3.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante3.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante3.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante3.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante3.setText("MP");
        iconoBancoComprobante3.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante3.setOpaque(true);
    }

    private void inicializarBotonesComprobante3() {
        inicializarBotonConfirmarComprobante3();
        inicializarBotonArchivarComprobante3();
    }

    private void inicializarBotonConfirmarComprobante3() {
        botonConfirmarComprobante3 = new JButton();
        botonConfirmarComprobante3.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante3.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante3.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante3.setText("CONFIRMAR");
        botonConfirmarComprobante3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt); //TODO implementacion boton confirmar comprobante 1
            }
        });
    }

    private void inicializarBotonArchivarComprobante3() {
        botonArchivarComprobante3 = new JButton();
        botonArchivarComprobante3.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante3.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante3.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante3.setText("ARCHIVAR");
        botonArchivarComprobante3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante3() {
        inicializarMontoComprobante3();
        inicializarDatosComprobante3();
    }

    private void inicializarMontoComprobante3() {
        montoCoprobante3 = new JLabel();
        montoCoprobante3.setBackground(new Color(0, 102, 204));
        montoCoprobante3.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante3.setForeground(new Color(255, 255, 255));
        montoCoprobante3.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante3.setText("$3.315.151 ");
        montoCoprobante3.setOpaque(true);
    }

    private void inicializarDatosComprobante3() {
        datosComprobante3 = new JLabel();
        datosComprobante3.setBackground(new Color(0, 102, 204));
        datosComprobante3.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante3.setForeground(new Color(255, 255, 255));
        datosComprobante3.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante3.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante3.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante3() {
        barraEstadoCoprobante3 = new JLabel();
        barraEstadoCoprobante3.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante3.setOpaque(true);
    }

    private void inicializarComponentesComprobante3() {
        comprobante3 = new JPanel();
        comprobante3.setBackground(new Color(0, 51, 153));
        comprobante3.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante3.setLayout(new AbsoluteLayout());
        comprobante3.add(iconoBancoComprobante3, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante3.add(botonConfirmarComprobante3, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante3.add(botonArchivarComprobante3, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante3.add(montoCoprobante3, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante3.add(datosComprobante3, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante3.add(barraEstadoCoprobante3, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComprobante4() {
        inicializarIconoBancoComprobante4();
        inicializarBotonesComprobante4();
        inicializarCamposComprobante4();
        inicializarBarraEstadoComprobante4();
        inicializarComponentesComprobante4();
    }

    private void inicializarIconoBancoComprobante4() {
        iconoBancoComprobante4 = new JLabel();
        iconoBancoComprobante4.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante4.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante4.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante4.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante4.setText("MP");
        iconoBancoComprobante4.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante4.setOpaque(true);
    }

    private void inicializarBotonesComprobante4() {
        inicializarBotonConfirmarComprobante4();
        inicializarBotonArchivarComprobante4();
    }

    private void inicializarBotonConfirmarComprobante4() {
        botonConfirmarComprobante4 = new JButton();
        botonConfirmarComprobante4.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante4.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante4.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante4.setText("CONFIRMAR");
        botonConfirmarComprobante4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt); //TODO implementacion boton confirmar comprobante 1
            }
        });
    }

    private void inicializarBotonArchivarComprobante4() {
        botonArchivarComprobante4 = new JButton();
        botonArchivarComprobante4.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante4.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante4.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante4.setText("ARCHIVAR");
        botonArchivarComprobante4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante4() {
        inicializarMontoComprobante4();
        inicializarDatosComprobante4();
    }

    private void inicializarMontoComprobante4() {
        montoCoprobante4 = new JLabel();
        montoCoprobante4.setBackground(new Color(0, 102, 204));
        montoCoprobante4.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante4.setForeground(new Color(255, 255, 255));
        montoCoprobante4.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante4.setText("$3.315.151 ");
        montoCoprobante4.setOpaque(true);
    }

    private void inicializarDatosComprobante4() {
        datosComprobante4 = new JLabel();
        datosComprobante4.setBackground(new Color(0, 102, 204));
        datosComprobante4.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante4.setForeground(new Color(255, 255, 255));
        datosComprobante4.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante4.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante4.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante4() {
        barraEstadoCoprobante4 = new JLabel();
        barraEstadoCoprobante4.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante4.setOpaque(true);
    }

    private void inicializarComponentesComprobante4() {
        comprobante4 = new JPanel();
        comprobante4.setBackground(new Color(0, 51, 153));
        comprobante4.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante4.setLayout(new AbsoluteLayout());
        comprobante4.add(iconoBancoComprobante4, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante4.add(botonConfirmarComprobante4, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante4.add(botonArchivarComprobante4, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante4.add(montoCoprobante4, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante4.add(datosComprobante4, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante4.add(barraEstadoCoprobante4, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComprobante5() {
        inicializarIconoBancoComprobante5();
        inicializarBotonesComprobante5();
        inicializarCamposComprobante5();
        inicializarBarraEstadoComprobante5();
        inicializarComponentesComprobante5();
    }

    private void inicializarIconoBancoComprobante5() {
        iconoBancoComprobante5 = new JLabel();
        iconoBancoComprobante5.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante5.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante5.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante5.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante5.setText("MP");
        iconoBancoComprobante5.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante5.setOpaque(true);
    }

    private void inicializarBotonesComprobante5() {
        inicializarBotonConfirmarComprobante5();
        inicializarBotonArchivarComprobante5();
    }

    private void inicializarBotonConfirmarComprobante5() {
        botonConfirmarComprobante5 = new JButton();
        botonConfirmarComprobante5.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante5.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante5.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante5.setText("CONFIRMAR");
        botonConfirmarComprobante5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt); //TODO implementacion boton confirmar comprobante 1
            }
        });
    }

    private void inicializarBotonArchivarComprobante5() {
        botonArchivarComprobante5 = new JButton();
        botonArchivarComprobante5.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante5.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante5.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante5.setText("ARCHIVAR");
        botonArchivarComprobante5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante5() {
        inicializarMontoComprobante5();
        inicializarDatosComprobante5();
    }

    private void inicializarMontoComprobante5() {
        montoCoprobante5 = new JLabel();
        montoCoprobante5.setBackground(new Color(0, 102, 204));
        montoCoprobante5.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante5.setForeground(new Color(255, 255, 255));
        montoCoprobante5.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante5.setText("$3.315.151 ");
        montoCoprobante5.setOpaque(true);
    }

    private void inicializarDatosComprobante5() {
        datosComprobante5 = new JLabel();
        datosComprobante5.setBackground(new Color(0, 102, 204));
        datosComprobante5.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante5.setForeground(new Color(255, 255, 255));
        datosComprobante5.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante5.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante5.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante5() {
        barraEstadoCoprobante5 = new JLabel();
        barraEstadoCoprobante5.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante5.setOpaque(true);
    }

    private void inicializarComponentesComprobante5() {
        comprobante5 = new JPanel();
        comprobante5.setBackground(new Color(0, 51, 153));
        comprobante5.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante5.setLayout(new AbsoluteLayout());
        comprobante5.add(iconoBancoComprobante5, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante5.add(botonConfirmarComprobante5, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante5.add(botonArchivarComprobante5, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante5.add(montoCoprobante5, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante5.add(datosComprobante5, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante5.add(barraEstadoCoprobante5, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComprobante6() {
        inicializarIconoBancoComprobante6();
        inicializarBotonesComprobante6();
        inicializarCamposComprobante6();
        inicializarBarraEstadoComprobante6();
        inicializarComponentesComprobante6();
    }

    private void inicializarIconoBancoComprobante6() {
        iconoBancoComprobante6 = new JLabel();
        iconoBancoComprobante6.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante6.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante6.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante6.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante6.setText("MP");
        iconoBancoComprobante6.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante6.setOpaque(true);
    }

    private void inicializarBotonesComprobante6() {
        inicializarBotonConfirmarComprobante6();
        inicializarBotonArchivarComprobante6();
    }

    private void inicializarBotonConfirmarComprobante6() {
        botonConfirmarComprobante6 = new JButton();
        botonConfirmarComprobante6.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante6.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante6.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante6.setText("CONFIRMAR");
        botonConfirmarComprobante6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt); //TODO implementacion boton confirmar comprobante 1
            }
        });
    }

    private void inicializarBotonArchivarComprobante6() {
        botonArchivarComprobante6 = new JButton();
        botonArchivarComprobante6.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante6.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante6.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante6.setText("ARCHIVAR");
        botonArchivarComprobante6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante6() {
        inicializarMontoComprobante6();
        inicializarDatosComprobante6();
    }

    private void inicializarMontoComprobante6() {
        montoCoprobante6 = new JLabel();
        montoCoprobante6.setBackground(new Color(0, 102, 204));
        montoCoprobante6.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante6.setForeground(new Color(255, 255, 255));
        montoCoprobante6.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante6.setText("$3.315.151 ");
        montoCoprobante6.setOpaque(true);
    }

    private void inicializarDatosComprobante6() {
        datosComprobante6 = new JLabel();
        datosComprobante6.setBackground(new Color(0, 102, 204));
        datosComprobante6.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante6.setForeground(new Color(255, 255, 255));
        datosComprobante6.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante6.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante6.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante6() {
        barraEstadoCoprobante6 = new JLabel();
        barraEstadoCoprobante6.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante6.setOpaque(true);
    }

    private void inicializarComponentesComprobante6() {
        comprobante6 = new JPanel();
        comprobante6.setBackground(new Color(0, 51, 153));
        comprobante6.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante6.setLayout(new AbsoluteLayout());
        comprobante6.add(iconoBancoComprobante6, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante6.add(botonConfirmarComprobante6, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante6.add(botonArchivarComprobante6, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante6.add(montoCoprobante6, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante6.add(datosComprobante6, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante6.add(barraEstadoCoprobante6, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComprobante7() {
        inicializarIconoBancoComprobante7();
        inicializarBotonesComprobante7();
        inicializarCamposComprobante7();
        inicializarBarraEstadoComprobante7();
        inicializarComponentesComprobante7();
    }

    private void inicializarIconoBancoComprobante7() {
        iconoBancoComprobante7 = new JLabel();
        iconoBancoComprobante7.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante7.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante7.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante7.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante7.setText("MP");
        iconoBancoComprobante7.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante7.setOpaque(true);
    }

    private void inicializarBotonesComprobante7() {
        inicializarBotonConfirmarComprobante7();
        inicializarBotonArchivarComprobante7();
    }

    private void inicializarBotonConfirmarComprobante7() {
        botonConfirmarComprobante7 = new JButton();
        botonConfirmarComprobante7.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante7.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante7.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante7.setText("CONFIRMAR");
        botonConfirmarComprobante7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt); //TODO implementacion boton confirmar comprobante 1
            }
        });
    }

    private void inicializarBotonArchivarComprobante7() {
        botonArchivarComprobante7 = new JButton();
        botonArchivarComprobante7.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante7.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante7.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante7.setText("ARCHIVAR");
        botonArchivarComprobante7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante7() {
        inicializarMontoComprobante7();
        inicializarDatosComprobante7();
    }

    private void inicializarMontoComprobante7() {
        montoCoprobante7 = new JLabel();
        montoCoprobante7.setBackground(new Color(0, 102, 204));
        montoCoprobante7.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante7.setForeground(new Color(255, 255, 255));
        montoCoprobante7.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante7.setText("$3.315.151 ");
        montoCoprobante7.setOpaque(true);
    }

    private void inicializarDatosComprobante7() {
        datosComprobante7 = new JLabel();
        datosComprobante7.setBackground(new Color(0, 102, 204));
        datosComprobante7.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante7.setForeground(new Color(255, 255, 255));
        datosComprobante7.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante7.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante7.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante7() {
        barraEstadoCoprobante7 = new JLabel();
        barraEstadoCoprobante7.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante7.setOpaque(true);
    }

    private void inicializarComponentesComprobante7() {
        comprobante7 = new JPanel();
        comprobante7.setBackground(new Color(0, 51, 153));
        comprobante7.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante7.setLayout(new AbsoluteLayout());
        comprobante7.add(iconoBancoComprobante7, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante7.add(botonConfirmarComprobante7, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante7.add(botonArchivarComprobante7, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante7.add(montoCoprobante7, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante7.add(datosComprobante7, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante7.add(barraEstadoCoprobante7, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComprobante8() {
        inicializarIconoBancoComprobante8();
        inicializarBotonesComprobante8();
        inicializarCamposComprobante8();
        inicializarBarraEstadoComprobante8();
        inicializarComponentesComprobante8();
    }

    private void inicializarIconoBancoComprobante8() {
        iconoBancoComprobante8 = new JLabel();
        iconoBancoComprobante8.setBackground(new Color(0, 102, 153));
        iconoBancoComprobante8.setFont(new Font("Segoe UI", 0, 36));
        iconoBancoComprobante8.setForeground(new Color(255, 255, 255));
        iconoBancoComprobante8.setHorizontalAlignment(SwingConstants.CENTER);
        iconoBancoComprobante8.setText("MP");
        iconoBancoComprobante8.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        iconoBancoComprobante8.setOpaque(true);
    }

    private void inicializarBotonesComprobante8() {
        inicializarBotonConfirmarComprobante8();
        inicializarBotonArchivarComprobante8();
    }

    private void inicializarBotonConfirmarComprobante8() {
        botonConfirmarComprobante8 = new JButton();
        botonConfirmarComprobante8.setBackground(new Color(0, 51, 102));
        botonConfirmarComprobante8.setFont(new Font("Segoe UI", 1, 20));
        botonConfirmarComprobante8.setForeground(new Color(204, 204, 255));
        botonConfirmarComprobante8.setText("CONFIRMAR");
        botonConfirmarComprobante8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonConfirmarComprobante1ActionPerformed(evt); //TODO implementacion boton confirmar comprobante 1
            }
        });
    }

    private void inicializarBotonArchivarComprobante8() {
        botonArchivarComprobante8 = new JButton();
        botonArchivarComprobante8.setBackground(new Color(0, 51, 102));
        botonArchivarComprobante8.setFont(new Font("Segoe UI", 1, 20));
        botonArchivarComprobante8.setForeground(new Color(204, 204, 255));
        botonArchivarComprobante8.setText("ARCHIVAR");
        botonArchivarComprobante8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //botonArchivarComprobante1ActionPerformed(evt);
            }
        });
    }

    private void inicializarCamposComprobante8() {
        inicializarMontoComprobante8();
        inicializarDatosComprobante8();
    }

    private void inicializarMontoComprobante8() {
        montoCoprobante8 = new JLabel();
        montoCoprobante8.setBackground(new Color(0, 102, 204));
        montoCoprobante8.setFont(new Font("Segoe UI Black", 0, 48));
        montoCoprobante8.setForeground(new Color(255, 255, 255));
        montoCoprobante8.setHorizontalAlignment(SwingConstants.RIGHT);
        montoCoprobante8.setText("$3.315.151 ");
        montoCoprobante8.setOpaque(true);
    }

    private void inicializarDatosComprobante8() {
        datosComprobante8 = new JLabel();
        datosComprobante8.setBackground(new Color(0, 102, 204));
        datosComprobante8.setFont(new Font("Segoe UI", 1, 20));
        datosComprobante8.setForeground(new Color(255, 255, 255));
        datosComprobante8.setText("<html>Nombre: <br><br>Fecha: <br><br>Codigo de transferencia: </html>");
        datosComprobante8.setVerticalAlignment(SwingConstants.TOP);
        datosComprobante8.setOpaque(true);
    }

    private void inicializarBarraEstadoComprobante8() {
        barraEstadoCoprobante8 = new JLabel();
        barraEstadoCoprobante8.setBackground(new Color(0, 153, 51));
        barraEstadoCoprobante8.setOpaque(true);
    }

    private void inicializarComponentesComprobante8() {
        comprobante8 = new JPanel();
        comprobante8.setBackground(new Color(0, 51, 153));
        comprobante8.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
        comprobante8.setLayout(new AbsoluteLayout());
        comprobante8.add(iconoBancoComprobante8, new AbsoluteConstraints(20, 10, 90, 80));
        comprobante8.add(botonConfirmarComprobante8, new AbsoluteConstraints(130, 20, 160, 30));
        comprobante8.add(botonArchivarComprobante8, new AbsoluteConstraints(130, 60, 160, 30));
        comprobante8.add(montoCoprobante8, new AbsoluteConstraints(20, 100, 270, 80));
        comprobante8.add(datosComprobante8, new AbsoluteConstraints(20, 190, 270, 170));
        comprobante8.add(barraEstadoCoprobante8, new AbsoluteConstraints(20, 370, 270, 20));
    }

    private void inicializarComponentesPanelComprobantes() {
        panelComprobantes = new JPanel();
        panelComprobantes.setOpaque(false);
        panelComprobantes.setLayout(new AbsoluteLayout());
        panelComprobantes.add(comprobante1, new AbsoluteConstraints(50, 180, 310, 400));
        panelComprobantes.add(comprobante2, new AbsoluteConstraints(410, 180, 310, 400));
        panelComprobantes.add(comprobante3, new AbsoluteConstraints(770, 180, 310, 400));
        panelComprobantes.add(comprobante4, new AbsoluteConstraints(1130, 180, 310, 400));
        panelComprobantes.add(comprobante5, new AbsoluteConstraints(50, 640, 310, 400));
        panelComprobantes.add(comprobante6, new AbsoluteConstraints(410, 640, 310, 400));
        panelComprobantes.add(comprobante7, new AbsoluteConstraints(770, 640, 310, 400));
        panelComprobantes.add(comprobante8, new AbsoluteConstraints(1130, 640, 310, 400));
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
        panelLateralLogueo.add(cartelFormatoUsuarioIncorrecto,new AbsoluteConstraints(20, 1000, 250, 50)); //TOQUETEADO
        panelLateralLogueo.add(cartelFormatoContraseñaIncorrecto,new AbsoluteConstraints(20, 800, 250, 50));
        panelLateralLogueo.add(fondoPanelLateral1, new AbsoluteConstraints(0, 0, -1, -1));
    }

    ///INICIALIZACION PANEL LATERAL BILLETERAS
    private void  inicializarPanelLateralBilleteras() {
        inicializarFondoPanelLateralBilleteras();
        inicializarImagenPanelLateralBilleteras();
        inicializarCamposPanelLateralBilleteras();
        inicializarBotonesPanelLateralBilleteras();
        inicializarCartelesPanelLateralBilleteras();
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
        textoUsuarioLogueado.setText(""); ///TODO setear el texto cuando se loguea
    }

    private void inicializarBotonesPanelLateralBilleteras() {
        inicializarBotonAgregarBilletera();
        inicializarBotonCerrarSesion();
        inicializarBotonSalirPanelBilleteras();
        inicializarBotonBilletera1();
        inicializarBotonEliminarBilletera1();
        inicializarBotonBilletera2();
        inicializarBotonEliminarBilletera2();
        inicializarBotonBilletera3();
        inicializarBotonEliminarBilletera3();
        inicializarBotonBilletera4();
        inicializarBotonEliminarBilletera4();
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
        botonCerrarSesion.setText("Cerrar sesión");
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
        botonSalirPanelBilleteras.setText("SALIR");
        botonSalirPanelBilleteras.setVisible(true);
        botonSalirPanelBilleteras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera1() {
        botonBilletera1 = new JButton();
        botonBilletera1.setBackground(new Color(1, 25, 127, 255));
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

    private void inicializarBotonEliminarBilletera1() {
        botonEliminarBilletera1 = new JButton();
        botonEliminarBilletera1.setBackground(new Color(1, 25, 127, 255));
        botonEliminarBilletera1.setFont(new Font("Segoe UI", 1, 24));
        botonEliminarBilletera1.setForeground(new Color(204, 204, 255));
        botonEliminarBilletera1.setHorizontalAlignment(SwingConstants.CENTER);
        botonEliminarBilletera1.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(139,000,000)));
        botonEliminarBilletera1.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "boteBasura.png"));
        botonEliminarBilletera1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonEliminarBilletera1ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera2() {
        botonBilletera2 = new JButton();
        botonBilletera2.setBackground(new Color(1, 25, 127, 255));
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

    private void inicializarBotonEliminarBilletera2() {
        botonEliminarBilletera2 = new JButton();
        botonEliminarBilletera2.setBackground(new Color(1, 25, 127, 255));
        botonEliminarBilletera2.setFont(new Font("Segoe UI", 1, 24));
        botonEliminarBilletera2.setForeground(new Color(204, 204, 255));
        botonEliminarBilletera2.setHorizontalAlignment(SwingConstants.CENTER);
        botonEliminarBilletera2.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(139,000,000)));
        botonEliminarBilletera2.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "boteBasura.png"));
        botonEliminarBilletera2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonEliminarBilletera2ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera3() {
        botonBilletera3 = new JButton();
        botonBilletera3.setBackground(new Color(1, 25, 127, 255));
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

    private void inicializarBotonEliminarBilletera3() {
        botonEliminarBilletera3 = new JButton();
        botonEliminarBilletera3.setBackground(new Color(1, 25, 127, 255));
        botonEliminarBilletera3.setFont(new Font("Segoe UI", 1, 24));
        botonEliminarBilletera3.setForeground(new Color(204, 204, 255));
        botonEliminarBilletera3.setHorizontalAlignment(SwingConstants.CENTER);
        botonEliminarBilletera3.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(139,000,000)));
        botonEliminarBilletera3.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "boteBasura.png"));
        botonEliminarBilletera3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonEliminarBilletera3ActionPerformed(evt);
            }
        });
    }

    private void inicializarBotonBilletera4() {
        botonBilletera4 = new JButton();
        botonBilletera4.setBackground(new Color(1, 25, 127, 255));
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

    private void inicializarBotonEliminarBilletera4() {
        botonEliminarBilletera4 = new JButton();
        botonEliminarBilletera4.setBackground(new Color(1, 25, 127, 255));
        botonEliminarBilletera4.setFont(new Font("Segoe UI", 1, 24));
        botonEliminarBilletera4.setForeground(new Color(204, 204, 255));
        botonEliminarBilletera4.setHorizontalAlignment(SwingConstants.CENTER);
        botonEliminarBilletera4.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(139,000,000)));
        botonEliminarBilletera4.setIcon(new ImageIcon(Config.getCarpetaImagenes() + "boteBasura.png"));
        botonEliminarBilletera4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonEliminarBilletera4ActionPerformed(evt);
            }
        });
    }

    private void inicializarCartelesPanelLateralBilleteras() {
        inicializarCartelBilleteraAgregada();
        inicializarCartelLimiteBilletera();
    }

    private void inicializarCartelBilleteraAgregada(){
        cartelBilleteraAgregada = new JLabel();
        cartelBilleteraAgregada.setBackground(new Color(0, 51, 153));
        cartelBilleteraAgregada.setOpaque(true);
        cartelBilleteraAgregada.setFont(new Font("Segoe UI", 0, 24));
        cartelBilleteraAgregada.setForeground(new Color(204, 204, 255));
        cartelBilleteraAgregada.setHorizontalAlignment(SwingConstants.CENTER);
        cartelBilleteraAgregada.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(046,139,87)));
        cartelBilleteraAgregada.setText("Billetera agregada");
        cartelBilleteraAgregada.setVisible(false);
    }

    private void inicializarCartelLimiteBilletera() {
        cartelLimiteDeBilleteras = new JLabel();
        cartelLimiteDeBilleteras.setBackground(new Color(0, 51, 153));
        cartelLimiteDeBilleteras.setOpaque(true);
        cartelLimiteDeBilleteras.setFont(new Font("Segoe UI", 0, 24));
        cartelLimiteDeBilleteras.setForeground(new Color(204, 204, 255));
        cartelLimiteDeBilleteras.setHorizontalAlignment(SwingConstants.CENTER);
        cartelLimiteDeBilleteras.setBorder(BorderFactory.createMatteBorder(8, 8, 8, 8, new Color(139,000,000)));
        cartelLimiteDeBilleteras.setText("Límite de billeteras");
        cartelLimiteDeBilleteras.setVisible(false);
    }

    private void inicializarComponentesPanelLateralBilleteras() {
        panelLateralBilleteras = new JPanel();
        panelLateralBilleteras.setLayout(new AbsoluteLayout());
        panelLateralBilleteras.add(botonSalirPanelBilleteras, new AbsoluteConstraints(50, 960, 190, 60));
        panelLateralBilleteras.add(botonCerrarSesion, new AbsoluteConstraints(50, 870, 190, 60));
        panelLateralBilleteras.add(botonAgregarBilletera, new AbsoluteConstraints(50, 780, 190, 60));
        panelLateralBilleteras.add(botonBilletera1, new AbsoluteConstraints(5, 390, 250, 60));
        panelLateralBilleteras.add(botonEliminarBilletera1, new AbsoluteConstraints(255, 390, 50, 60));
        panelLateralBilleteras.add(botonBilletera2, new AbsoluteConstraints(5, 470, 250, 60));
        panelLateralBilleteras.add(botonEliminarBilletera2, new AbsoluteConstraints(255, 470, 50, 60));
        panelLateralBilleteras.add(botonBilletera3, new AbsoluteConstraints(5, 550, 250, 60));
        panelLateralBilleteras.add(botonEliminarBilletera3, new AbsoluteConstraints(255, 550, 50, 60));
        panelLateralBilleteras.add(botonBilletera4, new AbsoluteConstraints(5, 630, 250, 60));
        panelLateralBilleteras.add(botonEliminarBilletera4, new AbsoluteConstraints(255, 630, 50, 60));
        panelLateralBilleteras.add(iconoUsuario, new AbsoluteConstraints(20, 30, 250, 250));
        panelLateralBilleteras.add(textoUsuarioLogueado, new AbsoluteConstraints(20, 310, 250, 50));
        panelLateralBilleteras.add(cartelLimiteDeBilleteras, new AbsoluteConstraints(20, 700, 250, 60));
        panelLateralBilleteras.add(fondoPanelLateral2, new AbsoluteConstraints(0, 0, -1, -1));
        panelLateralBilleteras.setVisible(false);
    }

    ///INICIALIZACION PANEL VENTANA PRINCIPAL
    private void inicializarPanelVentanaPrincipal() {
        panelVentanaPrincipal = new JLayeredPane();
        panelVentanaPrincipal.setLayout(new AbsoluteLayout());
        panelVentanaPrincipal.add(panelComprobantes, new AbsoluteConstraints(320, 0, 1600, 1080));
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
        mostrarBilleterasExistentes();
    }

    private void botonCerrarSesionActionPerformed(ActionEvent evt) {
        usuarioLogueado = null;
        panelLateralLogueo.setVisible(true);
        panelLateralBilleteras.setVisible(false);
        textoUsuarioLogueado.setText("");
        ocultarCarteles();
        ocultarBilleteras();
    }

    private void botonAgregarBilleteraActionPerformed(ActionEvent evt) {
        agregarBilletaraVirtual();
    }

    private void botonBilletera1ActionPerformed(ActionEvent evt) {
        ///TODO filtro para ver comprobantes de solo esa billetera
    }

    private void botonEliminarBilletera1ActionPerformed(ActionEvent evt) {
        eliminarBilleteraVirtual(0);
        mostrarBilleterasExistentes();
    }

    private void botonBilletera2ActionPerformed(ActionEvent evt) {
        ///TODO filtro para ver comprobantes de solo esa billetera
    }

    private void botonEliminarBilletera2ActionPerformed(ActionEvent evt) {
        eliminarBilleteraVirtual(1);
        mostrarBilleterasExistentes();
    }

    private void botonBilletera3ActionPerformed(ActionEvent evt) {
        ///TODO filtro para ver comprobantes de solo esa billetera
    }
    private void botonEliminarBilletera3ActionPerformed(ActionEvent evt) {
        eliminarBilleteraVirtual(2);
        mostrarBilleterasExistentes();
    }

    private void botonBilletera4ActionPerformed(ActionEvent evt) {
        ///TODO filtro para ver comprobantes de solo esa billetera
    }

    private void botonEliminarBilletera4ActionPerformed(ActionEvent evt) {
        eliminarBilleteraVirtual(3);
        mostrarBilleterasExistentes();
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
        ArrayList<BilleteraVirtual> billeteras = usuarioLogueado.getBilleterasVirtuales();

        int contadorBotones = billeteras.toArray().length;
        contadorBotones++;
        if ( contadorBotones < 5 ) {

            ControladorBilleteraVirtual.agregarBilleteraVirtual(usuarioLogueado,Generador.generarBilleteraVirtual());

            if (contadorBotones == 1) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera1.setVisible(true);
                botonBilletera1.setText(billeteras.get(0).getBanco().getNombreBanco());
                botonEliminarBilletera1.setVisible(true);
            }
            else if ( contadorBotones == 2 ) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera2.setVisible(true);
                botonBilletera2.setText(billeteras.get(1).getBanco().getNombreBanco());
                botonEliminarBilletera2.setVisible(true);
            }
            else if (contadorBotones == 3) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera3.setVisible(true);
                botonBilletera3.setText(billeteras.get(2).getBanco().getNombreBanco());
                botonEliminarBilletera3.setVisible(true);
            }
            else if (contadorBotones == 4) {

                cartelBilleteraAgregada.setVisible(true);
                botonBilletera4.setVisible(true);
                botonBilletera4.setText(billeteras.get(3).getBanco().getNombreBanco());
                botonEliminarBilletera4.setVisible(true);
            }
        }
        else {
            cartelLimiteDeBilleteras.setVisible(true);
        }
        Timer temporizadorLogueado = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartelBilleteraAgregada.setVisible(false);
                cartelLimiteDeBilleteras.setVisible(false);
            }
        });
        temporizadorLogueado.setRepeats(false);
        temporizadorLogueado.start();
    }

    private void eliminarBilleteraVirtual(int posicion) {
        ArrayList<BilleteraVirtual> billeteras = usuarioLogueado.getBilleterasVirtuales();

        try {
            ControladorBilleteraVirtual.eliminarBilleteraVirtual(usuarioLogueado, billeteras.get(posicion).getBanco().getNombreBanco());
        }
        catch (InvalidNonExistentVirtualWallet exception) {
            System.out.println("Error: " + exception.getMessage());
        }

    }

    private void mostrarBilleterasExistentes() {
        ArrayList<BilleteraVirtual> billeterasVirtuales = usuarioLogueado.getBilleterasVirtuales();

        ocultarBilleteras();

        if(billeterasVirtuales != null && !(billeterasVirtuales.isEmpty())) {

            int numBilleteras = billeterasVirtuales.size();
            botonBilletera1.setVisible(true);
            botonBilletera1.setText(billeterasVirtuales.get(0).getBanco().getNombreBanco());
            botonEliminarBilletera1.setVisible(true);

            if (numBilleteras > 1) {
                botonBilletera2.setVisible(true);
                botonBilletera2.setText(billeterasVirtuales.get(1).getBanco().getNombreBanco());
                botonEliminarBilletera2.setVisible(true);
            }

            if (numBilleteras > 2) {
                botonBilletera3.setVisible(true);
                botonBilletera3.setText(billeterasVirtuales.get(2).getBanco().getNombreBanco());
                botonEliminarBilletera3.setVisible(true);
            }

            if (numBilleteras > 3) {
                botonBilletera4.setVisible(true);
                botonBilletera4.setText(billeterasVirtuales.get(3).getBanco().getNombreBanco());
                botonEliminarBilletera4.setVisible(true);
            }
        }
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

    private void ocultarBilleteras() {
        botonBilletera1.setVisible(false);
        botonEliminarBilletera1.setVisible(false);
        botonBilletera2.setVisible(false);
        botonEliminarBilletera2.setVisible(false);
        botonBilletera3.setVisible(false);
        botonEliminarBilletera3.setVisible(false);
        botonBilletera4.setVisible(false);
        botonEliminarBilletera4.setVisible(false);
    }

    private void mostrarComprobantes() {
        comprobante1.setVisible(true);
        comprobante2.setVisible(true);
        comprobante3.setVisible(true);
        comprobante4.setVisible(true);
        comprobante5.setVisible(true);
        comprobante6.setVisible(true);
        comprobante7.setVisible(true);
        comprobante8.setVisible(true);
    }

    private void ocultarComprobantes() {
        comprobante1.setVisible(false);
        comprobante2.setVisible(false);
        comprobante3.setVisible(false);
        comprobante4.setVisible(false);
        comprobante5.setVisible(false);
        comprobante6.setVisible(false);
        comprobante7.setVisible(false);
        comprobante8.setVisible(false);
    }

}
