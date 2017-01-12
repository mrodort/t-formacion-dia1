package com.tsystem.dia1.world_csv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class CountryEntity {

    @Id
    @Column(name = "Code", columnDefinition = "CHAR", length = 3)
    private String code;
    @Column(name = "Name", columnDefinition = "CHAR", length = 52)
    private String name;
    @Column(name = "Continent", columnDefinition = "ENUM")
    private String continent;
    @Column(name = "Region", columnDefinition = "CHAR", length = 26)
    private String region;
    @Column(name = "SurfaceArea")
    private Float surfaceArea;
    @Column(name = "IndepYear", columnDefinition = "SMALLINT", length = 6)
    private Integer indepYear;
    @Column(name = "Population")
    private Integer population;
    @Column(name = "LifeExpectancy")
    private Float lifeExpectancy;
    @Column(name = "GNP")
    private Float gnp;
    @Column(name = "GNPOld")
    private Float gnpOld;
    @Column(name = "LocalName", columnDefinition = "CHAR", length = 45)
    private String localName;
    @Column(name = "GovernmentForm", columnDefinition = "CHAR", length = 45)
    private String governmentForm;
    @Column(name = "HeadOfState", columnDefinition = "CHAR", length = 60)
    private String headOfState;
    @Column(name = "Capital")
    private Integer capital;
    @Column(name = "Code2", columnDefinition = "CHAR", length = 2)
    private String code2;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "countryCode")
    private List<HibernateCityEntity> cities = new ArrayList<>();

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getContinent() {
	return continent;
    }

    public void setContinent(String continent) {
	this.continent = continent;
    }

    public String getRegion() {
	return region;
    }

    public void setRegion(String region) {
	this.region = region;
    }

    public Float getSurfaceArea() {
	return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
	this.surfaceArea = surfaceArea;
    }

    public Integer getIndepYear() {
	return indepYear;
    }

    public void setIndepYear(Integer indepYear) {
	this.indepYear = indepYear;
    }

    public Integer getPopulation() {
	return population;
    }

    public void setPopulation(Integer population) {
	this.population = population;
    }

    public Float getLifeExpectancy() {
	return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
	this.lifeExpectancy = lifeExpectancy;
    }

    public Float getGnp() {
	return gnp;
    }

    public void setGnp(Float gnp) {
	this.gnp = gnp;
    }

    public Float getGnpOld() {
	return gnpOld;
    }

    public void setGnpOld(Float gnpOld) {
	this.gnpOld = gnpOld;
    }

    public String getLocalName() {
	return localName;
    }

    public void setLocalName(String localName) {
	this.localName = localName;
    }

    public String getGovernmentForm() {
	return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
	this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
	return headOfState;
    }

    public void setHeadOfState(String headOfState) {
	this.headOfState = headOfState;
    }

    public Integer getCapital() {
	return capital;
    }

    public void setCapital(Integer capital) {
	this.capital = capital;
    }

    public String getCode2() {
	return code2;
    }

    public void setCode2(String code2) {
	this.code2 = code2;
    }

    @Override
    public String toString() {
	return "CountryEntity [code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region
		+ ", surfaceArea=" + surfaceArea + ", indepYear=" + indepYear + ", population=" + population
		+ ", lifeExpectancy=" + lifeExpectancy + ", gnp=" + gnp + ", gnpOld=" + gnpOld + ", localName="
		+ localName + ", governmentForm=" + governmentForm + ", headOfState=" + headOfState + ", capital="
		+ capital + ", code2=" + code2 + "]";
    }

    public List<HibernateCityEntity> getCities() {
	return cities;
    }

    public void setCities(List<HibernateCityEntity> cities) {
	this.cities = cities;
    }

}
