package com.tsystem.dia1.world_csv;

import java.io.File;
import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.repository.CsvDataRepository;
import com.tsystem.dia1.world_csv.repository.DataRepository;
import com.tsystem.dia1.world_csv.ui.ConsoleUserInterface;

public class Aplication {

    // Queremos hacer:
    // 1 obtener city por id
    // 2 obtener city por nombre empieza por
    // 3 obtener country por codigo
    // 4 ...

    public static void main(final String args[]) {

	DataRepository dataRepository = new CsvDataRepository();

	if (args.length < 1) {
	    throw new IllegalArgumentException("Debe al menos indicar un parametro para el comando.");
	}

	File cvsFile = null;

	switch (args[0]) {
	case "city":
	    cvsFile = ResourceUtils.getResourceByName("city.csv");
	    break;
	case "country":
	    cvsFile = ResourceUtils.getResourceByName("country.csv");
	    break;
	case "language":
	    cvsFile = ResourceUtils.getResourceByName("countrylanguage.csv");
	    break;
	default:
	    throw new IllegalArgumentException("Argumento invalido, seleccione city, country o language");
	}

	try {

	    switch (args[1]) {
	    case "id":
		Optional<String[]> optionalLine = dataRepository.findById(cvsFile, args[2]);

		if (optionalLine.isPresent()) {
		    ConsoleUserInterface.printLine(optionalLine.get());
		}

		break;
	    case "name":
		List<String[]> lines = dataRepository.findByNameStartWith(cvsFile, args[2]);
		for (String[] line : lines) {
		    ConsoleUserInterface.printLine(line);
		}
		break;

	    default:
		throw new IllegalArgumentException("Argumento invalido, seleccione id o nombre");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
