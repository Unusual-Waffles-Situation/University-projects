package proyecto_abc;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;

public class Menu_Principal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel mensaje;
	private JRadioButton ingresar_postulante, ingresar_empleo, filtrar_postulantes;
	private ButtonGroup opciones;
	private JButton aceptar;
	private Container c;
	private Dimension pantalla,ventana;
	private SpringLayout layout;
	private int opc;
	private Formulario_Postulante_Info_Personal fp;
        Connection connection;
	
	public Menu_Principal(Connection connection) {
		super("Programa Administracion de Empleos");
                
                // Conectando a la base de datos.
                this.connection = connection;
                
		opciones_pantalla();
		
		opc = 1;
		mensaje = new JLabel("Seleccione la opcion que desea utilizar:");
		ingresar_postulante = new JRadioButton("Ingresar informacion de Postulante",true);
		ingresar_empleo = new JRadioButton("Ingresar informacion de oferta de empleo",false);
		filtrar_postulantes = new JRadioButton("Filtrar postulantes segun oferta de empleo",false);
		opciones = new ButtonGroup();
		opciones.add(ingresar_postulante);
		opciones.add(ingresar_empleo);
		opciones.add(filtrar_postulantes);
		aceptar = new JButton("Aceptar");
		
		ingresar_postulante.addActionListener(this);
		ingresar_empleo.addActionListener(this);
		filtrar_postulantes.addActionListener(this);
		aceptar.addActionListener(this);
		
		c.add(mensaje);
		c.add(ingresar_postulante);
		c.add(ingresar_empleo);
		c.add(filtrar_postulantes);
		c.add(aceptar);
		
		organizar_elementos();
	}
	
	private void opciones_pantalla() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450,300);
		this.setResizable(false);
		pantalla=Toolkit.getDefaultToolkit().getScreenSize();
		ventana=this.getSize();
		this.setLocation(((pantalla.width-ventana.width)/2),((pantalla.height-ventana.height)/2));
		c = getContentPane();
		layout = new SpringLayout();
		c.setLayout(layout);
	}
	
	private void organizar_elementos() {
		//Etiqueta "Seleccione la opcion que desea utilizar:"
		layout.putConstraint(SpringLayout.WEST, mensaje, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, mensaje, 5, SpringLayout.NORTH, c);
		//RadioButton ingresar_postulante
		layout.putConstraint(SpringLayout.WEST, ingresar_postulante, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, ingresar_postulante, 10, SpringLayout.SOUTH, mensaje);
		//RadioButton ingresar_empleo
		layout.putConstraint(SpringLayout.WEST, ingresar_empleo, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, ingresar_empleo, 10, SpringLayout.SOUTH, ingresar_postulante);
		//RadioButton filtrar_postulantes
		layout.putConstraint(SpringLayout.WEST, filtrar_postulantes, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, filtrar_postulantes, 10, SpringLayout.SOUTH, ingresar_empleo);
		//Boton Aceptar
		layout.putConstraint(SpringLayout.WEST, aceptar, 200, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, aceptar, 12, SpringLayout.SOUTH, filtrar_postulantes);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource().equals(ingresar_postulante)) opc = 1;
		if(ae.getSource().equals(ingresar_empleo)) opc = 2;
		if(ae.getSource().equals(filtrar_postulantes)) opc = 3;
		
		if(ae.getSource().equals(aceptar)) {
			if(opc==1) {
				fp = new Formulario_Postulante_Info_Personal(connection);
				fp.setVisible(true);
				dispose();
			}
                        else if(opc == 2){
                                Formulario_Empleo_Informacion oe = new Formulario_Empleo_Informacion(connection);
                                oe.setVisible(true);
                                dispose();
                        }
		}
	}
}