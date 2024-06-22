package Vista;

import Modelo.Config;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;

public class PanelFondoVentanaPrincipal extends JPanel {

    private JLabel fondoVentanaPrincipal;

    public PanelFondoVentanaPrincipal() {
        inicializarPanelFondo();
    }

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
        this.setLayout(new AbsoluteLayout());
        this.add(fondoVentanaPrincipal, new AbsoluteConstraints(0, 0, -1, -1));
        this.setVisible(true);
    }

}
