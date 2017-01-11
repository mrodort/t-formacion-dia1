package com.tsystem.dia1.world_csv;

import java.util.List;

import com.tsystem.dia1.world_csv.domain.CityEntity;
import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.services.GetCityByIdService;
import com.tsystem.dia1.world_csv.services.GetCityNameStartWithService;
import com.tsystem.dia1.world_csv.services.GetCountryByCodeService;
import com.tsystem.dia1.world_csv.services.GetCountryLanguageByCountryCodeService;
import com.tsystem.dia1.world_csv.services.GetCountryNameStartWithService;
import com.tsystem.dia1.world_csv.ui.ConsoleUserInterface;

public class CommandSwitcher {

    private final GetCityByIdService getCityByIdService = new GetCityByIdService();
    private final GetCityNameStartWithService getCityNameStartWithService = new GetCityNameStartWithService();
    private final GetCountryByCodeService getCountryByCodeService = new GetCountryByCodeService();
    private final GetCountryNameStartWithService getCountryNameStartWithService = new GetCountryNameStartWithService();
    private final GetCountryLanguageByCountryCodeService getCountryLanguageByCountryCodeService = new GetCountryLanguageByCountryCodeService();
    private final ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();

    public void executeCommand(String[] commands) throws RepositoryConnectionExpection {

	if (commands[0].equals("city") && commands[1].equals("id")) {
	    CityEntity city = getCityByIdService.getCityById(commands[2]);
	    consoleUserInterface.printCity(city);
	} else if (commands[0].equals("city") && commands[1].equals("name")) {
	    List<CityEntity> cityList = getCityNameStartWithService.getCityNameStartWith(commands[2]);
	    for (CityEntity city : cityList) {
		consoleUserInterface.printCity(city);
	    }
	} else if (commands[0].equals("country") && commands[1].equals("code")) {
	    CountryEntity country = getCountryByCodeService.getCountryByCode(commands[2]);
	    consoleUserInterface.printCountry(country);
	} else if (commands[0].equals("country") && commands[1].equals("name")) {
	    List<CountryEntity> countryList = getCountryNameStartWithService.getCountryNameStartWith(commands[2]);
	    for (CountryEntity country : countryList) {
		consoleUserInterface.printCountry(country);
	    }
	} else if (commands[0].equals("language") && commands[1].equals("countrycode")) {
	    CountryLanguageEntity countryLanguage = getCountryLanguageByCountryCodeService
		    .getCountryLanguageByCountryCode(commands[2]);
	    consoleUserInterface.printCountryLanguage(countryLanguage);
	}
    }
}
