package programacionfuncional.anonimanofuncional;

import java.util.ArrayList;
import java.util.List;

public class Terreno {

	private String ubicacion;
	private List<String> caracteristicas;
	private List<String> lugaresCercanos;

	public Terreno() {
		this.caracteristicas = new ArrayList<>();
		this.lugaresCercanos = new ArrayList<>();
	}

	private void agregarCaracteristica(String caracteristica) {
		this.caracteristicas.add(caracteristica);
	}

	private void agregarLugarCercano(String lugarCercano) {
		this.lugaresCercanos.add(lugarCercano);
	}

	public void agregarCaracteristicas(String... caracteristicas) {
		for (String caracteristica : caracteristicas) {
			this.agregarCaracteristica(caracteristica);
		}
	}

	public void agregarLugarCercano(String... lugaresCercanos) {
		for (String lugarCercano : lugaresCercanos) {
			this.agregarLugarCercano(lugarCercano);
		}
	}

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<String> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<String> getLugaresCercanos() {
		return lugaresCercanos;
	}

	public void setLugaresCercanos(List<String> lugaresCercanos) {
		this.lugaresCercanos = lugaresCercanos;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String obtenerInformacionCaracteristicas(Impresion impresion) {
		return impresion.imprimirInformacion(caracteristicas);
	}

	public String obtenerInformacionLugaresCercanos(Impresion impresion) {
		return impresion.imprimirInformacion(lugaresCercanos);
	}

}
