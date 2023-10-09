package graphsemaphore;

import com.mxgraph.view.mxGraph;
import static graphsemaphore.GraphSemaphore2.graph;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import javax.swing.JFrame;

public class Grafo 
{

    private ArrayList<Nodo> nodos;
    
    public Grafo() 
    {
        nodos = new ArrayList();
    }
    
    //Agrega el nodo al ArrayList (AL).
    //Recomiendo mejor usar este método.
    public void addNodo(final Nodo newNodo) 
    {
        nodos.add(newNodo);
    }
    
    //Agrega dos nodos, el primero (newNodo) apuntando a nextNodo.
    //No recomiendo usar este método.
    public void addNodo(final Nodo newNodo, final Nodo nextNodo) 
    {
        linkNodo(newNodo, nextNodo);
        
        nodos.add(newNodo);
        
        nodos.add(nextNodo);
    }
    
    //Agrega un arreglo de nodos, el primero (newNodo) apuntando al arreglo
    // de nodos nextNodo
    //No recomiendo usar este método.
    public void addNodo(final Nodo newNodo, final Nodo[] nextNodo) 
    {
        nodos.add(newNodo);
        
        for (Nodo n : nextNodo) 
        {
            linkNodo(newNodo, n);
            
            nodos.add(n);
        }
    }
    
    //Agrega un nodo, el primero (newNodo) apuntando al arreglo de Nodos
    // que se específican en nextNodos. Es decir, se buscan nodos existentes en
    // el AL.
    public void addNodo(final Nodo newNodo, final String[] nextNodos) 
    {
        nodos.add(newNodo);
        
        Nodo[] en = searchNodos(nextNodos);
        
        for (Nodo n : en)
            linkNodo(newNodo, n);
    }
    
    //Enlazar nodo
    //Enlazar startNodo con endNodo. Ambos existen en la AL.
    public void linkNodo(final String startNodo, final String endNodo) 
    {
        Nodo sn = searchNodo(startNodo);
        
        Nodo en = searchNodo(endNodo);
        
        linkNodo(sn, en);
    }
    
    //Enlazar nodo
    //Enlazar startNodo con endNodo.
    private void linkNodo(final Nodo startNodo, final Nodo endNodo) 
    {
        startNodo.addNodo(endNodo);
        
        endNodo.addExternalSemaphores(startNodo.getSemaphore());
    }
    
    //Enlazar nodos.
    //Enlaza startNodo con un arreglo de nodos que se especifíquen.
    //Tira excepción si no se encuentra el nodo(s) específicado en el arreglo.
    public void linkNodos(final String startNodo, final String[] endNodos) 
    {
        Nodo sn = searchNodo(startNodo);
        
        if (sn == null)
            throw new IllegalArgumentException("No existe el nodo inicial (linkNodos)");
        
        Nodo[] en = searchNodos(endNodos);
        
        for (Nodo n : en)
            linkNodo(sn, n);
    }
    
    //Buscar nodo
    private Nodo searchNodo(final String nodoName) 
    {
        for (Nodo n : nodos)
            if (n.getNombre().equalsIgnoreCase(nodoName))
                return n;
        
        return null;
    }
    
    //Buscar nodo (booleano)
    public boolean nodoExist(final String nodoName) 
    {
        if (searchNodo(nodoName) != null)
            return true;
        
        return false;
    }
    
    //Está vacío.
    public boolean isEmpty() 
    {
        return (nodos.size() == 0) ? false : true;
    }
    
    //Buscar nodos.
    private Nodo[] searchNodos(final String[] nodoNames) 
    {
        Nodo[] en = new Nodo[nodoNames.length];
        
        for (int i = 0; i < nodoNames.length; ++i) 
        {
            en[i] = searchNodo(nodoNames[i]);
            
            if (en[i] == null)
               throw new IllegalArgumentException("No existe el nodo \"" + nodoNames[i] + "\" (linkNodos)");
        }
        
        return en;
    }
    
    public ArrayList<Nodo>getNodos(){ return nodos; }
    
    //Iniciar los hilos.
    //Obligatorio invocar este método cuando todo esté listo para iniciar.
    public final void start(mxGraph graph, Object arr[]) 
    {
        for (int i = 0; i < nodos.size(); ++i) {
            nodos.get(i).setCell(arr[i]);
            nodos.get(i).setModel(graph.getModel());
            //nodos.get(i).setFrame(f);
            new Thread(nodos.get(i), nodos.get(i).getNombre()).start();
        }
       /*for (Nodo n : nodos)
        {
            n.setArreglo(arr);
            
            n.setGraph(graph);
            
            new Thread(n, n.getNombre()).start();
        }*/
            
    }
    
}
