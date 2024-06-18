package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelAgregarBilletera extends JPanel{
    private JButton botonAgregarBilletera;
    private JButton botonBack;
    private JLabel textoNombreApellido;
    private JFormattedTextField campoNombreApellido;
    private JLabel textoCuil;
    private JFormattedTextField campoCuil;
    private JLabel textoNombreBanco;
    private JFormattedTextField campoNombreBanco;
    private JLabel textoAliasBanco;
    private JFormattedTextField campoAliasBanco;

    public void inicializarPanelAgregarBilletera(){
        inicializarBotonesAgregarBilletera();
        inicializarComponentesPanelAgregarBilletera();
    }
    private void inicializarBotonesAgregarBilletera(){
        inicializarBotonBack();
        inicializarBotonAgregarBilletera();
    }
    private void inicializarBotonBack(){
        botonBack.setBackground(new Color(0, 51, 102));
        botonBack.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonBack.setForeground(new Color(204, 204, 255));
        botonBack.setText("BACK");
        botonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonBackActionPerformed(evt);
            }
        });
    }

    private void botonBackActionPerformed(ActionEvent evt){
        JPanelBilleterasVirtuales panelBilleterasVirtuales = new JPanelBilleterasVirtuales();
        ///No se si esta bien la linea de arriba o directamente pasarle el JPanel de billeteras virtuales por parametro a inicializarPanelAgregarBilletera()
        this.setVisible(false);
        panelBilleterasVirtuales.setVisible(true);
    }

    private void inicializarBotonAgregarBilletera(){
        botonAgregarBilletera.setBackground(new Color(0, 51, 102));
        botonAgregarBilletera.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonAgregarBilletera.setForeground(new Color(204, 204, 255));
        botonAgregarBilletera.setText("AGREGAR BILLETERA");
        botonAgregarBilletera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonAgregarBilleteraActionPerformed(evt);
            }
        });
    }
    private void botonAgregarBilleteraActionPerformed(ActionEvent evt){
        String nombreApellido = this.campoNombreApellido.getText();
        String cuil = this.campoCuil.getText();
        String nombreBanco = this.campoNombreBanco.getText();
        String aliasBanco = this.campoAliasBanco.getText();
        ///FALTA EL CONTROLADOR DE BILLETERAS VIRTUALES PARA VALIDARLO Y AGREGARLO.
    }

    private void inicializarComponentesPanelAgregarBilletera(){
        inicializarTextoNombreApellido();
        inicializarCampoNombreApellido();
        inicializarTextoCuil();
        inicializarCampoCuil();
        inicializarTextoNombreBanco();
        inicializarCampoNombreBanco();
        inicializarTextoAliasBanco();
        inicializarCampoAliasBanco();
    }

    private void inicializarTextoNombreApellido(){
        textoNombreApellido.setBackground(new Color(0, 51, 153));
        textoNombreApellido.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoNombreApellido.setForeground(new Color(204, 204, 255));
        textoNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
        textoNombreApellido.setText("Nombre y Apellido");
    }

    private void inicializarCampoNombreApellido(){

    }

    private void inicializarTextoCuil(){
        textoCuil.setBackground(new Color(0, 51, 153));
        textoCuil.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoCuil.setForeground(new Color(204, 204, 255));
        textoCuil.setHorizontalAlignment(SwingConstants.CENTER);
        textoCuil.setText("Cuil");
    }

    private void inicializarCampoCuil(){

    }

    private void inicializarTextoNombreBanco(){
        textoNombreBanco.setBackground(new Color(0, 51, 153));
        textoNombreBanco.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoNombreBanco.setForeground(new Color(204, 204, 255));
        textoNombreBanco.setHorizontalAlignment(SwingConstants.CENTER);
        textoNombreBanco.setText("Nombre del Banco");
    }

    private void inicializarCampoNombreBanco(){

    }

    private void inicializarTextoAliasBanco(){
        textoAliasBanco.setBackground(new Color(0, 51, 153));
        textoAliasBanco.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoAliasBanco.setForeground(new Color(204, 204, 255));
        textoAliasBanco.setHorizontalAlignment(SwingConstants.CENTER);
        textoAliasBanco.setText("Alias del Banco");
    }

    private void inicializarCampoAliasBanco(){

    }

}
