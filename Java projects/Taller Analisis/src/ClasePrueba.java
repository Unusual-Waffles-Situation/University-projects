

import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.jfree.ui.RefineryUtilities;

public class ClasePrueba 
{
	public static final short cantidadMaxima = 500;
	
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
	
	public static void leerArchivo(String nombreArchivo, int cantidadArreglo, int arreglo[]) throws IOException
	{
		String linea = null;
		
		short cant = 0;
		
		String arr[] = new String[cantidadArreglo];
		
		try
		{
			FileReader fl = new FileReader(nombreArchivo);
			
			BufferedReader br = new BufferedReader(fl);
			
			// Este while se encarga de leer todas las lineas del archivo
			
			while ((linea = br.readLine()) != null)
			{
				arr = linea.split(" ");
				
				arreglo[cant++] = Integer.parseInt(arr[0]);
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El árchivo no se encuentra. \n");
		}
		
		int arregloFinal[] = new int[cant];
		
		for (short d = 0; d < cant; d++)
			arregloFinal[d] = arreglo[d];
		
		arreglo = arregloFinal;
		
		//arregloFinal = null;
	}
	
	public static void mejorCaso(int arreglo[], int cantidadArreglo)
	{
		Insercion i = new Insercion();
		
		i.metodoInsercion(arreglo, cantidadArreglo, 0);
	}
	
	public static void casoPromedio(int arreglo[], int cantidadArreglo)
	{
		Insercion i = new Insercion();
		
		int cant = cantidadArreglo / 2;
		
		i.metodoInsercion(arreglo, cant, 0);
		i.metodoInsercion(arreglo, cantidadArreglo, cant);
	}
	
	public static void peorCaso(int arreglo[], int cantidadArreglo)
	{
		int temp = 0;
		
		for (int d = 0; d < cantidadArreglo; d++)
		{
			for (int k = 1; k < cantidadArreglo - 1; k++)
			{
				if (arreglo[k - 1] < arreglo[k])
				{
					temp = arreglo[k - 1];
					arreglo[k - 1] = arreglo[k];
					arreglo[k] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		String nombreArchivo = "";
		
		double duracion[] = new double[6];
		
		int arreglo[] = new int[cantidadMaxima];
		int arreglo2[] = new int[cantidadMaxima * 2];
		int arreglo3[] = new int [cantidadMaxima * 4];
		
		byte num = 1;
		
		// Generar primer árchivo
		
		nombreArchivo = random(cantidadMaxima, num);
		
		leerArchivo(nombreArchivo, arreglo.length, arreglo);
		
		peorCaso(arreglo, arreglo.length);
		
		// Generar segundo árchivo
		
		nombreArchivo = "";
		
		num++;
		
		nombreArchivo = random(cantidadMaxima, num);
		
		leerArchivo(nombreArchivo, arreglo2.length, arreglo2);
		
		peorCaso(arreglo2, arreglo2.length);
		
		// Generar tercer árchivo
		
		nombreArchivo = "";
		
		num++;
		
		nombreArchivo = random(cantidadMaxima, num);
		
		leerArchivo(nombreArchivo, arreglo3.length, arreglo3);
		
		peorCaso(arreglo3, arreglo3.length);
		
		// Arreglo 1
		
		// Método de inserción
		
		Insercion i = new Insercion();
		
		double inicio, fin;
		inicio =  fin = 0;
		
		inicio = System.nanoTime();
		
		i.metodoInsercion(arreglo, arreglo.length, 0);
		
		fin = System.nanoTime();
		
		duracion[0] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo.length + " - " + duracion[0] + " (Método de inserción)");
		
		// Método QuickSort
		
		inicio = fin = 0;
		
		inicio = System.nanoTime(); 
		
		QuickSort qs = new QuickSort();
		
		qs.metodoQuickSort(arreglo, 0, arreglo.length - 1);
		
		fin = System.nanoTime();
		
		duracion[1] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo.length + " - " + duracion[1] + " (Método QuickSort)");
		
		// Arreglo 2
		
		inicio = fin = 0;
		
		inicio = System.nanoTime();
		
		i.metodoInsercion(arreglo2, arreglo2.length, 0);
		
		fin = System.nanoTime();
		
		duracion[2] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo2.length + " - " + duracion[2] + " (Método de inserción)");
		
		// Método QuickSort
		
		inicio = fin = 0;
		
		inicio = System.nanoTime(); 
		
		qs.metodoQuickSort(arreglo2, 0, arreglo2.length - 1);
		
		fin = System.nanoTime();
		
		duracion[3] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo2.length + " - " + duracion[3] + " (Método QuickSort)");
		
		// Arreglo 3
		
		inicio = fin = 0;
		
		inicio = System.nanoTime();
		
		i.metodoInsercion(arreglo3, arreglo3.length, 0);
		
		fin = System.nanoTime();
		
		duracion[4] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo3.length + " - " + duracion[4] + " (Método de inserción)");
		
		// Método QuickSort
		
		inicio = fin = 0;
		
		inicio = System.nanoTime(); 
		
		qs.metodoQuickSort(arreglo3, 0, arreglo3.length - 1);
		
		fin = System.nanoTime();
		
		duracion[5] = (fin - inicio) / 1000000000;
		
		System.out.println("N = " + arreglo3.length + " - " + duracion[5] + " (Método QuickSort)");
		
		final Grafica g1 = new Grafica("Peor caso (Insercion)", arreglo.length, arreglo2.length, arreglo3.length, duracion[0], duracion[2], duracion[4]);
		
		g1.pack();
		
		RefineryUtilities.centerFrameOnScreen(g1);
		g1.setVisible(true);
		
		final Grafica g2 = new Grafica("Peor caso (QuickSort)", arreglo.length, arreglo2.length, arreglo3.length, duracion[1], duracion[3], duracion[5]);
		
		g2.pack();
		
		RefineryUtilities.centerFrameOnScreen(g2);
		g2.setVisible(true);
	}

}
