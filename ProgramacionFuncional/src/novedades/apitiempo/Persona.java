package novedades.apitiempo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Persona {
	private String nombre;
	private LocalDate fechaNacimiento;
	private LocalTime horaNacimiento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalTime getHoraNacimiento() {
		return horaNacimiento;
	}

	public void setHoraNacimiento(LocalTime horaNacimiento) {
		this.horaNacimiento = horaNacimiento;
	}
	
	public boolean esMayorEdad() {
		Period periodo = Period.between(this.fechaNacimiento, LocalDate.now());
		return periodo.getYears() >= 18;
	}
	
	public String obtenerFechaNacimientoCompleta() {		
		return this.fechaNacimiento.format(DateTimeFormatter.ISO_LOCAL_DATE)
				+ " " + this.horaNacimiento.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
	
	public String obtenerFechaNacimientoCompletaLocalDateTime() {
		LocalDateTime fecha = LocalDateTime.of(fechaNacimiento, horaNacimiento);
		return fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public String obtenerPrimerDomingoDespuesDeNacimiento() {
		TemporalAdjuster ajustadorParaProximoViernes = TemporalAdjusters.next(DayOfWeek.SUNDAY);
		return this.fechaNacimiento.with(ajustadorParaProximoViernes)
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public void aumentarEdadEnAnios(int anios) {
		this.fechaNacimiento = this.fechaNacimiento.plusYears(anios);
	}
	
	public void disminuirEdadEnAnios(int anios) {
		this.fechaNacimiento  = this.fechaNacimiento.minusYears(anios);
	}
}
