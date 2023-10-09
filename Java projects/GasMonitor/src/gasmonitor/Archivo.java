package gasmonitor;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Archivo 
{
    private final Path inputFilePath;
    private final ArrayList<Bomba> bombas;
    private final ArrayList<Carro> carros; 
    private final ArrayList<Moto> motos;
    private final ArrayList<Camioneta> camionetas;
    private final ArrayList<Cisterna> cisternas;
    private final MonitorBúsqueda mb;
    private MonitorEntrada me;
    private final MonitorSalida ms;
    private final static String CARS_NAME = Carro.getNombre() + "s";
    private final static String CAMIONETAS_NAME = Camioneta.getNombre() + "s";
    private final static String MOTOS_NAME = Moto.getNombre() + "s";
    private final static short CISTERNAS_AMOUNT = 2;
    
    private ArrayList<JLabel> lblBombasCapacidad;
    private ArrayList<JLabel> lblBombas;
    private ArrayList<JLabel> lblCisternas;
    private ArrayList<JLabel> lblSurtidores;
    private JLabel lblRestantes;
    private ArrayList<JPanel> pnlSurtidores;
    private ArrayList<JLabel> lblEnCola;
    private JLabel lblColaCounter;
    
    public Archivo(final String inputName, final String dir) 
    {
        inputFilePath  = FileSystems.getDefault().getPath(dir, inputName);
        bombas = new ArrayList<>();
        carros = new ArrayList<>();
        motos = new ArrayList<>();
        camionetas = new ArrayList<>();
        cisternas = new ArrayList<>();
        ms = new MonitorSalida();
        mb = new MonitorBúsqueda(bombas);
    }
    
    public void readFile() throws NoSuchElementException, Exception 
    {
        Scanner scannerFile = new Scanner(inputFilePath);
        boolean vehiclesNext = false;
        short count = 0;
        while (scannerFile.hasNextLine()) {
            String line = scannerFile.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            if (line.isEmpty()) {
                vehiclesNext = true;
                continue;
            }
            
            if (vehiclesNext) {
                lineScanner.useDelimiter(Pattern.compile(":"));
                while (lineScanner.hasNext()) 
                {
                    String vehicleName = lineScanner.next();

                    lineScanner.reset();

                    lineScanner.next();
                    
                    short amount = lineScanner.nextShort();
                    count += amount;
                    
                    if (vehicleName.equalsIgnoreCase(CARS_NAME))
                        for (short i = 0; i < amount; ++i)
                            carros.add(new Carro(me, mb, ms));
                    else
                        if (vehicleName.equalsIgnoreCase(CAMIONETAS_NAME))
                            for (short i = 0; i < amount; ++i)
                                camionetas.add(new Camioneta(me, mb, ms));
                        else
                            if (vehicleName.equalsIgnoreCase(MOTOS_NAME))
                                for (short i = 0; i < amount; ++i)
                                    motos.add(new Moto(me, mb, ms));
                }
            }
            else {
                while (lineScanner.hasNext()) {
                    short pumpsAmount = lineScanner.nextShort();
                    short pumpsCapacity = lineScanner.nextShort();
                    for (short i = 0, k = 0; i < pumpsAmount; ++i, k += 2)
                        bombas.add(new Bomba(pumpsCapacity, 
                                lblBombasCapacidad.get(i), 
                                lblBombas.get(i),
                                new ArrayList<JLabel>(
                                        Arrays.asList(
                                                lblSurtidores.get(k), lblSurtidores.get(k + 1)
                                        )
                                ),
                                new ArrayList<JPanel>(
                                        Arrays.asList(
                                                pnlSurtidores.get(k), pnlSurtidores.get(k + 1)
                                        )
                                )
                                
                        ));
                }
                me = new MonitorEntrada((short) ((short) bombas.size() * 2), lblEnCola, lblColaCounter);
                addCisternas();
            }
            
            lineScanner.close();
            // you're at the end of the line here. Do what you have to do.
          }
        lblRestantes.setText("Surtir: " + count + " vehículos");
        scannerFile.close();
    }
    
    private void addCisternas() {
        for (short i = 0; i < CISTERNAS_AMOUNT; ++i)
            cisternas.add(new Cisterna(me, mb, ms, lblCisternas.get(i)));
    }
    
    public final void start() {
        for (short i = 0; i < carros.size(); ++i)
            new Thread(carros.get(i), carros.get(i).getName()).start();
        
        for (short i = 0; i < motos.size(); ++i)
            new Thread(motos.get(i), motos.get(i).getName()).start();
        
        for (short i = 0; i < camionetas.size(); ++i)
            new Thread(camionetas.get(i), camionetas.get(i).getName()).start();
        
        for (short i = 0; i < cisternas.size(); ++i)
            new Thread(cisternas.get(i)).start();
    }
    
    public void setLblBombas(final ArrayList<JLabel> lblBombas, 
            final ArrayList<JLabel> lblBombasCapacidad) {
        this.lblBombas = lblBombas;
        this.lblBombasCapacidad = lblBombasCapacidad;
    }
    
    public void setLblSurtidores(final ArrayList<JLabel> lblSurtidores) {
        this.lblSurtidores = lblSurtidores;
    } 

    public void setLblRestantes(final JLabel lblRestantes) {
        this.lblRestantes = lblRestantes;
    }
    
    public void setLblCisterna(final ArrayList<JLabel> lblCisternas) {
        this.lblCisternas = lblCisternas;
    }
    
    public void setPnlSurtidores(final ArrayList<JPanel> pnlSurtidores) {
        this.pnlSurtidores = pnlSurtidores;
    }
    
    public void setLblEnCola(final ArrayList<JLabel> lblEnCola) {
        this.lblEnCola = lblEnCola;
    }
    
    public void setLblCounterCola(final JLabel lblEnCola) {
        this.lblColaCounter = lblEnCola;
    }
    
    public final Path getInputFilePath() {
         return inputFilePath;
    }

}
