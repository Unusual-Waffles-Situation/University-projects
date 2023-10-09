import javax.swing.JFrame;

public class Perceptron 
{
	private float x0, x1, x2;
	private float w0, w1, w2, tasaAprendizaje;
	
	public Perceptron(float pes1, float pes2, float pes3)
	{
		x0 = 1;
		x1 = x2 = 0;
		
		w0 = pes1;
		w1 = pes2;
		w2 = pes3;
		
		tasaAprendizaje = 0.5f;
	}
	
	public void entrenamiento(Punto p[], Punto p2[], Punto p3[], JFrame f)
	{
		boolean comp = false;
		
		metodoEntrenamiento(p, p3, p2, comp, f);
		
		comp = true;
		
		metodoEntrenamiento(p2, p3, p, comp, f);
	}
	
	public void metodoEntrenamiento(Punto p[], Punto p2[], Punto p3[], boolean com, JFrame f)
	{
		boolean comp;
		char i = 0;
		
		Grafica g;
		
		do
		{
			comp = false;
			
			for (; p[i].getPos() != 0;)
			{
				x1 = p[i].getPosX();
				x2 = p[i].getPosY();
				
				float res = (w1 *x1) - (w2 * x2) + w0;
				
				if (res > 0)
					res = 1;
				
				else
					res = -1;
				
				float nuevoPeso = res + p[i].getPos();
				
				if (nuevoPeso != 0)
				{
					if (!com)
					{
						w0 += + (tasaAprendizaje * x0);
						w1 += + (tasaAprendizaje * x1);
						w2 += + (tasaAprendizaje * x2);
					}
					
					else
					{
						w0 += - (tasaAprendizaje * x0);
						w1 += - (tasaAprendizaje * x1);
						w2 += - (tasaAprendizaje * x2);
					}
					
					/*w0 += + (tasaAprendizaje * x0);
					w1 += + (tasaAprendizaje * x1);
					w2 += + (tasaAprendizaje * x2);*/
					
					p2[0].setPosX((byte) 0);
					p2[0].setPosY(w0 / w2);
					
					p2[1].setPosX(10 * (w2 / w1));
					p2[1].setPosY(10);
					
					if (!com)
						g = new Grafica(p, p3, p2);
					
					else
						g = new Grafica(p3, p, p2);
					
					f.add(g.getCP());
					
					f.pack();
					
					f.setLocationRelativeTo(null);
					
					f.setVisible(true);
					
					/*g.setIndex();
					
					g.pack();
					
					RefineryUtilities.centerFrameOnScreen(g);
					g.setVisible(true);*/
					
					comp = true;
					
					break;
				}
				
				else
					i++;
			}
			
		} while (comp);
	}
	
	public float getW0(){ return w0; }
	public float getW1(){ return w1; }
	public float getW2(){ return w2; }
}
