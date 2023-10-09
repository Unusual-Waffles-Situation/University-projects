package proyecto_abc;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Formulario_Postulante_Conocimientos extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JLabel titulo_label, especialidad_label, certificaciones_label, herramientas_label, conocimientos_label, experienciasLaborales_label;
	private JTextArea certificaciones_text, herramientas_text, conocimientos_text, experienciasLaborales_text;
	private JRadioButton bachiller, licenciado, ingeniero, tecnico_superior, magister, doctor, informatica, computacion, sistemas;
	private ButtonGroup titulos, especialidades;
	private JButton agregar_certificacion, agregar_herramienta, agregar_conocimiento, agregar_expLab, siguiente, cancelar;
	private Container c;
	private Postulante nuevo_postulante;
	private Menu_Principal mp;
	private int opc_titulo, opc_especialidad;
	private Dimension pantalla,ventana;
	private SpringLayout layout;
        Connection connection;
        private int id_postulante;
	
	public Formulario_Postulante_Conocimientos(Postulante np, Connection connection) {
		super("Conocimientos Tecnicos");
		nuevo_postulante = new Postulante();
		nuevo_postulante = np;
		opc_titulo = 1;
		opc_especialidad = 1;
                this.connection = connection;
                
                this.id_postulante = getIdPostulanteDatabase(np.getCorreo());
                
                System.out.println(this.id_postulante);
                
		prueba_postulante();
		opciones_pantalla();
		creacion_labels();
		creacion_textFields();
		creacion_radioButtons();
		creacion_botones();
		asignar_actionListeners();
		
		c.add(titulo_label);
		c.add(bachiller);
		c.add(licenciado);
		c.add(ingeniero);
		c.add(tecnico_superior);
		c.add(magister);
		c.add(doctor);
		c.add(especialidad_label);
		c.add(computacion);
		c.add(informatica);
		c.add(sistemas);
		c.add(certificaciones_label);
		c.add(certificaciones_text);
		c.add(agregar_certificacion);
		c.add(herramientas_label);
		c.add(herramientas_text);
		c.add(agregar_herramienta);
		c.add(conocimientos_label);
		c.add(conocimientos_text);
		c.add(agregar_conocimiento);
		c.add(experienciasLaborales_label);
		c.add(experienciasLaborales_text);
		c.add(agregar_expLab);
		c.add(cancelar);
		c.add(siguiente);
		
		organizar_elementos();
                
                
                System.out.println(np.getEdad() + " " + np.getNombres());
	}
        
          // Obtiene el id del postulante durante la aplicacion desde la base de datos.
          private int getIdPostulanteDatabase(String postulante_correo){
        
             int id_postulante = 0;
              
             try {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM postulantes WHERE correo = ?");
                
                ps.setString(1, postulante_correo);
                
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                    id_postulante = Integer.parseInt(rs.getString(1));
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Formulario_Postulante_Conocimientos.class.getName()).log(Level.SEVERE, null, ex);
            }
             
          return id_postulante;
            
        }
	
	private void opciones_pantalla() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(729,520);
		this.setResizable(false);
		pantalla=Toolkit.getDefaultToolkit().getScreenSize();
		ventana=this.getSize();
		this.setLocation(((pantalla.width-ventana.width)/2),((pantalla.height-ventana.height)/2));
		c = getContentPane();
		layout = new SpringLayout();
		c.setLayout(layout);
	}
	
	private void creacion_labels() {
		titulo_label = new JLabel("Titulo:");
		especialidad_label = new JLabel("Especialidad:");
		certificaciones_label = new JLabel("Certificaciones");
		herramientas_label = new JLabel("Herramientas Manejadas");
		conocimientos_label = new JLabel("Conocimientos Generales");
		experienciasLaborales_label = new JLabel("Experiencias Laborales");
	}
	
	private void creacion_textFields() {
		certificaciones_text = new JTextArea(10,15);
		certificaciones_text.setEditable(false);
		certificaciones_text.setBorder(BorderFactory.createLineBorder(Color.black));
		herramientas_text = new JTextArea(10,15);
		herramientas_text.setEditable(false);
		herramientas_text.setBorder(BorderFactory.createLineBorder(Color.black));
		conocimientos_text = new JTextArea(10,15);
		conocimientos_text.setEditable(false);
		conocimientos_text.setBorder(BorderFactory.createLineBorder(Color.black));
		experienciasLaborales_text = new JTextArea(10,15);
		experienciasLaborales_text.setEditable(false);
		experienciasLaborales_text.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	private void creacion_radioButtons() {
		bachiller = new JRadioButton("Bachiller",true);
		licenciado = new JRadioButton("Licenciado",false);
		ingeniero = new JRadioButton("Ingeniero",false);
		tecnico_superior = new JRadioButton("Tecnico Superior",false);
		magister = new JRadioButton("Magister",false);
		doctor = new JRadioButton("Doctor",false);
		computacion = new JRadioButton("Computacion",true);
		informatica = new JRadioButton("Informatica",false);
		sistemas = new JRadioButton("Sistemas",false);
		titulos = new ButtonGroup();
		titulos.add(bachiller);
		titulos.add(licenciado);
		titulos.add(ingeniero);
		titulos.add(tecnico_superior);
		titulos.add(magister);
		titulos.add(doctor);
		especialidades = new ButtonGroup();
		especialidades.add(computacion);
		especialidades.add(informatica);
		especialidades.add(sistemas);
	}
	
	private void creacion_botones() {
		agregar_certificacion = new JButton("Agregar");
		agregar_herramienta = new JButton("Agregar");
		agregar_conocimiento = new JButton("Agregar");
		agregar_expLab = new JButton("Agregar");
		siguiente = new JButton("Siguiente");
		cancelar = new JButton("Cancelar");
	}
	
	private void organizar_elementos() {
		//Etiqueta "Titulo:"
		layout.putConstraint(SpringLayout.WEST, titulo_label, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, titulo_label, 5, SpringLayout.NORTH, c);
		//RadioButton bachiller
		layout.putConstraint(SpringLayout.WEST, bachiller, 5, SpringLayout.EAST, titulo_label);
		layout.putConstraint(SpringLayout.NORTH, bachiller, 5, SpringLayout.NORTH, c);
		//RadioButton licenciado
		layout.putConstraint(SpringLayout.WEST, licenciado, 5, SpringLayout.EAST, titulo_label);
		layout.putConstraint(SpringLayout.NORTH, licenciado, 5, SpringLayout.SOUTH, bachiller);
		//RadioButton ingeniero
		layout.putConstraint(SpringLayout.WEST, ingeniero, 5, SpringLayout.EAST, titulo_label);
		layout.putConstraint(SpringLayout.NORTH, ingeniero, 5, SpringLayout.SOUTH, licenciado);
		//RadioButton tecnico_superior
		layout.putConstraint(SpringLayout.WEST, tecnico_superior, 5, SpringLayout.EAST, titulo_label);
		layout.putConstraint(SpringLayout.NORTH, tecnico_superior, 5, SpringLayout.SOUTH, ingeniero);
		//RadioButton magister
		layout.putConstraint(SpringLayout.WEST, magister, 5, SpringLayout.EAST, titulo_label);
		layout.putConstraint(SpringLayout.NORTH, magister, 5, SpringLayout.SOUTH, tecnico_superior);
		//RadioButton doctor
		layout.putConstraint(SpringLayout.WEST, doctor, 5, SpringLayout.EAST, titulo_label);
		layout.putConstraint(SpringLayout.NORTH, doctor, 5, SpringLayout.SOUTH, magister);
		//Etiqueta "Especialidad:"
		layout.putConstraint(SpringLayout.WEST, especialidad_label, 5, SpringLayout.EAST, tecnico_superior);
		layout.putConstraint(SpringLayout.NORTH, especialidad_label, 5, SpringLayout.NORTH, c);
		//RadioButton computacion
		layout.putConstraint(SpringLayout.WEST, computacion, 5, SpringLayout.EAST, especialidad_label);
		layout.putConstraint(SpringLayout.NORTH, computacion, 5, SpringLayout.NORTH, c);
		//RadioButton informatica
		layout.putConstraint(SpringLayout.WEST, informatica, 5, SpringLayout.EAST, especialidad_label);
		layout.putConstraint(SpringLayout.NORTH, informatica, 5, SpringLayout.SOUTH, computacion);
		//RadioButton sistemas
		layout.putConstraint(SpringLayout.WEST, sistemas, 5, SpringLayout.EAST, especialidad_label);
		layout.putConstraint(SpringLayout.NORTH, sistemas, 5, SpringLayout.SOUTH, informatica);
		//Etiqueta "Certificaciones:"
		layout.putConstraint(SpringLayout.WEST, certificaciones_label, 45, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, certificaciones_label, 10, SpringLayout.SOUTH, doctor);
		//Etiqueta "Herramientas Manejadas:"
		layout.putConstraint(SpringLayout.WEST, herramientas_label, 70, SpringLayout.EAST, certificaciones_label);
		layout.putConstraint(SpringLayout.NORTH, herramientas_label, 10, SpringLayout.SOUTH, doctor);
		//Etiqueta "Conocimiento General:"
		layout.putConstraint(SpringLayout.WEST, conocimientos_label, 37, SpringLayout.EAST, herramientas_label);
		layout.putConstraint(SpringLayout.NORTH, conocimientos_label, 9, SpringLayout.SOUTH, doctor);
		//Etiqueta "Experiencias Laborales:"
		layout.putConstraint(SpringLayout.WEST, experienciasLaborales_label, 41, SpringLayout.EAST, conocimientos_label);
		layout.putConstraint(SpringLayout.NORTH, experienciasLaborales_label, 10, SpringLayout.SOUTH, doctor);
		//Campo de las certificaciones
		layout.putConstraint(SpringLayout.WEST, certificaciones_text, 5, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, certificaciones_text, 10, SpringLayout.SOUTH, certificaciones_label);
		//Campo de las herramientas
		layout.putConstraint(SpringLayout.WEST, herramientas_text, 15, SpringLayout.EAST, certificaciones_text);
		layout.putConstraint(SpringLayout.NORTH, herramientas_text, 10, SpringLayout.SOUTH, certificaciones_label);
		//Campo de los conocimientos
		layout.putConstraint(SpringLayout.WEST, conocimientos_text, 15, SpringLayout.EAST, herramientas_text);
		layout.putConstraint(SpringLayout.NORTH, conocimientos_text, 10, SpringLayout.SOUTH, certificaciones_label);
		//Campo de las experiencias laborales
		layout.putConstraint(SpringLayout.WEST, experienciasLaborales_text, 15, SpringLayout.EAST, conocimientos_text);
		layout.putConstraint(SpringLayout.NORTH, experienciasLaborales_text, 10, SpringLayout.SOUTH, certificaciones_label);
		//Boton Agregar(Certificacion)
		layout.putConstraint(SpringLayout.WEST, agregar_certificacion, 48, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, agregar_certificacion, 10, SpringLayout.SOUTH, certificaciones_text);
		//Boton Agregar(Herramienta)
		layout.putConstraint(SpringLayout.WEST, agregar_herramienta, 105, SpringLayout.EAST, agregar_certificacion);
		layout.putConstraint(SpringLayout.NORTH, agregar_herramienta, 10, SpringLayout.SOUTH, certificaciones_text);
		//Boton Agregar(Conocimientos)
		layout.putConstraint(SpringLayout.WEST, agregar_conocimiento, 101, SpringLayout.EAST, agregar_herramienta);
		layout.putConstraint(SpringLayout.NORTH, agregar_conocimiento, 10, SpringLayout.SOUTH, certificaciones_text);
		//Boton Agregar(Experiencia)
		layout.putConstraint(SpringLayout.WEST, agregar_expLab, 100, SpringLayout.EAST, agregar_conocimiento);
		layout.putConstraint(SpringLayout.NORTH, agregar_expLab, 10, SpringLayout.SOUTH, certificaciones_text);
		//Boton Cancelar
		layout.putConstraint(SpringLayout.WEST, cancelar, 260, SpringLayout.WEST, c);
		layout.putConstraint(SpringLayout.NORTH, cancelar, 40, SpringLayout.SOUTH, agregar_herramienta);
		//Boton Siguiente
		layout.putConstraint(SpringLayout.WEST, siguiente, 40, SpringLayout.EAST, cancelar);
		layout.putConstraint(SpringLayout.NORTH, siguiente, 40, SpringLayout.SOUTH, agregar_herramienta);
	}
	
	public void asignar_actionListeners() {
		bachiller.addActionListener(this);
		licenciado.addActionListener(this);
		ingeniero.addActionListener(this);
		tecnico_superior.addActionListener(this);
		magister.addActionListener(this);
		doctor.addActionListener(this);
		computacion.addActionListener(this);
		informatica.addActionListener(this);
		sistemas.addActionListener(this);
		agregar_certificacion.addActionListener(this);
		agregar_herramienta.addActionListener(this);
		agregar_conocimiento.addActionListener(this);
		agregar_expLab.addActionListener(this);
		siguiente.addActionListener(this);
		cancelar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource().equals(bachiller)) opc_titulo = 1;
		if(ae.getSource().equals(licenciado)) opc_titulo = 2;
		if(ae.getSource().equals(ingeniero)) opc_titulo = 3;
		if(ae.getSource().equals(tecnico_superior)) opc_titulo = 4;
		if(ae.getSource().equals(magister)) opc_titulo = 5;
		if(ae.getSource().equals(doctor)) opc_titulo = 6;
		
		if(ae.getSource().equals(computacion)) opc_especialidad = 1;
		if(ae.getSource().equals(informatica)) opc_especialidad = 2;
		if(ae.getSource().equals(sistemas)) opc_especialidad = 3;
		
		if(ae.getSource().equals(agregar_certificacion)) {
                    
                    ToSendDatabaseFrame tsdf = new ToSendDatabaseFrame(id_postulante, 0, connection);
                    tsdf.setVisible(true);
		}
		if(ae.getSource().equals(agregar_herramienta)) {
                    
                    ToSendDatabaseFrame tsdf = new ToSendDatabaseFrame(id_postulante, 1, connection);
                    tsdf.setVisible(true);
		}
		if(ae.getSource().equals(agregar_conocimiento)) {
                    
		    ToSendDatabaseFrame tsdf = new ToSendDatabaseFrame(id_postulante, 2, connection);
                    tsdf.setVisible(true);
		}
		if(ae.getSource().equals(agregar_expLab)) {
                    
		    ToSendDatabaseFrame tsdf = new ToSendDatabaseFrame(id_postulante, 3, connection);
                    tsdf.setVisible(true);
		}
		
		if(ae.getSource().equals(cancelar)) {
                    mp = new Menu_Principal(connection);
                    mp.setVisible(true);
                    dispose();
		}
		
		if(ae.getSource().equals(siguiente)) {
                    
                                if(opc_titulo == 1) nuevo_postulante.setTitulo("Bachiller");
                                if(opc_titulo == 2) nuevo_postulante.setTitulo("Licenciado");
                                if(opc_titulo == 3) nuevo_postulante.setTitulo("Ingeniero");
                                if(opc_titulo == 4) nuevo_postulante.setTitulo("Tecnico Superior");
                                if(opc_titulo == 5) nuevo_postulante.setTitulo("Magister");
                                if(opc_titulo == 6) nuevo_postulante.setTitulo("Doctor");

                                if(opc_especialidad == 1) nuevo_postulante.setEspecialidad("Computación");
                                if(opc_especialidad == 2) nuevo_postulante.setEspecialidad("Informatica");
                                if(opc_especialidad == 3) nuevo_postulante.setEspecialidad("Sistemas");

                                agregarPostulanteNivelAcademicoDatabase();

                                dispose();
		}
	}
	
	public void incluir_certificacion(String certi) {
		
	}
	
	public void incluir_herramienta(String herra) {
		
	}
	
	public void incluir_conocimiento() {
		
	}
	
	public void prueba_postulante() {
		System.out.println("Nombres: "+nuevo_postulante.getNombres()+"\nApellidos: "+nuevo_postulante.getApellidos()+"\nEdad: "+nuevo_postulante.getEdad()+"\nSexo: "+nuevo_postulante.getSexo()+"\nPais Origen: "+nuevo_postulante.getPais_origen()+"\nResidencia: "+nuevo_postulante.getResidencia()+"\nTelefono: "+nuevo_postulante.getTelefono()+"\nCorreo: "+nuevo_postulante.getCorreo());
	}
        
        private boolean campos_vacios() {
		if(certificaciones_text.getText().equals("")||herramientas_text.getText().equals("")||conocimientos_text.getText().equals("")||experienciasLaborales_text.getText().equals(""))
			return true;
		return false;
	}
	
        
        // Agregamos en la base de datos los conocimientos del postulante.
        public void agregarPostulanteNivelAcademicoDatabase(){
        
        try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `nivelacademico` (`idnivelacademico`, `titulo`, `especialidad`, `idpostulante`) VALUES (NULL, ?, ?, ?)");
                
                ps.setString(1, nuevo_postulante.getTitulo());
                ps.setString(2, nuevo_postulante.getEspecialidad());
                ps.setInt(3, this.id_postulante);
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog (null, "Registro de Conocimientos de Postulante", "Agregados Exitosamente", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
                
                Logger.getLogger(Administracion_json.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog (null, "Registro de Conocimientos de Postulante", "Ha Ocurrido un Error", JOptionPane.ERROR_MESSAGE);
            }
        
        }
}