package programacionfuncional.apistream;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import programacionfuncional.apistream.exception.SinLugaresException;

public class Vehiculo {

	private List<String> lugaresVisitados;
	private String chasis;
	
	public Vehiculo() {
		this.lugaresVisitados = new ArrayList<>();
	}

	public List<String> getLugaresVisitados() {
		return lugaresVisitados;
	}

	public void setLugaresVisitados(List<String> lugaresVisitados) {
		this.lugaresVisitados = lugaresVisitados;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	
	public void agregarLugaresVisitados(String... lugares) {
		Arrays.asList(lugares).forEach( this :: agregarLugarVisitado);
	}
	
	private void agregarLugarVisitado(String lugarVisitado) {
		this.lugaresVisitados.add(lugarVisitado);
	}
	
	public String listarLugaresVisitados() {
		return this.lugaresVisitados.stream()
				.collect(joining("-"));
	}
	
	public String listarLugaresVisitadosEnOrden() {
		return this.lugaresVisitados.stream()
				.sorted()
				.collect(joining("-"));
	}
	
	public Optional<String> obtenerPrimerLugarVisitado() {
		return this.lugaresVisitados.stream()
				.findFirst();
	}
	
	public String obtenerLugarVisitadoAleatorio() throws SinLugaresException  {
		return this.lugaresVisitados.stream()
				.findAny()
				.orElseThrow(() -> new SinLugaresException("sin ningun lugar"));
	}
	
	public List<String> obtenerLugaresVisitadosEnMayusculas() {
		return this.lugaresVisitados.stream()
				.map(String :: toUpperCase)
				.collect(Collectors.toList());
	}
	
}

