package novedades.apitiempo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Vuelo {

	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	
	public Duration obtenerDuracionVueloConZonaHoraria(String zonaSalida, String zonaLlegada) {
		ZoneId zonaHorariaSalida = ZoneId.of(zonaSalida);
		ZoneId zonaHorariaLlegada = ZoneId.of(zonaLlegada);
		
		ZonedDateTime salidaConZonaHoraria = ZonedDateTime.of(this.fechaSalida, zonaHorariaSalida);
		ZonedDateTime llegadaConZonaHoraria = ZonedDateTime.of(this.fechaLlegada, zonaHorariaLlegada);
		
		return Duration.between(salidaConZonaHoraria, llegadaConZonaHoraria);
	}
	
	public Duration obtenerDuracionVueloSinZonaHoraria() {
		return Duration.between(this.fechaSalida, this.fechaLlegada);
	}
	
	

}
