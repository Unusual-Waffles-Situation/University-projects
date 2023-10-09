import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;

public class ClasePrueba 
{
	public static final short cantidadMaxima = 20;
	
	public static BufferedReader Leer()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br;
	}
	
	public static short leerShort()
	{
		short i = 0;
		
		boolean sw;
		
		do
		{
			sw = false;
			
			try
			{
				i = Short.parseShort(Leer().readLine());
			}
			
			catch (Exception e)
			{
				System.out.println("Ha ocurrido un error.");
				
				sw = true;
			}
			
		} while (sw);
		
		return i;
	}
	
	public static void generarArchivo()
	{
		File out = new File("Archivo1.txt");
		FileWriter fw = null;
		
		int cant = cantidadMaxima;
		
		try
		{
			fw = new FileWriter(out);
			
			BufferedWriter writer = new BufferedWriter(fw);
			
			int lineX, lineY;
			lineX = lineY = 0;

			byte linePos = 0;
			
			Random random = new Random();
			
			while (cant > 0)
			{

				lineX = random.nextInt(10);
				lineY = random.nextInt(10);
				
				if (lineX == 0)
					lineX++;
				
				if (lineY == 0)
					lineY++;
				
				if (((lineY - lineX) >= 2) || (lineY == 10 && lineY > lineX))
					linePos = 1;
				
				else
					linePos = -1;
				
				writer.write("1, " + String.valueOf(lineX) + ", " + String.valueOf(lineY) + ", " + String.valueOf(linePos));
				
				writer.newLine();
				
				cant--;
			}
			
			writer.close();
		}
		
		catch (IOException e)
		{
			System.out.println("Ha ocurrido un error intentando abrir el archivo");
		}
	}
	
	public static void leerArchivo(Punto p[], Punto p2[]) throws IOException
	{
		String linea = null;
		
		String arregloString[] = new String[100];
		
		byte i1, i2;
		i1 = i2 = 0;
		
		try
		{
			FileReader fl = new FileReader("Archivo.txt");
			
			BufferedReader br = new BufferedReader(fl);
			
			while ((linea = br.readLine()) != null)
			{
				arregloString = linea.split("," + " "/* + "," + " "*/);
				
				short valor1, valor2;
				byte valor3;
				
				valor1 = Short.parseShort(arregloString[1]);
				valor2 = Short.parseShort(arregloString[2]);
				valor3 = Byte.parseByte(arregloString[3]);
				
				if (valor3 == 1)
				{
					p[i1].setPosX(valor1);
					p[i1].setPosY(valor2);
					p[i1].setPos(valor3);
					
					i1++;
				}
				
				else
				{
					p2[i2].setPosX(valor1);
					p2[i2].setPosY(valor2);
					p2[i2].setPos(valor3);
					
					i2++;
				}
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El archivo no es encuentra.");
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		Punto punto1[] = new Punto[cantidadMaxima];
		Punto punto2[] = new Punto[cantidadMaxima];
		Punto punto3[] = new Punto[2];
		
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		for (byte i = 0, j = 0; i < punto1.length; i++)
		{
			punto1[i] = new Punto();
			punto2[i] = new Punto();
			
			if (j < 2)
			{
				punto3[j] = new Punto();
				j++;
			}
		}
		
		generarArchivo();
		
		leerArchivo(punto1, punto2);
		
		float peso1 = 0f;
		float peso2 = 2f;
		float peso3 = 2f;
		
		punto3[0].setPosX((byte) 0);
		punto3[0].setPosY(peso1 / peso3);
		
		punto3[1].setPosX(10 * (peso3 / peso2));
		punto3[1].setPosY(10);
		
		Perceptron p = new Perceptron(peso1, peso2, peso3);
		
		Grafica g = new Grafica(punto1, punto2, punto3);
		
        frame.add(g.getCP());
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
		/*g.pack();
		
		RefineryUtilities.centerFrameOnScreen(g);
		g.setVisible(true);*/
		
		p.entrenamiento(punto1, punto2, punto3, frame);
	}
}
