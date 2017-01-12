package com.tsystem.dia1.world_csv;

import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.domain.HibernateCityEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.services.GetCountryByCodeService;

public class PruebaPerezoso {

    public static void main(String[] args) throws RepositoryConnectionExpection {

	CountryEntity country = new GetCountryByCodeService().getCountryByCode("USA");
	System.out.println("Las ciudades de USA son: ");
	for (HibernateCityEntity city : country.getCities()) {
	    System.out.println(city);
	}

    }

}
