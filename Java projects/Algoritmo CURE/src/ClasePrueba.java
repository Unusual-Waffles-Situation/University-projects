import java.util.Arrays;
import java.io.*;

public class ClasePrueba 
{

	public static void main(String[] args) throws IOException 
	{
		String nombreArchivo = "Archivo.txt";
		
		String linea = null;
		
		byte cant = 0;
		
		double arregloX[] = new double[20];
		double arregloY[] = new double[20];
		
		String[] arr = new String[125];
		
		try
		{
			FileReader fl = new FileReader(nombreArchivo);
			
			BufferedReader br = new BufferedReader(fl);
			
			while((linea = br.readLine()) != null)
			{
				arr = linea.split("," + " ");
				
				arregloX[cant] = Double.parseDouble(arr[0]);
				
				arregloY[cant++] = Double.parseDouble(arr[1]);
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("No se puede abrir el archivo '" + nombreArchivo + "'.");
		}
		
		double arrX[] = new double[cant];
		double arrY[] = new double[cant];
		double arrXAux[] = new double[cant];
		
		for (byte k = 0; k < cant; k++)
		{
			arrX[k] = arregloX[k];
			arrXAux[k] = arregloX[k];
			arrY[k] = arregloY[k];
		}
		
		arregloX = arregloY = null;
		
		/*System.out.println(Arrays.toString(arrX));
		
		System.out.println(Arrays.toString(arrY));*/
		
		KDTree ab = new KDTree();
		
		Nodo nodo = new Nodo();
		
		nodo = ab.kdtree(arrX, arrY, arrXAux, 0);
		
	}

}
