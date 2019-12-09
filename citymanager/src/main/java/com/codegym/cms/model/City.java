package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "citys")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public City() {
    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
