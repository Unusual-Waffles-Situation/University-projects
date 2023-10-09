import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClasePrueba 
{
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
	
	public static byte leerByte()
	{
		byte i = 0;
		
		boolean sw;
		
		do
		{
			sw = false;
			
			try
			{
				i = Byte.parseByte(Leer().readLine());
			}
			
			catch (Exception e)
			{
				System.out.println("Ha ocurrido un error.");
				
				sw = true;
			}
			
		} while (sw);
		
		return i;
	}
	
	public static String leerString()
	{
		String i = "";
		
		boolean sw;
		
		do
		{
			sw = false;
			
			try
			{
				i = Leer().readLine();
			}
			
			catch (Exception e)
			{
				System.out.println("Ha ocurrido un error.");
				
				sw = true;
			}
			
		} while (sw);
		
		return i;
	}
	
	public static void main(String[] args)
	{
		byte cantidadObj = 0;
		
		short capacidad = 0;
		
		Mochila m;
		
		System.out.print("Ingrese cantidad de objetos: ");
		cantidadObj = leerByte();
		
		System.out.print("Ingrese capacidad máxima de la mochila: ");
		capacidad = leerShort();
		
		m = new Mochila(cantidadObj, capacidad);
		
		for (byte i = 0; i < cantidadObj; i++)
		{
			String nombre = "";
			
			byte valor, peso;
			valor = peso = 0;
			
			System.out.print("Ingrese nombre del objetos #" + (i + 1) + ": ");
			nombre = leerString();
			
			System.out.print("Ingrese valor del objeto: ");
			valor = leerByte();
			
			System.out.print("Ingrese peso del objeto: ");
			peso = leerByte();
			
			m.agregarObjetos(nombre, peso, valor, i);
			
			System.out.print("\n");
		}
		
		boolean comp;
		byte cont = 0;
		
		do
		{
			comp = false;
			
			comp = m.mejoramientoLocal();
			
			if (!comp)
				cont++;
			
		} while (cont < 9);
		
		System.out.println(m.mostrar());
	}
}
