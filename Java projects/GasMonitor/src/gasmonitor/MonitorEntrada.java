package gasmonitor;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MonitorEntrada {
    private final Lock lock = new ReentrantLock();
    private final Condition available = lock.newCondition();
    private short surtidoresDisponibles;
    private short enCola;
    private ArrayList<JLabel> lblEnCola;
    private JLabel colaCounter;
    private boolean noMoreCars;
    private Queue<ImageIcon> colaVehiculos;
    
    public MonitorEntrada(final short surtidoresDisponibles, 
            final ArrayList<JLabel> lblEnCola, final JLabel colaCounter) {
        this.surtidoresDisponibles = surtidoresDisponibles;
        this.lblEnCola = lblEnCola;
        this.colaCounter = colaCounter;
        enCola = 0;
        noMoreCars = false;
        colaVehiculos = new LinkedList();
    }
    
    public void entrar(final ImageIcon vehiclePicture) throws InterruptedException {
        lock.lock();
        try {
            while (surtidoresDisponibles == 0) {
                colaVehiculos.add(vehiclePicture);
                if (enCola < lblEnCola.size()) {
                    lblEnCola.get(enCola).setIcon(colaVehiculos.remove());
                    lblEnCola.get(enCola).setVisible(true);
                    enCola++;
                    
                }
                colaCounter.setText("En cola: " + (colaVehiculos.size() + enCola));
                System.out.println(Thread.currentThread().getName() + " espera");
                available.await();
                moveCola();
            }
            surtidoresDisponibles--;
            
        }
        finally {
            lock.unlock();
        }
    }
    
    public void salir() {
        lock.lock();
        try {
            surtidoresDisponibles++;
            available.signal();
        }
        finally {
            lock.unlock();
        }
    }
    
    private void moveCola() {
        lock.lock();
        try {
            for (short i = 0, k = 1; i < lblEnCola.size() - 1; ++i, ++k) {
                ImageIcon next = (ImageIcon) lblEnCola.get(k).getIcon();
                lblEnCola.get(i).setIcon(next);
                lblEnCola.get(i).revalidate();
            }
            if (!noMoreCars) {
                if (colaVehiculos.peek() == null) {
                    lblEnCola.get(lblEnCola.size() - 1).setIcon(null);
                    lblEnCola.get(lblEnCola.size() - 1).revalidate();
                    enCola--;
                    noMoreCars = true;
                }
                else {
                    lblEnCola.get(lblEnCola.size() - 1).setIcon(
                            colaVehiculos.remove()
                    );
                    lblEnCola.get(lblEnCola.size() - 1).revalidate();
                }
            }
            else
                enCola--;
            colaCounter.setText("En cola: " + (colaVehiculos.size() + enCola));
            
            /*for (short i = 0; i < lblEnCola.size(); ++i) {
                lblEnCola.get(i).setIcon(null);
                lblEnCola.get(i).revalidate();
                //lblEnCola.get(i).setVisible(false);
            }
            if (colaVehiculos.peek() != null) {
                colaVehiculos.remove();
                for (short i = 0; i < lblEnCola.size(); ++i) {
                    if (colaVehiculos.peek() == null) {
                        enCola--;
                        break;
                    }
                    lblEnCola.get(i).setIcon(colaVehiculos.remove());
                }
            }
            else
                enCola--;
            colaCounter.setText("En cola: " + (colaVehiculos.size() + enCola));*/
        }
        finally {
            lock.unlock();
        }
        /*for (short i = 0, k = 1; i < enCola - 1; ++i) {
            JLabel next = lblEnCola.get(k);
            if (next.getIcon() == null) {
                lblEnCola.get(i).setIcon(null);
                lblEnCola.get(i).revalidate();
                lblEnCola.get(i).setVisible(false);
                enCola--;
                colaContador--;
                colaCounter.setText("En cola: " + colaContador);
                break;
            }
            lblEnCola.get(i).setIcon(next.getIcon());
        }
        if (enCola != 0) {
            if (colaVehiculos.size() > 0) {
                lblEnCola.get(lblEnCola.size() - 1).setIcon(
                        colaVehiculos.remove()
                );
                colaContador--;
            }
            else {
                lblEnCola.get(lblEnCola.size() - 1).setIcon(null);
                lblEnCola.get(lblEnCola.size() - 1).revalidate();
                //lblEnCola.get(lblEnCola.size() - 1).setVisible(false);
                enCola--;
                colaContador--;
                colaCounter.setText("En cola: " + colaContador);
            }
        }*/
    }
    
    
}
