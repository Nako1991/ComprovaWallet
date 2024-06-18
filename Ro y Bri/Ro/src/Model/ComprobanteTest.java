package Model;

import javax.swing.*;
import java.awt.*;

public class ComprobanteTest extends JPanel {

    private String destinatario;
    private double cantidad;
    private String fecha;


    public ComprobanteTest(String destinatario, double cantidad, String fecha) {
        this.destinatario = destinatario;
        this.cantidad = cantidad;
        this.fecha = fecha;
        setPreferredSize(new Dimension(200, 100)); // Tamaño predeterminado del comprobante de pago
        setBackground(Color.GREEN); // Color de fondo del comprobante de pago
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el comprobante de pago
        g.setColor(Color.WHITE);
        g.fillRect(10, 10, getWidth() - 20, getHeight() - 20);

        // Dibujar la información del comprobante
        g.setColor(Color.BLACK);
        g.drawString("Destinatario: " + destinatario, 20, 30);
        g.drawString("Cantidad: $" + cantidad, 20, 60);
        g.drawString("Fecha: " + fecha, 20, 90);
    }
}
