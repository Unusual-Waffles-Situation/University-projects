public class Operaciones 
{
	private double Valor;
	
	public Operaciones()
	{
		Valor = 0;
	}
	
	public void Suma(double d)
	{
		Valor += d;
	}
	
	public void Resta(double k)
	{
		Valor -= k;
	}
	
	public void Mul(double d)
	{
		Valor *= d;
	}
	
	public void Div(double k)
	{
		Valor /= k;
	}
	
	public void Mod(double d)
	{
		Valor %= d;
	}
	
	public void Raiz(String k)
	{
		double d = Double.parseDouble(k);
		Valor = Math.sqrt(d);
	}
	
	public void Exp(double d, double k)
	{
		Valor = Math.pow(d, k);
	}
	
	public void Sin(double d)
	{
		double k = Math.toRadians(d);
		Valor = Math.sin(k);
	}
	
	public String toString()
	{
		return "" + Valor;
	}
	
	public void setValor(double x){Valor = x;}
	public double getValor(){return Valor;}
}