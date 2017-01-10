package com.tsystem.dia1.world_csv.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CountryRepository {

    List<String[]> findByNameStartWith(String startWith) throws IOException, FileNotFoundException;

    Optional<String[]> findByCode(String code) throws IOException, FileNotFoundException;

}