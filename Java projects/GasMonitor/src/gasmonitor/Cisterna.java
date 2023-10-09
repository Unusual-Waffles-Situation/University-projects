package gasmonitor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Cisterna implements Runnable {
    private short id = 0;
    private static short total = 0; 
    private MonitorEntrada me;
    private MonitorBúsqueda mb;
    private MonitorSalida ms;
    private static final short DELAY_PER_LTR = 500;
    private JLabel lblCisterna;
    
    public Cisterna(final MonitorEntrada me, final MonitorBúsqueda mb, 
            final MonitorSalida ms, final JLabel lblCisterna) {
        this.me = me;
        this.mb = mb;
        this.ms = ms;
        this.lblCisterna = lblCisterna;
        this.id = total;
        total++;
    }
    
    public final short getId() {
        return id;
    }
    
    public final void setLblCisterna(final JLabel lblCisterna) {
        this.lblCisterna = lblCisterna;
    }
    
    @Override
    public void run(){
        try {
            do {
                ms.recargar();
                Bomba b = mb.recargarBomba();
                if (b != null ) {
                    lblCisterna.setVisible(true);
                    while(!b.isFull()) {
                        b.recargar();
                        System.out.println(getClass().getSimpleName() + 
                                 " " + getId() + " recargó la bomba " + b.getId() 
                                        + "(" + b.toString() + ")");
                        Thread.sleep(DELAY_PER_LTR);
                    }
                    b.getBombaLabel().setText(Short.toString(b.getId()));
                    lblCisterna.setVisible(false);
                    b.setLlenando(false);
                }
                me.salir();
                me.salir();
            } while(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cisterna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
