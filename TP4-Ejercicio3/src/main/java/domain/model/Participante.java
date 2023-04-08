package domain.model;

import java.util.Objects;

import domain.portsin.DomainException;

public class Participante {

	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String email;
	private Long idConcurso;

	public Participante(String nombre, String apellido, String telefono, String email, Long idConcurso)
			throws DomainException {
		try {
			Objects.requireNonNull(idConcurso, "Concurso Invalido");
			Objects.requireNonNull(nombre, "Nombre Nulo");
			Objects.requireNonNull(apellido, "Apellido Nulo");
			// Objects.requireNonNull(dni, "DNI Nulo");
			Objects.requireNonNull(telefono, "Telefono Nulo");
			Objects.requireNonNull(email, "Email Nulo");
		} catch (Exception e) {
			throw new DomainException(e.getMessage());
		}

		verificarStringVacio(nombre, "Nombre");
		verificarStringVacio(apellido, "Apellido");
		// verificarStringVacio(dni, "DNI");
		verificarStringVacio(telefono, "Telefono");
		verificarStringVacio(email, "Email");

		checkEmail(email);
		checkPhone(telefono);

		this.nombre = nombre;
		this.apellido = apellido;
		// this.dni = dni;
		this.telefono = telefono;
		this.email = email;
		this.idConcurso = idConcurso;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
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

	private void verificarStringVacio(String string, String nombreCampo) throws DomainException {
		if (string.isBlank())
			throw new DomainException(nombreCampo + " no debe estar vacio");
	}

	private void checkEmail(String email) throws DomainException {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		if (!email.matches(regex))
			throw new DomainException("Email Invalido");
	}

	private void checkPhone(String telefono) throws DomainException {
		String regex = "\\d{4}-\\d{6}";
		if (!telefono.matches(regex))
			throw new DomainException("Telefono Invalido");
	}

}
