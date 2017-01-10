package com.tsystem.dia1.world_csv.repository;

import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;

public interface CountryRepository {

    List<String[]> findByNameStartWith(String startWith) throws RepositoryConnectionExpection;

    Optional<String[]> findByCode(String code) throws RepositoryConnectionExpection;

}