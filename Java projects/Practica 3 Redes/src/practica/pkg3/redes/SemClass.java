package practica.pkg3.redes;

import com.mxgraph.model.mxIGraphModel;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SemClass implements Runnable
{
    private static Semaphore aux = new Semaphore(1);
    private mxIGraphModel gModel;
    private Object cell;
    
    public SemClass()
    {
        
    }
    
    public void setCell(Object o){ cell = o; }
    
    public void setModel(mxIGraphModel mod){ gModel = mod; }
    
    @Override
    public void run() 
    {
        try 
        {
            //waitForSemaphores();
            
            Thread.sleep(3000);
            
            aux.acquire();
            
            gModel.beginUpdate();
            
            gModel.setStyle(cell, "defaultVertex;fillColor=cyan");
            
            gModel.endUpdate();
            
            aux.release();
            
            //Thread.sleep(1000);
            
            Thread.sleep(2000);
            
            aux.acquire();
            
            gModel.beginUpdate();
            
            //gModel.setStyle(cell, "defaultVertex");
            
            gModel.endUpdate();
            
            aux.release();
        } 
        
        catch (InterruptedException ex) 
        {
            Logger.getLogger(SemClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
