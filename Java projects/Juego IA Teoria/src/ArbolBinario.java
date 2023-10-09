public class ArbolBinario 
{
	private Nodo raiz, nodoActual;
	private byte cantidad;
	
	public ArbolBinario()
	{
		nodoActual = null;
		
		raiz = new Nodo((byte) 4, (byte) 7);
		
		cantidad = 0;
		
		/*raiz.setPosX((byte) 4);
		raiz.setPosY((byte) 7);*/
	}
	
	public void agregarCaminoDerecha(Nodo n)
	{
		if (cantidad == 0)
		{
			raiz.setDerecha(n);
			
			nodoActual = raiz.getDerecha();
			nodoActual.setPadre(raiz);
			cantidad++;
		}
		
		else
		{
			nodoActual.setDerecha(n);
			
			Nodo aux = nodoActual;
			aux.getDerecha().setPadre(nodoActual);
			nodoActual = aux.getDerecha();
			cantidad++;
		}
	}
	
	public void agregarCaminoIzquierda(Nodo n)
	{
		if (cantidad == 0)
		{
			raiz.setIzquierda(n);
			
			nodoActual = raiz.getIzquierda();
			nodoActual.setPadre(raiz);
			cantidad++;
		}
		
		else
		{
			nodoActual.setIzquierda(n);
			
			Nodo aux = nodoActual;
			aux.getIzquierda().setPadre(nodoActual);
			nodoActual = aux.getIzquierda();
			cantidad++;
		}
	}
	
	public void regresar()
	{
		Nodo aux = nodoActual;
		nodoActual = aux.getPadre();
	}
	
	/*public boolean verificar(Nodo nodoAct, Nodo nodoBus)
	{
		if (nodoAct != null)
		{
			
		}
		
		return false;
	}*/
	
	public Nodo getRaiz(){ return raiz; }
}
