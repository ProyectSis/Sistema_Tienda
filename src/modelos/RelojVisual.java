package modelos;

import Vistas.V_principal;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Visual para mostrar el reloj. Es un JLabel que recibe un Observable de cambio
 * de fecha.
 */
public class RelojVisual extends JLabel {
    SimpleDateFormat format = new SimpleDateFormat("aaaa.MM.dd HH: mm: ss");

    /**
     * Se pasa un observable de fecha/hora. El Observable debe pasar un Date a
     * esta visual para que la presente.
     */
    public RelojVisual(Observable modelo) {
        // La fecha/hora se pinta en el centro de este JLabel
        this.setHorizontalAlignment((SwingConstants.CENTER));

        // Suscripción al cambio de fecha/hora en el modelo recibido.
        modelo.addObserver(new Observer() {
            // Método al que el Observable llamará cuando se cambie
            // la fecha/hora. El arg se espera que sea un Date.
            public void update(java.util.Observable o, Object arg) {
                final Object fecha = arg;

                // Se actualiza en pantalla la fecha/hora.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        setText(format.format(fecha));
                        V_principal.lblFecha.setText(fecha+"");
                    }
                });
            }
        });

        // Se da una dimension al JLabel.
        this.setPreferredSize(new Dimension(320, 24));
    }

    /**
     * Cambia el formato de presentacion de la fecha/hora en pantalla.
     */
    public void setFormat(SimpleDateFormat unFormato) {
        format = unFormato;
    }

    /**
     * Clase para mostrar una fecha/hora en formato texto.
     */
}
