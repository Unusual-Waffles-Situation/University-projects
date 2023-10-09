public class Punto 
{
	private int posX, posY;
	
	public Punto()
	{
		posX = posY = 0;
	}
	
	public Punto(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public void setPosX(short x){ posX = x; }
	public void setPosY(short y){ posY = y; }
	
	public int getPosX(){ return posX; }
	public int getPosY(){ return posY; }
}
