package novedades.metodostatic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CelularTest {
	
	@Test
	void obtenerDescripcion_formaEstatica() {
		String esperado = "El celular Xiaomi ofrece muy buena calidad!";
		assertEquals(Celular.obtenerDescripcion("Xiaomi"), esperado);
	}

	@Test
	void obtenerDescripcion_desdeSamsung() {
		Samsung samsung = new Samsung();
		String esperado = "El celular Samsung ofrece muy buena calidad!";
		assertEquals(esperado, samsung.obtenerDescripcion());
	}

}
