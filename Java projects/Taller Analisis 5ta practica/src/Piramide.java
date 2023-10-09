public class Piramide 
{
	private short dimension[][], a, b, contadorA, contadorB, posiX, posiY;
	private CamaraRectangular cr;
	private boolean comprobar;
	
	public Piramide(short a, short b, CamaraRectangular cr)
	{
		this.a = a;
		this.b = b;
		
		comprobar = false;
		
		contadorA = contadorB = posiX = posiY = 0;
		
		dimension = new short[b][a];
		
		this.cr = cr;
	}
	
	public void agergarDimensiones(short x)
	{
		if (contadorA == a)
		{
			contadorA = 0;
			contadorB++;
		}
		
		dimension[contadorB][contadorA] = x;
	}
	
	public boolean getComprobar(){ return comprobar; }
	public short getA(){ return a; }
	public short getB(){ return b; }
	public CamaraRectangular getCR(){ return cr; }
	public short getPosX(){ return posiX; }
	public short getPosY(){ return posiY; }
	public short getContadorA(){ return contadorA; }
	public short getContadorB(){ return contadorB; }
	
	public void setA(short a){ this.a = a; }
	public void setB(short b){ this.b = b; }
	public void setPosX(short x){ posiX = x; }
	public void setPosY(short y){ posiY = y; }
	public void setContadorA(short a){ contadorA = a; }
	public void setContadorB(short b){ contadorB = b; }
	public void setComprobar(boolean c){ comprobar = c; }
}
