import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Programa 
{
	Operaciones o = new Operaciones();

	JFrame frame = new JFrame("Programa");

	JButton bNum1, bNum2, bNum3, bNum4, bNum5, bNum6, bNum7, bNum8, bNum9, bNum0, bSuma, bResta, bMul, bDiv, bMod, bExp, bRaiz, bIgual, bLimpiar, bSin;

	JTextArea Area;

	int Contador, Cont;
	
	Double Valor1, Valor2; 
	
	String Metodo = "";

	private void Test()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Area = new JTextArea(1, 30);
		JScrollPane scrollPane = new JScrollPane(Area);
		Area.setEditable(true);
		
		Area.setText("");
		
		Valor1 = Valor2 = 0.0;
		
		Contador = Cont = 0;

		bNum1 = new JButton("1");
		bNum2 = new JButton("2");
		bNum3 = new JButton("3");
		bNum4 = new JButton("4");
		bNum5 = new JButton("5");
		bNum6 = new JButton("6");
		bNum7 = new JButton("7");
		bNum8 = new JButton("8");
		bNum9 = new JButton("9");
		bNum0 = new JButton("0");
		bSuma = new JButton("+");
		bResta = new JButton("-");
		bMul = new JButton("*");
		bDiv = new JButton("/");
		bMod = new JButton("%");
		bExp = new JButton("Exp");
		bRaiz = new JButton("Raiz");
		bIgual = new JButton("=");
		bLimpiar = new JButton("C");
		bSin = new JButton("Sin");

		frame.getContentPane();
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		frame.setSize(355, 200);

		frame.add(Area);
		frame.add(bNum1);
		frame.add(bNum2);
		frame.add(bNum3);
		frame.add(bNum4);
		frame.add(bNum5);
		frame.add(bNum6);
		frame.add(bNum7);
		frame.add(bNum8);
		frame.add(bNum9);
		frame.add(bNum0);
		frame.add(bIgual);
		frame.add(bLimpiar);
		frame.add(bSuma);
		frame.add(bResta);
		frame.add(bMul);
		frame.add(bDiv);
		frame.add(bMod);
		frame.add(bRaiz);
		frame.add(bExp);
		frame.add(bSin);
		
		frame.setVisible(true);

		bNum1.addActionListener(new Boton1());
		bNum2.addActionListener(new Boton2());
		bNum3.addActionListener(new Boton3());
		bNum4.addActionListener(new Boton4());
		bNum5.addActionListener(new Boton5());
		bNum6.addActionListener(new Boton6());
		bNum7.addActionListener(new Boton7());
		bNum8.addActionListener(new Boton8());
		bNum9.addActionListener(new Boton9());
		bNum0.addActionListener(new Boton0());
		bLimpiar.addActionListener(new LimpiarBoton());
		bSuma.addActionListener(new Suma());
		bIgual.addActionListener(new IgualBoton());
		bMul.addActionListener(new Multiplicacion());
		bDiv.addActionListener(new Division());
		bResta.addActionListener(new Resta());
		bMod.addActionListener(new Modulo());
		bRaiz.addActionListener(new Raiz());
		bExp.addActionListener(new Exponente());
		bSin.addActionListener(new SinBoton());
	}

	class Boton1 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (Contador == 0)
				Area.insert("1", Contador++);
			else
				Area.insert("1", Contador++);
		}
	}

	class Boton2 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (Contador == 0)
				Area.insert("2", Contador++);
			else
				Area.insert("2", Contador++);
		}
	}

	class Boton3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("3", Contador++);
			else
				Area.insert("3", Contador++);
		}
	}

	class Boton4 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("4", Contador++);
			else
				Area.insert("4", Contador++);
			
		}
	}

	class Boton5 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("5", Contador++);
			else
				Area.insert("5", Contador++);
		}
	}

	class Boton6 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("6", Contador++);
			else
				Area.insert("6", Contador++);
		}
	}

	class Boton7 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("7", Contador++);
			else
				Area.insert("7", Contador++);
		}
	}

	class Boton8 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("8", Contador++);
			else
				Area.insert("8", Contador++);
		}
	}

	class Boton9 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("9", Contador++);
			else
				Area.insert("9", Contador++);
		}
	}

	class Boton0 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (Contador == 0)
				Area.insert("0", Contador++);
			else
				Area.insert("0", Contador++);
		}
	}

	class LimpiarBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Area.setText("");
			Contador = 0;
			o.setValor(0);
		}
	}

	class Suma implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			Metodo = "Suma";
			boolean sw, sw2;
			
			if (o.getValor() == 0)
			{
				do
				{
					sw = false;
					try
					{
						Valor1 = Double.parseDouble(Area.getText());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
						sw = true;
					}
				} while (sw);
				o.setValor(Valor1);
				Area.setText("");
				Contador = 0;
				Cont++;
			} 
			else
			{
				if(Cont == 1)
				{
					do
					{
						sw2 = false;
						try
						{
							Valor2 = Double.parseDouble(Area.getText());
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
							sw2 = true;
						}
					} while (sw2);
					o.Suma(Valor2);
					JOptionPane.showMessageDialog(frame, o.toString());
					Area.setText("");
					Contador = 0;
					Cont++;
				}
				else
				{
					Area.setText("");
					Contador = 0;
					Cont++;
				}
			}
		}
	}
	
	class IgualBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (o.getValor() == 0)
				JOptionPane.showMessageDialog(frame, "Ingrese valores primero", "Pop-up", JOptionPane.WARNING_MESSAGE);
			else
			{	
				double i = 0;
				try
				{
					i = Double.parseDouble(Area.getText());
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Ha ocurrido un error");
				}
				if (Metodo == "Suma")
					o.Suma(i);
				
				if (Metodo == "Resta")
					o.Resta(i);
				
				if (Metodo == "Multiplicacion")
					o.Mul(i);
				
				if (Metodo == "Division")
					o.Div(i);
				
				if (Metodo == "Modulo")
					o.Mod(i);
				
				if(Metodo == "Exponente")
					o.Exp(o.getValor(), i);
				
				Area.setText(o.toString());
				try
				{
					i = Double.parseDouble(Area.getText());
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Ha ocurrido un error");
				}
				o.setValor(i);
			}
		}
	}
	
	class Multiplicacion implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			Metodo = "Multiplicacion";
			
			boolean sw, sw2;
			
			if (o.getValor() == 0)
			{
				do
				{
					sw = false;
					try
					{
						Valor1 = Double.parseDouble(Area.getText());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
						sw = true;
					}
				} while (sw);
				o.setValor(Valor1);
				Area.setText("");
				Contador = 0;
				Cont++;
			} 
			else
			{
				if (Cont == 1)
				{
					do
					{
						sw2 = false;
						try
						{
							Valor2 = Double.parseDouble(Area.getText());
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
							sw2 = true;
						}
					} while (sw2);
					o.Mul(Valor2);
					Area.setText("");
					Contador = 0;
					Cont++;
				}
				else
				{
					Area.setText("");
					Contador = 0;
					Cont++;
				}
			}
		}
	}
	
	class Division implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			Metodo = "Division"; 
			boolean sw, sw2;
			
			if (o.getValor() == 0)
			{
				do
				{
					sw = false;
					try
					{
						Valor1 = Double.parseDouble(Area.getText());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
						sw = true;
					}
				} while (sw);
				o.setValor(Valor1);
				Area.setText("");
				Contador = 0;
				Cont++;
			} 
			else
			{
				if (Cont == 1)
				{
					do
					{
						sw2 = false;
						try
						{
							Valor2 = Double.parseDouble(Area.getText());
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
							sw2 = true;
						}
					} while (sw2);
					o.Div(Valor2);
					Area.setText("");
					Contador = 0;
					Cont++;
				}
				else
				{
					Area.setText("");
					Contador = 0;
					Cont++;
				}
			}
		}
	}
	
	class Resta implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			Metodo = "Resta";
			boolean sw, sw2;
			
			if (o.getValor() == 0)
			{
				do
				{
					sw = false;
					try
					{
						Valor1 = Double.parseDouble(Area.getText());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
						sw = true;
					}
				} while (sw);
				o.setValor(Valor1);
				Area.setText("");
				Contador = 0;
				Cont++;
			} 
			else
			{
				if (Cont == 1)
				{
					do
					{
						sw2 = false;
						try
						{
							Valor2 = Double.parseDouble(Area.getText());
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
							sw2 = true;
						}
					} while (sw2);
					o.Resta(Valor2);
					Area.setText("");
					Contador = 0;
					Cont++;
				}
				else
				{
					Area.setText("");
					Contador = 0;
					Cont++;
				}
			}
		}
	}
	
	class Modulo implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			Metodo = "Modulo";
			boolean sw, sw2;
			
			if (o.getValor() == 0)
			{
				do
				{
					sw = false;
					try
					{
						Valor1 = Double.parseDouble(Area.getText());
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
						sw = true;
					}
				} while (sw);
				o.setValor(Valor1);
				Area.setText("");
				Contador = 0;
				Cont++;
			} 
			else
			{
				if (Cont == 1)
				{
					do
					{
						sw2 = false;
						try
						{
							Valor2 = Double.parseDouble(Area.getText());
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
							sw2 = true;
						}
					} while (sw2);
					o.Mod(Valor2);
					Area.setText("");
					Contador = 0;
					Cont++;
				}
				else
				{
					Area.setText("");
					Contador = 0;
					Cont++;
				}
			}
		}
	}
	
	class Exponente implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			Metodo = "Exponente";
			boolean sw;
			do
			{
				sw = false;
				try
				{
					Valor1 = Double.parseDouble(Area.getText());
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
					sw = true;
				}
			} while (sw);
			o.setValor(Valor1);
			Area.setText("");
			Contador = 0;
		}
	}
	
	class SinBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			boolean sw;
			do
			{
				sw = false;
				try
				{
					Valor1 = Double.parseDouble(Area.getText());
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
					sw = true;
				}
			} while (sw);
			o.Sin(Valor1);
			Area.setText(o.toString());
		}
	}
	
	class Raiz implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			o.Raiz(Area.getText());
			Area.setText(o.toString());
		}
	}

	public static void main(String[] args)
	{
		Programa p = new Programa();
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				p.Test();
			}
		});
	}
}