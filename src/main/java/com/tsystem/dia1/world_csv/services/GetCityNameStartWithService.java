package com.tsystem.dia1.world_csv.services;

import java.util.List;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.repository.CityRepository;
import com.tsystem.dia1.world_csv.repository.imp.CsvCityRepository;

public class GetCityNameStartWithService {
    
    private final CityRepository cityRepository = new CsvCityRepository();
    
    public List<CityEntity> getCityNameStartWith(String namePrefix) throws RepositoryConnectionExpection{
	
	List<CityEntity> citiesToReturn = cityRepository.findByNameStartWith(namePrefix);
	
	return citiesToReturn;
    }

}
