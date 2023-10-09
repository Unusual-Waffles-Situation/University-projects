import java.util.Random;

public class Zorro 
{
	private byte posX, posY;
	private ArbolBinario ab;
	private byte num;
	private boolean comp;
	
	public Zorro(byte y, byte x)
	{
		posX = x;
		posY = y;
		
		ab = new ArbolBinario();
		
		num = 1;
		
		comp = false;
	}
	
	public boolean moverse(boolean matriz[][])
	{
		byte y = posY;
		
		comp = true;
		
		if (!matriz[y - 2][posX])
		{
			
			if (num == 1)
			{
				Nodo nodo = new Nodo();
				
				byte x = posY--;
				nodo.setPosX(x);
				
				byte y2 = posX--;
				nodo.setPosX(y2);
				
				nodo.setVisitado(true);
				
				ab.agregarCaminoIzquierda(nodo);
				
				num = 0;
				
				return true;
			}
			
			else
			{
				Nodo nodo = new Nodo();
				
				byte x = posY++;
				nodo.setPosX(x);
				
				byte y2 = posX--;
				nodo.setPosX(y2);
				
				nodo.setVisitado(true);
				
				ab.agregarCaminoDerecha(nodo);
				
				num = 1;
				
				return true;
			}
		}
		
		else
		{
			ab.regresar();
			
			return false;
		}
	}
	
	public byte getPosX(){ return posX; }
	public byte getPosY(){ return posY; }
	public boolean getComp(){ return comp; }
}
