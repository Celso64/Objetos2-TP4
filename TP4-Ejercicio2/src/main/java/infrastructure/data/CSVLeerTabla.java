package infrastructure.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.opencsv.CSVReader;

import domain.portsuot.LeerTabla;

public class CSVLeerTabla implements LeerTabla {

	private CSVReader reader;

	public CSVLeerTabla(CSVReader reader) {
		this.reader = Objects.requireNonNull(reader);
	}

	@Override
	public List<String[]> getTabla() {
		List<String[]> listaDatos = new ArrayList<>();

		this.reader.forEach(listaDatos::add);

		return listaDatos;
	}

}
