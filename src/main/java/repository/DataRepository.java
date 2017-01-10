package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import au.com.bytecode.opencsv.CSVReader;

public class DataRepository {

    public static List<String[]> findByNameStartWith(final File fileName, final String startWith)
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

    public static Optional<String[]> findById(final File fileName, final String id)
	    throws IOException, FileNotFoundException {
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
