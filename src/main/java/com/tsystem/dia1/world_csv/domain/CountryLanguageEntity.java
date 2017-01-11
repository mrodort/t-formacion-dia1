package com.tsystem.dia1.world_csv.domain;

public class CountryLanguageEntity {

    private final String countryCode;
    private final String language;
    private final boolean isOfficial;
    private final float percentage;

    private CountryLanguageEntity(String countryCode, String language, boolean isOfficial, float percentage) {
	super();
	this.countryCode = countryCode;
	this.language = language;
	this.isOfficial = isOfficial;
	this.percentage = percentage;
    }

    public String getCountryCode() {
	return countryCode;
    }

    public String getLanguage() {
	return language;
    }

    public boolean isOfficial() {
	return isOfficial;
    }

    public float getPercentage() {
	return percentage;
    }

    public static CountryLanguageEntityBuilder builder() {
	return new CountryLanguageEntityBuilder();
    }

    @Override
    public String toString() {
	return "CountryLanguageEntity [countryCode=" + countryCode + ", language=" + language + ", isOfficial="
		+ isOfficial + ", percentage=" + percentage + "]";
    }

    public static class CountryLanguageEntityBuilder {

	private String countryCode;
	private String language;
	private boolean isOfficial;
	private float percentage;

	public CountryLanguageEntityBuilder countryCode(String countryCode) {
	    this.countryCode = countryCode;
	    return this;
	}

	public CountryLanguageEntityBuilder language(String language) {
	    this.language = language;
	    return this;
	}

	public CountryLanguageEntityBuilder isOfficial(boolean isOfficial) {
	    this.isOfficial = isOfficial;
	    return this;
	}

	public CountryLanguageEntityBuilder percentage(float percentage) {
	    this.percentage = percentage;
	    return this;
	}

	public CountryLanguageEntity build() {
	    return new CountryLanguageEntity(countryCode, language, isOfficial, percentage);
	}

    }
}
