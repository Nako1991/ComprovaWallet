package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelBilleterasVirtuales extends JPanel {

    private JButton botonAgregarBilletera;
    private JButton botonEliminarBilletera;
    ///Elimino por nombre de banco

    public JPanelBilleterasVirtuales() {}

    public void inicializarPanelBilleterasVirtuales(){
        inicializarBotonesPanelLateralBilleterasVirtuales();
    }
    private void inicializarBotonesPanelLateralBilleterasVirtuales(){
        inicializarBotonAgregarBilletera();
        inicializarBotonEliminarBilletera();
    }
    private void inicializarBotonAgregarBilletera(){
        botonAgregarBilletera.setBackground(new Color(0, 51, 102));
        botonAgregarBilletera.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonAgregarBilletera.setForeground(new Color(204, 204, 255));
        botonAgregarBilletera.setText("Agregar Billetera");
        botonAgregarBilletera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonAgregarBilleteraActionPerformed(evt);
            }
        });

    }
    private void botonAgregarBilleteraActionPerformed(ActionEvent evt){

    }
    private void inicializarBotonEliminarBilletera(){
        botonEliminarBilletera.setBackground(new Color(0, 51, 102));
        botonEliminarBilletera.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        botonEliminarBilletera.setForeground(new Color(204, 204, 255));
        botonEliminarBilletera.setText("Eliminar Billetera");
        botonEliminarBilletera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonEliminarBilleteraActionPerformed(evt);
            }
        });
    }

    private void botonEliminarBilleteraActionPerformed(ActionEvent evt){

    }

}
