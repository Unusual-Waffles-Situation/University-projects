public class ClasePrueba 
{
	public static void main(String args[])
	{
		Operaciones o = new Operaciones();
		
		o.leerNombres();
		
		try
		{
			o.getCon().close();
		}
		
		catch(Exception e)
		{
			System.out.println("Ha ocurrido un error.");
		}
		
	}
}
