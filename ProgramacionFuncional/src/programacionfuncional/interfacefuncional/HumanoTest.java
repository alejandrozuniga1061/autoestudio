package programacionfuncional.interfacefuncional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HumanoTest {

	private static final String FEMENINO = "FEMENINO";
	private static final String MASCULINO = "Masculino";
	private Humano humano = new Humano();
	
	@BeforeEach
	void setUp() {
		this.humano.setDiasConVida(0);
	}
	
	@Test
	void aumentarDiasConVida_sinLlamarRunnable() {		
		Runnable aumentarDia = () -> humano.aumentarDiasConVida();
		assertEquals(0, humano.getDiasConVida());
	}
	
	@Test
	void aumentarDiasConVida_llamandoRunnable() {		
		Runnable aumentarDia = () -> humano.aumentarDiasConVida();
		aumentarDia.run();
		assertEquals(1, humano.getDiasConVida());
	}
	
	@Test
	void aumentarDiasConVida_sinLlamarConsumer() {		
		Consumer<Integer> aumentarDia = dias -> humano.aumentarDiasConVida(dias);
		assertEquals(0, humano.getDiasConVida());
	}
	
	@Test
	void aumentarDiasConVida_llamandoConsumer() {		
		Consumer<Integer> aumentarDia = dias -> humano.aumentarDiasConVida(dias);
		aumentarDia.accept( 5 );
		assertEquals(5, humano.getDiasConVida());
		aumentarDia.accept(2);
		assertEquals(7, humano.getDiasConVida());
	}
	
	@Test
	void fijarGenero_sinLlamarFunction() {
		Function<String, String> fijarGenero = genero -> humano.fijarGenero(genero);
		assertNull(humano.getGenero());
	}
	
	@Test
	void fijarGenero_llamandoFunction() {
		UnaryOperator<String> fijarGenero = genero -> humano.fijarGenero(genero);
		assertEquals("Actualizado", fijarGenero.apply(MASCULINO));
	}
	
	@Test
	void toString_llamandoSupplier() {
		Supplier<String> supplier = () -> humano.toString();
		humano.fijarGenero(MASCULINO);
		assertEquals("0 Masculino", supplier.get());
	}
	
	@Test
	void validarGeneroFemenino_conGeneroMasculinoPredicate() {
		Predicate<String> tieneGeneroFemenino = genero -> genero.equals(MASCULINO);
		assertFalse(tieneGeneroFemenino.test(FEMENINO));
	}
	
	@Test
	void validarGeneroFemenino_conGeneroFemeninoPredicate() {
		Predicate<String> tieneGeneroFemenino = genero -> genero.equals(FEMENINO);
		assertTrue(tieneGeneroFemenino.test(FEMENINO));
	}

	
	@Test
	void validarInterfazFuncionalCreada() {
		String respuesta = "Hello word";
		FunctionQuipux f = nombre -> "Bienvenido " + nombre;
		String respuesta2 = "Bienvenido Carlos";
		assertEquals(respuesta, f.sayHelloWord() );
		assertEquals( respuesta2, f.sayHelloTo("Carlos"));
	}
}
