package gasmonitor;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorSalida {
    private final Lock lock = new ReentrantLock();
    private final Condition recharge = lock.newCondition();
    private short bombasVacías;
    
    public MonitorSalida() {
        bombasVacías = 0;
    }
    
    public void noHayGas(final Bomba b) throws InterruptedException {
        lock.lock();
        try {
            b.subBuffer();
            if (b.isBufferEmpty()) {
                bombasVacías++;
                recharge.signal();
            }
        }
        finally {
            lock.unlock();
        }
    }
    
    public void recargar() throws InterruptedException {
        lock.lock();
        try {
            while (bombasVacías == 0)
                recharge.await();
            bombasVacías--;
        }
        finally {
            lock.unlock();
        }
    }
}
