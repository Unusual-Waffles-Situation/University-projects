package gasmonitor;

import javax.swing.ImageIcon;

public class Moto extends Vehiculo {
    private static final byte MAX_CAPACIDAD = 20;
    private static final String NOMBRE = "Moto";
    private static short total = 0;
    
    public Moto(final MonitorEntrada me, final MonitorBúsqueda mb, 
           final MonitorSalida ms){
        super(MAX_CAPACIDAD, me, mb, ms, NOMBRE, total);
        total++;
        setPicture();
    }
    
    public final static String getNombre() {
       return NOMBRE;
    }
    
    public void setPicture() {
        short randomPicture = (short) (Math.random() * bikePicture.length);
        picture = new ImageIcon(bikePicture[randomPicture]);
    }
    
}