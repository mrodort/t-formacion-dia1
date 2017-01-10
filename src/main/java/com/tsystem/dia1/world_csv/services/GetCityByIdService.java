package com.tsystem.dia1.world_csv.services;

import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.error.ElementNotFoundExpection;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.repository.CityRepository;
import com.tsystem.dia1.world_csv.repository.imp.CsvCityRepository;

public class GetCityByIdService {

    private final CityRepository cityRepository = new CsvCityRepository();

    public CityEntity getCityById(final String cityId) throws RepositoryConnectionExpection {

	Optional<CityEntity> optionalCity = cityRepository.findById(cityId);

	if (optionalCity.isPresent()) {
	    return optionalCity.get();
	} else {
	    throw new ElementNotFoundExpection("No existe ciudad con el id:" + cityId);
	}
    }

}
