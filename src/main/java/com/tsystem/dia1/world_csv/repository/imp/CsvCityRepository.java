package com.tsystem.dia1.world_csv.repository.imp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.repository.CityRepository;

import au.com.bytecode.opencsv.CSVReader;

public class CsvCityRepository implements CityRepository {

    private static final String CITY_FILE_NAME = "city.csv";
    private static final char COLUM_DELIMITER_CHAR = ';';

    @Override
    public List<CityEntity> findByNameStartWith(String startWith) throws IOException, FileNotFoundException {
	List<String[]> linesToReturn = new ArrayList<>();
	final CSVReader reader = new CSVReader(new FileReader(CITY_FILE_NAME), COLUM_DELIMITER_CHAR);

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[1].startsWith(startWith)) {
		linesToReturn.add(nextLine);
	    }
	}

	return linesToReturn;
    }

    @Override
    public Optional<CityEntity> findById(String id) throws IOException, FileNotFoundException {
	final CSVReader reader = new CSVReader(new FileReader(CITY_FILE_NAME), COLUM_DELIMITER_CHAR);

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[0].equals(id)) {
		return Optional.of(nextLine);
	    }
	}

	return Optional.empty();
    }

}
