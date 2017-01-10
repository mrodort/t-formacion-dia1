package com.tsystem.dia1.world_csv.repository.imp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;
import com.tsystem.dia1.world_csv.mapper.CountryLanguageMapper;
import com.tsystem.dia1.world_csv.repository.CountryLanguageRepository;

import au.com.bytecode.opencsv.CSVReader;

public class CsvCountryLanguageRepository implements CountryLanguageRepository {

    private static final String CITY_FILE_NAME = "countrylanguage.csv";
    private static final char COLUM_DELIMITER_CHAR = ';';

    private final CountryLanguageMapper mapper = new CountryLanguageMapper();

    @Override
    public Optional<CountryLanguageEntity> findByCountryCode(String countryCode)
	    throws IOException, FileNotFoundException {
	final CSVReader reader = new CSVReader(new FileReader(CITY_FILE_NAME), COLUM_DELIMITER_CHAR);

	String[] nextLine;
	while ((nextLine = reader.readNext()) != null) {
	    if (nextLine[0].equals(countryCode)) {
		return Optional.of(mapper.toCountryLanguage(nextLine));
	    }
	}

	return Optional.empty();
    }

}
