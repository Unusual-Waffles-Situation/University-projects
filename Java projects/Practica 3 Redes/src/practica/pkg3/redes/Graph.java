package practica.pkg3.redes;

import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import javax.swing.JFrame;

public class Graph extends JFrame
{
    private final mxGraph graph;
    private final Object parent;
    private mxGraphComponent graphComponent;
    private mxIGraphModel gModel;
    private final Object o[];
    private final SemClass sem;
    
    public Graph(int cant)
    {
        o = new Object[cant];
        
        graph = new mxGraph();
	
        parent = graph.getDefaultParent();
        
        sem = new SemClass();
        
        gModel = null;
    }
    
    public void addVertex(Node[] arr)
    {
        int cant = arr.length;
        
        short xVal = 20;
        short yVal = 20;
        
        boolean comp = false;
        
        for (byte j = 0; j < cant; j++)
        {
            String name = arr[j].getName();
            
            graph.getModel().beginUpdate();
                
            try
            {
                o[j] = graph.insertVertex(parent, null, name, xVal, yVal, 80, 30);
                
                /*gModel = graph.getModel();
                
                gModel.beginUpdate();
                
                gModel.setStyle(o[j], "defaultVertex;fillColor=cyan");
                
                gModel.setStyle(o[0], "defaultVertex");
                
                gModel.endUpdate();*/
                
            }
                
            finally
            {
                graph.getModel().endUpdate();
            }
                
            if (!comp)
            {
                xVal = 240;
                
                comp = true;
            }
            
            else
            {
                xVal = 20;
                
                comp = false;
            }
            
            yVal += 80;
        }
    }
    
    public void addEdge(byte origin, byte destiny, byte value)
    {
	graph.getModel().beginUpdate();
        
        try
        {
            graph.insertEdge(parent, null, value, o[origin], o[destiny]);
        }
        
        finally
        {
            graph.getModel().endUpdate();
        }
        
        graphComponent = new mxGraphComponent(graph);
	getContentPane().add(graphComponent);
    }
    
    public void showProgress()
    {
        int val = o.length;
        
        for (byte i = 0; i < val; i++)
        {
            gModel = graph.getModel();
                
            gModel.beginUpdate();
            
            if (i > 0)
            {
                gModel.setStyle(o[(i - 1)], "defaultVertex");
                
                gModel.setStyle(o[i], "defaultVertex;fillColor=cyan");
            }
            
            else
                gModel.setStyle(o[i], "defaultVertex;fillColor=cyan");
                
            gModel.endUpdate();
            
            /*sem.setCell(o[i]);
            
            sem.setModel(graph.getModel());
            
            new Thread().start();*/
        }
    }
    
    public Object[] getObject(){ return o; }
    
    public mxGraph getGraphInfo(){ return graph; }
}
