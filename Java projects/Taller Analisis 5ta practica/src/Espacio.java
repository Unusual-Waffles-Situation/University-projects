public class Espacio 
{
	private Piramide p;
	private short dimension[][], m, n, contadorM, contadorN, valorMax, posM, posN;
	
	public Espacio()
	{
		m = n = contadorM = contadorN = valorMax = posM = posN = 0;
	}
	
	public Espacio(short m, short n, Piramide p)
	{
		this.m = m;
		this.n = n;
		this.p = p;
		contadorM = contadorN = valorMax = posM = posN = 0;
		
		dimension = new short[n][m];
	}
	
	public void agregarValoresDimension(short valor)
	{
		if (contadorN == m)
		{
			contadorN = 0;
			contadorM++;
		}
		
		dimension[contadorM][contadorN++] = valor;
	}
	
	public void verificarLugar(short contM, short contN)
	{
		short valorMaximo = 0;
		
		if (contN != n)
		{
			if (contM != m)
			{
				short valorA, valorB;
				valorA = p.getA();
				valorB = p.getB();
				
				boolean compA, compB;
				compA = compB = false;
				
				for (short k = contN, c = 0; ; k++, c++)
				{
					compB = false;
					
					if (c == valorB)
					{
						compB = true;
						break;
					}
					
					else if (k == n)
						break;
					
					compA = false;
					
					for (short d = contM, i = 0; ; d++, i++)
					{
						if (i == valorA)
						{
							compA = true;
							break;
						}
						
						else if (d == m)
							break;
						
						else
							valorMaximo += dimension[k][d];
					}
				}
				
				if (compA && compB)
				{
					if (contM == 0 && contN == 0)
					{
						valorMax = valorMaximo;
						posM = contM;
						posN = contN;
					}
					
					else
					{
						if (valorMax < valorMaximo)
						{
							valorMax = valorMaximo;
							posM = contM;
							posN = contN;
						}
					}
				}
				
				contN++;
				
				verificarLugar(contM, contN);
			}
		}
		
		else
		{
			contN = 0;
			contM++;
			
			verificarLugar(contM, contN);
		}
	}
	
	public void agregarDimensionPiramide()
	{
		short valA = p.getA();
		short valB = p.getB();
		
		for (short k = posN, c = 0; c < valB; c++, k++)
			for (short d = posM, i = 0; i < valA; i++, d++)
				p.agergarDimensiones(dimension[k][d]);
	}
	
	public void calculoCamara(short posX, short posY)
	{
		short valor = 0;
		
		if (!p.getComprobar())
		{
			p.setPosX(posX);
			p.setPosY(posY);
		}
		
		if (posX != posM + (p.getA() - 1))
		{
			if (posY != posN + (p.getB() - 1))
			{
				boolean compA, compB;
				compA = compB = false;
				
				for (short k = posY, c = 0; ; k++, c++)
				{
					if (c == p.getCR().getD())
					{
						compB = true;
						break;
					}
					
					else if (k == n - 1)
						break;
					
					for (short d = posX, i = 0; ; d++, i++)
					{
						if (i == p.getCR().getC())
						{
							compA = true;
							break;
						}
						
						else if (d == m - 1)
							break;
						
						valor += dimension[k][d];
					}
				}
				
				if (compA && compB)
				{
					if (p.getCR().getValor() == 0)
					{
						p.getCR().setValor(valor);
						p.setContadorA(posX);
						p.setContadorB(posY);
					}
					
					else if (p.getCR().getValor() > valor)
					{
						p.getCR().setValor(valor);
						p.setContadorA(posX);
						p.setContadorB(posY);
					}
				}
				
				posX++;
				p.setComprobar(true);
				calculoCamara(posX, posY);
			}
		}
		
		else
		{
			posX = p.getPosX();
			posY++;
			
			calculoCamara(posX, posY);
		}
	}
	
	public short getValorMax(){ return valorMax; }
	public short getPosM(){ return posM; }
	public short getPosN(){ return posN; }
	public Piramide getPiramide(){ return p; }
	public short getM(){ return m; }
	public short getN(){ return n; } 
	public short[][] getDimension(){ return dimension; } 
}
