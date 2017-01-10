package com.tsystem.dia1.world_csv.repository;

import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;

public interface CityRepository {

    List<CityEntity> findByNameStartWith(String startWith) throws RepositoryConnectionExpection;

    Optional<CityEntity> findById(String id) throws RepositoryConnectionExpection;

}