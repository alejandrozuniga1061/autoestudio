package programacionfuncional.apistream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Propietario {

	private String nombre;
	private List<Vehiculo> vehiculos;

	public Propietario() {
		this.vehiculos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	
	public List<String> obtenerLugaresVisitados() {
		return this.vehiculos.stream()
			.flatMap(vehiculo -> vehiculo.getLugaresVisitados().stream())
			.collect(Collectors.toList());
	}
	
	public List<String> obtenerLugaresVisitadosPorVehiculo(Vehiculo vehiculo) {
		return this.vehiculos.stream()
			.filter( v ->  v.equals(vehiculo))
			.flatMap(v -> v.getLugaresVisitados().stream())
			.collect(Collectors.toList());
	}

}
