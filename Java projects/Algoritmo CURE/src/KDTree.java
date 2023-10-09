import java.util.Arrays;

public class KDTree 
{
	private Nodo raiz;
	private double arreglo[];
	
	KDTree()
	{
		raiz = null;
	}
	
	public Nodo kdtree(double[] lp, double[] lp2, double[] lpAux, int profundidad)
	{
		if (lp.length != 0)
		{
			int cant = lpAux.length;
			
			int cantidad = lp.length;
			
			Arrays.sort(lp);
			
			double media = 0;
			
			double arreglo1[];
			double arreglo2[];
			
			media = cantidad / 2;
			
			if (cantidad % 2 == 0)
			{
				arreglo1 = new double[(int)media];
				
				arreglo2 = new double[(cantidad - 1) - (int)media];
			}
			
			else
			{
				arreglo1 = new double[(int)media];
				arreglo2 = new double[(int)media];
			}
				
			Nodo aux = new Nodo();
			
			int d = (int)media;
			
			for (byte k = 0; k < d; k++)
				arreglo1[k] = lp[k];
			
			d = (int)(media + 1);
			
			for (byte k = 0; d < lp.length; d++, k++)
				arreglo2[k] = lp[d];
			
			double posY = 0;
			
			aux.setPosicionX(lp[(int)(media)]);
			
			for (byte k = 0; k < cant; k++)
			{
				boolean comp = false;
				
				for (byte c = 0; c < cant; c++)
				{
					if (lpAux[c] == lp[(int)media])
					{
						posY = lp2[c];
						comp = true;
						break;
					}
				}
				
				if (comp)
					break;
			}
			
			if (raiz == null)
			{
				raiz = aux;
				arreglo = lp;
			}
			
			aux.setPosicionY(posY);
			
			aux.setMedia((aux.getPosicionX() + aux.getPosicionY()) / 2);
			
			aux.setIzquierda(kdtree(arreglo1, lp2, lpAux, profundidad + 1));
			aux.setDerecha(kdtree(arreglo2, lp2, lpAux, profundidad + 1));
			
			return aux;
		}
		
		Nodo nodo = new Nodo();
		
		return nodo;
	}
	
	Nodo buscarVecinoMasCercano(Nodo nodo, Nodo nodoBuscar, double diferenciaX, double diferenciaY)
	{	
		Nodo vecinoCercano = null;
		
		if (nodo == null)
			return null;
		
		else
		{
			double valX = nodo.getPosicionX() - nodoBuscar.getPosicionX();
			double valY = nodo.getPosicionY() - nodoBuscar.getPosicionY();
			
			if (diferenciaX == 0 && diferenciaY == 0)
			{
				diferenciaX = Math.abs(valX);
				diferenciaY = Math.abs(valY);
			}
			
			else
			{
				if (valX < diferenciaX && valY < diferenciaY)
				{
					diferenciaX = Math.abs(valX);
					diferenciaY = Math.abs(valY);
				}
			}
			
			return vecinoCercano;
		}
	}
	
	public Nodo getRaiz(){ return raiz; }
	
	/*Nodo eliminarNodo(Nodo nodo)
	{
		if (raiz == null)
			return null;
		
		for (byte d = 0; d < raiz.getPosicionX(); d++)
		{
			
		}
		
		return null;
	}*/
}
