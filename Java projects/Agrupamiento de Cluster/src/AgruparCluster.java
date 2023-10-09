import java.util.*;

public class AgruparCluster 
{
	private List<Nodo> lista; // Lista donde estarán los nodos
	private byte cantidadDeCluster; // Cantidad de cluster (k)
	private Cluster clusters[]; // Arreglo de cluster
	private int cantidadArreglo; // Tamaño total del arreglo que se recibirá
	private double arregloCluster[]; // Arreglo de los valores que se usaran para la comparación en "metodoK_Means"
	
	public AgruparCluster(byte cdc)
	{
		lista = new ArrayList<>();
		cantidadDeCluster = cdc;
		arregloCluster = new double[cdc];
		cantidadArreglo = 0;
		clusters = new Cluster[cdc];
	}
	
	public double calculoMedia(int valX1, int valY1, int valX2, int valY2)
	{
		double valX = Math.pow((valX2 - valX1), 2);
		double valY = Math.pow((valY2 - valY1), 2);
		
		double media = Math.sqrt(((int)valY + (int)valX));
		
		return media;
	}
	
	public Cluster[] metodoK_Means(int variable1[], int variable2[])
	{
		byte cantAux = 0;
		boolean comprobar, primeraCorrida;
		primeraCorrida = false;
		
		byte cont = 0;
		
		int cantArreglo = 0;
		
		double arregloValores[] = new double[cantidadArreglo];
		
		do
		{
			if (cont == 2)
				break;
			
			comprobar = false;
			
			cantArreglo = 0;
			
			// El nuevo cálculo de la media
			
			if (primeraCorrida)
			{
				for (byte d = 0; d < cantidadDeCluster; d++)
					clusters[d].calculoCentroide();
			}
			
			for (int k = 0; k < cantidadArreglo; k++)
			{
				while (cantAux < cantidadDeCluster)
				{
					arregloCluster[cantAux] = calculoMedia(variable1[k], variable2[k], clusters[cantAux].getCentroidePuntoX(), 
							clusters[cantAux].getCentroidePuntoY());
					
					cantAux++;
				}
				
				double valorMinimo = 0;
				byte pos = 0;
					
				for (byte d = 0; (d + 1) < cantidadDeCluster; d++)
				{
					if (arregloCluster[d] < arregloCluster[d + 1])
					{
						if (valorMinimo == 0)
						{
							valorMinimo = arregloCluster[d];
							pos = d;
								
							// Condición para asegurase de que no hubo cambios
							
							if ((primeraCorrida && arregloValores[cantArreglo] != valorMinimo) || !primeraCorrida)
								comprobar = true;
						}
								
						else
						{
							if (valorMinimo > arregloCluster[d])
							{
								valorMinimo = arregloCluster[d];
								pos = d;
									
								if ((primeraCorrida && arregloValores[cantArreglo] != valorMinimo) || !primeraCorrida)
									comprobar = true;
							}
						}
							
					}
							
						
					else
					{
						if (valorMinimo == 0)
						{
							valorMinimo = arregloCluster[d + 1];
							pos = (byte) (d + 1);
						}
						
						else
						{
							if (valorMinimo > arregloCluster[d + 1])
							{
								valorMinimo = arregloCluster[d + 1];
								pos = (byte) (d + 1);
							}
						}
							
						if ((primeraCorrida && arregloValores[cantArreglo] != valorMinimo) || !primeraCorrida)
							comprobar = true;
					}
					
					// Arreglo auxiliar de valores (para asegurase de que no hubo cambios)
						
					arregloValores[cantArreglo] = valorMinimo;
				}
					
				if ((primeraCorrida && arregloValores[cantArreglo] != valorMinimo) || !primeraCorrida)
				{
					Nodo nodo = lista.get(k);
						
					clusters[pos].agregarPunto(nodo);
				}
					
				cantAux = 0;
					
				cantArreglo++;
					
			}
			
			primeraCorrida = true;
			
			cont++;
			
		} while(comprobar);
		
		return clusters;
		
	}
	
	// En este método, mientras se van ingresando los nodos a la lista, se va haciendo un cálculo aproximado del centroide
	
	public void cargarPuntos(int arregloX[], int arregloY[])
	{
		cantidadArreglo = arregloX.length;
		byte cant = 0;
		byte can = 1;
		
		int cantidadPuntos = cantidadArreglo / cantidadDeCluster;
		
		//int cantidadAux = cantidadPuntos;
		
		boolean compPar = false;
		boolean compCondicion1 = false;
		boolean compImpar = false;
		
		if (cantidadPuntos * cantidadDeCluster != cantidadArreglo)
		{
			if (cantidadDeCluster % 2 == 0)
				compPar = true;
			
			else
				compImpar = true;
		}
		
		int k = 0;
		int auxX, auxY;
		auxX = auxY = 0;
		
		for (int d = 0; d < cantidadArreglo; d++, k++)
		{
			Nodo nodo = new Nodo(arregloX[d], arregloY[d], (arregloX[d] + arregloY[d]) / 2);
			
			lista.add(nodo);
			
			if (k < cantidadPuntos)
			{
				auxX += nodo.getPosX();
				auxY += nodo.getPosY();
			}
			
			else if (k == cantidadPuntos)
			{
				if (d + 1 != cantidadArreglo)
				{
					if (compPar || compImpar)
					{
						/* Agarra los valores antes y después del valor que se quiere,
						para hacer una prediccion de donde iría ese valor en uno de los clusters (ya sea el cluster actual o el siguiente)*/
						
						int xAux = arregloX[d - 1];
						int yAux = arregloY[d - 1];
						int xAux2 = nodo.getPosX();
						int yAux2 = nodo.getPosY();
						int xAux3 = arregloX[(cantidadPuntos * can) + 1];
						int yAux3 = arregloY[(cantidadPuntos * can) + 1];
						
						double media1, media2, media3;
						media1 = (xAux + yAux) / 2;
						media2 = (xAux2 + yAux2) / 2;
						media3 = (xAux3 + yAux3) / 2;
						
						double diferencia1, diferencia2;
						diferencia1 = Math.abs((media1 - media2));
						diferencia2 = Math.abs((media3 - media2));
						
						if (diferencia1 < diferencia2)
						{
							auxX += xAux2;
							auxY += yAux2;
							//d++;
							//cantidadPuntos--;
							compCondicion1 = true;
							
							Punto p = new Punto(auxX / cantidadPuntos, auxY / cantidadPuntos);
							
							clusters[cant] = new Cluster();
							clusters[cant++].setCentroide(p);
						}
						
						else
						{
							
							Punto p = new Punto(auxX / cantidadPuntos, auxY / cantidadPuntos);
							
							clusters[cant] = new Cluster();
							clusters[cant++].setCentroide(p);
							
							auxX = xAux2;
							auxY = yAux2;
							//cantidadPuntos = cantidadAux;
						}
						
					}
					
					else
					{
						Punto p = new Punto(auxX / cantidadPuntos, auxY / cantidadPuntos);
						
						clusters[cant] = new Cluster();
						clusters[cant++].setCentroide(p);
						
						auxX = auxY = 0;
					}
					
					k = -1;
					
					can++;
					
					if (compCondicion1)
						auxX = auxY = 0;
				}
				
				else
				{
					int xAux = arregloX[d];
					int yAux = arregloY[d];
					
					auxX += xAux;
					auxY += yAux;
					
					Punto p = new Punto(auxX / cantidadPuntos, auxY / cantidadPuntos);
					
					clusters[cant] = new Cluster();
					clusters[cant++].setCentroide(p);
				}
				
			}
		}
		
		// Condición de emergencia
		
		if (clusters[cantidadDeCluster - 1] == null)
		{
			Punto p = new Punto((auxX + 150) / cantidadPuntos, auxY / cantidadPuntos);
			
			clusters[cantidadDeCluster - 1] = new Cluster();
			clusters[cantidadDeCluster - 1].setCentroide(p);
		}
		
		Punto p = new Punto((clusters[0].getCentroidePuntoX() - 2), clusters[0].getCentroidePuntoY());
		clusters[0].setCentroide(p);
	}
	
	public String mostrarPuntosCluster()
	{
		String cadena = "";
		
		for (byte k = 0; k < cantidadDeCluster; k++)
			cadena += "Cluster #" + (k + 1) + ": \n" + clusters[k].mostrarPuntos() + "\n";
		
		return cadena;
	}
}
