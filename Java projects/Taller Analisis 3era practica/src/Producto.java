public class Producto 
{
	private byte identificador;
	
	public Producto()
	{
		identificador = 0;
	}
	
	public Producto(byte i)
	{
		identificador = i;
	}
	
	public byte getIdentificador(){ return identificador; }
}
