package gasmonitor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Vehiculo implements Runnable {
    private byte capacidad;
    private int tanque;
    private String name;
    private short id;
    private MonitorEntrada me;
    private MonitorBúsqueda mb;
    private MonitorSalida ms;
    private JLabel lblSurtidor;
    private JLabel lblContador;
    private JPanel pnlSurtidor;
    private short DELAY_PER_LTR = 500;
    protected ImageIcon picture;
    protected String[] carPictures = {
        "src/gasmonitor/resources/Car.png",
        "src/gasmonitor/resources/Audi.png",
        "src/gasmonitor/resources/Black_viper.png"
                            };
    protected String[] truckPictures = {
        "src/gasmonitor/resources/Mini_truck.png",
        "src/gasmonitor/resources/Mini_van.png",
    };
    protected String[] bikePicture = {"src/gasmonitor/resources/bike.jpg"};
    
    public Vehiculo(final byte capacidad, final MonitorEntrada me, 
            final MonitorBúsqueda mb, final MonitorSalida ms,
            final String name, final short id){
        this.capacidad = capacidad;
        this.me = me;
        this.mb = mb;
        this.ms = ms;
        this.name = name;
        this.lblSurtidor = null;
        this.lblContador = null;
        this.id = id;
        tanque = (int) Math.random() * (capacidad - 1);
    }
    
    @Override
    public void run(){
        try {
            me.entrar(picture);
            System.out.println(name + " " + id + " entró");
            Bomba b = mb.buscarBomba();
            pnlSurtidor = b.getSurtidorPanel();
            lblSurtidor = (JLabel) pnlSurtidor.getComponent(0);
            lblContador = (JLabel) pnlSurtidor.getComponent(1);
            //lblSurtidor = b.getSurtidor();
            if (b != null) {
                System.out.println(name + " " + id +  " entró a la bomba " + b.getId());
                lblSurtidor.setIcon(picture);
                lblSurtidor.setVisible(true);
                lblContador.setVisible(true);
                while (!isFull()) {
                    b.surtir(this);
                    if (tanque <= capacidad * 0.35)
                       lblContador.setForeground(new java.awt.Color(204,0,0));
                    else
                         if (tanque <= capacidad * 0.9)
                             lblContador.setForeground(new java.awt.Color(255,128,0));
                         else
                             lblContador.setForeground(new java.awt.Color(0,153,51));
                    lblContador.setText("<html>#" + id + "<br>" + tanqueWatcher());
                    //lblCount.setText(tanqueWatcher());
                    Thread.sleep(DELAY_PER_LTR);
                    if (b.isEmpty() || b.getLlenando()) {
                        break;
                    }
                }
                System.out.println(name + " " + id + " salió de la bomba " + b.getId());
                /*if (!isFull())
                    ms.noHayGas(b);*/
                ///lblIcon.setIcon(null);
                //lblIcon.revalidate();
                lblContador.setVisible(false);
                lblSurtidor.setIcon(null);
                lblSurtidor.revalidate();
                lblSurtidor.setVisible(false);
                //b.addSurtidor(lblSurtidor);
                b.addSurtidorPanel(pnlSurtidor);
                if (!b.isGoingToEmpty()) {
                    b.subBuffer();
                    me.salir();
                }
                else {
                    ms.noHayGas(b);
                }
            }
            else
                me.salir();
            System.out.println(name + " " + id + " salió");
        } catch (InterruptedException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void llenarTanque(){
        tanque++;
    }
    
    public final String tanqueWatcher() {
        return tanque + "/" + capacidad;  
    }
    
    public boolean isFull(){
        return tanque == capacidad;
    }
    
    public final String getName() {
        return name;
    }
    
    public final short getId() {
        return id;
    }
    
    public abstract void setPicture();
    
    public ImageIcon getPicture() {
        return picture;
    }
    
}
