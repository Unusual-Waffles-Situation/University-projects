public class Excepcion extends Exception 
{
	public Excepcion(short cant)
	{
		super("No se puede agregar m�s figuras, ya que se ha superado el m�ximo (" + cant + ").");
	}
}
