package programacionfuncional.anonimanofuncional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.StringJoiner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TerrenoTest {
	
	private Terreno terreno1 = new Terreno();
	
	@BeforeEach
	void setUp() {
		terreno1.setUbicacion("Avenida W");
		terreno1.agregarCaracteristicas("Ubicado en clima lluvioso", "Tiene servicios");
		terreno1.agregarLugarCercano("Centro Comercial TTT");
	}
	
	@Test
	void obtenerInformacionCaracteristicas_implementandoImpresionConPrimeraCaracteristica() {		
		String caracteristica = terreno1.obtenerInformacionCaracteristicas(new Impresion() {		
			@Override
			public String imprimirInformacion(List<String> items) {	
				return items.get(0);
			}

		});
		assertEquals("Ubicado en clima lluvioso", caracteristica);
	}
	
	@Test
	void obtenerInformacionCaracteristicas_implementandoImpresionConTodasLasCaracteristicas() {
		String caracteristica = terreno1.obtenerInformacionCaracteristicas(new Impresion() {		
			@Override
			public String imprimirInformacion(List<String> items) {	
				StringJoiner caracteristicas =  new StringJoiner(",");
				for(String caracteristica : items) {
					caracteristicas.add(caracteristica);
				}
				return caracteristicas.toString();
			}
		});
		assertEquals("Ubicado en clima lluvioso,Tiene servicios", caracteristica);
	}
	
	@Test
	void obtenerInformacionCaracteristicas_implementandoImpresionConScopeExterno() {
		String lugarCercano = terreno1.obtenerInformacionLugaresCercanos(new Impresion() {		
			@Override
			public String imprimirInformacion(List<String> items) {	
				StringJoiner lugarCercano =  new StringJoiner(",");
				for(String lugar : items) {
					lugarCercano.add(lugar);
				}
				return new StringJoiner(" ")
						.add("Ubicado en")
						.add(terreno1.getUbicacion())
						.add("lugares cercanos")
						.merge(lugarCercano).toString();
			}
		});
		assertEquals("Ubicado en Avenida W lugares cercanos Centro Comercial TTT", lugarCercano);
	}

}
