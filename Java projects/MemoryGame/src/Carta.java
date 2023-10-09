import javax.swing.*;

public class Carta 
{
	private Icon Nombre;
	
	public Carta()
	{
		Nombre = null;
	}
	
	public Carta(Icon x)
	{
		Nombre = x;
	}
	
	public void SetNombre(Icon k){Nombre = k;}
	public Icon getNombre(){return Nombre;}
}