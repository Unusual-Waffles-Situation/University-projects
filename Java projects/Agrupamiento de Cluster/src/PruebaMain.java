import java.io.*;
import java.util.Random;

import org.jfree.ui.RefineryUtilities;

import java.util.Arrays;

public class PruebaMain 
{
	public static final int cantidadArreglo = 50; // La cantidad de valores que se van a leer
	
	public static final byte cantidadClusters = 4; // El número de k
	
	public static String random(int cant, byte num)
	{
		String nombreArchivo = "Archivo" + num + ".txt";
		
		File out = new File(nombreArchivo);
		FileWriter fw = null;
		
		int n = cant;
		
		try
		{
			fw = new FileWriter(out);
			
			BufferedWriter writer = new BufferedWriter(fw);
			
			int line = 0;
			
			Random random = new Random();
			
			while (n > 0)
			{
				line = random.nextInt(1000);
				writer.write(String.valueOf(line));
				writer.newLine();
				n--;
			}
			
			writer.close();
		}
		
		catch (IOException e)
		{
			System.out.println("Ha ocurrido un error intentando abrir el archivo");
		}
		
		return nombreArchivo;
	}
	
	// El método de lectura de archivo
	
	public static void leerArchivo(String nombreArchivo, int arreglo[]) throws IOException
	{
		String linea = null;
		
		int cant = 0;
		
		String arregloString[] = new String[cantidadArreglo];
		
		try
		{
			FileReader fl = new FileReader(nombreArchivo);
			
			BufferedReader br = new BufferedReader(fl);
			
			while ((linea = br.readLine()) != null)
			{
				arregloString = linea.split(" ");
				
				arreglo[cant++] = Integer.parseInt(arregloString[0]);
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El árchivo no se encuentra. \n");
		}
		
		int arregloFinal[] = new int[cant];
		
		for (int d = 0; d < cant; d++)
			arregloFinal[d] = arreglo[d];
		
		arreglo = arregloFinal;
	}
	
	public static void main(String[] args) throws IOException
	{
		int arreglo1[] = new int[cantidadArreglo];
		int arreglo2[] = new int[cantidadArreglo];
		
		String nombre1, nombre2;
		
		// Se le cambiarían el nombre a los archivos, con el fin de leer el deseado
		
		//nombre1 = "Archivo.txt";
		//nombre2 = "Archivo2.txt";
		
		byte num = 1;
		
		nombre1 = "X.txt"; /*= random(cantidadArreglo, num);*/
		leerArchivo(nombre1, arreglo1);
		
		num++;
		
		nombre2 = "Y.txt";/*= random(cantidadArreglo, num);*/
		leerArchivo(nombre2, arreglo2);
		
		AgruparCluster ac = new AgruparCluster(cantidadClusters);
		
		int arregloAux[] = new int[cantidadArreglo];
		leerArchivo(nombre1, arregloAux);
		
		Arrays.sort(arreglo1);
		
		for (int i = 0; i < cantidadArreglo; i++)
		{
			for (int k = 0; k < cantidadArreglo; k++)
			{
				if (arreglo1[i] == arregloAux[k])
				{
					int aux = arreglo2[i];
					arreglo2[i] = arreglo2[k];
					arreglo2[k] = aux;
					break;
				}
			}
		}
		
		Cluster c[] = new Cluster[cantidadClusters];
		
		ac.cargarPuntos(arreglo1, arreglo2);
		
		c = ac.metodoK_Means(arreglo1, arreglo2);
		
		//String cadena = ac.mostrarPuntosCluster();
		
		//System.out.println(cadena);
		
		GraficaCluster grafica = new GraficaCluster(c, cantidadClusters, cantidadArreglo);
		
		grafica.pack();
		//grafica.generarGrafica(c, cantidadClusters, cantidadArreglo);
		RefineryUtilities.centerFrameOnScreen(grafica);
		grafica.setVisible(true);
	}

}
