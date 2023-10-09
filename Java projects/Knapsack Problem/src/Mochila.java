import java.util.Random;

public class Mochila 
{
	private Gen mochila;
	private Objeto objetos[];
	private short capacidad;
	private float probabilidad;
	private byte cantObjetos;
	
	public Mochila(byte co, short c)
	{
		cantObjetos = co;
		capacidad = c;
		
		mochila = new Gen(cantObjetos);
		
		Random random = new Random();
		
		probabilidad = random.nextFloat();
		
		objetos = new Objeto[cantObjetos];
		
		for (byte i = 0; i < cantObjetos; i++)
			objetos[i] = new Objeto();
	}
	
	public void agregarObjetos(String nombre, byte peso, byte valor, byte i)
	{
		objetos[i].setNombre(nombre);
		objetos[i].setPeso(peso);
		objetos[i].setValor(valor);
	}
	
	public Gen mecanismoDeGeneracion()
	{
		Gen mochilaAux = new Gen(cantObjetos);
		
		byte arr[] = new byte[cantObjetos];
		arr = mochila.getGen();
		
		Random random = new Random();
		
		int i = random.nextInt(cantObjetos);
		
		float prob = random.nextFloat();
		
		if (prob > probabilidad)
		{
			if (arr[i] == 1)
				arr[i] = 0;
			
			else
				arr[i] = 1;
		}
		
		mochilaAux.setGen(arr);
		
		return mochilaAux;
	}
	
	public boolean mejoramientoLocal()
	{
		int i, j;
		
		Random random = new Random();
		
		do
		{
			i = random.nextInt(cantObjetos - 1);
			j = random.nextInt(cantObjetos - 1);
		} while (i == j);
		
		int h, k;

		byte arr[] = new byte[cantObjetos];
		arr = mochila.getGen();
		
		boolean comp;
		
		do
		{
			comp = false;
			
			h = random.nextInt(2);
			k = random.nextInt(2);
			
			int i1, i2;
			i1 = arr[i];
			i2 = arr[j];
			
			if (h == i1 && k == i2)
				comp = true;
				
		} while(comp);
		
		Gen mochilaNueva = modificar(mochila, h, k, i, j);
		
		short resPeso1, resValor1, resPeso2, resValor2;
		short res1[], res2[];
		res1 = new short[1];
		res2 = new short[2];
		
		res1 = verificarMedia(mochila);
		res2 = verificarMedia(mochilaNueva);
		
		resPeso1 = res1[0];
		resValor1 = res1[1];
		
		resPeso2 = res2[0];
		resValor2 = res2[1];
		
		if (resValor1 < resValor2 && resPeso2 < capacidad)
		{
			mochila.setGen(mochilaNueva.getGen());
			
			return true;
		}
		
		else if (resValor1 == resValor2)
			probabilidad -= 0.01;
		
		return false;
	}
	
	public Gen modificar(Gen m, int h, int k, int i, int j)
	{
		Gen mochilaAux = new Gen(cantObjetos);
		
		byte arr[] = new byte[cantObjetos];
		
		arr[i] = (byte) h;
		arr[j] = (byte) k;
		
		mochilaAux.setGen(arr);
		
		return mochilaAux;
	}
	
	public short[] verificarMedia(Gen g)
	{
		byte arr[] = g.getGen();
		
		short res[] = new short[2];
		
		byte k = 0;
		
		for (byte i = 0; i < cantObjetos; i++)
		{
			if (arr[i] == 1)
			{
				res[k] += objetos[i].getPeso();
				k++;
				res[k] += objetos[i].getValor();
				
				k = 0;
			}
		}
		
		return res;
	}
	
	public String mostrar()
	{
		String cadena = "Los objetos para la mochila del ópimo global: \n";
		
		byte arr[] = mochila.getGen();
		
		for (byte i = 0; i < cantObjetos; i++)
		{
			if (arr[i] == 1)
				cadena += objetos[i].getNombre() + "\n"; 
		}
		
		return cadena;
	}
}
