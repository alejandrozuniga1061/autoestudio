package novedades.concatenadorstring;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Alumno {

	private String nombre;
	private String apellido;
	private List<String> utiles;

	public Alumno() {
		this.utiles = new ArrayList<>(5);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void agregarUtil(String util) {
		this.utiles.add(util);
	}
	
	public void agregarUtiles(String... utiles) {
		for(String util: utiles) {
			this.agregarUtil(util);
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String obtenerInformacionAlumno() {
		StringJoiner informacion = new StringJoiner(",");
		for(String util : utiles) {
			informacion.add(util);
		}
		return new StringJoiner(" ").add(this.nombre)
				.add(this.apellido)
				.merge(informacion)
				.toString();
	}

}
