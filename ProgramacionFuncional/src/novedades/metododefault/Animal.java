package novedades.metododefault;

import java.lang.reflect.Field;

public interface Animal {
	
	default String obtenerPropiedades() {
		Field[] campos = this.getClass().getDeclaredFields();
		StringBuilder stringBuilder = new StringBuilder();
		for(Field campo: campos) {
			stringBuilder.append(campo.getName());
		}
		return stringBuilder.toString();
	}
	
	default boolean puedeRespirarEnAgua() {
		return false;
	}
	
}
