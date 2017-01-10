package com.tsystem.dia1.world_csv.domain;

public class CityEntity {
    private final Long id;
    private final String name;
    private final String countryCode;
    private final String district;
    private final Long population;

    private CityEntity(Long id, String name, String countryCode, String district, Long population) {
	super();
	this.id = id;
	this.name = name;
	this.countryCode = countryCode;
	this.district = district;
	this.population = population;
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getCountryCode() {
	return countryCode;
    }

    public String getDistrict() {
	return district;
    }

    public Long getPopulation() {
	return population;
    }

    public static CityEntityBuilder builder() {
	return new CityEntityBuilder();
    }

    private static class CityEntityBuilder {
	private Long id;
	private String name;
	private String countryCode;
	private String district;
	private Long population;

	public CityEntityBuilder id(Long id) {
	    this.id = id;
	    return this;
	}

	public CityEntityBuilder name(String name) {
	    this.name = name;
	    return this;
	}

	public CityEntityBuilder countryCode(String countryCode) {
	    this.countryCode = countryCode;
	    return this;
	}

	public CityEntityBuilder district(String district) {
	    this.district = district;
	    return this;
	}

	public CityEntityBuilder population(Long population) {
	    this.population = population;
	    return this;
	}

	public CityEntity build() {
	    return new CityEntity(id, name, countryCode, district, population);
	}
    }

}
