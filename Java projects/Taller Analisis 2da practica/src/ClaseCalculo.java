import java.util.*;

public class ClaseCalculo 
{
	private List<Punto> listaPuntos;
	private int cantidad;
	
	public ClaseCalculo()
	{
		listaPuntos = new ArrayList<>();
		cantidad = 0;
	}
	
	public void agregarPunto(Punto p)
	{
		listaPuntos.add(p);
		cantidad++;
	}
	
	public int getCantidad(){ return cantidad; }
	public List<Punto> getListaPuntos(){ return listaPuntos; }
}
