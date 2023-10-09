package graphsemaphore;

import com.mxgraph.model.mxIGraphModel;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mxgraph.view.mxGraph;
import javax.swing.JFrame;

public class Nodo implements Runnable 
{
    private Semaphore s = new Semaphore(0);
    private ArrayList<Semaphore> externalSemaphores = new ArrayList();
    private ArrayList<Nodo> nodoSiguiente = new ArrayList();
    private long tiempoTarea;
    private String nombre;
    private Object cell;
    private mxIGraphModel gModel;
    private static Semaphore aux = new Semaphore(1);
    
    public Nodo(final String nombre, final long tiempoTarea) throws InterruptedException 
    {
        this.tiempoTarea = tiempoTarea;
        
        this.nombre = nombre;
        
    }
    
    public Nodo(final String nombre, final long tiempoTarea, final Nodo nodoSiguiente) throws InterruptedException 
    {
        this.nombre = nombre;
        
        this.tiempoTarea = tiempoTarea;
        
        this.nodoSiguiente.add(nodoSiguiente);
    }
    
    public Nodo(final String nombre, final long tiempoTarea, 
            final Nodo nodoSiguiente, 
            final Semaphore externalSemaphore) throws InterruptedException 
    {
        this.nombre = nombre;
        
        this.tiempoTarea = tiempoTarea;
        
        this.nodoSiguiente.add(nodoSiguiente);
        
        externalSemaphores.add(externalSemaphore);
    }
    
    public final void addExternalSemaphores(final Semaphore sem) 
    {
        externalSemaphores.add(sem);
    }
    
    public final void addNodo(final Nodo nodo) 
    {
        nodoSiguiente.add(nodo);
    }
    
    public final Semaphore getSemaphore() 
    {
        return s;
    }
    
    private void signalAdyacentNodes() throws InterruptedException 
    {
        int size = nodoSiguiente.size();
        
        for (int i = 0; i < size; ++i)
            s.release();
    }
    
    private void waitForSemaphores() throws InterruptedException 
    {
        for (Semaphore sem : externalSemaphores)
            sem.acquire();
    }
    
    public final String getNombre() 
    {
        return nombre;
    }
    
    public ArrayList<Nodo> getNodosSiguientes(){ return nodoSiguiente; }
    
    public long getTiempoTarea(){ return tiempoTarea / 1000; }
    
    public void setCell(final Object cell) {
        this.cell = cell;
    }
    
    public void setModel(final mxIGraphModel gModel) {
        this.gModel = gModel;
    }
    
    @Override
    public void run() 
    {
        try 
        {
            waitForSemaphores();
            
            //Thread.sleep(500);
            
            aux.acquire();
            
            gModel.beginUpdate();
            
            gModel.setStyle(cell, "defaultVertex;fillColor=yellow");
            
            System.out.println(nombre + " Inició");
            
            gModel.endUpdate();
            
            aux.release();
            
            Thread.sleep(tiempoTarea);
            
            //Thread.sleep(500);
            
            aux.acquire();
            
            gModel.beginUpdate();
            
            gModel.setStyle(cell, "defaultVertex;fillColor=blue");
            
            gModel.endUpdate();
            
            System.out.println(nombre + " Terminó");
            
            aux.release();
            
            signalAdyacentNodes();
            
            /*waitForSemaphores();
            
            System.out.println(nombre + " Inició");
            
            grafo.getModel().setStyle(arr[(id - 1)], "defaultVertex;fillColor=yellow");
            
            Thread.sleep(tiempoTarea);
            
            grafo.getModel().setStyle(arr[(id - 1)], "defaultVertex;fillColor=blue");
            
            System.out.println(nombre + " Terminó");
            
            signalAdyacentNodes();*/
        } 
        
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
