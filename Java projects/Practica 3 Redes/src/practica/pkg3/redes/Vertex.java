package practica.pkg3.redes;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>
{
    public final String name;
    public List <Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    
    public Vertex(String argName) 
    { 
        name = argName;
        
        adjacencies = new ArrayList<>();
    }
    
    public void addAdjancents(Edge e)
    {
        adjacencies.add(e);
    }
    
    public List<Edge> getAdjacents(){ return adjacencies; }
    
    @Override
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    
    @Override
    public String toString() { return name; }
}
