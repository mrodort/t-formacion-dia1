package com.tsystem.dia1.world_csv.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DataRepository {

    List<String[]> findByNameStartWith(File fileName, String startWith) throws IOException, FileNotFoundException;

    Optional<String[]> findById(File fileName, String id) throws IOException, FileNotFoundException;

}