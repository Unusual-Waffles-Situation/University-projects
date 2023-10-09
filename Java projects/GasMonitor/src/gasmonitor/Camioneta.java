package gasmonitor;

import javax.swing.ImageIcon;

public class Camioneta extends Vehiculo{
    private static final byte MAX_CAPACIDAD = 60;
    private static final String NOMBRE = "Camioneta";
    private static short total = 0;
    
    public Camioneta(final MonitorEntrada me, final MonitorBúsqueda mb, 
           final MonitorSalida ms){
        super(MAX_CAPACIDAD, me, mb, ms, NOMBRE, total);
        total++;
        setPicture();
    }
    
    public final static String getNombre() {
       return NOMBRE;
    }
    
    public void setPicture() {
        short randomPicture = (short) (Math.random() * truckPictures.length);
        picture = new ImageIcon(truckPictures[randomPicture]);
    }
    
}
