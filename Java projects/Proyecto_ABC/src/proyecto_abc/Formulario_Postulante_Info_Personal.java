package proyecto_abc;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.*;

public class Formulario_Postulante_Info_Personal extends JFrame implements ActionListener, KeyListener {
	private JLabel nombre1_label, nombre2_label, apellido1_label, apellido2_label, edad_label, sexo_label, telefono_label, correo_label, residencia_label, nacionalidad_label;
	private JTextField nombre1_text, nombre2_text, apellido1_text, apellido2_text, telefono_text, correo_text, residencia_text, nacionalidad_text;
	private JComboBox edades;
	private JRadioButton masculino, femenino;
	private ButtonGroup sexos;
	private JButton siguiente, cancelar;
	private Container c;
	private Dimension pantalla,ventana;
	private SpringLayout layout;
	private Menu_Principal mp;
	Formulario_Postulante_Conocimientos fpc;
	private Postulante nuevo_postulante;
	private int opc;
        Connection connection;
	
	public Formulario_Postulante_Info_Personal(Connection connection) {
		super("Información Personal");
                
                // Conectando a la base de datos.
                this.connection = connection;
                
		opciones_pantalla();
		creacion_labels();
		creacion_textFields();
		creacion_radioButtons();
		carga_edades();
		
		siguiente = new JButton("Siguiente");
		cancelar = new JButton("Cancelar");
		
		masculino.addActionListener(this);
		femenino.addActionListener(this);
		siguiente.addActionListener(this);
		cancelar.addActionListener(this);
		
		c.add(nombre1_label); 
		c.add(nombre1_text);
		c.add(nombre2_label);
		c.add(nombre2_text);
		c.add(apellido1_label);
		c.add(apellido1_text);
		c.add(apellido2_label);
		c.add(apellido2_text);
		c.add(edad_label);
		c.add(edades);
		c.add(sexo_label);
		c.add(masculino);
		c.add(femenino);
		c.add(nacionalidad_label);
		c.add(nacionalidad_text);
		c.add(residencia_label);
		c.add(residencia_text);
		c.add(telefono_label);
		c.add(telefono_text);
		c.add(correo_label);
		c.add(correo_text);
		c.add(cancelar);
		c.add(siguiente);
		
		organizar_elementos();
		
		nuevo_postulante = new Postulante();
		opc = 1;
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
	
	private void creacion_labels() {
		nombre1_label = new JLabel("Primer Nombre:");
		nombre2_label = new JLabel("Segundo Nombre:");
		apellido1_label = new JLabel("Primer Apellido:");
		apellido2_label = new JLabel("Segundo Apellido:");
		edad_label = new JLabel("Edad:");
		sexo_label = new JLabel("Sexo:");
		nacionalidad_label = new JLabel("Pais de Origen:");
		residencia_label = new JLabel("Residencia Actual:");
		telefono_label = new JLabel("Telefono:");
		correo_label = new JLabel("Correo:");
	}
	
	private void creacion_textFields() {
		nombre1_text = new JTextField("",10);
		nombre1_text.addKeyListener(this);
		nombre2_text = new JTextField("",10);
		nombre2_text.addKeyListener(this);
		apellido1_text = new JTextField("",10);
		apellido1_text.addKeyListener(this);
		apellido2_text = new JTextField("",10);
		apellido2_text.addKeyListener(this);
		nacionalidad_text = new JTextField("",10);
		nacionalidad_text.addKeyListener(this);
		residencia_text = new JTextField("",10);
		residencia_text.addKeyListener(this);
		telefono_text = new JTextField("",10);
		telefono_text.addKeyListener(this);
		correo_text = new JTextField("",10);
		correo_text.addKeyListener(this);
	}
	
	private void creacion_radioButtons() {
		masculino = new JRadioButton("Masculino",true);
		femenino = new JRadioButton("Femenino",false);
		sexos = new ButtonGroup();
		sexos.add(masculino);
		sexos.add(femenino);
	}
	
	private void organizar_elementos() {
		//Etiqueta "Primer Nombre:"
		layout.putConstraint(SpringLayout.WEST, nombre1_label, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, nombre1_label, 5, SpringLayout.NORTH, c);
		//Campo del primer nombre
		layout.putConstraint(SpringLayout.WEST, nombre1_text, 5, SpringLayout.EAST, nombre1_label);
		layout.putConstraint(SpringLayout.NORTH, nombre1_text, 5, SpringLayout.NORTH, c);
		//Etiqueta "Segundo Nombre:"
		layout.putConstraint(SpringLayout.WEST, nombre2_label, 5, SpringLayout.EAST, nombre1_text);
		layout.putConstraint(SpringLayout.NORTH, nombre2_label, 5, SpringLayout.NORTH, c);
		//Campo del segundo nombre
		layout.putConstraint(SpringLayout.WEST, nombre2_text, 5, SpringLayout.EAST, nombre2_label);
		layout.putConstraint(SpringLayout.NORTH, nombre2_text, 5, SpringLayout.NORTH, c);
		//Etiqueta "Primer Apellido:"
		layout.putConstraint(SpringLayout.WEST, apellido1_label, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, apellido1_label, 9, SpringLayout.SOUTH, nombre1_label);
		//Campo del primer apellido
		layout.putConstraint(SpringLayout.WEST, apellido1_text, 5, SpringLayout.EAST, apellido1_label);
		layout.putConstraint(SpringLayout.NORTH, apellido1_text, 5, SpringLayout.SOUTH, nombre1_text);
		//Etiqueta "Segundo Apellido:"
		layout.putConstraint(SpringLayout.WEST, apellido2_label, 5, SpringLayout.EAST, apellido1_text);
		layout.putConstraint(SpringLayout.NORTH, apellido2_label, 9, SpringLayout.SOUTH, nombre2_label);
		//Campo del primer apellido
		layout.putConstraint(SpringLayout.WEST, apellido2_text, 5, SpringLayout.EAST, apellido2_label);
		layout.putConstraint(SpringLayout.NORTH, apellido2_text, 5, SpringLayout.SOUTH, nombre2_text);
		//Eiqueta "Edad:"
		layout.putConstraint(SpringLayout.WEST, edad_label, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, edad_label, 12, SpringLayout.SOUTH, apellido1_label);
		//ComboBox de edades
		layout.putConstraint(SpringLayout.WEST, edades, 5, SpringLayout.EAST, edad_label);
		layout.putConstraint(SpringLayout.NORTH, edades, 5, SpringLayout.SOUTH, apellido1_text);
		//Etiqueta "Sexo:"
		layout.putConstraint(SpringLayout.WEST, sexo_label, 5, SpringLayout.EAST, edades);
		layout.putConstraint(SpringLayout.NORTH, sexo_label, 12, SpringLayout.SOUTH, apellido1_label);
		//RadioButton "Masculino"
		layout.putConstraint(SpringLayout.WEST, masculino, 5, SpringLayout.EAST, sexo_label);
		layout.putConstraint(SpringLayout.NORTH, masculino, 10, SpringLayout.SOUTH, apellido1_label);
		//RadioButton "Femenino"
		layout.putConstraint(SpringLayout.WEST, femenino, 5, SpringLayout.EAST, masculino);
		layout.putConstraint(SpringLayout.NORTH, femenino, 10, SpringLayout.SOUTH, apellido1_label);
		//Etiqueta "Pais de Origen:"
		layout.putConstraint(SpringLayout.WEST, nacionalidad_label, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, nacionalidad_label, 12, SpringLayout.SOUTH, edad_label);
		//Campo de la nacionalidad
		layout.putConstraint(SpringLayout.WEST, nacionalidad_text, 5, SpringLayout.EAST, nacionalidad_label);
		layout.putConstraint(SpringLayout.NORTH, nacionalidad_text, 12, SpringLayout.SOUTH, edad_label);
		//Etiqueta "Residencia Actual:"
		layout.putConstraint(SpringLayout.WEST, residencia_label, 5, SpringLayout.EAST, nacionalidad_text);
		layout.putConstraint(SpringLayout.NORTH, residencia_label, 12, SpringLayout.SOUTH, edad_label);
		//Campo de la residencia
		layout.putConstraint(SpringLayout.WEST, residencia_text, 5, SpringLayout.EAST, residencia_label);
		layout.putConstraint(SpringLayout.NORTH, residencia_text, 12, SpringLayout.SOUTH, edad_label);
		//Etiqueta "Telefono:"
		layout.putConstraint(SpringLayout.WEST, telefono_label, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, telefono_label, 12, SpringLayout.SOUTH, nacionalidad_label);
		//Campo del telefono
		layout.putConstraint(SpringLayout.WEST, telefono_text, 5, SpringLayout.EAST, telefono_label);
		layout.putConstraint(SpringLayout.NORTH, telefono_text, 12, SpringLayout.SOUTH, nacionalidad_label);
		//Etiqueta "Correo:"
		layout.putConstraint(SpringLayout.WEST, correo_label, 5, SpringLayout.EAST, telefono_text);
		layout.putConstraint(SpringLayout.NORTH, correo_label, 12, SpringLayout.SOUTH, nacionalidad_label);
		//Campo del correo
		layout.putConstraint(SpringLayout.WEST, correo_text, 5, SpringLayout.EAST, correo_label);
		layout.putConstraint(SpringLayout.NORTH, correo_text, 12, SpringLayout.SOUTH, nacionalidad_label);
		//Boton Cancelar
		layout.putConstraint(SpringLayout.WEST, cancelar, 135, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, cancelar, 12, SpringLayout.SOUTH, telefono_label);
		//Boton Siguiente
		layout.putConstraint(SpringLayout.WEST, siguiente, 5, SpringLayout.EAST, cancelar);
		layout.putConstraint(SpringLayout.NORTH, siguiente, 12, SpringLayout.SOUTH, telefono_label);
	}
	
	private void carga_edades() {
		edades = new JComboBox();
		
		for(int counter = 18; counter <= 60; counter++)
			edades.addItem(counter);
	}
	
	private boolean campos_vacios() {
		if(nombre1_text.getText().equals("")||nombre2_text.getText().equals("")||apellido1_text.getText().equals("")||apellido2_text.getText().equals("")||nacionalidad_text.getText().equals("")||residencia_text.getText().equals("")||telefono_text.getText().equals("")||correo_text.getText().equals(""))
			return true;
		return false;
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource().equals(masculino)) opc = 1;
		if(ae.getSource().equals(femenino)) opc = 2;
		
		if(ae.getSource().equals(cancelar)) {
			mp = new Menu_Principal(connection);
			mp.setVisible(true);
			dispose();
		}
		
		if(ae.getSource().equals(siguiente)) {
			if(campos_vacios()) {
				
			}
			else {
				nuevo_postulante.setNombres(nombre1_text.getText(), nombre2_text.getText());
				nuevo_postulante.setApellidos(apellido1_text.getText(), apellido2_text.getText());
				nuevo_postulante.setEdad(Integer.parseInt(edades.getSelectedItem().toString()));
				if(opc==1) nuevo_postulante.setSexo("Masculino");
				else nuevo_postulante.setSexo("Femenino");
				nuevo_postulante.setPais_origen(nacionalidad_text.getText());
				nuevo_postulante.setResidencia(residencia_text.getText());
				nuevo_postulante.setTelefono(telefono_text.getText());
				nuevo_postulante.setCorreo(correo_text.getText());
                                
                                // Agregando nuevo postulante a la base de datos.
                                agregarPostulanteDatabase();
                                
                                
				fpc = new Formulario_Postulante_Conocimientos(nuevo_postulante, connection);
				fpc.setVisible(true);
				dispose();
			}
		}
	}
	
	public void keyTyped(KeyEvent ke){
            char c=ke.getKeyChar();
            String s="";
	 	
                if(ke.getSource().equals(nombre1_text)) {
                    if(Character.isDigit(c)||Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=nombre1_text.getText();
                        nombre1_text.setText(null);
                        nombre1_text.setText(s);
                    }
                }

                if(ke.getSource().equals(nombre2_text)) {
                    if(Character.isDigit(c)||Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=nombre2_text.getText();
                        nombre2_text.setText(null);
                        nombre2_text.setText(s);
                    }
                }

                if(ke.getSource().equals(apellido1_text)) {
                    if(Character.isDigit(c)||Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=apellido1_text.getText();
                        apellido1_text.setText(null);
                        apellido1_text.setText(s);
                    }
                }

                if(ke.getSource().equals(apellido2_text)) {
                    if(Character.isDigit(c)||Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=apellido2_text.getText();
                        apellido2_text.setText(null);
                        apellido2_text.setText(s);
                    }
                }	

                if(ke.getSource().equals(nacionalidad_text)) {
                    if(Character.isDigit(c)||Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=nacionalidad_text.getText();
                        nacionalidad_text.setText(null);
                        nacionalidad_text.setText(s);
                    }
                }

                if(ke.getSource().equals(residencia_text)) {
                    if(Character.isDigit(c)||Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=residencia_text.getText();
                        residencia_text.setText(null);
                        residencia_text.setText(s);
                    }
                }

                if(ke.getSource().equals(telefono_text)) {
                    if(Character.isLetter(c)||Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=telefono_text.getText();
                        telefono_text.setText(null);
                        telefono_text.setText(s);
                    }
                }

                if(ke.getSource().equals(correo_text)) {
                    if(Character.isWhitespace(c)) {
                        getToolkit().beep(); 
                        ke.consume();
                        s=correo_text.getText();
                        correo_text.setText(null);
                        correo_text.setText(s);
                    }
                }
	}
	
	public void keyPressed(KeyEvent ke){
		
	}
	public void keyReleased(KeyEvent ke){
		
	}
        
        // Metodo para agregar un postulante a la base de datos.
        public void agregarPostulanteDatabase(){
        
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `postulantes` (`idpostulante`, `nombre`, `apellido`, `edad`, `sexo`, `pais_origen`, `residencia`, `telefono`, `correo`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)");
                
                ps.setString(1, nuevo_postulante.getNombres());
                ps.setString(2, nuevo_postulante.getApellidos());
                ps.setInt(3, nuevo_postulante.getEdad());
                ps.setString(4, nuevo_postulante.getSexo());
                ps.setString(5, nuevo_postulante.getPais_origen());
                ps.setString(6, nuevo_postulante.getResidencia());
                ps.setString(7, nuevo_postulante.getTelefono());
                ps.setString(8, nuevo_postulante.getCorreo());
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog (null, "Registro de Informacion Personal Postulante", "Informacion Personal Cargada Correctamente", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog (null, "Registro de Informacion Personal Postulante", "Ha Ocurrido un Error", JOptionPane.ERROR_MESSAGE);
            }
        }
}