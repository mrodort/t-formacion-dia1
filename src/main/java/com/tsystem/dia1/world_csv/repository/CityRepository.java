package com.tsystem.dia1.world_csv.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CityEntity;

public interface CityRepository {

    List<CityEntity> findByNameStartWith(String startWith) throws IOException, FileNotFoundException;

    Optional<CityEntity> findById(String id) throws IOException, FileNotFoundException;

}