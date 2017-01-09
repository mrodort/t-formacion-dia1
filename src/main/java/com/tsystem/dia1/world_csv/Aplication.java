package com.tsystem.dia1.world_csv;

import java.io.File;
import java.io.FileReader;

import au.com.bytecode.opencsv.CSVReader;

public class Aplication {

    public static void main(String args[]) {

	try {

	    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
	    File cityFile = new File(systemClassLoader.getResource("city.csv").getFile());

	    CSVReader reader = new CSVReader(new FileReader(cityFile), ';');
	    String[] nextLine;
	    while ((nextLine = reader.readNext()) != null) {
		// nextLine[] is an array of values from the line
		System.out.println(
			nextLine[0] + " " + nextLine[1] + " " + nextLine[2] + " " + nextLine[3] + " " + nextLine[4]);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
