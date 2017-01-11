package com.tsystem.dia1.world_csv.ui;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;

public class ConsoleUserInterface {

    public void printCity(CityEntity city) {
	System.out.println(city);
    }

    public void printCountry(CountryEntity country) {
	System.out.println(country);
    }

    public void printCountryLanguage(CountryLanguageEntity countryLanguage) {
	System.out.println(countryLanguage);
    }
}
