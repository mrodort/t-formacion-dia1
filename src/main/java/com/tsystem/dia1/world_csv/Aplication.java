package com.tsystem.dia1.world_csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

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
		findById(cvsFile, args[2]);
		break;
	    case "name":
		findByNameStartWith(cvsFile, args[2]);
		break;

	    default:
		throw new IllegalArgumentException("Argumento invalido, seleccione id o nombre");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private static void findByNameStartWith(final File fileName, final String startWith)
	    throws IOException, FileNotFoundException {

	final CSVReader reader = new CSVReader(new FileReader(fileName), ';');

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[1].startsWith(startWith)) {
		System.out.println(nextLine[0] + " " + nextLine[1] + " etc...");
	    }
	}

    }

    private static void findById(final File fileName, final String id) throws IOException, FileNotFoundException {
	final CSVReader reader = new CSVReader(new FileReader(fileName), ';');

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[0].equals(id)) {
		System.out.println(nextLine[0] + " " + nextLine[1] + " etc...");
	    }
	}
    }
}
