package domain.model;

import java.time.LocalDate;
import java.util.Objects;

public class Concurso {
	private Long id;
	private String nombre;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinInscripcion;

	public Concurso(Long id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
		this.id = Objects.requireNonNull(id);
		this.nombre = Objects.requireNonNull(nombre);
		this.fechaInicioInscripcion = Objects.requireNonNull(fechaInicioInscripcion);
		this.fechaFinInscripcion = Objects.requireNonNull(fechaFinInscripcion);
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
