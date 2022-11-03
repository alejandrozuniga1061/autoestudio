package novedades.apitiempo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTest {
	
	private Persona persona = new Persona();
	private static final String FECHA_COMPLETA = "2004-09-20 10:00:00";
	
	@BeforeEach
	public void setUp() {
		persona.setNombre("Andres");
		persona.setFechaNacimiento(LocalDate.of(2004, Month.SEPTEMBER, 20));
		persona.setHoraNacimiento(LocalTime.of(10, 0));
	}

	@Test
	void esMayorEdad_personaMenorEdad() {
		assertFalse(persona.esMayorEdad());
	}
	
	@Test
	void esMayorEdad_personaMayorEdadInmutable() {
		persona.getFechaNacimiento().minusDays(12);
		assertFalse(persona.esMayorEdad());
	}
	
	@Test
	void esMayorEdad_personaMayorEdad() {
		persona.setFechaNacimiento(persona.getFechaNacimiento().minusDays(15));
		assertTrue(persona.esMayorEdad());
	}
	
	@Test
	void obtenerFechaNacimientoCompleta_sinDatos() {
		persona.setFechaNacimiento(null);
		assertThrows(NullPointerException.class, () -> persona.obtenerFechaNacimientoCompleta());
	}
	
	@Test
	void obtenerFechaNacimientoCompleta_conDatos() {
		assertEquals(FECHA_COMPLETA, persona.obtenerFechaNacimientoCompleta());
	}
	
	@Test
	void obtenerFechaNacimientoCompleta_conDatosLocalDateTime() {
		assertEquals(FECHA_COMPLETA, persona.obtenerFechaNacimientoCompletaLocalDateTime());
	}
	
	@Test
	void obtenerPrimerDomingoDespuesDeNacimiento_conDatos() {
		String fechaProximoDomingo = "2004-09-26";
		assertEquals(fechaProximoDomingo, persona.obtenerPrimerDomingoDespuesDeNacimiento());
	}
	
	//OTROS
	
	@Test
	void disminuirEdadEnAnios_restandoUnAnio() {
		LocalDate esperado = LocalDate.of(2003, Month.SEPTEMBER, 20);
		persona.disminuirEdadEnAnios(1);
		assertEquals(esperado, persona.getFechaNacimiento());
	}
	
	@Test
	void aumentarEdadEnAnios_aumentadoUnAnio() {
		LocalDate esperado = LocalDate.of(2005, Month.SEPTEMBER, 20);
		persona.aumentarEdadEnAnios(1);
		assertEquals(esperado, persona.getFechaNacimiento());
	}

}
