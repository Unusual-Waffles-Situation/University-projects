import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.io.IOException;

public class PruebaFrame 
{
	private Espacio e = new Espacio();
	
	JFrame frame = new JFrame("Espacio");
	
	public void test() throws IOException
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setSize(600, 400);
		
		int x = 10;
		int y = 10;
		
		/*PruebaMain pb = new PruebaMain();
		
		String nombreArchivo = "pyramid.in.txt";*/

		//PruebaMain.leerArchivo(nombreArchivo);
		
		String a[] = new String[20];
		
		e = PruebaMain.main(a);
		
		short arreglo[][] = e.getDimension();
		
		boolean sw, sw2, sw3;
		sw = sw2 = sw3 = false;
		
		short contAuxX = 0;
		short contAuxY = 0;
		short contAuxX2 = 0;
		short contAuxY2 = 0;
		
		short cantY = e.getN();
		short cantX = e.getM();
		
		for (short k = 0; k < cantY; k++)
		{	
			sw = sw2 = sw3 = false;
			
			for (short d = 0; d < cantX; d++)
			{
				JButton boton = new JButton();
				
				boton.setBounds(x, y, 50, 50);
				boton.setEnabled(false);
				
				if (d == e.getPosM() || (sw))
				{
					if (k == e.getPosN() || (sw))
					{
						if (contAuxY != e.getPiramide().getB())
						{
							if (contAuxX != e.getPiramide().getA())
							{
								boton.setBackground(new Color(0, 219, 0));
								
								contAuxX++;
							}
							
							sw = true;
						}
						
					}
					
					else if (k > e.getPosN() && contAuxY != e.getPiramide().getB())
					{
						if (contAuxX != e.getPiramide().getA())
						{
							boton.setBackground(new Color(0, 219, 0));
							
							contAuxX++;
							
							sw = true;
						}
					}
					
				}
				
				if (d == e.getPiramide().getContadorA() || (sw2))
				{
					if (k == e.getPiramide().getContadorB())
						sw3 = true;
					
					if (contAuxY2 != e.getPiramide().getCR().getD() && sw3)
					{
						if (contAuxX2 != e.getPiramide().getCR().getC())
						{
							boton.setBackground(new Color(0, 0, 219));
							
							contAuxX2++;
						}
						
						sw2 = true;
					}
				}
				
				/*else
					boton.setBackground(new Color(255, 255, 255));*/
				
				boton.setText("" + arreglo[k][d]);
				
				frame.add(boton);
				
				x += 50;
			}
			
			contAuxX = contAuxX2 = 0;
			
			y += 50;
			x = 10;
			
			if (sw && contAuxY != e.getPiramide().getB())
				contAuxY++;
			
			else if (sw2 && contAuxY2 != e.getPiramide().getCR().getD())
				contAuxY2++;
		}
		
		/*bBoton.setBounds(10, 10, 50, 50);
		bBoton.setEnabled(false);
		bBoton.setBackground(new Color(255, 0, 0));
		bBoton.setText("10");*/
		
		//frame.add(bBoton);
		
		frame.setVisible(true);
	}
	
	public static void main(String []args)
	{
		PruebaFrame pf = new PruebaFrame();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					pf.test();
				} 
				
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
