public class Figura 
{
	private Punto verticeInferiorIzquierdo, verticeSuperiorDerecho;
	
	public Figura(Punto vi, Punto vs)
	{
		verticeInferiorIzquierdo = vi;
		verticeSuperiorDerecho = vs;
	}
	
	public Punto getVII(){ return verticeInferiorIzquierdo; }
	public Punto getVSD(){ return verticeSuperiorDerecho; }
}
