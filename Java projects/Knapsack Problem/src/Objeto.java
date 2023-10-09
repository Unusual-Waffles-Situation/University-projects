public class Objeto 
{
	private byte peso, valor;
	private String nombre;
	
	public Objeto()
	{
		peso = valor = 0;
		
		nombre = "";
	}
	
	public void setPeso(byte p){ peso = p; }
	public void setValor(byte v){ valor = v; }
	public void setNombre(String n){ nombre = n; }
	
	public byte getPeso(){ return peso; }
	public byte getValor(){ return valor; }
	public String getNombre(){ return nombre; }
}
