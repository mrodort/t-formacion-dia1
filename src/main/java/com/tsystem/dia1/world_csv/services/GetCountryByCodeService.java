package com.tsystem.dia1.world_csv.services;

import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.error.ElementNotFoundExpection;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.repository.CountryRepository;

public class GetCountryByCodeService {

    private final CountryRepository countryRepository = null;

    public CountryEntity getCountryByCode(final String countryCode) throws RepositoryConnectionExpection {

	Optional<CountryEntity> optionalCountry = countryRepository.findByCode(countryCode);

	if (optionalCountry.isPresent()) {
	    return optionalCountry.get();
	} else {
	    throw new ElementNotFoundExpection("No existe pais con el codigo:" + countryCode);
	}
    }

}
