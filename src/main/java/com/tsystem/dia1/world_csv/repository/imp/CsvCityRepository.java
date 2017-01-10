package com.tsystem.dia1.world_csv.repository.imp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.mapper.CityMapper;
import com.tsystem.dia1.world_csv.repository.CityRepository;

import au.com.bytecode.opencsv.CSVReader;

public class CsvCityRepository implements CityRepository {

    private static final String CITY_FILE_NAME = "city.csv";
    private static final char COLUM_DELIMITER_CHAR = ';';

    private final CityMapper mapper = new CityMapper();

    @Override
    public List<CityEntity> findByNameStartWith(String startWith) throws IOException, FileNotFoundException {
	List<CityEntity> cityToReturn = new ArrayList<>();
	final CSVReader reader = new CSVReader(new FileReader(CITY_FILE_NAME), COLUM_DELIMITER_CHAR);

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[1].startsWith(startWith)) {
		cityToReturn.add(mapper.toCity(nextLine));
	    }
	}

	return cityToReturn;
    }

    @Override
    public Optional<CityEntity> findById(String id) throws IOException, FileNotFoundException {
	final CSVReader reader = new CSVReader(new FileReader(CITY_FILE_NAME), COLUM_DELIMITER_CHAR);

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[0].equals(id)) {
		return Optional.of(mapper.toCity(nextLine));
	    }
	}

	return Optional.empty();
    }

}
