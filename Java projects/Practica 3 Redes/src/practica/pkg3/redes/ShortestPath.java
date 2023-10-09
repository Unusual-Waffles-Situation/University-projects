package practica.pkg3.redes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class ShortestPath 
{
    public ShortestPath()
    {
        
    }
    
    public void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        
        PriorityQueue<Vertex> vertexQueue;
        vertexQueue = new PriorityQueue();
        
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) 
        {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                
                if (distanceThroughU < v.minDistance) 
                {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }
    
    public List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path;
        path = new ArrayList();
        
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        
        return path;
    }
    
    public Node[] getArray(List<Vertex> list)
    {
        Node arr[] = new Node[list.size()];
        
        int size = arr.length;
        
        for (byte i = 0; i < size; i++)
        {
            String name = list.get(i).toString();
            
            Node n = new Node();
            n.setName(name);
            
            arr[i] = n;
        }
        
        return arr;
    }
    
    public void addVertex(Graph g, List<Vertex> list)
    {
        int size = list.size();
        
        String array[] = new String[size];
        
        for (byte i = 0; i < size; i++)
        {
            array[i] = list.get(i).toString();
        }
        
        byte k = 0;
        
        for (byte i = 1; i < size; i++)
        {
            List<Edge> adjaList = list.get(k).getAdjacents();
            
            int sizeList = adjaList.size();
            
            for (byte j = 0; j < sizeList; j++)
            {
                if (adjaList.get(j).target.toString() == array[i])
                {
                    double value = adjaList.get(j).getWeight();
                    
                    int l = k + 1;
                    
                    g.addEdge(k, (byte)l, (byte)value);
                    
                    k++;
                    
                    break;
                }
            }
        }
    }
} 
