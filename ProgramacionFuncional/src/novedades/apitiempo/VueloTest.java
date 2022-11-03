package novedades.apitiempo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VueloTest {
	
	private Vuelo vuelo = new Vuelo();
	
	@BeforeEach
	void setUp() {
		this.vuelo.setFechaSalida(LocalDateTime.of(2022, Month.SEPTEMBER, 8, 12, 0));
		this.vuelo.setFechaLlegada(LocalDateTime.of(2022, Month.SEPTEMBER, 8, 20, 0));
	}

	@Test
	void obtenerDuracionVueloSinZonaHoraria_conDatosCorrectos() {
		Duration esperado = Duration.ofHours(8);
		Duration evaluado = this.vuelo.obtenerDuracionVueloSinZonaHoraria();
		assertEquals(esperado, evaluado);
	}
	
	@Test
	void obtenerDuracionVueloConZonaHoraria_conDatosCorrectos() {
		Duration esperado = Duration.ofHours(7);
		Duration evaluado = this.vuelo.obtenerDuracionVueloConZonaHoraria("America/Bogota", "America/New_York"); //New York tiene una hora de diferencia por encima
		assertEquals(esperado, evaluado);
	}

}
