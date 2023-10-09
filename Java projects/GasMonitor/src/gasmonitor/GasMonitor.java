package gasmonitor;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JFrame;

public class GasMonitor {

    public static void main(String[] args) {
        String INPUT_FILE_NAME     = "input.txt",      //Nombre del archivo de entrada
               FILES_DIRECTORY     = "src/gasmonitor/files";         //Directorio donde se encuentran
        Archivo a = new Archivo(INPUT_FILE_NAME, FILES_DIRECTORY);
        
        try {
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName());
            MainWindow frame = new MainWindow(a);
            a.setLblBombas(frame.getLblBomba(), frame.getLblBombasCapacidad());
            a.setLblCisterna(frame.getlblCisterna());
            a.setLblSurtidores(frame.getLblSurtidores());
            a.setLblRestantes(frame.getLblRestantes());
            a.setPnlSurtidores(frame.getPnlSurtidores());
            a.setLblEnCola(frame.getlBlEnCola());
            a.setLblCounterCola(frame.getlBlEnColaCounter());
            a.readFile();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    frame.setVisible(true);
                }
            });
            
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /*try {
            a.readFile();
            a.start();
        }
        catch (NoSuchElementException ex ) {
            ex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }*/
        /*short MAX = 3;
        short MAX_CARS = 6;
        short MAX_MOTOS = 1; 
        short MAX_CAMIONETAS = 2;
        
        ArrayList<Bomba> bombas = new ArrayList<Bomba>();
        
        for (int i = 0; i < MAX; ++i)
            bombas.add(new Bomba((short) 80));
        
        MonitorBúsqueda mb = new MonitorBúsqueda(bombas);
        MonitorEntrada me = new MonitorEntrada((short)(bombas.size() * 2));
        MonitorSalida ms = new MonitorSalida();
        MonitorGas mg = new MonitorGas(bombas);
        
        ArrayList<Carro> carros = new ArrayList<Carro>();
        ArrayList<Camioneta> camionetas = new ArrayList<Camioneta>();
        ArrayList<Moto> motos = new ArrayList<Moto>();
        
        Cisterna c = new Cisterna(me, mb, ms, mg);
        Cisterna c2 = new Cisterna(me, mb, ms, mg);
        
        for (int i = 0; i < MAX_CARS; ++i)
            carros.add(new Carro(me, mb, ms, mg));
        
        for (int i = 0; i < MAX_CAMIONETAS; ++i)
            camionetas.add(new Camioneta(me, mb, ms, mg));
        
        for (int i = 0; i < MAX_MOTOS; ++i)
            motos.add(new Moto(me, mb, ms, mg));
        
        for (int i = 0; i < carros.size(); ++i)
            new Thread(carros.get(i), "Carro " + i).start();
        
        for (int i = 0; i < motos.size(); ++i)
            new Thread(motos.get(i), "Moto " + i).start();
        
        for (int i = 0; i < camionetas.size(); ++i)
            new Thread(camionetas.get(i), "Camioneta " + i).start();
        
        new Thread(c, "Cisterna").start();
        new Thread(c2, "Cisterna").start();*/
        
        /*short MAX = 1;
        short MAX_CARS = 10;
        
        ArrayList<Bomba> bombas = new ArrayList<Bomba>();
        
        for (int i = 0; i < MAX; ++i)
            bombas.add(new Bomba((short) 10));
        
        ArrayList<Surtidor> surtidores = new ArrayList<Surtidor>();
        
        for (int i = 0; i < MAX; ++i) {
            surtidores.add(new Surtidor(bombas.get(i)));
            surtidores.add(new Surtidor(bombas.get(i)));
        }
        
        Gasolinera g = new Gasolinera(surtidores, bombas, 10);
        Cisterna c = new Cisterna(g);
        
        ArrayList<Carro> carros = new ArrayList<Carro>(10);
        
        for (int i = 0; i < MAX_CARS; ++i)
            carros.add(new Carro(g));
        
        for (Carro crr : carros) {
            new Thread(crr).start();
        }
        
        new Thread(c).start();
        */
        
        
        /*ArrayList<Bomba2> bombas = new ArrayList<Bomba2>();
        
        for (short i = 0; i < MAX; ++i)
            bombas.add(new Bomba2((short) 50));
        
        GestorBomba ge = new GestorBomba(bombas);
        
        Gasolinera2 g = new Gasolinera2(ge, MAX_CARS);
        
        Cisterna c = new Cisterna(g);
        Cisterna c2 = new Cisterna(g);
        
        ArrayList<Carro> carros = new ArrayList<Carro>();
        
        for (int i = 0; i < MAX_CARS; ++i)
            carros.add(new Carro(g));
        
        for (Carro crr : carros) {
            new Thread(crr).start();
        }
        
        new Thread(c).start();
        new Thread(c2).start();*/

    }
    
}

