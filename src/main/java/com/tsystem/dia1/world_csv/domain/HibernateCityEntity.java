package com.tsystem.dia1.world_csv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class HibernateCityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "INT")
    private Long id;
    @Column(name = "Name", columnDefinition = "CHAR", length = 35)
    private String name;
    @Column(name = "CountryCode", columnDefinition = "CHAR", length = 3)
    private String countryCode;

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getCountryCode() {
	return countryCode;
    }

    @Override
    public String toString() {
	return "CityEntity [id=" + id + ", name=" + name + ", countryCode=" + countryCode + "]";
    }

}
