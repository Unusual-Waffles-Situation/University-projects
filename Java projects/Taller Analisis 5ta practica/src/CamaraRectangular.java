public class CamaraRectangular 
{
	private short c, d, valor;
	
	public CamaraRectangular(short c, short d)
	{
		this.c = c;
		this.d = d;
		
		valor = 0;
	}
	
	public short getC(){ return c; }
	public short getD(){ return d; }
	public short getValor(){ return valor; }
	
	public void setValor(short x){ valor = x; }
}
