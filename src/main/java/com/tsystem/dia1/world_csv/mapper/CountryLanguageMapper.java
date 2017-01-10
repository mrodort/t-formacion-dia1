package com.tsystem.dia1.world_csv.mapper;

import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;

public class CountryLanguageMapper {
    private static final int PERCENTAGE_COLUMN_NUMBER = 3;
    private static final int IS_OFFICIAL_COLUMN_NUMBER = 2;
    private static final int LANGUAGE_COLUMN_NUMBER = 1;
    private static final int COUNTRY_CODE_COLUMN_NUMBER = 0;

    public CountryLanguageEntity toCountryLanguage(String[] line) {
	boolean isOfficial = true;
	if (line[IS_OFFICIAL_COLUMN_NUMBER].equals("F")) {
	    isOfficial = false;
	}
	return CountryLanguageEntity.builder()//
		.countryCode(line[COUNTRY_CODE_COLUMN_NUMBER])//
		.language(line[LANGUAGE_COLUMN_NUMBER])//
		.isOfficial(isOfficial)//
		.percentage(Float.parseFloat(line[PERCENTAGE_COLUMN_NUMBER]))//
		.build();
    }
}
