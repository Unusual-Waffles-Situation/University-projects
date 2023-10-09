public class Tablero 
{
	private boolean matriz[][];
	private Cazador c[];
	private Zorro zorro;
	private byte turno;
	
	public Tablero()
	{
		zorro = new Zorro((byte) 4, (byte) 7);
		
		turno = 1;
		
		c = new Cazador[4];
		
		for (byte d = 0, k = 1; d < 4; d++, k += 2)
			c[d] = new Cazador((byte) 0, (byte) k);
		
		matriz = new boolean[8][8];
		
		for (byte j = 0, d = 1; j < 8; j++)
		{
			if (j == d)
			{
				matriz[0][d] = true;
				
				d += 2;
			}
			
			else
			{
				for (byte k = 0; k < 8; k++)
					matriz[j][k] = false;
			}
		}
		
		matriz[7][4] = true;
	}
	
	/*public void jugar()
	{
		switch(turno)
		{
			case 1:
			{
				turno++;
				
				zorro.moverse(matriz);
				
				break;
			}
			
			case 2:
			{
				turno++;
				
				zorro.moverse(matriz);
				
				break;
			}
			
			case 3:
			{
				turno++;
				
				zorro.moverse(matriz);
				
				break;
			}
			
			case 4:
			{
				turno = 1;
				
				zorro.moverse(matriz);
				
				break;
			}
			
			default:
				break;
		}
	}*/
	
	public String mostrar()
	{
		String cadena = "";
		
		for (byte d = 0; d < 8; d++)
		{
			for (byte k = 0; k < 8; k++)
			{
				if (matriz[d][k] == true)
					cadena += "| *";
				
				else
					cadena += "|  ";
			}
			
			cadena += "|\n";
		}
		
		return cadena;
	}
	
	public boolean[][] getMatriz(){ return matriz; }
	
	public Cazador[] getCazadores(){ return c; }
	
	public Zorro getZorro(){ return zorro; }
}
