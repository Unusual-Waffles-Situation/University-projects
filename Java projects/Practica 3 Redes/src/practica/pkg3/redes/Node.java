package practica.pkg3.redes;

import java.util.List;
import java.util.ArrayList;

public class Node 
{
    private String nodeName;
    private float weightInMbps;
    private final List<Node> nodeList;
    
    public Node()
    {
        nodeName = "";
        
        weightInMbps = 0.0f;
        
        nodeList = new ArrayList<>();
    }
    
    public String showNodes(int value)
    {
        String str = "";
        
        boolean comp;
        
        int val = nodeList.size();
        
        byte l = 0;
        
        for (byte j = 0; j < value; j++)
        {
            comp = false;
            
            if (val > 0)
            {
                if (l < val)
                {
                    byte aux = Byte.parseByte(nodeList.get(l).getName());
                    
                    if ((j + 1) == aux)
                    {
                        str += "1 ";
                        
                        l++;
                        
                        comp = true;
                    }
                }
            }
            
            if (!comp)
                str += "0 ";
        }
        
        return str;
    }
    
    public void addNode(Node n){ nodeList.add(n); }
    
    public List getNodes(){ return nodeList; }
    
    public void setName(String name){ nodeName = name; }
    
    public String getName(){ return nodeName; }
    
    public void setWeight(float w){ weightInMbps = w; }
    
    public float getWeight(){ return weightInMbps; }
}
