package gasmonitor;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bomba {
    private short maxCapacidad, capacidad;
    private static short total = 0;
    private final short id;
    private short buffer = 0;
    private static final short MAX_BUFFER = 2;
    private static final short DELAY_PER_LTR = 500;
    private boolean llenando = false;
    private JLabel lblCapacidad;
    private JLabel lblBomba;
    private ArrayList<JPanel> pnlSurtidores;
    private ArrayList<JLabel> lblSurtidores;
    private final Lock lock = new ReentrantLock();
    
    public Bomba(final short capacidad, 
            final JLabel lblCapacidad,
            final JLabel lblBomba, final ArrayList<JLabel> lblSurtidores,
            final ArrayList<JPanel> pnlSurtidores) {
        this.capacidad = capacidad;
        this.maxCapacidad = capacidad;
        this.id = total;
        this.lblCapacidad = lblCapacidad;
        this.lblBomba = lblBomba;
        this.lblSurtidores = lblSurtidores;
        this.pnlSurtidores = pnlSurtidores;
        lblCapacidad.setText(Short.toString(capacidad));
        total++;
    }
    
    public void surtir(final Vehiculo v) throws InterruptedException {
        lock.lock();
        try {
           if (capacidad != 0) {
               capacidad--;
               if (capacidad <= maxCapacidad * 0.2)
                       lblCapacidad.setForeground(new java.awt.Color(204,0,0));
               else
                    if (capacidad <= maxCapacidad * 0.5)
                        lblCapacidad.setForeground(new java.awt.Color(255,128,0));
                    else
                        lblCapacidad.setForeground(new java.awt.Color(0,153,51));
                   
               lblCapacidad.setText(Short.toString(capacidad));
               v.llenarTanque();
               System.out.println(v.getName() + " " + v.getId() + 
                    " surtió de la bomba " + 
                   getId() + "(" + toString() + ")" +
                            " - " + v.tanqueWatcher());
           }
        }
        finally {
            lock.unlock();
        }
    }
    
    public void recargar() throws InterruptedException {
        if (capacidad != maxCapacidad) {
            capacidad++;
            if (lblBomba.getText().trim().isEmpty())
                lblBomba.setText(Short.toString(id));
            else
                lblBomba.setText(" ");
            if (capacidad <= maxCapacidad * 0.2)
                       lblCapacidad.setForeground(new java.awt.Color(204,0,0));
               else
                    if (capacidad <= maxCapacidad * 0.5)
                        lblCapacidad.setForeground(new java.awt.Color(255,128,0));
                    else
                        lblCapacidad.setForeground(new java.awt.Color(0,153,51));
            lblCapacidad.setText(Short.toString(capacidad));
        }
    }
    
    public JLabel getSurtidor() {
        lock.lock();
        JLabel lbl = null;
        try {
            lbl = lblSurtidores.remove(0);
            
        }
        finally {
            lock.unlock();
        }
        return lbl;
    }
    
    public JPanel getSurtidorPanel() {
        lock.lock();
        JPanel pnl = null;
        try {
            pnl = pnlSurtidores.remove(0);
        }
        finally {
            lock.unlock();
        }
        return pnl;
    }
    
    public void addSurtidorPanel(JPanel surtidor) {
        lock.lock();
        try {
            pnlSurtidores.add(surtidor);
        }
        finally {
            lock.unlock();
        }
    }
    
    public void addSurtidor(JLabel surtidor) {
        lock.lock();
        try {
            lblSurtidores.add(surtidor);
        }
        finally {
            lock.unlock();
        }
    }
    
    public boolean isGoingToEmpty() {
        lock.lock();
        boolean value = false;
        try {
            value = capacidad <= maxCapacidad * 0.05;
        }
        finally {
            lock.unlock();
        }
        return value;
    }
    
    public final JLabel getBombaLabel() {
        return lblBomba;
    }
    
    public final void subBuffer() {
        buffer--;
    }
    
    public final void addBuffer() {
        buffer++;
    }
    
    @Override
    public final String toString() {
        return capacidad + "/" + maxCapacidad;
    }
    
    public final boolean isAvailable() {
        return buffer != MAX_BUFFER && !llenando;
    }
    
    public final boolean isBufferFull() {
        return buffer == MAX_BUFFER;
    }
    
    public final short getBuffer() {
        return buffer;
    }
    
    public final short getMaxBuffer() {
        return MAX_BUFFER;
    }
    
    public final boolean canRecharge() {
        return isEmpty() && !llenando;
    }
    
    public final void setLlenando(final boolean llenando) {
        this.llenando = llenando;
    }
    
    public final boolean getLlenando() {
        return llenando;
    }
    
    public final boolean isBufferEmpty() {
        return buffer == 0;
    }
    
    public final boolean isEmpty() {
        return capacidad == 0;
    }
    
    public final boolean isFull() {
        return capacidad == maxCapacidad;
    }
    
    public final short getId() {
        return id;
    }
}
