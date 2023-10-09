import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.sun.javafx.geom.Rectangle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame 
{
	private Tablero tablero = new Tablero();
	
	private JFrame frame = new JFrame("Ventana");
	
	private JLabel label = new JLabel("Turno: ");
	
	private JLayeredPane lp;
	
	private byte turno = 1;
	
	private JButton buttonHunter[] = new JButton[4];
	
	private Cazador hunters[] = tablero.getCazadores();
	
	private Zorro fox = tablero.getZorro();
	
	private boolean matrizTablero[][] = tablero.getMatriz();
	
	private JButton zorro = new JButton();
	
	public void test()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(null);
		//frame.setLocationRelativeTo(null);
		frame.setSize(900, 670);
		
		short x, y;
		x = y = 10;
		
		lp = frame.getLayeredPane();
		
		short posX = 85;
		
		for (byte k = 0; k < 4; k++)
		{
			JButton buttons = new JButton();
			
			buttons.setBounds(posX, 10, 37, 37);
			
			buttons.setEnabled(false);
			
			buttons.setBackground(new Color(255, 0, 0));
			
			buttonHunter[k] = buttons;
			
			lp.add(buttonHunter[k], new Integer(2));
			
			posX += (75 * 2);
		}
		
		zorro.setBounds(310, 535, 37, 37);
		zorro.setBackground(new Color(0, 0, 255));
		zorro.setEnabled(false);
		lp.add(zorro, new Integer(2));
		
		boolean comp = false;
		
		JButton buttonArray[][] = new JButton[8][8];
		
		for (byte k = 0; k < 8; k++)
		{	
			for (byte d = 0; d < 8; d++)
			{			
				JButton button = new JButton();
				button.setBounds(x, y, 75, 75);
				
				if (!comp)
				{
					button.setBackground(new Color(0, 0, 0));
					
					comp = true;
				}
					
				else
				{
					button.setBackground(new Color(255, 255, 255));
					
					comp = false;
				}
				
				buttonArray[k][d] = button;
				
				button.addActionListener(new Boton(k, d));
				
				lp.add(button, new Integer(1));
				
				x += 75;
			}
			
			comp = !comp;
			
			x = 10;
			y += 75;
		}
		
		label.setBounds(725, 10, 100, 25);
		//label.setSize(300, 300);
		
		lp.setVisible(true);
		
		frame.add(label);
		
		frame.setVisible(true);
	}
	
	class Boton implements ActionListener
	{
		private byte x, y;
		
		public Boton(byte x, byte y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			if (turno != 4)
			{
				metodo(x, y);
				
				movZorro();
				
				turno++;
			}
			
			else
			{
				metodo(x, y);
				turno = 1;
			}
			
			//System.out.println(x + ", " + y);
		}
	}
	
	public void metodo(byte x, byte y)
	{
		byte aux = turno;
		aux--;
		
		Rectangle r = new Rectangle();
		r.x = buttonHunter[aux].getX();
		
		if (y < hunters[aux].getPosY())
			r.x -= 75;
		
		else
			r.x += 75;
		
		matrizTablero[hunters[aux].getPosX()][hunters[aux].getPosY()] = false; 
		
		hunters[aux].setPosY(y);
		hunters[aux].setPosX(x);
		
		matrizTablero[hunters[aux].getPosX()][hunters[aux].getPosY()] = true; 
		
		r.y = buttonHunter[aux].getY();
		r.y += 75;
		
		//System.out.println(x + ", " + y + " / " + hunters[aux].getPosX() + ", " + hunters[aux].getPosY());
		
		buttonHunter[aux].setBounds(r.x, r.y, buttonHunter[aux].getHeight(), buttonHunter[aux].getWidth());
	}
	
	public void movZorro()
	{
		byte posX, posY;
		short x, y;
		x = y = 0;
		
		matrizTablero[fox.getPosX()][fox.getPosY()] = false;
		
		posX = fox.getPosX();
		posY = fox.getPosY();
		
		x = (short) zorro.getX();
		
		if (fox.moverse(matrizTablero))
		{
			if (posY > fox.getPosY())
				x -= 75;
			
			else
				x += 75;
			
			y = (short) zorro.getY();
			y -= 75;
			
			zorro.setBounds(x, y, zorro.getWidth(), zorro.getHeight());
		}
		
		else
		{
			if (posY > fox.getPosY())
				x += 75;
			
			else
				x -= 75;
			
			y = (short) zorro.getY();
			y += 75;
			
			zorro.setBounds(x, y, zorro.getWidth(), zorro.getHeight());
			
			if (fox.getPosX() == 7 && fox.getComp())
				JOptionPane.showMessageDialog(frame, "Los cazadores ganaron", "Condicion", JOptionPane.ERROR_MESSAGE);
		}
		
		matrizTablero[fox.getPosX()][fox.getPosY()] = true;
	}
	
	public static void main(String []args)
	{
		Frame f = new Frame();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					f.test();
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
