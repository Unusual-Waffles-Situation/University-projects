public class Excepcion extends Exception 
{
	public Excepcion(short cant)
	{
		super("No se puede agregar más figuras, ya que se ha superado el máximo (" + cant + ").");
	}
}
