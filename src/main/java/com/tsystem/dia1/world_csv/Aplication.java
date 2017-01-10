package com.tsystem.dia1.world_csv;

import java.io.File;
import java.util.List;
import java.util.Optional;

import repository.DataRepository;
import userInterface.ConsoleUserInterface;

public class Aplication {

    public static void main(final String args[]) {

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
		Optional<String[]> optionalLine = DataRepository.findById(cvsFile, args[2]);

		if (optionalLine.isPresent()) {
		    ConsoleUserInterface.printLine(optionalLine.get());
		}

		break;
	    case "name":
		List<String[]> lines = DataRepository.findByNameStartWith(cvsFile, args[2]);
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
