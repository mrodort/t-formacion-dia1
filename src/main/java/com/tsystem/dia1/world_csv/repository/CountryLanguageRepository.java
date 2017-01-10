package com.tsystem.dia1.world_csv.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;

public interface CountryLanguageRepository {

    Optional<CountryLanguageEntity> findByCountryCode(String countryCode) throws IOException, FileNotFoundException;

}