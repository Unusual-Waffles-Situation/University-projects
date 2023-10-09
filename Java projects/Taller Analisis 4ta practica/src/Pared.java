import java.util.*;

public class Pared 
{
	private List<Figura> listaFiguras;
	private short cantidadFiguras;
	private short contador;
	
	public Pared()
	{
		listaFiguras = new ArrayList<>();
		cantidadFiguras = 0;
		contador = 0;
	}
	
	public void agregarFigura(Figura f) throws Excepcion
	{
		if (contador < cantidadFiguras)
			listaFiguras.add(f);
		
		else
			throw new Excepcion(cantidadFiguras);
	}
	
	public void setCantidadFiguras(short x){ cantidadFiguras = x; }
	
	public short getCantidadFiguras(){ return cantidadFiguras; }
	public List<Figura> getListaFiguras(){ return listaFiguras; }
}
