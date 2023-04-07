package domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import domain.portsin.Tabla;
import domain.portsuot.LeerTabla;
import domain.portsuot.Notificador;

public class EmpleadosTabla implements Tabla {

	private List<String> titulos;
	private List<String[]> datos;
	private Notificador notificador;

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	public EmpleadosTabla(LeerTabla lectorDeTabla, Notificador notificador) {
		this(lectorDeTabla.getTabla());
		this.notificador = notificador;
	}

	private EmpleadosTabla(List<String[]> datos) {

		this.datos = new ArrayList<>();

		List<String[]> lista = Objects.requireNonNull(datos);

		this.titulos = List.of(lista.get(0));
		lista.remove(0);

		this.validarFilas(lista);
		this.datos = lista;

	}

	private void validarFilas(List<String[]> lista) {

		Integer columnas = titulos.size();

		Long filasIncompletas = lista.stream().filter(x -> x.length != columnas).count();

		if (filasIncompletas > 0)
			throw new RuntimeException(filasIncompletas.toString() + " filas incompletas");

	}

	@Override
	public void felicitarCumpleanieros() {

		this.datos.stream().filter(x -> esCumpleanios(LocalDate.parse(x[2], FORMATTER))).forEach(this::notificarCumple);

	}

	private void notificarCumple(String[] datosCumpleaniero) {

		StringBuffer mensaje = new StringBuffer(128);

		mensaje.append("Feliz Cumpleaños ").append(datosCumpleaniero[1]).append(" ").append(datosCumpleaniero[0]);

		this.notificador.notificar("Feliz Cumpleaños", mensaje.toString(), datosCumpleaniero[3]);

	}

	private Boolean esCumpleanios(LocalDate fecha) {

		Boolean esCumple = false;

		LocalDate hoy = LocalDate.now();

		esCumple = hoy.getMonth().equals(fecha.getMonth());

		esCumple &= Integer.valueOf(hoy.getDayOfMonth()).equals(Integer.valueOf(fecha.getDayOfMonth()));

		return esCumple;
	}

}
