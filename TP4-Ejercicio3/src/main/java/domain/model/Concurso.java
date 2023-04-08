package domain.model;

import java.time.LocalDate;

public class Concurso {
	private Long id;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(Long id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
		this.id = id;
		this.nombre = nombre;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinInscripcion = fechaFinInscripcion;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public LocalDate getFechaFinInscripcion() {
		return fechaFinInscripcion;
	}

	public Boolean estaVigente() {
		return this.fechaFinInscripcion.isAfter(LocalDate.now());
	}

}
