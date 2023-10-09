package proyecto_abc;
import java.util.*;

public class Postulante {
	
	private String nombres;
	private String apellidos;
	private String sexo;
	private String pais_origen;
	private String residencia;
	private String telefono;
	private String correo;
	private String titulo;
	private String especialidad;
	private List<String> certificaciones;
	private List<String> lenguajes_programacion;
	private List<String> conocimiento_general;
	private List<Experiencia_Laboral> experiencias_laborales;
	int edad;
	
	public Postulante() {
		certificaciones = new ArrayList();
		lenguajes_programacion = new ArrayList();
		conocimiento_general = new ArrayList();
		experiencias_laborales = new ArrayList();
	}
	
	public void setNombres(String nombre1, String nombre2) {
		nombres = nombre1+" "+nombre2;
	}
	
	public void setApellidos(String apellido1, String apellido2) {
		apellidos = apellido1+" "+apellido2;
	}
	
	public void setEdad(int e) {
		edad = e;
	}
	
	public void setSexo(String genero) {
		sexo = genero;
	}
	
	public void setPais_origen(String pais) {
		pais_origen = pais;
	}
	
	public void setResidencia(String pais) {
		residencia = pais;
	}
	
	public void setTelefono(String tlf) {
		telefono = tlf;
	}
	
	public void setCorreo(String email) {
		correo = email;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public void agregarCertificacion(String certificacion) {
		certificaciones.add(certificacion);
	}
	
	public void agregarLenguaje(String lenguaje) {
		lenguajes_programacion.add(lenguaje);
	}
	
	public void agregarConocimiento(String conocimiento) {
		conocimiento_general.add(conocimiento);
	}
	
	public void agregarExperienciaLaboral(Experiencia_Laboral experiencia) {
		experiencias_laborales.add(experiencia);
	}
	
	public String getNombres() {return nombres;}
	public String getApellidos() {return apellidos;}
	public int getEdad() {return edad;}
	public String getSexo() {return sexo;}
	public String getPais_origen() {return pais_origen;}
	public String getResidencia() {return residencia;}
	public String getTelefono() {return telefono;}
	public String getCorreo() {return correo;}
        public String getTitulo() {return titulo;}
	public String getEspecialidad() {return especialidad;}
	public List<String> getLenguajes_programacion(){return lenguajes_programacion;}
	public List<String> getCertificaciones(){return certificaciones;}
	public List<String> getConocimiento_general(){return conocimiento_general;}
	public List<Experiencia_Laboral> getExperiencias_laborales(){return experiencias_laborales;}
}
