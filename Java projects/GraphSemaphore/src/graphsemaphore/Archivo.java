package graphsemaphore;

import com.mxgraph.view.mxGraph;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JFrame;

public class Archivo 
{
    private final Path inputFilePath;
    private Grafo g;
    
    public Archivo(final String inputName, final String dir) 
    {
        inputFilePath  = FileSystems.getDefault().getPath(dir, inputName);
        
        g = new Grafo();
        //readFile();
    }
    
    private boolean isLineEmpty(final String line) 
    {
        return line.isEmpty() || line.trim().isEmpty();
    }
    
    private short isFileValid(Scanner scanner) throws IOException 
    {
        if (!scanner.hasNextShort())
            throw new IOException("No se encontraron números en el archivo");
        
        return scanner.nextShort();
    }
    
    public void readFile() throws NoSuchElementException, Exception 
    {
        Scanner scannerFile = new Scanner(inputFilePath);
        
        boolean nodeLinking = false;
        
        while (scannerFile.hasNextLine()) 
        {
            String line = scannerFile.nextLine();
            
            if (line.isEmpty()) 
            {
                nodeLinking = true;
                
                continue;
            }
            
            Scanner lineScanner = new Scanner(line);
            
            if (!nodeLinking) 
            {
                lineScanner.useDelimiter(Pattern.compile(":"));
                
                while (lineScanner.hasNext()) 
                {
                    String nodeName = lineScanner.next();
                    
                    lineScanner.reset();
                    
                    lineScanner.next();
                    
                    long taskTime = lineScanner.nextLong();
                    
                    g.addNodo(new Nodo(nodeName, secToMilis(taskTime)));
                }
            }
            
            else 
            {
                String node = lineScanner.next();
                
                while (lineScanner.hasNext()) 
                {
                    String nextNode = lineScanner.next();
                    
                    g.linkNodo(node, nextNode);
                    
                    node = nextNode;
                }
            }
            
            lineScanner.close();
            // you're at the end of the line here. Do what you have to do.
          }
        
        /*if (g.isEmpty())
            throw new IOException("Grafo está vacío");*/
        
        scannerFile.close();
    }
    
    private long secToMilis(final long sec) 
    {
        return sec * 1000;
    }
    
    public final Path getInputFilePath() 
    {
         return inputFilePath;
    }
    
    public final void start(mxGraph graph, Object arr[]) 
    {
        g.start(graph, arr);
    }
    
    public Grafo getGrafo(){ return g; }
}
