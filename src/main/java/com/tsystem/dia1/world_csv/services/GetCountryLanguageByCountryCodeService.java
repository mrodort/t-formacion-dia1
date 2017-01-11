package com.tsystem.dia1.world_csv.services;

import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;
import com.tsystem.dia1.world_csv.error.ElementNotFoundExpection;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.repository.CountryLanguageRepository;
import com.tsystem.dia1.world_csv.repository.imp.CsvCountryLanguageRepository;

public class GetCountryLanguageByCountryCodeService {

    private final CountryLanguageRepository countryLanguageRepository = new CsvCountryLanguageRepository();

    public CountryLanguageEntity getCountryLanguageByCountryCode(final String countryCode)
	    throws RepositoryConnectionExpection {

	Optional<CountryLanguageEntity> optionalCountryCode = countryLanguageRepository.findByCountryCode(countryCode);

	if (optionalCountryCode.isPresent()) {
	    return optionalCountryCode.get();
	} else {
	    throw new ElementNotFoundExpection("No existe idioma con el codigo:" + countryCode);
	}
    }

}
