package novedades.metodostatic;

public interface Celular {
	
	String DESCRIPCION = "El celular %s ofrece muy buena calidad!";
	
	static String obtenerDescripcion(String marca) {
		return String.format(DESCRIPCION, marca);
	}

}
