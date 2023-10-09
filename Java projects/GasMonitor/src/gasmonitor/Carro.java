package gasmonitor;

import javax.swing.ImageIcon;

public class Carro extends Vehiculo {
    private static final byte MAX_CAPACIDAD = 40;
    private static final String NOMBRE = "Carro";
    private static short total = 0;
   
    public Carro(final MonitorEntrada me, final MonitorBúsqueda mb, 
            final MonitorSalida ms) {
        super(MAX_CAPACIDAD, me, mb, ms, NOMBRE, total);
        setPicture();
        total++;
    }

    public final static String getNombre() {
        return NOMBRE;
    }
    
    public void setPicture() {
        short randomPicture = (short) (Math.random() * carPictures.length);
        picture = new ImageIcon(carPictures[randomPicture]);
    }
    
}
