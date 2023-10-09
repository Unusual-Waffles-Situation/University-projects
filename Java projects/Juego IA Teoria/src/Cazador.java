public class Cazador 
{
	private byte posX, posY;
	
	public Cazador(byte x, byte y)
	{
		posX = x;
		posY = y;
	}
	
	public void setPosX(byte x){ posX = x; }
	public void setPosY(byte y){ posY = y; }
	
	public byte getPosX(){ return posX; }
	public byte getPosY(){ return posY; }
}
