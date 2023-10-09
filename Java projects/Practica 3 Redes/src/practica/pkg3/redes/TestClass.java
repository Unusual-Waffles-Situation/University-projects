package practica.pkg3.redes;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class TestClass 
{
    public static Graph g, gFinal;
    
    public static List<Vertex> vertexList;
    
    public static int graphArray[][];
    
    public static SemClass sem = new SemClass();
    
    public static Node[] readFile(String fileName) throws IOException
    {
        vertexList = new ArrayList<>();
        
	String line;
		
	String stringArray[] = new String[16];
        
        int arraySize = stringArray.length;
        
        boolean comp = false;
        
        byte aux = 0;
        
        byte xAux, yAux;
        xAux = yAux = 0;
        
        graphArray = new int[1][1];
        
        Node nodeArray[] = new Node[1];
        
        byte numberOfNodes = 0;
        
        for (byte i = 0; i < arraySize; i++)
            stringArray[i] = "";
		
	try
	{
            FileReader fl = new FileReader(fileName);
			
            try (BufferedReader br = new BufferedReader(fl)) 
            {
                while ((line = br.readLine()) != null)
                {
                    if (!comp)
                    {
                        String auxValue[] = new String[1];
					
			auxValue = line.split(" ");
					
			numberOfNodes = Byte.parseByte(auxValue[0]);
                        
                        g = new Graph(numberOfNodes);
                        
                        graphArray = new int[numberOfNodes][numberOfNodes];
                        
                        nodeArray = new Node[numberOfNodes];
                        
                        for (byte i = 0; i < numberOfNodes; i++)
                        {
                            String name = "" + (i + 1);
                            
                            Node n = new Node();
                            
                            n.setName(name);
                            
                            nodeArray[i] = n;
                            
                            Vertex v = new Vertex(name);
                            
                            vertexList.add(v);
                        }
                        
                        g.addVertex(nodeArray);
					
			comp = true;
                        
                        //gFinal.addVertex(nodeArray);
                    }
				
                    else
                    {
			stringArray = line.split(" ");
					
                        for (byte j = 0; j < numberOfNodes; j++)
                        {
                            byte value = Byte.parseByte(stringArray[j]);
                            
                            if (value > 0)
                            {
                                nodeArray[aux].addNode(nodeArray[j]);
                                
                                g.addEdge(aux, j, value);
                                //nodeArray[j].setWeight(value);
                                
                                Edge e = new Edge(vertexList.get(j), value);
                                
                                vertexList.get(aux).addAdjancents(e);
                            }
                            
                            graphArray[xAux][yAux++] = value;
                        }
                        
                        aux++;
                        
                        xAux++;
                        yAux = 0;
                    }
                }
            }
	}
		
	catch (FileNotFoundException ex)
	{
            System.out.println("El árchivo no se encuentra. \n");
	}
        
        return nodeArray;
    }
    
    public static void createFile(int[][] a, int cant)
    {
        String fileName = "Matriz.txt";
        
        File out = new File(fileName);
	FileWriter fw = null;
        
        try
	{
            fw = new FileWriter(out);
			
            BufferedWriter writer = new BufferedWriter(fw);
			
            int line = 0;
			
            Random random = new Random();
            
            writer.write(String.valueOf(cant));
            writer.newLine();
            
            for (byte i = 0; i < cant; i++)
            {
                for (byte k = 0; k < cant; k++)
                {
                    if (a[i][k] != 0)
                    {
                        line = random.nextInt(12);
                        
                        a[i][k] = line;
                    }
                    
                    else
                        line = 0;
                    
                    writer.write(String.valueOf(line) + " ");
                }
                
                writer.newLine();
            }
			
            writer.close();
	}
		
	catch (IOException e)
	{
            System.out.println("Ha ocurrido un error intentando abrir el archivo");
	}
    }
    
    public static void main(String[] args) throws IOException 
    {
        byte counter = 0;
        
        while (counter < 3)
        {
            String fileName = "Matriz.txt";
        
            Node array[] = readFile(fileName);
        
            int numberNodes = array.length;
        
            for (byte i = 0; i < numberNodes; i++)
                System.out.println(array[i].showNodes(numberNodes));
        
            g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            g.setSize(400, 800);
            g.setVisible(true);
        
            ShortestPath sp = new ShortestPath();
        
            sp.computePaths(vertexList.get(0)); // run Dijkstra
            
            System.out.println("Distance to " + vertexList.get(4).toString() + ": " + vertexList.get(4).minDistance);
            
            List<Vertex> path = sp.getShortestPathTo(vertexList.get(4));
            
            System.out.println("Path: " + path);
        
            Node arrayOfNodes[] = sp.getArray(path);
        
            int size;
            size = arrayOfNodes.length;
        
            gFinal = new Graph(size);
        
            gFinal.addVertex(arrayOfNodes);
        
            sp.addVertex(gFinal, path);
        
            JFrame f = new JFrame();
        
            gFinal.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
            gFinal.setSize(400, 800);
            gFinal.setVisible(true);
            
            gFinal.showProgress();
            createFile(graphArray, numberNodes);
            
            g.dispatchEvent(new WindowEvent(g, WindowEvent.WINDOW_CLOSING));
            gFinal.dispatchEvent(new WindowEvent(gFinal, WindowEvent.WINDOW_CLOSING));
            
            counter++;
        }
    }
    
}
