package infrastructure.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import domain.model.Concurso;
import domain.model.Participante;
import domain.portsout.LectorDatos;

public class TXTLectorDatos implements LectorDatos {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	private InputStream lectorParticipantes;
	private InputStream lectorConcursos;

	public TXTLectorDatos(InputStream lectorParticipantes, InputStream lectorConcursos) {
		this.lectorParticipantes = lectorParticipantes;
		this.lectorConcursos = lectorConcursos;
	}

	@Override
	public List<Participante> getParticipantes() throws InfrastructureDataException {
		List<Participante> participantes = new LinkedList<>();

		var datos = leerCampos(this.lectorParticipantes);

		try {
			for (String[] valor : datos) {

				participantes.add(new Participante(valor[1], valor[0], valor[2], valor[3], Long.parseLong(valor[4])));
			}
		} catch (Exception e) {
			throw new InfrastructureDataException(e.getMessage() + " || no se pudo leer los participantes");
		}

		return participantes;
	}

	@Override
	public List<Concurso> getConcursos() throws InfrastructureDataException {
		List<Concurso> concursos = new LinkedList<>();

		var datos = leerCampos(this.lectorConcursos);

		try {
			for (String[] valor : datos) {

				concursos.add(new Concurso(Long.parseLong(valor[0]), valor[1], LocalDate.parse(valor[2], FORMATTER),
						LocalDate.parse(valor[3], FORMATTER)));

			}
		} catch (Exception e) {
			throw new InfrastructureDataException(e.getMessage() + " || no se pudo leer los participantes");
		}

		return concursos;
	}

	private List<String[]> leerCampos(InputStream lector) {

		var lineas = leerLineas(lector);

		List<String[]> campos = new LinkedList<>();

		lineas.forEach(x -> campos.add(x.split(", ")));

		return campos;

	}

	private List<String> leerLineas(InputStream lector) {

		List<String> lineas = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(lector));
		Integer i = 0;

		try

		{

			while (reader.ready()) {
				String next = reader.readLine();
				lineas.add(next);
				i++;
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lineas;
	}

}
