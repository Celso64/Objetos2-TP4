package domain.model;

import java.util.Objects;

import domain.portsin.DomainException;

class Email {

	private static String REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

	private String email;

	public Email(String email) throws DomainException {

		Objects.requireNonNull(email, "Email Nulo");

		if (!email.matches(REGEX) || email.isBlank())
			throw new DomainException("Email Invalido");

		this.email = email;
	}

	@Override
	public String toString() {
		return email;
	}

}
