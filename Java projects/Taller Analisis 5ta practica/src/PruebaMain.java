import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaMain 
{
	public static Espacio leerArchivo(String nombreArchivo) throws NumberFormatException, IOException
	{
		String linea = null;
		
		String arregloString[] = new String[125];
		
		Espacio e = null;
		
		boolean comp = false;
		
		short cantM, cantN, cantA, cantB, cantC, cantD;
		cantM = cantN = cantA = cantB = cantC = cantD = 0;
		
		try
		{
			FileReader fl = new FileReader(nombreArchivo);
			
			BufferedReader br = new BufferedReader(fl);
			
			while ((linea = br.readLine()) != null)
			{
				if (!comp)
				{
					String valorAux[] = new String[6];
					
					valorAux = linea.split(" ");
					
					cantM = Short.parseShort(valorAux[0]);
					cantN = Short.parseShort(valorAux[1]);
					cantA = Short.parseShort(valorAux[2]);
					cantB = Short.parseShort(valorAux[3]);
					cantC = Short.parseShort(valorAux[4]);
					cantD = Short.parseShort(valorAux[5]);
					
					CamaraRectangular cr = new CamaraRectangular(cantC, cantD);
					
					Piramide p = new Piramide(cantA, cantB, cr);
					
					e = new Espacio(cantM, cantN, p);
					
					comp = true;
				}
				
				else
				{
					arregloString = linea.split(" ");
					
					for (short k = 0; k < cantM; k++)
					{
						short valor = 0;
						valor = Short.parseShort(arregloString[k]);
						
						e.agregarValoresDimension(valor);
					}
				}
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El árchivo no se encuentra. \n");
		}
		
		return e;
	}
	
	public static void crearArchivo(Espacio e)
	{
		String nombreArchivo2 = "pyramid.out.txt";
		
		File out = new File(nombreArchivo2);
		FileWriter fw = null;
		
		try
		{
			fw = new FileWriter(out);
			
			BufferedWriter writer = new BufferedWriter(fw);
			
			int line = e.getPosM() + 1;
			int line2 = e.getPosN() + 1;
			int line3 = e.getPiramide().getContadorB() + 1;
			int line4 = e.getPiramide().getContadorA() + 1;
			
			writer.write(String.valueOf(line) + " " + String.valueOf(line2));
			writer.newLine();
			
			writer.write(String.valueOf(line4) + " " + String.valueOf(line3));
			writer.newLine();
			
			writer.close();
		}
		
		catch (IOException ex)
		{
			System.out.println("Ha ocurrido un error intentando crear el archivo");
		}
	}
	
	public static Espacio main(String[] args) throws IOException 
	{
		String nombreArchivo = "pyramid2.in.txt";
		
		Espacio e = leerArchivo(nombreArchivo);
		
		short valor1, valor2;
		valor1 = 0;
		valor2 = 0;
		
		e.verificarLugar(valor1, valor2);
		
		e.agregarDimensionPiramide();
		
		e.calculoCamara((short)(e.getPosM() + 1), (short)(e.getPosN() + 1));
		
		crearArchivo(e);
		
		return e;
	}
}