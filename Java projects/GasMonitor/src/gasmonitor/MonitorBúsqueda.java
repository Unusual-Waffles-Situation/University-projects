package gasmonitor;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MonitorBúsqueda {
    private ArrayList<Bomba> bombas;
    private final Lock lock = new ReentrantLock();
    
    public MonitorBúsqueda(final ArrayList<Bomba> bombas) {
        this.bombas = bombas;
    }
    
    public Bomba buscarBomba() {
        lock.lock();
        Bomba retBomb = null;
        try {
            for(Bomba b : bombas)
                if (b.isAvailable()) {
                    b.addBuffer();
                    retBomb = b;
                    break;
                }
        }
        finally {
            lock.unlock();
        }
        return retBomb;
    }
    
    public Bomba recargarBomba() {
        lock.lock();
        Bomba retBomb = null;
        try {
            for(Bomba b : bombas)
                if (b.canRecharge()) {
                    b.setLlenando(true);
                    retBomb = b;
                    break;
                }
        }
        finally {
            lock.unlock();
        }
        return retBomb;
    }
    
    public short getBombasAmount() {
        return (short) bombas.size();
    }
}
