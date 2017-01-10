package com.tsystem.dia1.world_csv.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface CountryLanguageRepository {

    Optional<String[]> findByCountryCode(String countryCode) throws IOException, FileNotFoundException;

}