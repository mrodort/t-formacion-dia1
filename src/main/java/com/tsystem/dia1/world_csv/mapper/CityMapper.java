package com.tsystem.dia1.world_csv.mapper;

import com.tsystem.dia1.world_csv.domain.CityEntity;

public class CityMapper {

    private static final int POPULATION_COLUMN_NUMBER = 4;
    private static final int DISCTRICT_COLUMN_NUMBER = 3;
    private static final int COUNTRY_CODE_COLUMN_NUMBER = 2;
    private static final int NAME_COLUMN_NUMBER = 1;
    private static final int ID_COLUMN_NUMBER = 0;

    public CityEntity toCity(String[] line) {
	return CityEntity.builder()//
		.id(Long.parseLong(line[ID_COLUMN_NUMBER]))//
		.name(line[NAME_COLUMN_NUMBER])//
		.countryCode(line[COUNTRY_CODE_COLUMN_NUMBER])//
		.district(line[DISCTRICT_COLUMN_NUMBER])//
		.population(Long.parseLong(line[POPULATION_COLUMN_NUMBER]))//
		.build();
    }
}
