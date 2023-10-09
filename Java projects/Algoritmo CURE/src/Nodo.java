public class Nodo 
{
	private int ejeNodo;
	Nodo izquierda;
	Nodo derecha;
	private Nodo padre;
	double[] listaPuntos;
	private double posicionX, posicionY, media;
	
	Nodo(double[] lp, int en)
	{
		listaPuntos = new double[2];
		
		ejeNodo = en;
		
		for (byte k = 0; k < 2; k++)
			listaPuntos[k] = lp[k];
		
		izquierda = derecha = padre = null;
		
		posicionX = posicionY = media = 0;
	}
	
	Nodo()
	{
		
	}
	
	public Nodo encontrarPadre(double[] lp)
	{
		Nodo aux = null;
		Nodo siguiente = this;
		
		int dividir = 0;
		
		while (siguiente != null)
		{
			dividir = siguiente.ejeNodo;
			aux = siguiente;
			
			if (lp[dividir] > siguiente.listaPuntos[dividir])
				siguiente = siguiente.derecha;
			
			else
				siguiente = siguiente.izquierda;
		}
		
		return aux;
	}
	
	public Nodo ingresar(double[] lp)
	{
		//listaPuntos = new double[2];
		
		Nodo aux = encontrarPadre(lp);
		
		if (igual(lp, aux.listaPuntos, 2))
			return null;
		
		Nodo nuevoNodo = new Nodo(lp, aux.ejeNodo + 1 < 2 ? aux.ejeNodo + 1 : 0);
		nuevoNodo.padre = aux;
		
		if (lp[aux.ejeNodo] > aux.listaPuntos[aux.ejeNodo])
			aux.derecha = nuevoNodo;
		
		else
			aux.izquierda = nuevoNodo;
		
		return nuevoNodo;
			
	}
	
	// Para asegurar que no es el mismo nodo
	
	boolean igual(double[] lp1, double[] lp2, int dim)
	{
		for (byte k = 0; k < dim; k++)
		{
			if (lp1[k] != lp2[k])
				return false;
		}
		
		return true;
	}
		
	public void setIzquierda(Nodo x){ izquierda = x; }
	public Nodo getIzquierda(){ return izquierda; }
	
	public void setDerecha(Nodo x){ derecha = x; }
	public Nodo getDerecha(){ return derecha; }
	
	public void setListaPuntos(double[] x){ listaPuntos = x; }
	
	public void setPosicionX(double k){ posicionX = k; }
	public double getPosicionX(){ return posicionX; }
	
	public void setPosicionY(double d){ posicionY = d; }
	public double getPosicionY(){ return posicionY; }
	
	public void setMedia(double k){ media = k; }
	public double getMedia(){ return media; }
}
