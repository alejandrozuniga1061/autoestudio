package programacionfuncional.interfacefuncional;

import java.util.StringJoiner;

public class Humano {

	private int diasConVida;
	private String genero;

	public int getDiasConVida() {
		return diasConVida;
	}

	public void setDiasConVida(int diasConVida) {
		this.diasConVida = diasConVida;
	}
	
	public void aumentarDiasConVida() {
		this.diasConVida++;
	}
	
	public void aumentarDiasConVida( int dias) {
		this.diasConVida += dias;
	}
	
	public String fijarGenero(String genero) {
		this.genero = genero;
		return "Actualizado";
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public String toString() {
		return new StringJoiner(" ")
				.add(String.valueOf(diasConVida))
				.add(genero)
				.toString();
	}

}
