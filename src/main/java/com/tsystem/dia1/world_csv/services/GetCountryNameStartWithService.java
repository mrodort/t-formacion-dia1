package com.tsystem.dia1.world_csv.services;

import java.util.List;

import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.repository.CountryRepository;
import com.tsystem.dia1.world_csv.repository.imp.HibernateCountryRepository;

public class GetCountryNameStartWithService {

    private final CountryRepository countryRepository = new HibernateCountryRepository();

    public List<CountryEntity> getCountryNameStartWith(String namePrefix) throws RepositoryConnectionExpection {

	List<CountryEntity> countriesToReturn = countryRepository.findByNameStartWith(namePrefix);

	return countriesToReturn;
    }

}
