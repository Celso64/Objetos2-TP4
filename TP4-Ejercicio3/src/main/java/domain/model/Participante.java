package domain.model;

import java.util.Objects;

import domain.portsin.DomainException;

public class Participante {

	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private Long idConcurso;

	public Participante(String nombre, String apellido, String telefono, String email, Long idConcurso)
			throws DomainException {
		try {
			Objects.requireNonNull(idConcurso, "Concurso Invalido");

		} catch (Exception e) {
			throw new DomainException(e.getMessage());
		}

		this.nombre = new Nombre(nombre).toString();
		this.apellido = new Apellido(apellido).toString();
		this.telefono = new Telefono(telefono).toString();
		this.email = new Email(email).toString();
		this.idConcurso = idConcurso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public Long getIdConcurso() {
		return idConcurso;
	}

}
