import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Empresa
{
	private short nTiendas, mProductos;
	private List<Producto> contenedores;
	private int cantidadContenedores;
	private byte arregloContenedores[][];
	
	public Empresa(short nTiendas, short mProductos) throws Excepcion
	{
		if ((nTiendas >= 1 && nTiendas <= 400) && (mProductos >= 1 && mProductos <= 400))
		{
			this.nTiendas = nTiendas;
			this.mProductos = mProductos;
			cantidadContenedores = this.nTiendas * this.mProductos;
			contenedores = new ArrayList<>();
			arregloContenedores = new byte[nTiendas][mProductos];
		}
		
		else
			throw new Excepcion();
	}
	
	public void leerArchivo(String nombreArchivo) throws IOException
	{
		String linea = null;
		
		String arregloString[] = new String[cantidadContenedores];
		
		byte cont, cont2;
		cont = cont2 = 0;
		
		try
		{
			FileReader fl = new FileReader(nombreArchivo);
			
			BufferedReader br = new BufferedReader(fl);
			
			while ((linea = br.readLine()) != null)
			{	
				arregloString = linea.split(" ");
				
				Producto p = new Producto(Byte.parseByte(arregloString[0]));
				
				contenedores.add(p);
				
				if (cont < mProductos)
				{
					arregloContenedores[cont2][cont] = p.getIdentificador();
					cont++;
				}
				
				else
				{
					cont2++;
					cont = 0;
				}
			}
			
			br.close();
		}
		
		catch (FileNotFoundException ex)
		{
			System.out.println("El árchivo no se encuentra. \n");
		}
	}
	
	public void metodoBuscarMinimoMovimiento()
	{
		byte cantidadMinima = 0;
		
		String cadenaFinal = "";
		
		boolean verificar = false;
		
		do
		{
			
		} while (verificar);
	}
	
	public byte ordenar(String cadena, byte cant)
	{
		byte cantidad = 0;
		
		boolean verificar = false;
		
		byte valorRepetido, valorRestante;
		valorRepetido = valorRestante = 0;
		
		byte valorPosicionVacia;
		valorPosicionVacia = 0;
		
		byte cantidadMovimientos = 0;
		
		int posicionVacia = (nTiendas * mProductos) + 1;
		
		String cadenaFinal;
		cadenaFinal = "";
		
		do
		{
			verificar = false;
			
			for (byte k = 0; k < nTiendas; k++)
			{
				byte arregloAux[] = new byte[mProductos];
				
				for (byte d = 0; d < mProductos; d++)
					arregloAux[d] = arregloContenedores[k][d];
				
				if (!verificarArreglo(arregloAux))
				{
					valorRepetido = verificarValorRepetido(arregloAux);
					
					valorRestante = verificarValorRestante(arregloAux);
					
					verificar = true;
					
					byte valorRepetido2 = 0;
					
					byte valorRestante2 = 0;
					
					byte arregloAux2[] = new byte[mProductos];
					
					if ((k + 1) != nTiendas)
					{
						for (byte d = 0; d < mProductos; d++)
							arregloAux2[d] = arregloContenedores[k + 1][d];
						
						if (!verificarArreglo(arregloAux2))
						{
							valorRepetido2 = verificarValorRepetido(arregloAux2);
							
							valorRestante2 = verificarValorRestante(arregloAux2);
							
							if ((valorRepetido == valorRestante2) && (valorRestante == valorRepetido2))
							{
								cantidadMovimientos++;
								
								byte aux = conseguirPosicion(arregloAux);
								
								valorPosicionVacia = arregloAux[aux];
								
								posicionVacia = 
							}
						}
					}
				}
			}
		} while (verificar);
		
		return cantidad;
	}
	
	public boolean verificarArreglo(byte arreglo[])
	{
		int cantidadArreglo = arreglo.length;
		
		for (byte k = 0; k < cantidadArreglo; k++)
		{
			for (byte d = 0; d < cantidadArreglo; d++)
			{
				if (d == k)
					d++;
				
				if (d == cantidadArreglo)
					break;
				
				else if (arreglo[k] == arreglo[d])
					return false;
			}
		}
		
		return true;
	}
	
	public byte verificarValorRepetido(byte arreglo[])
	{
		byte valorRepetido = 0;
		
		for (byte k = 0; k < mProductos; k++)
		{
			for (byte d = 0; d < mProductos; d++)
			{
				if (d == k)
					d++;
				
				if (d == mProductos)
					break;
				
				else if (arreglo[k] == arreglo[d])
				{
					valorRepetido = arreglo[k];
					return valorRepetido;
				}
			}
		}
		
		return 0;
	}
	
	public byte conseguirPosicion(byte arreglo[])
	{
		for (byte k = 0; k < mProductos; k++)
		{
			for (byte d = 0; d < mProductos; d++)
			{
				if (d == k)
					d++;
				
				if (d == mProductos)
					break;
				
				else if (arreglo[k] == arreglo[d])
					return k;
			}
		}
		
		return 0;
	}
	
	public byte verificarValorRestante(byte arreglo[])
	{
		boolean verificar = false;
		
		byte vRestante = 1;
		
		for (; vRestante < mProductos; vRestante++)
		{
			verificar = false;
			
			for (byte k = 0; k < mProductos; k++)
			{
				if (arreglo[k] == vRestante)
					verificar = true;
			}
			
			if (!verificar)
				break;
		}
		
		return vRestante;
	}
}
