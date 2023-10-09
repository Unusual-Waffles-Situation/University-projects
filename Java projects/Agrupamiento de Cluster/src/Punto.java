public class Punto 
{
	private int posX, posY;
	
	public Punto()
	{
		posX = posY = 0;
	}
	
	public Punto(int pX, int pY)
	{
		posX = pX;
		posY = pY;
	}
	
	public int getPosX(){ return posX; }
	public int getPosY(){ return posY; }
}
