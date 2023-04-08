package domain.portsout;

import infrastructure.data.InfrastructureDataException;

public interface InscripcionAlmacenamiento {

	void inscribir(String nombre, String telefono, String region) throws InfrastructureDataException;

}
