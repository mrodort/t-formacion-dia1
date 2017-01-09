package com.tsystem.dia1.world_csv;

import java.io.File;
import java.io.FileReader;

import au.com.bytecode.opencsv.CSVReader;

public class Aplication {

    public static void main(final String args[]) {

	if (args.length < 1) {
	    throw new IllegalArgumentException("Debe a menos indecar un parametro para el comando.");
	}

	final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
	File cvsFile = null;

	switch (args[0]) {
	case "city":
	    cvsFile = new File(systemClassLoader.getResource("city.csv").getFile());
	    break;
	case "country":
	    cvsFile = new File(systemClassLoader.getResource("country.csv").getFile());
	    break;
	case "language":
	    cvsFile = new File(systemClassLoader.getResource("countrylanguage.csv").getFile());
	    break;
	default:
	    throw new IllegalArgumentException("Argumento invalido, seleccione city, country o language");
	}

	try {

	    final CSVReader reader = new CSVReader(new FileReader(cvsFile), ';');
	    String[] nextLine;
	    while ((nextLine = reader.readNext()) != null) {
		// nextLine[] is an array of values from the line
		System.out.println(nextLine[0] + " " + nextLine[1] + " etc...");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
