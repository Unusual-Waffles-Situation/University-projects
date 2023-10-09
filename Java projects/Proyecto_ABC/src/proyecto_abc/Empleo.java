package proyecto_abc;

import java.util.*;

public class Empleo {
	
	private List<String> especialidades;
	private List<String> lenguajes_manejados;
	private List<String> certificaciones_sugeridas;
	private String tipoProyecto;
	private int menorEdad;
	private int mayorEdad;
	
	public Empleo() {
		especialidades = new ArrayList();
		lenguajes_manejados = new ArrayList();
		certificaciones_sugeridas = new ArrayList();
	}
	
	public List<String> getEspecialidades() { return especialidades; }
	public List<String> getLenguajes_manejados() {return lenguajes_manejados;}
	public List<String> getCertificaciones_sugeridas() {return certificaciones_sugeridas;}
	public int getMenorEdad() {return menorEdad;}
	public int getMayorEdad() {return mayorEdad;}
	public String getTipoProyecto() {return tipoProyecto;}
}
