package com.codegym.cms.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long acr;
    private Long population;
    private Long GDP;
    private String description;


    @OneToMany(targetEntity = City.class)
    private List<City> cities;

    public Customer() {
    }

    public Customer(Long acr, Long population, Long GDP, String description) {
        this.acr = acr;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcr() {
        return acr;
    }

    public void setAcr(Long acr) {
        this.acr = acr;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
