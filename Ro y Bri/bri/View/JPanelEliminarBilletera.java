package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelEliminarBilletera extends JPanel {
    private JButton botonBack;
    private JButton botonEliminar;
    private JLabel textoNombreBanco;
    private JFormattedTextField campoNombreBanco;

    public void inicializarPanelEliminarBilletera(){
        inicializarBotonesPanelLateralEliminarBilletera();
        inicializarComponentesPanelLateralEliminarBilletera();
    }
    private void inicializarBotonesPanelLateralEliminarBilletera(){
        inicializarBotonBack();
        inicializarBotonEliminar();
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

    }

    private void inicializarBotonEliminar(){
        botonEliminar.setBackground(new Color(0, 51, 102));
        botonEliminar.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonEliminar.setForeground(new Color(204, 204, 255));
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
    }

    private void botonEliminarActionPerformed(ActionEvent evt){

    }

    private void inicializarComponentesPanelLateralEliminarBilletera(){
        inicializarTextoCampoNombreBanco();
        inicializarCampoNombreBanco();
    }

    private void inicializarTextoCampoNombreBanco(){
        textoNombreBanco.setBackground(new Color(0, 51, 153));
        textoNombreBanco.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        textoNombreBanco.setForeground(new Color(204, 204, 255));
        textoNombreBanco.setHorizontalAlignment(SwingConstants.CENTER);
        textoNombreBanco.setText("NOMBRE BANCO");
    }

    private void inicializarCampoNombreBanco(){

    }

}
