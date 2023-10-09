package proyecto_abc;

import java.util.*;

public class Puntajes_EAP {
	
	private float pse; //Puntaje segun el empleo
	private float psa; //Puntaje segun aptitud
	private float pep; //Puntaje extra del proyecto
	private Postulante postulante;
	private Empleo empleo;
	private int modo; //Modo = 1: pse llega hasta 40 y psa hasta 20. Modo = 2: ambos llegan hasta 30
	
	public Puntajes_EAP(Postulante postulante, Empleo empleo) {
		this.postulante = postulante;
		this.empleo = empleo;
		pse = 0f;
		psa = 0f;
		pep = 0f;
		modo = 1;
	}
	
	public void calcular_puntaje_pse() {
		
		//Comprobamos si la especialidad del postulante coincide con una del empleo
		boolean especialidadIncorrecta = true;
		for(int i=0; i<empleo.getEspecialidades().size(); i++) {
			if(postulante.getEspecialidad().equals(empleo.getEspecialidades().get(i))){
				pse += 10f;
				especialidadIncorrecta = false;
			}
		}
		if(especialidadIncorrecta) pse += 5f;
		
		//Comprobamos la equivalencia entre los lenguajes empleados por el proyecto y los manejados por el postulante
		float puntajeLenguaje = 10/(empleo.getLenguajes_manejados().size());
		for(int i=0; i<empleo.getLenguajes_manejados().size(); i++) {
			for(int j=0; j<postulante.getLenguajes_programacion().size(); j++) {
				if(postulante.getLenguajes_programacion().get(j).equals(empleo.getLenguajes_manejados().get(i)))
					pse += puntajeLenguaje;
			}
		}
		
		//Comprobamos la edad del postulante contra el rango de edades del empleo
		if(postulante.getEdad()>=empleo.getMenorEdad() && postulante.getEdad()<=empleo.getMayorEdad()) {
			pse += 10f;
		}
		else {
			float puntaje_por_edad = 10/(43-(empleo.getMayorEdad()-empleo.getMenorEdad()));
			if(postulante.getEdad() < empleo.getMenorEdad()) {
				pse += 10 - (puntaje_por_edad*(empleo.getMenorEdad()-postulante.getEdad()));
			}
			if(postulante.getEdad() > empleo.getMayorEdad()) {
				pse += 10 - (puntaje_por_edad*(postulante.getEdad()-empleo.getMayorEdad()));
			}
		}
		
		//Comprobamos(de existir) las certificaciones sugeridas por el empleo con las que posee el postulante
		if(!empleo.getCertificaciones_sugeridas().isEmpty()) {
			int puntajeCertificaciones = 10/(empleo.getCertificaciones_sugeridas().size());
			for(int i=0; i<empleo.getCertificaciones_sugeridas().size(); i++) {
				for(int j=0; j<postulante.getCertificaciones().size(); j++) {
					if(postulante.getCertificaciones().get(j).equalsIgnoreCase(empleo.getCertificaciones_sugeridas().get(i)))
						pse += puntajeCertificaciones;
				}
			}
			
		}
		else {
			modo = 2;
		}
		
	}
	
	public void calcular_puntaje_psa() {
		
		//Asignamos cierto puntaje (0.5 ptos) por cada conocimiento general que tenga el postulante
		if(postulante.getConocimiento_general().size()>=20)
			psa += 10f;
		else
			psa += 0.5*(postulante.getConocimiento_general().size());
		
		//Asignamos 1 pto por cada experiencia laboral que tenga el postulante
		if(postulante.getExperiencias_laborales().size()>=10)
			psa += 10f;
		else
			psa += postulante.getExperiencias_laborales().size();
		
		//Si estamos en modo 2, se cuentan las certificaciones como parte del psa
		if(modo==2) {
			if(postulante.getCertificaciones().size()>=20)
				psa += 10f;
			else
				psa += 0.5*(postulante.getCertificaciones().size());
		}
		
	}
	
	public void calcular_puntaje_pep() {
		
		//Aqui primero obtenemos, de la base de datos, las herramientas o lenguajes que
		//tenemos almacenados del tipo de proyecto que tenga el empleo (el tipo del proyecto
		//lo sabremos con el metodo getTipoProyecto() en la clase empleo).
		
		List<String> herramientas_extraidas = new ArrayList(); //Este es solo una lista de ejemplo de los datos que se sacaron de la base de datos
		
		//Ahora comparamos la lista de herramientas que extrajimos con la lista de herramientas del postulante
		//y asignamos 1 pto por cada herramienta que coincida. Esto se hara hasta que se comprueben todas las
		//herramientas de la lista, o hasta que se alcancen 10 ptos, que es el maximo que se puede obtener en esta
		//categoria
		for(int i=0; i<herramientas_extraidas.size(); i++) {
			for(int j=0; j<postulante.getLenguajes_programacion().size(); j++) {
				if(pep!=10 && postulante.getLenguajes_programacion().get(j).equals(herramientas_extraidas.get(i)))
					pse += 1;
			}
		}
		
	}
}
