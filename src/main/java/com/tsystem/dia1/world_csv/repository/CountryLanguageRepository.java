package com.tsystem.dia1.world_csv.repository;

import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;

public interface CountryLanguageRepository {

    Optional<CountryLanguageEntity> findByCountryCode(String countryCode) throws RepositoryConnectionExpection;

}