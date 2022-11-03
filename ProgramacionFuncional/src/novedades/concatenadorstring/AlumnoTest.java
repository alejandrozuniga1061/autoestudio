package novedades.concatenadorstring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void test() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Pepito");
		alumno.setApellido("Perez");
		
		alumno.agregarUtiles("Cuaderno", "Lapicero", "Regla", "Borrado", "Lapiz");
		String esperado = "Pepito Perez Cuaderno,Lapicero,Regla,Borrado,Lapiz";
		assertEquals(esperado, alumno.obtenerInformacionAlumno());
	}

}
