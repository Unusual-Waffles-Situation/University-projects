package gasmonitor;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorGas {
    private final Lock lock = new ReentrantLock();
    private final Condition noHayGas = lock.newCondition();
    private final ArrayList<Bomba> bombas;
    
    public MonitorGas(final ArrayList<Bomba> bombas) {
        this.bombas = bombas;
    }
    
    public void entrar() throws InterruptedException {
        lock.lock();
        try {
            while (isBombasVacías()) {
                System.out.println("Cola sin gas");
                noHayGas.await();  
            }
        }
        finally {
            lock.unlock();
        }
    }
    
    public void hayGas() {
        lock.lock();
        try {
            noHayGas.signal();
        }
        finally {
            lock.unlock();
        }
    }
    
    private boolean isBombasVacías() {
        short vacías = 0;
        for (Bomba b : bombas)
            if (b.isEmpty() || !b.isFull())
                vacías++;
        return vacías == bombas.size();
    }
}
