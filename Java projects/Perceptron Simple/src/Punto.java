public class Punto 
{
	private float posX, posY;
	private byte pos;
	
	public Punto()
	{
		posX = posY = pos = 0;
	}
	
	public Punto(short x, short y, byte p)
	{
		posX = x;
		posY = y;
		pos = p;
	}
	
	public void setPosX(float x){ posX = x; }
	public void setPosY(float y){ posY = y; }
	public void setPos(byte p){ pos = p; }
	
	public float getPosX(){ return posX; }
	public float getPosY(){ return posY; }
	public byte getPos(){ return pos; }
}
