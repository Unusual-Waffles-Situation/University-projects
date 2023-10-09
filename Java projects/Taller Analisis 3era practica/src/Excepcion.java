public class Excepcion extends Exception 
{
	public Excepcion()
	{
		super("Uno de los valores no corresponde al rango correspondiente (>= 1 && <= 400)");
	}
}
