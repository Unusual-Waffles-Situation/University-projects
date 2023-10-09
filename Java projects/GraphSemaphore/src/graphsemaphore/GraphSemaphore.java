package graphsemaphore;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;

public class GraphSemaphore {
    private boolean comp = false;
    private mxGraph graph;
    private mxGraphComponent graphComponent;
    private Object arr[];
    
    public GraphSemaphore(final Archivo a) {
        graph = new mxGraph();
        init(a);
    }
    
    private void init(final Archivo archivo) {
            Grafo g = archivo.getGrafo();
            Object parent = graph.getDefaultParent();
            
            graph.getModel().beginUpdate();
            short x, y;
            x = 20;
            y = 305;
            
            ArrayList<Nodo> nodos = g.getNodos();
            int length = nodos.size();
            arr = new Object[length];
            for (byte i = 0; i < length; i++)
                arr[i] = null;
            
            for (byte i = 0; i < length; i++) {
                ArrayList<Nodo> nodosSiguientes = nodos.get(i).getNodosSiguientes();
                String numProceso = nodos.get(i).getNombre() + "\n" + nodos.get(i).getTiempoTarea() + " seg";
                int tam = nodosSiguientes.size();
                if (arr[i] == null) {
                    Object o = new Object();
                    try {
                        o = graph.insertVertex(parent, null, numProceso, x, y, 80, 30);
                        arr[i] = o;
                        x += 120;
                        y = 20;
                    }
                    finally {
                        graph.getModel().endUpdate();
                    }
                }
                
                for (byte k = 0; k < tam; k++) {
                    numProceso = nodosSiguientes.get(k).getNombre() + "\n" + nodosSiguientes.get(k).getTiempoTarea() + " seg";
                    char val = numProceso.charAt(1);
                    int valor = Character.getNumericValue(val);
                    if (arr[(valor - 1)] == null) {
                        Object p = graph.insertVertex(parent, null, numProceso, x, y, 80, 30);
                        arr[(valor - 1)] = p;
                        graph.insertEdge(parent, null, "", arr[i], p);
                    }
                    else
                        graph.insertEdge(parent, null, "", arr[i], arr[(valor - 1)]);
                    y += 120;
                }
                    x += 120;   
                    y = 80;
                }
            graphComponent = new mxGraphComponent(graph);
    }
    
    public mxGraphComponent getGraphComponent() {
        return graphComponent;
    }
    
    public final mxGraph getGraph() {
        return graph;
    }
    
     public final Object[] getArr() {
        return arr;
    }
}
