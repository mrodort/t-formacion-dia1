package com.tsystem.dia1.world_csv.repository.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.tsystem.dia1.world_csv.domain.CountryLanguageEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.repository.CountryLanguageRepository;

public class MySQLCountryLanguageRepository implements CountryLanguageRepository {

    private final MySQLConnectionFactory connectionFactory = new MySQLConnectionFactory();

    @Override
    public Optional<CountryLanguageEntity> findByCountryCode(String countryCode) throws RepositoryConnectionExpection {

	Connection connection = connectionFactory.getInstance();

	PreparedStatement prepareStatement;
	try {
	    prepareStatement = connection.prepareStatement(
		    "SELECT CountryCode,`Language`, IsOfficial, Percentage FROM countrylanguage WHERE CountryCode = ?;");

	    prepareStatement.setString(1, countryCode);

	    ResultSet resultSet = prepareStatement.executeQuery();

	    if (resultSet.next()) {

		CountryLanguageEntity countryLanguage = CountryLanguageEntity.builder()//
			.countryCode(resultSet.getString("CountryCode"))//
			.language(resultSet.getString("Language"))//
			.isOfficial(toBoolean(resultSet.getString("IsOfficial")))//
			.percentage(resultSet.getFloat("Percentage"))//
			.build();
		return Optional.of(countryLanguage);
	    }
	    return Optional.empty();

	} catch (SQLException e) {
	    throw new RepositoryConnectionExpection("Error al conectarme al servidor MySQL. ", e);
	}
    }

    private boolean toBoolean(String isOfficialString) {
	boolean isOfficial = true;
	if (isOfficialString.equals("F")) {
	    isOfficial = false;
	}
	return isOfficial;
    }

}
