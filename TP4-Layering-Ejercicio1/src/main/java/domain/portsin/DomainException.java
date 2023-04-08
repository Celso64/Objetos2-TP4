package domain.portsin;

public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;

	public DomainException(String message) {
		super(message);
	}

	public DomainException() {
		super("Error en el dominio");
	}

}
