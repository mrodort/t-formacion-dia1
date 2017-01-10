package com.tsystem.dia1.world_csv.repository.imp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.mapper.CityMapper;
import com.tsystem.dia1.world_csv.repository.CityRepository;

import au.com.bytecode.opencsv.CSVReader;

public class CsvCityRepository implements CityRepository {

    private static final String CITY_FILE_NAME = "city.csv";
    private static final char COLUM_DELIMITER_CHAR = ';';

    private final CityMapper mapper = new CityMapper();

    @Override
    public List<CityEntity> findByNameStartWith(String startWith) throws RepositoryConnectionExpection {
	List<CityEntity> cityToReturn = new ArrayList<>();
	CSVReader reader = null;
	try {
	    reader = new CSVReader(new FileReader(CITY_FILE_NAME), COLUM_DELIMITER_CHAR);
	    String[] nextLine;
	    while ((nextLine = reader.readNext()) != null) {
		if (nextLine[1].startsWith(startWith)) {
		    cityToReturn.add(mapper.toCity(nextLine));
		}
	    }
	} catch (FileNotFoundException fileNotFoundException) {
	    throw new RepositoryConnectionExpection("El archivo no se ha encontrado", fileNotFoundException);
	} catch (IOException ioException) {
	    throw new RepositoryConnectionExpection("Error en entrada salida", ioException);
	} finally {
	    try {
		reader.close();
	    } catch (IOException ioException) {
		throw new RepositoryConnectionExpection("Error al cerrar", ioException);
	    }
	}

	return cityToReturn;
    }

    @Override
    public Optional<CityEntity> findById(String id) throws RepositoryConnectionExpection {
	CSVReader reader = null;
	try {
	    reader = new CSVReader(new FileReader(CITY_FILE_NAME), COLUM_DELIMITER_CHAR);
	    String[] nextLine;
	    while ((nextLine = reader.readNext()) != null) {
		if (nextLine[0].equals(id)) {
		    return Optional.of(mapper.toCity(nextLine));
		}
	    }
	} catch (FileNotFoundException fileNotFoundException) {
	    throw new RepositoryConnectionExpection("El archivo no se ha encontrado", fileNotFoundException);
	} catch (IOException ioException) {
	    throw new RepositoryConnectionExpection("Error en entrada salida", ioException);
	} finally {
	    try {
		reader.close();
	    } catch (IOException ioException) {
		throw new RepositoryConnectionExpection("Error al cerrar", ioException);
	    }
	}

	return Optional.empty();
    }

}
