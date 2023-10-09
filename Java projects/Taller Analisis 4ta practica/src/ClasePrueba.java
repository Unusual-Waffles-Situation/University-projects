import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.Polygon;

import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;

public class ClasePrueba 
{
	public static void leerArchivo(String nombreArchivo, Pared pa) throws IOException, Excepcion
	{
		String linea = null;
		
		String arregloString[] = new String[125];
		
		boolean comp = false;
		
		short cant = 0;
		
		try
		{
			FileReader fl = new FileReader(nombreArchivo);
			
			BufferedReader br = new BufferedReader(fl);
			
			// Leer cantidad n
			
			while ((linea = br.readLine()) != null)
			{
				if (!comp)
				{
					String valorAux[] = new String[1];
					
					valorAux = linea.split(" ");
					
					cant = Short.parseShort(valorAux[0]);
					
					pa.setCantidadFiguras(cant);
					
					comp = true;
				}
				
				else
				{
					arregloString = linea.split(" ");
					
					short valorX, valorY, valorX2, valorY2;
					
					valorX = Short.parseShort(arregloString[0]);
					valorY = Short.parseShort(arregloString[1]);
					valorX2 = Short.parseShort(arregloString[2]);
					valorY2 = Short.parseShort(arregloString[3]);
					
					Punto punto = new Punto(valorX, valorY);
					Punto punto2 = new Punto(valorX2, valorY2);
					
					Figura f = new Figura(punto, punto2);
						
					pa.agregarFigura(f);
				}
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El árchivo no se encuentra. \n");
		}
	}
	
	public static void crearArchivo(DibujarFiguras df)
	{
		String nombreArchivo2 = "PICTUR.OUT.txt";
		
		File out = new File(nombreArchivo2);
		FileWriter fw = null;
		
		try
		{
			fw = new FileWriter(out);
			
			BufferedWriter writer = new BufferedWriter(fw);
			
			int line = df.getPerimetro();
			
			writer.write(String.valueOf(line));
			writer.newLine();
			
			writer.close();
		}
		
		catch (IOException e)
		{
			System.out.println("Ha ocurrido un error intentando crear el archivo");
		}
	}
	
	public static void main(String[] args) throws IOException, Excepcion 
	{
		Pared p = new Pared();
		
		String nombreArchivo = "PICTUR.IN.txt";
		
		leerArchivo(nombreArchivo, p);
		
		boolean verificar = false;
		
		List<Polygon> lista = new ArrayList<>();
		
		DibujarFiguras df = new DibujarFiguras(p, verificar, lista);
		
		lista = df.getLista();
		
		df.pack();
		
		RefineryUtilities.centerFrameOnScreen(df);
		df.setVisible(true);
		
		verificar = true;
		
		DibujarFiguras df2 = new DibujarFiguras(p, verificar, lista);
		
		df2.pack();
		
		RefineryUtilities.centerFrameOnScreen(df2);
		df2.setVisible(true);
		
		crearArchivo(df2);
	}

}
