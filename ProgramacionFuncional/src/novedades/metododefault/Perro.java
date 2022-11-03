package novedades.metododefault;

public class Perro implements Animal, Mitologico {

	private String nombre;
	private int edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int numeroPatas) {
		this.edad = numeroPatas;
	}

	@Override
	public boolean puedeRespirarEnAgua() {
		return Mitologico.super.puedeRespirarEnAgua();
	}
	
}
