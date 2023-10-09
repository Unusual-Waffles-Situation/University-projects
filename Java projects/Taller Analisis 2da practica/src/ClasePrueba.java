import java.io.*;

import org.jfree.ui.RefineryUtilities;

public class ClasePrueba 
{
	public static boolean leerArchivo(String nombreArchivo, ClaseCalculo c, Punto p) throws IOException
	{
		String linea = null;
		
		String arregloString[] = new String[125];
		
		boolean comp = false;
		
		int valAux = 0;
		
		int cant = 0;
		
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
					
					cant = Integer.parseInt(valorAux[0]);
					
					comp = true;
				}
				
				else
				{
					arregloString = linea.split("," + " ");
					
					int valorX, valorY;
					
					valorX = Integer.parseInt(arregloString[0]);
					valorY = Integer.parseInt(arregloString[1]);
					
					if (valAux < cant)
					{
						Punto punto = new Punto(valorX, valorY);
						
						c.agregarPunto(punto);
						
						valAux++;
					}
					
					else if (valAux == cant)
					{
						p.setPosX(valorX);
						p.setPosY(valorY);
					}
				}
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El árchivo no se encuentra. \n");
		}
		
		if (valAux > cant)
			return false;
		
		else
			return true;
	}
	
	public static void main(String[] args) throws IOException 
	{
		ClaseCalculo cc = new ClaseCalculo();
		
		String nombreArchivo = "Archivo.txt";
		
		boolean comp = false;
		
		Punto p = new Punto();
		
		comp = leerArchivo(nombreArchivo, cc, p);
		
		if (!comp)
			System.out.println("La cantidad de 'n' no es igual a la cantidad de puntos.");
		
		else
		{
			Grafica g = new Grafica(cc, p);
			
			if (g.verificarPunto(p))
			{
				System.out.println("El punto se encuentra adentro del polígono.");
				
				g.pack();
				
				RefineryUtilities.centerFrameOnScreen(g);
				g.setVisible(true);
			}
			
			else
				System.out.println("El punto no se encuentra adentro del polígono.");
		}
	}

}
