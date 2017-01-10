package com.tsystem.dia1.world_csv.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import au.com.bytecode.opencsv.CSVReader;

public class CsvDataRepository implements DataRepository {

    /* (non-Javadoc)
     * @see repository.DataRepository#findByNameStartWith(java.io.File, java.lang.String)
     */
    @Override
    public List<String[]> findByNameStartWith(final File fileName, final String startWith)
	    throws IOException, FileNotFoundException {

	List<String[]> linesToReturn = new ArrayList<>();
	final CSVReader reader = new CSVReader(new FileReader(fileName), ';');

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[1].startsWith(startWith)) {
		linesToReturn.add(nextLine);
	    }
	}

	return linesToReturn;

    }

    /* (non-Javadoc)
     * @see repository.DataRepository#findById(java.io.File, java.lang.String)
     */
    @Override
    public Optional<String[]> findById(final File fileName, final String id) throws IOException, FileNotFoundException {
	final CSVReader reader = new CSVReader(new FileReader(fileName), ';');

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[0].equals(id)) {
		return Optional.of(nextLine);
	    }
	}

	return Optional.empty();
    }

}
