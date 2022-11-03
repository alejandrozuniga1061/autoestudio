package novedades.metododefault;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnimalTest {
	
	private Animal perro = new Perro();
			
	@Test
	void imprimirPropiedades_animalPerro() {
		String propiedades = perro.obtenerPropiedades();
		assertEquals("nombreedad", propiedades);
	}
	
	@Test
	void puedeRespirarEnAgua_animalPerroYPescado() {
		assertTrue(perro.puedeRespirarEnAgua());
		
		Animal pescado = new Pescado();
		assertTrue(pescado.puedeRespirarEnAgua());
	}
	
	@Test
	void puedeRespirarEnAgua_mitologicoPerro() {
		assertTrue(perro.puedeRespirarEnAgua());
	}

}
