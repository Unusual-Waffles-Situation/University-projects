public class Nodo 
{
	private Nodo izquierda, derecha, padre;
	private byte posX, posY;
	private boolean visitado;
	
	public Nodo()
	{
		izquierda = derecha = padre = null;
		
		visitado = false;
		
		posX = posY = 0;
	}
	
	public Nodo(byte x, byte y)
	{
		izquierda = derecha = padre = null;
		
		visitado = false;
		
		posX = x;
		posY = y;
	}
	
	public void setIzquierda(Nodo i){ izquierda = i; }
	public Nodo getIzquierda(){ return izquierda; }
	
	public void setDerecha(Nodo d) {derecha = d;}
	public Nodo getDerecha(){ return derecha; }
	
	public void setPadre(Nodo p){ padre = p; }
	public Nodo getPadre(){ return padre; }
	
	public void setPosX(byte x){ posX = x; }
	public byte getPosX(){ return posX; }
	
	public void setPosY(byte y){ posY = y; }
	public byte getPosY(){ return posY; }
	
	public void setVisitado(boolean b){ visitado = b; }
	public boolean getVisitado(){ return visitado; }
}
