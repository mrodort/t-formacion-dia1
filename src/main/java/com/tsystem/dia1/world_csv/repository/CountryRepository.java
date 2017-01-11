package com.tsystem.dia1.world_csv.repository;

import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;

public interface CountryRepository {

    List<CountryEntity> findByNameStartWith(String startWith) throws RepositoryConnectionExpection;

    Optional<CountryEntity> findByCode(String code) throws RepositoryConnectionExpection;

}