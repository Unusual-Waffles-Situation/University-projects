package graphsemaphore;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphSemaphore2
{
    public static boolean comp = false;
    
    public static JFrame frame = new JFrame();
    
    public static mxGraph graph = new mxGraph();
    
    public static Object arr[];
    
    final static String INPUT_FILE_NAME     = "input.txt",      //Nombre del archivo de entrada
                        FILES_DIRECTORY     = "src/graphsemaphore/files";         //Directorio donde se encuentran
    
    private static final long serialVersionUID = -2707712944901661771L;
    
    public GraphSemaphore2(final Archivo archivo) throws Exception 
    {
            /*Archivo archivo = new Archivo(INPUT_FILE_NAME, FILES_DIRECTORY);
        
            archivo.readFile();*/
            
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
            
            for (byte i = 0; i < length; i++)
            {
                ArrayList<Nodo> nodosSiguientes = nodos.get(i).getNodosSiguientes();
                
                String numProceso = nodos.get(i).getNombre() + "\n\n Estado: ";
                
                int tam = nodosSiguientes.size();
                
                if (arr[i] == null)
                {
                    
                    Object o = new Object();
                
                    try
                    {
                        o = graph.insertVertex(parent, null, numProceso, x, y, 80, 90);
                        
                        arr[i] = o;
                    
                        x += 120;
                        y = 20;
                        
                        
                    }    
                
                    finally
                    {
                        graph.getModel().endUpdate();
                    }
                    
                }
                
                for (byte k = 0; k < tam; k++)
                {
                    numProceso = nodosSiguientes.get(k).getNombre();
                        
                    char val = numProceso.charAt(1);
                        
                    int valor = Character.getNumericValue(val);
                        
                    if (arr[(valor - 1)] == null)
                    {
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
            
            mxGraphComponent graphComponent = new mxGraphComponent(graph);
            
            //graph.getModel().setStyle(arr[0], "defaultVertex;fillColor=yellow");
            
            
		
            frame.getContentPane().add(graphComponent);
    }
    
    public mxGraph getGraph() {
        return graph;
    }
    
    public Object[] getArr() {
        return arr;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public static void main(String args[]) throws Exception 
    {
        /*GraphSemaphore2 g = new GraphSemaphore2();
        
        Archivo archivo = new Archivo(INPUT_FILE_NAME, FILES_DIRECTORY);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 690);
	frame.setVisible(true);
        
        archivo.readFile();
        
        archivo.start(graph, arr, g.getFrame());*/
        
        Archivo archivo = new Archivo(INPUT_FILE_NAME, FILES_DIRECTORY);
        archivo.readFile();
        GraphSemaphore2 g = new GraphSemaphore2(archivo);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 690);
	frame.setVisible(true);
        
        archivo.start(g.getGraph(), g.getArr());
        
        /*//N1 -> N2 -> N5
        //N1 -> N3 -> N4 -> N5
        
        //Creando el grafo
        Grafo g = new Grafo();
        
        //Creando los Nodos
        Nodo n1, n2, n3, n4, n5;
        
        n1 = new Nodo("P1", 2000);  //2 seg
        n2 = new Nodo("P2", 3000);  //3 seg
        n3 = new Nodo("P3", 1000);  //1 seg
        n4 = new Nodo("P4", 1000);  //1 seg
        n5 = new Nodo("P5", 1000);  //1 seg

        //Añadiendo los nodos al grafo
        g.addNodo(n1);
        g.addNodo(n2);
        g.addNodo(n3);
        g.addNodo(n4);
        g.addNodo(n5);
        
        //N1 -> N2 ; N1 -> N3
        g.linkNodos(n1.getNombre(), 
                new String[]{n2.getNombre(), n3.getNombre()});
        
        //N2 -> N5
        g.linkNodo(n2.getNombre(), n5.getNombre());
        
        //N3 -> N4
        g.linkNodo(n3.getNombre(), n4.getNombre());
        
        //N4 -> N5
        g.linkNodo(n4.getNombre(), n5.getNombre());
        
        //Fire it up (Obligatorio).
        g.start();
        /*new Thread(n1, n1.getNombre()).start();
        new Thread(n2, n2.getNombre()).start();
        new Thread(n3, n3.getNombre()).start();
        new Thread(n4, n4.getNombre()).start();
        new Thread(n5, n5.getNombre()).start();*/
        
    }
    
}

