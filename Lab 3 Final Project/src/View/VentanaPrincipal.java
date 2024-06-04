package View;
import Model.ComprobanteTest;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal implements DimensionPantalla, IconoVentanas {
    public VentanaPrincipal() {}

    public void ejecutarVentanaPrincipal(){
        JFrame ventanaPrincipal = new JFrame("ComprovaWallet");
        ///Cambiando icono de la ventana:
        iconoVentanaGrafica(ventanaPrincipal);

        ///Dimension pantalla:
        Dimension dimPantalla = calcularDimensionPantalla();
        int ancho = dimPantalla.width;
        int alto = dimPantalla.height;

        ventanaPrincipal.setSize(ancho,alto);

        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagenFondoMenu imagen = new ImagenFondoMenu(dimPantalla);
        imagen.setLayout(new BorderLayout());
        ventanaPrincipal.add(imagen);

        ///Colocamos los componentes de esta ventana
        componentesVentanaPrincipal(imagen, ventanaPrincipal);

        ///AGREGANDO LA COLUMNA:
        JPanel columna = new JPanel();
        agregarColumna(columna,imagen,ancho,alto);

        ComprobanteTest comprobanteTest = new ComprobanteTest("Brisa Ortiz", 500,"10/05/2023");
        ///Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

    }

    private void componentesVentanaPrincipal(JPanel componentes, JFrame ventanaPrincipal){
        componentes.setLayout(null);
        ///Creamos boton login
        JButton login = new JButton("LOGIN");
        botonLogin(componentes, login);

        ///Creamos boton register
        JButton register = new JButton("REGISTER");
        botonRegister(componentes,register);

        ///Creamos boton salir
        JButton salir = new JButton("SALIR");
        botonSalir(componentes, salir);

        ///Dandole interaccion al boton login:
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaLogueo ventanaLogueo = new VentanaLogueo();
                ventanaLogueo.ejecutarVentanaLogeo();
                ventanaLogueo.mostrarVentana();
                //ComprobanteTest comprobante = new ComprobanteTest("Brisa ortiz", 500, "03/06/2024");
                //ventanaLogueo.add(comprobante);
                ///A la ventana principal la ocultamos
                ///ventanaPrincipal.setVisible(false);
            }
        });
        ///Dandole interaccion al boton register:
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistro ventanaRegistro = new VentanaRegistro();
                ventanaRegistro.ejecutarVentanaRegistro();
                ventanaRegistro.mostrarVentana();
            }
        });

        ///Dandole interaccion al boton salir:
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.setVisible(false);
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



    /*public void generarComprobanteTest() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Comprobante de Pago");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Model.ComprobanteTest comprobantePago = new Model.ComprobanteTest("Juan Pérez", 50.00, "01/06/2024");
            frame.add(comprobantePago);

            frame.pack();
            frame.setVisible(true);
        });
    }
    */
}
