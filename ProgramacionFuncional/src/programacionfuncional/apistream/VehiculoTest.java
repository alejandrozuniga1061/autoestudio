package programacionfuncional.apistream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.IntPredicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import programacionfuncional.apistream.exception.SinLugaresException;

class VehiculoTest {

	private Vehiculo vehiculo = new Vehiculo();
	private Vehiculo segundoVehiculo = new Vehiculo();
	private Propietario propietario = new Propietario();
	
	@BeforeEach
	void setUp() {
		vehiculo.setChasis("ABC123");
		segundoVehiculo.setChasis("AAA");
		propietario.setNombre("Andres");
		propietario.agregarVehiculo(vehiculo);
		propietario.agregarVehiculo(segundoVehiculo);
	}
	
	@Test
	void listarLugaresVisitados_sinLugares() {
		assertEquals("", vehiculo.listarLugaresVisitados());
	}
	
	@Test
	void listarLugaresVisitados_conLugares() {
		vehiculo.agregarLugaresVisitados("Cali", "Medellin");
		assertEquals("Cali-Medellin", vehiculo.listarLugaresVisitados());
	}

	@Test
	void listarLugaresVisitadosEnOrden_conLugaresDesordenados() {
		vehiculo.agregarLugaresVisitados("Medellin", "Bogota","Cali");
		assertEquals("Bogota-Cali-Medellin", vehiculo.listarLugaresVisitadosEnOrden());
	}
	
	@Test
	void obtenerPrimerLugarVisitado_sinLugaresAgregados() {
		assertEquals(Optional.empty(), vehiculo.obtenerPrimerLugarVisitado());
	}
	
	@Test
	void obtenerPrimerLugarVisitado_conLugaresAgregados() {
		vehiculo.agregarLugaresVisitados("Medellin", "Bogota","Cali");
		
		assertEquals(Optional.of("Medellin"), vehiculo.obtenerPrimerLugarVisitado());
	}
	
	@Test
	void obtenerLugarVisitadoAleatorio_sinLugaresAgregados() {
		assertThrows(SinLugaresException.class, () -> vehiculo.obtenerLugarVisitadoAleatorio());		 
	}
	
	@Test
	void obtenerLugarVisitadoAleatorio_conLugaresAgregados() {
		vehiculo.agregarLugaresVisitados("Medellin", "Bogota","Cali");
		assertNotNull(vehiculo.obtenerLugarVisitadoAleatorio());		 
	}
	
	@Test
	void obtenerLugaresVisitadosEnMayusculas_sinLugaresAgregados() {
		assertTrue(vehiculo.obtenerLugaresVisitadosEnMayusculas().isEmpty());		 
	}
	
	@Test
	void obtenerLugaresVisitadosEnMayusculas_conLugaresAgregados() {
		vehiculo.agregarLugaresVisitados("Medellin", "Bogota","Cali");
		List<String> esperado = Arrays.asList("MEDELLIN", "BOGOTA","CALI");
		assertEquals(esperado, vehiculo.obtenerLugaresVisitadosEnMayusculas());		 
	}
	
	@Test
	void validarLugaresVisitadosPropietario_sinLugaresVisitados() {
		assertTrue(propietario.obtenerLugaresVisitados().isEmpty());
			
	}
	
	@Test
	void validarLugaresVisitadosPropietario_conLugaresVisitados() {
		vehiculo.agregarLugaresVisitados("Cali");
		segundoVehiculo.agregarLugaresVisitados("Bogota");
		List<String> esperado = Arrays.asList("Cali", "Bogota");
		assertEquals(esperado, propietario.obtenerLugaresVisitados());			
	}
	
	@Test
	void obtenerLugaresVisitadosPorVehiculo_conLugaresVisitados() {
		List<String> esperado = Arrays.asList("Popayan");
		vehiculo.agregarLugaresVisitados("Popayan");
		assertEquals(esperado, propietario.obtenerLugaresVisitadosPorVehiculo(vehiculo));
	}

}
