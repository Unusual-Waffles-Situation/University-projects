public class Nodo 
{
	private Punto punto;
	private float media;
	
	public Nodo()
	{
		punto = new Punto();
		media = 0;
	}
	
	public Nodo(int pX, int pY, float m)
	{
		punto = new Punto(pX, pY);
		media = m;
	}
	
	public float getMedia(){ return media; }
	public int getPosX(){ return punto.getPosX(); }
	public int getPosY(){ return punto.getPosY(); }
}
