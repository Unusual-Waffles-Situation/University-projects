import java.util.*;

public class Cluster 
{
	private Nodo nodoInicio, nodoFinal;
	private List <Nodo> listaPuntos;
	private Punto centroide;
	private int cantidadLista;
	
	public Cluster()
	{
		nodoInicio = nodoFinal = null;
		listaPuntos = new ArrayList<>();
		centroide = new Punto();
		cantidadLista = 0;
	}
	
	public void agregarPunto(Nodo x)
	{
		listaPuntos.add(x);
		cantidadLista++;
	}
	
	public void calculoCentroide()
	{
		int posX, posY;
		posX = posY = 0;
		int cantidad = 0;
		
		for (int i = 0; i < cantidadLista; i++)
		{
			posX += listaPuntos.get(i).getPosX();
			posY += listaPuntos.get(i).getPosY();
			cantidad++;
		}
		
		if (posX != 0 && posX != 0)
		{
			posX /= cantidad;
			posY /= cantidad;
			centroide = new Punto(posX, posY);
		}
	}
	
	public String mostrarPuntos()
	{
		String cadena = "";
		
		for (int i = 0; i < cantidadLista ; i++)
			cadena += listaPuntos.get(i).getPosX() + " " + listaPuntos.get(i).getPosY() + "\n";
		
		cadena += "Centroide: " + centroide.getPosX() + " " + centroide.getPosY() + "\n";
		
		return cadena;
	}
	
	public void setNodoInicio(Nodo k){ nodoInicio = k; }
	public void setNodoFinal(Nodo d){ nodoFinal = d; }
	public void setCentroide(Punto k){ centroide = k; }
	
	public Nodo getNodoInicio(){ return nodoInicio; }
	public Nodo getNodoFinal(){ return nodoFinal; }
	public int getCentroidePuntoX(){ return centroide.getPosX(); }
	public int getCentroidePuntoY(){ return centroide.getPosY(); }
	public int getCantidadLista(){ return listaPuntos.size(); }
	public List getLista(){ return listaPuntos; }
}
